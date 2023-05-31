package com.dab_userforum.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/")
    public String getMainPage() {
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

    @GetMapping("/messages")
    public String getMessagesPage() {
        return "messages";
    }
}