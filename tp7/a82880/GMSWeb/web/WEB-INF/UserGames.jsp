<%-- 
    Document   : UserGames
    Created on : Apr 25, 2020, 7:13:14 PM
    Author     : josepereira
--%>

<%@page import="java.util.Iterator"%>
<%@page import="pt.uminho.di.aa.GameSetCollection"%>
<%@page import="pt.uminho.di.aa.Game"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/UserGames" method="GET">
            <button name="actionUserGames" value="listallgames">All Games</button>
            <button name="actionUserGames" value="mygames" disabled="">My Games</button>
            <button name="actionUserGames" value="addgame">Add Game</button>
            <button name="actionUserGames" value="searchgame">Search Game</button>
            <button name="actionUserGames" value="logout">Log out</button>
        </form>
        <h1>User Games</h1>
        <table>
            <tr>
                <th>Nome</th>
                <th>Platform</th>
                <th>Year</th>
                <th>Price</th>
                <th>Description</th>
            </tr>
            
            <% GameSetCollection games = (GameSetCollection) request.getAttribute("games");
               Iterator it = games.getIterator();
               while(it.hasNext()){
                   Game g = (Game) it.next();
                %>
                <tr>
                    <td><%= g.getName() %></td>
                    <td><%= g.getPlatform() %></td>
                    <td><%= g.getYear() %></td>
                    <td><%= g.getPrice() %></td>
                    <td><%= g.getDescription() %></td>
                </tr>    
             <% } %>
        </table>
    </body>
</html>
