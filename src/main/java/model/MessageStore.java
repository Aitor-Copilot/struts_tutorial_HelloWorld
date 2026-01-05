package model;

//package org.apache.struts.helloworld.model;

public class MessageStore {
    private String message;
    
    public MessageStore() {
        message = "Hello Struts User:  ";
    }

    public String getMessage() {
        return message;
    }
    
    @Override
    public String toString(){
        return message + " (altered in the toString method)";
    }
}