<%-- 
    Document   : newjsp
    Created on : 25/abr/2020, 0:19:29
    Author     : Ricardo Petronilho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <%  // mostra a mensagem de credenciais inválidas a vermelho
            Integer warningType = (Integer) request.getAttribute("warningType");           
            if (warningType != null) { // >= 2º acesso
                if (warningType == 0) {
                   %> 
                   <span style="color: red">please enter all fields!</span>
                   <p>
                   <%
                }
                else if (warningType == 1) {
                   %> 
                   <span style="color: red">username already taken!</span>
                   <p>
                   <%
                }
            }   
        %>
            
        <form action="${pageContext.request.contextPath}/Register" method="POST">
            
            <label>name:</label>
            <input type="text" name="username"/>
            <p>
            <label>email:</label>
            <input type="text" name="email"/>
            <p>
            <label>password:</label>
            <input type="password" name="password"/>
            <p>
            <button type="submit" name="registerAction" value="register">Register</button>
        </form> 
    </body>
</html>
