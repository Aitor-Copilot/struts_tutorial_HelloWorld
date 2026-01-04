<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello World Ñandúç!</title>
    </head>
    <body>
        <!-- Solution 1: Direct property from action (works) -->
        <h2><s:property value="message" /></h2>

        <!-- Solution 2: Using push tag to access nested property (works) -->
        <!-- <s:push value="messageStore">
            <h2><s:property value="message" /></h2>
        </s:push> -->

        <p><a href="index.action">Go to index</a></p>

        <p>I have said hello <s:property value="helloCount" /> times!</p>
        
        <p>Call to the messageStore toString method:  <s:property value="messageStore"/>
            
        <p>Call to message <s:property value="message" /> AND <s:property value="description" /></p>
    </body>
</html>