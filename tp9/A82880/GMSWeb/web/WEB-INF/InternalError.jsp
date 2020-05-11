<%-- 
    Document   : InternalError
    Created on : Apr 25, 2020, 4:22:05 PM
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
        <h1>Hello World!</h1>
        <% 
            String error = (String) request.getAttribute("res");
            out.println(error);
        %>
    </body>
</html>
