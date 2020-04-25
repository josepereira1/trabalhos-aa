<%-- 
    Document   : index
    Created on : 24/abr/2020, 16:41:54
    Author     : Ricardo Petronilho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        
        <%  // mostra a mensagem de credenciais inválidas a vermelho
            Boolean loggedIn = (Boolean) request.getSession().getAttribute("loggedIn");
            if (loggedIn != null && loggedIn == false) {
               %> 
               <span style="color: red">invalid credentials!</span>
               <p>
               <%
            }
        %>
            
        <form action="${pageContext.request.contextPath}/Login" method="POST">
            
            <label>username:</label>
            <input type="text" name="username"/>
            <p>
            <label>password:</label>
            <input type="password" name="password"/>
            <p>

            <button type="submit" name="loginAction" value="login">Login</button>
            <button type="submit" name="loginAction" value="register">Register</button>
            
        </form> 
    </body>
</html>
