<%-- 
    Document   : Ejemplo
    Created on : 21-mar-2018, 18:52:37
    Author     : estebanpalomoferrer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:catch var="error">
        <%-- Acceso al parámetro "numero" mediante el objeto param en una EL --%>
        <p><fmt:formatNumber value="${param.numero}" pattern="##.##"/>
        </c:catch>
        
        <c:if test="${!empty error}">
        <p>Debe escribir un número
        </c:if>
                        
        <br>Longitud cadena: ${fn:length("hola")}
        
        <%-- Acceso al parámetro "numero" mediante el objeto request --%>
        <br><p><%= request.getParameter("numero") %>
        
    </body>
</html>
