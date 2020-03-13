package com.example.plesniar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NewUser {
    String login;
    String password;

    public NewUser(){}
}
