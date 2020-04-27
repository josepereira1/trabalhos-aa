<%-- 
    Document   : RegisterUser.jsp
    Created on : Apr 25, 2020, 12:42:06 PM
    Author     : josepereira
--%>

<%@page import="web.RegisterUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Register User</h1>
        <form action="${pageContext.request.contextPath}/RegisterUser" method="POST">
            Name: <input type="text" name="name"/>
            <br>
            Email: <input type="text" name="email"/>
            <br>
            Password: <input type="password" name="password"/>
            <br>
            <button type="submit" name="registerAction" value="login">Back</button>
            <button type="submit" name="registerAction" value="register">Register</button>
            <br>
        </form>
        <p style="color: red;">
        <% 
            String message = (String) request.getAttribute("message");
            if(message != null)out.println(message);
        %></p>
    </body>
</html>
