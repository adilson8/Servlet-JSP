<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

    <title>useBeanScope</title>
</head>
<body>
    <h1>/JSP/useBeanScope.jsp</h1>
    <hr>

    <h1>useBean 사용실습</h1>

    <%
        myBean.setUserid("John");
        myBean.setPasswd("1234");
    %>

    1. userid: <%= myBean.getUserid() %> <br>
    2. passwd: <%= myBean.getPasswd() %>

    <p>&nbsp;</p>
    <h3>myBean: <%= myBean %></h3>

</body>
</html>