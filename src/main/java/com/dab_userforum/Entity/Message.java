package com.dab_userforum.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {

    private Integer id;

    private String messageContent;

    private Integer userId;

    private String login;

    private String timestamp;

    public Message(String messageContent, Integer userId, String login, String timestamp) {
        this.messageContent = messageContent;
        this.userId = userId;
        this.login = login;
        this.timestamp = timestamp;
    }
}
