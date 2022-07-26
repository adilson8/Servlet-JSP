<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>main</title>
</head>

<body>
    <h1>/JSP/main.jsp</h1>    
    <hr>

    <h1>Lorem ipsum dolor sit amet.</h1>
    <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit.</p>

    <h2>1. Static injection</h2>
    <%@ include file="copyright.jsp" %>

    <hr>

    <h2>2. Dynamic injection</h2>
    <jsp:include page="copyright.jsp"/>
</body>
</html>