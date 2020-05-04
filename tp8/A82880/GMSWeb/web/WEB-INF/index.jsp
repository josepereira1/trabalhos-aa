<%-- 
    Document   : index.jsp
    Created on : Apr 24, 2020, 8:19:44 PM
    Author     : josepereira
--%>

<%@page import="pt.uminho.di.aa.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <br>
        <%
            String param = request.getAttribute("obj").toString().toUpperCase();
            out.println(param);
        %>
        <br>
        The parameter value is: <%= request.getAttribute("obj") %>
        <br>
        <%
            Game game = (Game) request.getAttribute("game");
            out.println(game.getName());
            out.println(game.getDescription());
            out.println(game.getPrice());
            // ...
        %>
        <br>
        <%
            String userAgent = request.getAttribute("userAgent").toString();
            out.println(userAgent);
        %>
        <br>
        <% 
           out.println(session.getAttribute("session"));
        %>
        <br>
        <% 
           out.println("a new session was created: "+request.getAttribute("sessionCreated"));
        %>
    </body>
</html>
