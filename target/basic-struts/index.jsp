<%-- 
    Document   : index
    Created on : Jan 3, 2026, 6:20:55 PM
    Author     : Shark
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Basic Struts Application - Welcome</title>
    </head>
    <body>
        <h1>Hello Mister. Aitor. Welcome to Struts!</h1>
        <p><a href="hello.action">Hello world again</a></p>
        <br><!-- Leave a blank space -->

        <s:url action="hello" var="helloLink">
            <s:param name="userName">Bruce Phillips</s:param>
        </s:url>
        <p><a href="${helloLink}">Hola B P></a></p>
        <br><!-- Leave a blank space -->

        <p> Get your own personal hello by filling out and submitting this form. </p>
        <s:form action="hello">
            <s:textfield name="userName" label="Your name"/>
            <s:textarea name="description" label="Description"/>
            <s:submit value="Submit" />
        </s:form>

        <p><a href="register.action">Please register</a> for our prize drawing.</p>

        <s:url action="registerInput" var="registerInputLink" />
        <p><s:a href="%{registerInputLink}">Please register</s:a> for our prize drawing.</p>

        <hr />
        <s:text name="contact" />
    </body>
</html>
