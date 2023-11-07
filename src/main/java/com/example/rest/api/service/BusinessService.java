package com.example.rest.api.service;

import org.springframework.stereotype.Component;

import com.example.rest.api.model.Message;

@Component
public class BusinessService {
    public Message getMessage() {
        Message message = new Message();
        return message;
    }
}
