<%-- 
    Document   : addgame
    Created on : 24/abr/2020, 22:42:37
    Author     : joaomarques
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="business.Platform"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
            }

            td {
                text-align: left;
                padding: 8px;
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
            
            input[type="submit"]:disabled {
                background: #f5f5f5;
                color: lightgray;
            }
        </style>
    </head>
    <body>
        <h1>Add Game</h1>
        <form method="GET">
            <input type="submit" formaction="${pageContext.request.contextPath}\AllGames" value="All Games"/>
            <input type="submit" formaction="${pageContext.request.contextPath}\MyGames" value="My Games"/>
            <input type="submit" formaction="${pageContext.request.contextPath}\AddGame" value="Add Game" disabled="disabled"/>
            <input type="submit" formaction="${pageContext.request.contextPath}\SearchGame" value="Search Game"/>
            <input type="submit" formaction="${pageContext.request.contextPath}\AddGame" name="logout" value="Logout"/>
        </form>
        <%
            String error = (String) request.getAttribute("error");
            if(error!=null) out.println(error);
        %>
        <form method="POST" action="${pageContext.request.contextPath}\AddGame">
            <table>
                <tbody>
                    <tr>
                        <td>Name:</td>
                        <td><input required="required" type="text" name="name"/></td>
                    </tr>
                    <tr>
                        <td>Year:</td>
                        <td><input required="required" min="1960" max="<%int year = Calendar.getInstance().get(Calendar.YEAR); out.println(year);%>" type="number" name="year"/></td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td><input required="required" min="0" step="0.01" type="number" name="price"/></td>
                    </tr>
                    <tr>
                        <td>Platform:</td>
                        <td>
                            <select name="platform">
                                <% List<Platform> platforms = (List) request.getAttribute("platforms");
                                for(Platform p : platforms) { %>
                                    <option value="<%= p.getName() %>"><%= p.getName() %></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td><input required="required" type="text" name="description"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="actionaddgame" value="Add Game"/>
        </form>
    </body>
</html>
