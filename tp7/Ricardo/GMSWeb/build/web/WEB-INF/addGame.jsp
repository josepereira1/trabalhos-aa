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
        
        <form action="${pageContext.request.contextPath}/AddGame" method="POST">
            <button type="submit" name="addGameAction" value="allGames">All Games</button>
            <button type="submit" name="addGameAction" value="userGames">My Games</button>  
            <button disabled>Add Game</button>
            <button type="submit" name="addGameAction" value="showGame">Show Game</button>
        </form> 
            
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
                   <span style="color: red">year does not have a valid (integer) format! ex: 2020</span>
                   <p>
                   <%
                }
                else if (warningType == 2) {
                   %> 
                   <span style="color: red">price does not have a valid (double) format! ex: 15.99</span>
                   <p>
                   <%
                }
                else if (warningType == 3) {
                   %> 
                   <span style="color: red">game already exists!</span>
                   <p>
                   <%
                }
            }   
        %>
            
        <form action="${pageContext.request.contextPath}/AddGame" method="POST">
            
            <label>name:</label>
            <input required="required" type="text" name="name"/>
            <p>
            <label>year:</label>
            <!-- o valor máximo é o ano atual -->
            <input required="required" type="number" min="0" max=" <% int year = Calendar.getInstance().get(Calendar.YEAR); out.println(year); %> " name="year"/>
            <p>
            <label>price:</label>
            <!-- 2 casas decimais e valor mínimo = 0 -->
            <input required="required" type="number" step="0.01" min="0" name="price"/>
            <p>
            <label>description:</label>
            <input required="required" type="text" name="description"/>
            <p>
            <label>Platform</label>
            <% Collection<Platform> platforms = (Collection<Platform>) request.getAttribute("platforms"); %>
            <select required="required" name="platformname">
                <% for(Platform p : platforms) { %>
                    <option> <%= p.getName() %> </option>
                <% } %>
            </select>
            <p>
            <button type="submit" name="addGameAction" value="addGame">Add Game</button>
        </form> 
    </body>
</html>
