package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("user", user);
        model.addAttribute("verify", verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("listOfUsers", UserData.getAll());
        if (user.getPassword().equals(verify)) {
           UserData.add(user);
           return "user/index";
        }
        else {
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }

    }

    @GetMapping("userDetails")
    public String displayUserDetails(Model model, @RequestParam("userId") int userId) {
        User userToDisplay = UserData.getById(userId);
        model.addAttribute("username", userToDisplay.getUsername());
        model.addAttribute("email", userToDisplay.getEmail());
        model.addAttribute("dateJoined", userToDisplay.getDateJoined());
        return "user/userDetails";
    }

}
