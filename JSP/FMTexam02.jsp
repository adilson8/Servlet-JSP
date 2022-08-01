<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>exam02</title>
</head>
<body>
    <h1>/FMT/exam02.jsp</h1>
    <hr>

    <h2>JSTL fmt 라이브러리 실습 #1</h2>
    <hr>

    <!-- 1. core library -->
    <c:set var="myDate" value="<%= new Date() %>" scope="page" />
    1. <c:out value="${ myDate }" /> <br>

    <!-- 2. formatting library -->
    2. <fmt:formatDate value="${ myDate }" type="date" /> <br>
    3. <fmt:formatDate value="${ myDate }" type="time" /> <br>
    4. <fmt:formatDate value="${ myDate }" type="both" /> <br>
    5. <fmt:formatDate value="${ myDate }" type="both" dateStyle="short" timeStyle="long" /> <br>
    6. <fmt:formatDate value="${ myDate }" type="both" dateStyle="long" timeStyle="short" /> <br>
    7. <fmt:formatDate value="${ myDate }" type="both" pattern="yyyy/MM/dd HH:mm:ss.SSS" /> <br>

    <h2>JSTL fmt 라이브러리 실습 #2</h2>
    <hr>

    1. <fmt:formatNumber value="100000" type="currency" /> <br>
    2. <fmt:formatNumber value="0.123" type="percent" /> <br>
    3. <fmt:formatNumber value="987654321.1234" pattern="###,###,###.00" /> <br>

</body>
</html>