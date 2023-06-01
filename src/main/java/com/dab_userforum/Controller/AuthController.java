package com.dab_userforum.Controller;

import com.dab_userforum.Entity.User;
import com.dab_userforum.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.sql.Date;

@Controller
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping("/sign_up")
    public String createUser(@RequestParam(value = "login") String login,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "role", defaultValue = "user", required = false) String role) {

        LocalDate date = LocalDate.now();
        String currentDate = String.valueOf(Date.valueOf(date));

        User user = new User(login, password, currentDate, email, 0, role);
        userService.add(user);

        return "index";
    }

    @GetMapping("/sign_up")
    public String getSignUpPage() {
        return "sign_up";
    }

    @GetMapping("/sign_in")
    public String getSignInPage() {
        return "sign_in";
    }

}
