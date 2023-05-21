package com.dab_userforum.Entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Date;

@JacksonXmlRootElement(localName = "forum_post")
public class Post {

    @JacksonXmlProperty(localName = "post_id")
    private Integer id;

    @JacksonXmlProperty(localName = "user_id")
    private Integer userId;

    @JacksonXmlProperty(localName = "timestamp")
    private Date timestamp;

    @JacksonXmlProperty(localName = "subject_line")
    private String subjectLine;

    public Post() {
    }

    public Post(Integer id, Integer userId, Date timestamp, String subjectLine) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.subjectLine = subjectLine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSubjectLine() {
        return subjectLine;
    }

    public void setSubjectLine(String subjectLine) {
        this.subjectLine = subjectLine;
    }
}
