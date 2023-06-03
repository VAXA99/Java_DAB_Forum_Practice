package com.dab_userforum.Controller;

import com.dab_userforum.Entity.Message;
import com.dab_userforum.Entity.User;
import com.dab_userforum.Service.MessageService;
import com.dab_userforum.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMainPage(Model model)  {

        return "index";
    }

    @GetMapping("/messages")
    public String getMessagesPage(Model model) {
        List<Message> messages = messageService.getAll();
        model.addAttribute("messages", messages);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();
        model.addAttribute("login", login);

        return "messages";
    }


    @PostMapping("/write_message")
    public String writeMessage( @RequestParam(value = "messageContent") String messageContent) {
        if (messageContent.trim().isEmpty()) {
            return "redirect:/messages";
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();

        User user = userService.findByUsername(login);
        Integer userId = user.getId();

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String timestamp = dateTime.format(formatter);


        Message message = new Message(messageContent, userId, login, timestamp);
        userService.writeMessage(message, userId);

        return "redirect:/messages";
    }

    @GetMapping("/delete_message/{messageId}")
    public String deleteMessage(@PathVariable Integer messageId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String login = authentication.getName();

        User user = userService.findByUsername(login);
        Integer userId = user.getId();

        userService.deleteMessage(messageId, userId);

        return "redirect:/messages";
    }

}
