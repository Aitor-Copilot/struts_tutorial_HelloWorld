package controllers;

import model.MessageStore;
import org.apache.struts2.ActionSupport;

public class HelloWorldAction extends ActionSupport {
    private MessageStore messageStore;
    private String message;

    @Override
    public String execute() {
        messageStore = new MessageStore();
        message = messageStore.getMessage();
        
        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
    
    public String getMessage() {
        return message;
    }
}