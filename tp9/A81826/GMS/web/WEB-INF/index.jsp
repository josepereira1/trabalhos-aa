<%-- 
    Document   : index
    Created on : 24/abr/2020, 19:38:40
    Author     : joaomarques
--%>

<%@page import="java.util.List"%>
<%@page import="business.Game"%>
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
        <h1>Games</h1>
        <form method="GET">
            <input type="submit" formaction="${pageContext.request.contextPath}\Login" name="login" value="Login"/>
        </form>
        <%
            String error = (String) request.getAttribute("error");
            if(error!=null) out.println(error);
        %>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Platform</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <% List<Game> games = (List) request.getAttribute("games");
                for(Game g : games) { %>
                    <tr>
                        <td><%= g.getName() %></td>
                        <td><%= g.getYear() %></td>
                        <td><%= g.getPrice() %></td>
                        <td><%= g.getPlatform().getName() %></td>
                        <td><%= g.getDescription() %></td>
                    </tr>
                <%}%>
            </tbody>
        </table>
        <p>
        <p>
        <p>
        ${useragent}
    </body>
</html>
