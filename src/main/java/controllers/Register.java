
package controllers;


import org.apache.struts2.ActionSupport;
import model.Person;
import org.apache.struts2.interceptor.parameter.StrutsParameter;

public class Register extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    
    private Person personBean;

    @Override
    public String execute() throws Exception {
        // Ensure personBean is initialized
        if (personBean == null) {
            personBean = new Person();
        }
        
        // Check if this is a form submission (POST) or initial display (GET)
        // If firstName is null or empty, it means the form hasn't been submitted yet
        String firstName = personBean.getFirstName();
        if (firstName == null || firstName.trim().isEmpty()) {
            // Show the form (initial GET request or empty form)
            return INPUT;
        }
        
        // Form was submitted with data - process it
        //call Service class to store personBean's state in database
        
        return SUCCESS;
    }

    @StrutsParameter(depth = 1)
    public Person getPersonBean() {
        if (personBean == null) {
            personBean = new Person();
        }
        return personBean;
    }
    
    public void setPersonBean(Person person) {
        personBean = person;
    }

}