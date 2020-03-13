package com.example.plesniar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NewMessage {
    private String message;
    private String topic;

    public NewMessage(){}
}
