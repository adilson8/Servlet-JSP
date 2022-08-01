<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>exam01</title>
</head>
<body>
    <h1>/FMT/exam01.jsp</h1>
    <hr>

    <h2>JSTL fmt 라이브러리 실습#1</h2>
    <hr>

    <fmt:setBundle basename="bundle" var="myBundle" scope="page" />
    
    <p>
        <fmt:message key="sendMessage" bundle="${ myBundle }" />
    </p>
</body>
</html>