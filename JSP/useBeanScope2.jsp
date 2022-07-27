<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 세션 공유영역에 올라가 있는 로그인 빈 객체를 얻어냄 -->
<!-- 주의 : 이 useBean 액션태그는 빈객체가 이미 지정된 공유영역에 있으면 그 빈 객체를 가져오고, 
            없으면 빈객체를 만들어 지정된 공유영역에 올려놓음 -->

<jsp:useBean
    id="myBean"
    class="org.zerock.myapp.domain.LoginBean"
    scope="session" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>useBeanScope2</title>
</head>
<body>
    <h1>/JSP/useBeanScope2.jsp</h1>
    <hr>

    <h1>useBean 사용실습</h1>

    1. userid: <%= myBean.getUserid() %> <br>
    2. passwd: <%= myBean.getPasswd() %>

    <p>&nbsp;</p>
    <h3>myBean: <%= myBean %></h3>
    
</body>
</html>