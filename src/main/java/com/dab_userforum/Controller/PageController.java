package com.dab_userforum.Controller;

import com.dab_userforum.Entity.Message;
import com.dab_userforum.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private MessageService messageService;

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
    public String getMessagesPage(Model model) {
        List<Message> messages = messageService.getAll();
        model.addAttribute("messages", messages);
        return "messages";
    }

}
