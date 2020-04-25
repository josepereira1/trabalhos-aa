<%-- 
    Document   : listAllGames
    Created on : 24/abr/2020, 23:59:33
    Author     : Ricardo Petronilho
--%>

<%@page import="java.util.Collection"%>
<%@page import="aa.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- My CSS -->
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }
            tr:hover {
                background-color: #dddddd;
            }
        </style>
        <title>My Games</title>
    </head>
    <body>
        
        <form action="${pageContext.request.contextPath}/UserGames" method="POST">
            <button type="submit" name="userGamesAction" value="allGames">All Games</button>
            <button disabled>My Games</button>  
            <button type="submit" name="userGamesAction" value="addGame">Add Game</button>
        </form> 
        
        <% 
            Collection<Game> games = (Collection) request.getAttribute("games");
            if (games == null || games.isEmpty()) {
                %>
                <h3 style="color: red">No games to display!</h3>
                <%
            } 
            else { 
                %>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>Year</th>
                        <th>Price</th>
                        <th>Description</th>
                    </tr>
                <% 
                        for(Game g : games) { %>
                            <tr> 
                                <td> <%= g.getName() %> </td>
                                <td> <%= g.getYear() %> </td>
                                <td> <%= g.getPrice() %> </td>
                                <td> <%= g.getDescription() %> </td>
                            </tr> 
                     <% } %>
                </table> 
        <% } %>
        
    </body>
</html>
