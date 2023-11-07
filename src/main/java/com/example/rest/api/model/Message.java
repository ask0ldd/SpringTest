package com.example.rest.api.model;

public class Message {
    public String value = "The console is working.";

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
