<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="myBean" class="org.zerock.myapp.domain.LoginBean" />
<jsp:setProperty name="myBean" property="userid" value="john" />
<jsp:setProperty name="myBean" property="passwd" value="1234" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>useBeanGet</title>
</head>

<body>    
    <h1>getProperty 실습</h1>
    
    <!-- useBean으로 얻어낸 자바빈 객체의 프로퍼티 값을 원하는 위치에 출력 -->
    1. 사용자 아이디: <jsp:getProperty name="myBean" property="userid" /> <br>
    2. 사용자 비밀번호: <jsp:getProperty name="myBean" property="passwd" />

    <!-- 다른 방법으로 해보자 (이게 낫다) -->
    1. userid: <%= myBean.getUserid() %> <br>
    2. passwd: <%= myBean.getPasswd() %>

</body>
</html>