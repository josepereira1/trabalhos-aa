<%-- 
    Document   : addGame
    Created on : 25/abr/2020, 18:00:54
    Author     : Ricardo Petronilho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/AddGame" method="POST">
            <button type="submit" name="addGameAction" value="allGames">All Games</button>
            <button type="submit" name="addGameAction" value="userGames">My Games</button>  
            <button disabled>Add Game</button>
        </form> 
            
        <form action="${pageContext.request.contextPath}/AddGame" method="POST">
            
            <label>name:</label>
            <input type="text" name="name"/>
            <p>
            <label>year:</label>
            <input type="number" name="year"/>
            <p>
            <label>price:</label>
            <input type="number" name="price"/>
            <p>
            <label>description:</label>
            <input type="text" name="description"/>
            <p>
            <button type="submit" name="addGameAction" value="addGame">Add Game</button>
        </form> 
    </body>
</html>
