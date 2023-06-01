package com.dab_userforum.Entity;

public class User {

    private Integer id;

    private String login;

    private String password;

    private String dateOfRegistration;

    private String emailAddress;

    private Integer numberOfMessages;

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



