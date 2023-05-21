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

    @JacksonXmlProperty(localName = "post_id")
    private Integer postId;

    @JacksonXmlProperty(localName = "timestamp")
    private Date timestamp;

    public Message() {
    }

    public Message(Integer id, String messageContent, Integer userId, Integer postId, Date timestamp) {
        this.id = id;
        this.messageContent = messageContent;
        this.userId = userId;
        this.postId = postId;
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

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
