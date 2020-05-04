<%-- 
    Document   : addGame
    Created on : 25/abr/2020, 18:00:54
    Author     : Ricardo Petronilho
--%>

<%@page import="java.util.Collection"%>
<%@page import="aa.Platform"%>
<%@page import="aa.GMS"%>
<%@page import="aa.IGMS"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Game</title>
    </head>
    <body>
        
        <div style="display: flex"> 
            <form action="${pageContext.request.contextPath}/AllGames" method="GET">
                <button type="submit">All Games</button>
            </form> 
            <form action="${pageContext.request.contextPath}/MyGames" method="GET">
                <button type="submit">My Games</button>
            </form> 
            <button disabled>Add Game</button>
            <form action="${pageContext.request.contextPath}/ShowGame" method="GET">
                <button type="submit">Show Game</button>
            </form> 
        </div>
            
        <p>
            
        <%  
            Integer warningType = (Integer) request.getAttribute("warningType"); 
            // é necessário testar o (warningType != null) pois quando é método = GET (ex: 1º acesso) não existe a variável warningType definida
            if (warningType != null) { // >= 2º acesso
                if (warningType == 0) {
                   %> 
                   <span style="color: red">please enter all fields!</span>
                   <p>
                   <%
                }
                else if (warningType == 1) {
                   %> 
                   <span style="color: red">game does not exist!</span>
                   <p>
                   <%
                }
            }   
        %>
            
        <form action="${pageContext.request.contextPath}/AddGame" method="POST">            
            <label>game's name:</label>
            <input required="required" type="text" name="gamename"/>
            <p>
            <button type="submit" name="action" value="addGame">Add Game</button>
        </form> 
    </body>
</html>
