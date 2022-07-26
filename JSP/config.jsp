<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>config.jsp</title>
</head>

<body>
    <h1>/JSP/config.jsp</h1>
    <hr>

    <%  
        String param1 = config.getInitParameter("PARAM1"); // config 내장객체(ServletConfig 타입)를 이용
        String param2 = config.getInitParameter("PARAM2"); // config 내장객체(ServletConfig 타입)를 이용
    %>

    <ol>
        <li>param1: <%= param1 %></li>
        <li>param2: <%= param2 %></li>
    </ol>
</body>
</html>