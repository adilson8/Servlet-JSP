<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- page 공유영역에 LoginBean 객체가 있으면 재사용하고 없으면 생성해서 page 공유영역에 바인딩 -->
<jsp:useBean id="myBean" class="org.zerock.myapp.domain.LoginBean" scope="page" />
<!-- 자바빈 객체의 프로퍼티의 이름과 모든 전송파라미터의 이름이 일치하는 경우에만 사용가능 -->
<jsp:setProperty name="myBean" property="*" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>useBeanAll</title>
</head>

<body>
    <h1>/JSP/useBeanAll.jsp</h1>    
    <hr>

    <h1>param 속성을 통한 전송파라미터 자동수집 실습2</h1>

    1. userid: <jsp:getProperty name="myBean" property="userid" /> <br>
    2. passwd: <jsp:getProperty name="myBean" property="passwd" />


</body>
</html>