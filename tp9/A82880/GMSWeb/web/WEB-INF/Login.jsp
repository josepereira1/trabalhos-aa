<%-- 
    Document   : Login
    Created on : Apr 25, 2020, 3:11:37 PM
    Author     : josepereira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="${pageContext.request.contextPath}/Login" method="POST">
            Name: <input type="text" name="name"/>
            <br>
            Password: <input type="password" name="password"/>
            <br>
            <button type="submit" name="loginAction" value="login">Login</button>
            <button type="submit" name="loginAction" value="register">Register</button>
            <br>
            <p style="color:red">
            <% 
                Boolean res = (Boolean) request.getAttribute("res");
                if(res != null && res == false)out.println("Invalid credentials!");
                else if(res != null && res == true)out.println("Sucess login!");    //  este não vai aparecer, foi apenas para teste
            %>
            </p>
        </form>
    </body>
</html>
