package com.example.restapi.service;

import org.springframework.stereotype.Component;

import com.example.restapi.model.Message;

@Component
public class BusinessService {
    public Message getMessage() {
        Message message = new Message();
        return message;
    }
}
