<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="myBean" class="org.zerock.myapp.domain.LoginBean" scope="page" />
<jsp:setProperty name="myBean" property="userid" value="john" />
<jsp:setProperty name="myBean" property="passwd" value="1234" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>useBeanSet</title>
</head>
<body>
    <h1>/JSP/useBeanSet.jsp</h1>
    <hr>

    <h1>useBean 사용실습</h1>

    1. userid : <%= myBean.getUserid() %> <br>
    2. passwd : <%= myBean.getPasswd() %>

    <p>&lt;jsp:getProperty/&gt;액션태그로 출력한다면</p>
    1. userid : <jsp:getProperty name="myBean" property="userid" /> <br>
    2. passwd : <jsp:getProperty name="myBean" property="passwd" /> 
    
</body>
</html>