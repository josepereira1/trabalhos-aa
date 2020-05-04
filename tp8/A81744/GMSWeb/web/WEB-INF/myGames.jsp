<%-- 
    Document   : listAllGames
    Created on : 24/abr/2020, 23:59:33
    Author     : Ricardo Petronilho
--%>

<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Arrays"%>
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
        
        <div style="display: flex">
            <form action="${pageContext.request.contextPath}/AllGames" method="GET">
                <button type="submit">All Games</button>
            </form> 
            <button disabled>My Games</button>
            <form action="${pageContext.request.contextPath}/AddGame" method="GET">
                <button type="submit">Add Game</button>
            </form> 
            <form action="${pageContext.request.contextPath}/ShowGame" method="GET">
                <button type="submit">Show Game</button>
            </form> 
        </div>
        
        
        <% 
            Collection<Game> games = (Collection) request.getAttribute("games");
            if (games == null || games.isEmpty()) {
                %>
                <h3 style="color: red">You don't have games yet!</h3>
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
                        <th>Platforms</th>
                    </tr>
                    <% 
                        for(Game g : games) { %>
                            <tr> 
                                <td> <%= g.getName() %> </td>
                                <td> <%= g.getYear() %> </td>
                                <td> <%= g.getPrice() %> </td>
                                <td> <%= g.getDescription() %> </td>
                                <td> <%= Arrays.toString(Arrays.stream(g.platforms.toArray()).map(Platform::getName).collect(Collectors.toList()).toArray()) %> </td>                            
                            </tr> 
                     <% } %>
                </table> 
        <% } %>
        
    </body>
</html>
