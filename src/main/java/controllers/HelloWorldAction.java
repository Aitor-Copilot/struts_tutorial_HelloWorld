package controllers;

import jakarta.servlet.http.HttpSession;
import model.MessageStore;
import org.apache.struts2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

public class HelloWorldAction extends ActionSupport {
    // Initialize to null to prevent Struts from trying to auto-inject
    private MessageStore messageStore = null;
    private String message;
    private int helloCount = 0;
    private String description = null;
    private String userName = null;

    @Override
    public String execute() {
        messageStore = new MessageStore();
        message = messageStore.getMessage();
        
        if(userName != null){
            message = message + " " + userName;
        }
        
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
    
    public String getUserName(){
        return userName;
    }
    
    @StrutsParameter
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getDescription() {
        return description;
    }

    @StrutsParameter
    public void setDescription(String description){
        this.description = description;
    }

}