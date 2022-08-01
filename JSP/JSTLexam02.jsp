<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>exam02.jsp</title>
</head>
<body>
    <h1>/JSTL/exam02.jsp</h1>
    <hr>
    
    <c:out value="${__PAGE__}" /> <br>
    <c:out value="${__REQUEST__}" /> <br>
    <c:out value="${__SESSION__}" /> <br>
    <c:out value="${__APPLICATION__}" /> <br>

</body>
</html>