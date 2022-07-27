<%@ page 
    language="java" 
    isErrorPage="true"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 이 JSP는 다른 JSP에서 발생하는 예외를 내장객체인 exception으로 받아서
예외처리하는 역할을 수행한다. (isErrorPage="true" 인 경우) -->

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>exceptionHandling</title>
</head>
<body>
    <h1>/JSP/exceptionHandling.jsp</h1>
    <hr>

    <h1>Lorem ipsum dolor sit amet.</h1>

    <h2><%= exception %></h2>

    <ol>
        <%
            StackTraceElement[] stackTrace = exception.getStackTrace();

            for(StackTraceElement element : stackTrace) {
        %>
                <li>at <%= element %> </li>

        <% } // enhanced for %>
    </ol>
</body>
</html>