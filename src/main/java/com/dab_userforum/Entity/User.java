package com.dab_userforum.Entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.LocalDate;
import java.util.Date;


@JacksonXmlRootElement(localName = "forum_admin")
public class User {

    @JacksonXmlProperty(localName = "id")
    private Integer id;

    @JacksonXmlProperty(localName = "login")
    private String login;

    @JacksonXmlProperty(localName = "password")
    private String password;

    @JacksonXmlProperty(localName = "date_of_registration")
    private String dateOfRegistration;

    @JacksonXmlProperty(localName = "email_address")
    private String emailAddress;

    @JacksonXmlProperty(localName = "number_of_messages")
    private Integer numberOfMessages;

   @JacksonXmlProperty(localName = "role")
    private String role;

    public User() {
    }

    public User(String login, String password, String dateOfRegistration, String emailAddress, Integer numberOfMessages, String role) {
        this.login = login;
        this.password = password;
        this.dateOfRegistration = dateOfRegistration;
        this.emailAddress = emailAddress;
        this.numberOfMessages = numberOfMessages;
        this.role = role;
    }

    public User(Integer id, String login, String password, String dateOfRegistration, String emailAddress, Integer numberOfMessages, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.dateOfRegistration = dateOfRegistration;
        this.emailAddress = emailAddress;
        this.numberOfMessages = numberOfMessages;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getNumberOfMessages() {
        return numberOfMessages;
    }

    public void setNumberOfMessages(Integer numberOfMessages) {
        this.numberOfMessages = numberOfMessages;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}



