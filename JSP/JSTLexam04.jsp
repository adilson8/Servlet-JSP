<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>exam04</title>
</head>
<body>
    <h1>/JSTL/exam04.jsp</h1>
    <hr>
    
    <h2>JSTL Core 라이브러리 실습</h2>
    <hr>

    <%  // scriptlet tag
        
        int [] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        
        // request scope에 배열객체 바인딩
        request.setAttribute("myArray", num);
    %>

    <c:forEach var="element" items="${ myArray }">
        ${element} <br>
    </c:forEach>

    <h2>JSTL Core 라이브러리 실습 #2</h2>
    <hr>

    <%  // scriptlet tag : 인덱스 기반의 자료구조인 List 컬렉션 생성 및 공유속성 바인딩

        // Arrays.asList() 메소드를 사용해보자
        java.util.List<String> list = Arrays.asList("홍길동", "이순신", "유관순");

        request.setAttribute("__NAME__", list);
    %>

    <c:forEach var="name" items="${__NAME__}">
        ${name} <br>
    </c:forEach>

    <h2>JSTL Core 라이브러리 실습 #3</h2>
    <hr>

    <%  // scriptlet tag
        String str = "A,B,C,D";
        request.setAttribute("data", str);
    %>

    <c:forTokens var="token" items="${ data }" delims=",">
        <c:out value="${ token }" /> <br>
    </c:forTokens>
</body>
</html>