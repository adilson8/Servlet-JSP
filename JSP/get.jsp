<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>get.jsp</title>
</head>
<body>
    <h1>/JSP/get.jsp</h1>
    <hr>

    <h1>EL 표현식의 비활성화</h1>
    <%
        request.setAttribute("__EL__", 100);        
    %>

    <p>${ __EL__ }</p>

</body>
</html>