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
        <title>Show Game</title>
    </head>
    <body>
        
        <div style="display: flex"> 
            <form action="${pageContext.request.contextPath}/AllGames" method="GET">
                <button type="submit">All Games</button>
            </form> 
            <form action="${pageContext.request.contextPath}/MyGames" method="GET">
                <button type="submit">My Games</button>
            </form> 
            <form action="${pageContext.request.contextPath}/AddGame" method="GET">
                <button type="submit">Add Game</button>
            </form> 
            <button disabled>Show Game</button>
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
            
        <form action="${pageContext.request.contextPath}/ShowGame" method="POST">
            <P>
            <label>game's name:</label>
            <input required="required" type="text" name="gamename"/>
            <p>
            <button type="submit" name="action" value="search">Search Game</button>
        </form> 
        
        <% Game g = (Game) request.getAttribute("game");
        if (g != null) { %>      
            <table>
                <tr>
                    <th>Name</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Platforms</th>  
                </tr>
                <tr> 
                    <td> <%= g.getName() %> </td>
                    <td> <%= g.getYear() %> </td>
                    <td> <%= g.getPrice() %> </td>
                    <td> <%= g.getDescription() %> </td>
                    <td> <%= Arrays.toString(Arrays.stream(g.platforms.toArray()).map(Platform::getName).collect(Collectors.toList()).toArray()) %> </td>                           
                </tr> 
            </table>         
        <% } %>    
        
    </body>
</html>
