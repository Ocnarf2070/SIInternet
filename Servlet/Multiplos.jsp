<%-- 
    Document   : Multiplos
    Created on : 04-abr-2018, 11:52:37
    Author     : Franco Emanuel González Sánchez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%! List<Integer> multiplos(int n){
	List<Integer> list = new ArrayList<>();
	for(int i=1;i<=n;i++)if(n%i==0)list.add(i);
	return list;
}%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

		<br><p>Numero: <%= request.getParameter("numero") %>
        
    </body>
</html>