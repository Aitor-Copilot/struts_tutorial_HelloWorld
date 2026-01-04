package controllers;

import jakarta.servlet.http.HttpSession;
import model.MessageStore;
import org.apache.struts2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class HelloWorldAction extends ActionSupport {
    // Initialize to null to prevent Struts from trying to auto-inject
    private MessageStore messageStore = null;
    private String message;
    private int helloCount = 0;

    @Override
    public String execute() {
        messageStore = new MessageStore();
        message = messageStore.getMessage();
        
        // Get the HTTP session
        HttpSession session = ServletActionContext.getRequest().getSession();
        
        // Get the count from session, or initialize to 0 if not present
        Integer count = (Integer) session.getAttribute("helloCount");
        if (count == null) {
            count = 0;
        }
        count++;
        session.setAttribute("helloCount", count);
        helloCount = count;
        
        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
    
    public String getMessage() {
        return message;
    }
    
    public int getHelloCount() {
        return helloCount;
    }
}