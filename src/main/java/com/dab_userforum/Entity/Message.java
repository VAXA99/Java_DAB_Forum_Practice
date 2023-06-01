package com.dab_userforum.Entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Date;

@JacksonXmlRootElement(localName = "forum_message")
public class Message {

    @JacksonXmlProperty(localName = "message_id")
    private Integer id;

    @JacksonXmlProperty(localName = "message_content")
    private String messageContent;

    @JacksonXmlProperty(localName = "user_id")
    private Integer userId;

    @JacksonXmlProperty(localName = "login")
    private String login;

    @JacksonXmlProperty(localName = "timestamp")
    private String timestamp;

    public Message() {
    }

    public Message(String messageContent, Integer userId, String login, String timestamp) {
        this.messageContent = messageContent;
        this.userId = userId;
        this.login = login;
        this.timestamp = timestamp;
    }

    public Message(Integer id, String messageContent, Integer userId, String login, String timestamp) {
        this.id = id;
        this.messageContent = messageContent;
        this.userId = userId;
        this.login = login;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
