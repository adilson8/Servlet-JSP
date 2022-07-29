<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="myBean" class="org.zerock.myapp.domain.LoginBean" />

<!-- param 속성에 지정한 이름이 바로 전송 파라미터의 이름임 -->
<jsp:setProperty name="myBean" property="userid" param="userid" />
<jsp:setProperty name="myBean" property="passwd" param="passwd" />


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>useBeanParam</title>
</head>

<body>
    <h1>/JSP/useBeanParam</h1>
    <hr>

    <h1>param 속성을 통한 전송 파라미터 자동수집 실습</h1>

    1. userid: <%= myBean.getUserid() %> <br>
    1. passwd: <%= myBean.getPasswd() %> <br>

    <!--  -->
    <p>다른 방식으로 해보자 (위에 방법이 더 낫다)</p>

    1. userid: <jsp:getProperty name="myBean" property="userid" /><br>
    1. passwd: <jsp:getProperty name="myBean" property="passwd" />
    
</body>
</html>