<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Register</title>
        <s:head />
    </head>

    <body>
        <h3>Register for a prize by completing this form.</h3>

        <s:form action="register" method="post">
            <s:textfield name="personBean.firstName" label="First name" />
            <s:textfield name="personBean.lastName" label="Last name" />
            <s:textfield name="personBean.email" label="Email" />
            <s:textfield name="personBean.age" label="Age" />
        </s:form>
        <br />

        <s:form action="register" method="post">
            <s:textfield key="personBean.firstName" />
            <s:textfield key="personBean.lastName" />
            <s:textfield key="personBean.email" />
            <s:textfield key="personBean.age" />
            <s:submit />
        </s:form>

        <p><a href="<s:url action='index' />">Return to home page</a>.</p>

        <h1><s:text name="greeting" /></h1>

        <hr />
        <s:text name="contact" />
    </body>

</html>