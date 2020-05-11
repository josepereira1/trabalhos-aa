<%-- 
    Document   : SearchGame
    Created on : Apr 25, 2020, 11:06:33 PM
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
        <form action="${pageContext.request.contextPath}/SearchGame" method="POST">
            <button name="searchGameAction" value="listallgames">All Games</button>
            <button name="searchGameAction" value="mygames">My Games</button>
            <button name="searchGameAction" value="addgame">Add Game</button>
            <button name="searchGameAction" value="searchgame" disabled="">Search Game</button>
            <button name="searchGameAction" value="logout" >Log out</button>
        
        <h1>Search Game</h1>
        
            Name: <input type="text" name="name"/>
            <button type="submit" name="searchGameAction" value="searchgame">Search Game</button>
        </form>
            <br>
            <p style="color:red">
            <% 
                String error = (String) request.getAttribute("message");
                if(error != null)out.println(error);
            %>
            </p>
            <% 
                Game game = (Game) request.getAttribute("game"); 
                if(game != null){
                    out.println("Name: " + game.getName() + "<br>");
                    out.println("Platform: " + game.getPlatform() + "<br>");
                    out.println("Year: " + game.getYear() + "<br>");
                    out.println("Price: " + game.getPrice() + "<br>");
                    out.println("Description: " + game.getDescription() + "<br>");
                }
            %>
    </body>
</html>
