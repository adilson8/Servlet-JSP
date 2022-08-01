<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>exam03</title>
</head>
<body>
    <h1>/JSTL/exam03.jsp</h1>
    <hr>

    <h2>JSTL Core 라이브러리 실습 #1</h2>
    <hr>

    <c:set var="myColor" value="빨강" scope="page" />

    <c:if test="${ myColor == '빨강' }" >
        <p>색상은 빨강색이다.</p>
    </c:if>

    <h2>JSTL Core 라이브러리 실습 #2</h2>
    <hr>

    <c:set var="grade" value="70" scope="request" />

    <c:choose>
        <c:when test ="${ grade >= 90 }">
            학점은 A 이다.
        </c:when>
        
        <c:when test ="${ grade >= 80 }">
            학점은 B 이다.
        </c:when>

        <c:when test ="${ grade >= 70 }">
            학점은 C 이다.
        </c:when>

        <c:otherwise>
            학점은 F 이다.
        </c:otherwise>

    </c:choose>

</body>
</html>