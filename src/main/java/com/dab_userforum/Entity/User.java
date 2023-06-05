package com.dab_userforum.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private Integer id;

    private String login;

    private String password;

    private String dateOfRegistration;

    private String emailAddress;

    private Integer numberOfMessages;

    private String role;

    public User(String login, String password, String dateOfRegistration, String emailAddress, Integer numberOfMessages, String role) {
        this.login = login;
        this.password = password;
        this.dateOfRegistration = dateOfRegistration;
        this.emailAddress = emailAddress;
        this.numberOfMessages = numberOfMessages;
        this.role = role;
    }
}



