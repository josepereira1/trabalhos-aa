<%-- 
    Document   : register
    Created on : 24/abr/2020, 22:13:27
    Author     : joaomarques
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Library</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
            }

            td {
                text-align: left;
                padding: 8px;
            }
            
            input[type=submit] {
                background-color: lightgray;
                border: none;
                color: black;
                padding: 10px 25px;
                text-decoration: none;
                margin: 4px 2px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <h1>Register</h1>
        <form method="GET">
            <input type="submit" formaction="${pageContext.request.contextPath}\Index" name="index" value="Home"/>
            <input type="submit" formaction="${pageContext.request.contextPath}\Login" name="login" value="Login"/>
        </form>
        <%
            String error = (String) request.getAttribute("error");
            if(error!=null) out.println(error);
        %>
        <form method="POST" action="${pageContext.request.contextPath}\Register">
            <table>
                <tbody>
                    <tr>
                        <td>Name:</td>
                        <td><input required="required"type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input required="required" type="email" name="email"/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input required="required" type="password" name="password"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="actionregister" value="Register"/>
        </form>
    </body>
</html>
