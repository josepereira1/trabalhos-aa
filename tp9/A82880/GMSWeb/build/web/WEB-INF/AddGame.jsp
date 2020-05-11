<%-- 
    Document   : AddGame
    Created on : Apr 25, 2020, 9:28:54 PM
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
        <form action="${pageContext.request.contextPath}/AddGame" method="POST">
            <button name="addGameAction" value="listallgames">All Games</button>
            <button name="addGameAction" value="mygames">My Games</button>
            <button name="addGameAction" value="addgame" disabled="">Add Game</button>
            <button name="addGameAction" value="searchgame">Search Game</button>
            <button name="addGameAction" value="logout">Log out</button>
        </form>
        <h1>Add Game</h1>
        <form action="${pageContext.request.contextPath}/AddGame" method="POST">
            Name: <input type="text" name="name"/>
            <button type="submit" name="addGameAction" value="addgame">Add Game to my Library</button>
            <br>
            <p style="color:red">
            <% 
                String error = (String) request.getAttribute("message");
                if(error != null)out.println(error);
            %>
            </p>
        </form>
    </body>
</html>
