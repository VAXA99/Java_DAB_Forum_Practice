package com.dab_userforum.Controller;

import com.dab_userforum.Entity.User;
import com.dab_userforum.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private IUserService adminService;

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = adminService.getAll();
        model.addAttribute("users", users);
        return "users";
    }
}
