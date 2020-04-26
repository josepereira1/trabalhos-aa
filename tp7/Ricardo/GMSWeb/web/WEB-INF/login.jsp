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
        
        <%  
            Boolean loggedIn = (Boolean) request.getSession().getAttribute("loggedIn");         
            // é necessário testar o (loggedIn != null) pois quando é método = GET (ex: 1º acesso) não existe a variável loggedIn definida
            if (loggedIn != null && loggedIn == false) {              
               Integer warningType = (Integer) request.getAttribute("warningType");         
               // não é necessário testar se (warningType != null) pois quando loggedIn != null existe sempre warningType               
               if (warningType == 0) {
                   %> 
                   <span style="color: red">please enter all fields!</span>
                   <p>
                   <%
                }
                else if (warningType == 1) {
                   %> 
                   <span style="color: red">username does not exist!</span>
                   <p>
                   <%
                }
                else if (warningType == 2) {
                   %> 
                   <span style="color: red">wrong password!</span>
                   <p>
                   <%
                }
            }
        %>
            
        <form action="${pageContext.request.contextPath}/Login" method="POST">         
            <label>username:</label>
            <input required="required" type="text" name="username"/>
            <p>
            <label>password:</label>
            <input required="required" type="password" name="password"/>
            <p>
            <button type="submit" name="loginAction" value="login">Login</button>           
        </form> 
        
        <form action="${pageContext.request.contextPath}/Login" method="POST">
            <button type="submit" name="loginAction" value="register">Register</button>
        </form>
            
    </body>
</html>
