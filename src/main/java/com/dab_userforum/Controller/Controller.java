package com.dab_userforum.Controller;

import com.dab_userforum.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listWagons(Model model) {
        List<User> users = userService.getForumUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
