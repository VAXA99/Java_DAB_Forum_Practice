package com.dab_userforum.Controller;

import com.dab_userforum.Entity.Message;
import com.dab_userforum.Service.MessageService;
import com.dab_userforum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMainPage()  {
        return "index";
    }

    @GetMapping("/messages")
    public String getMessagesPage(Model model) {
        List<Message> messages = messageService.getAll();
        model.addAttribute("messages", messages);
        return "messages";
    }


}
