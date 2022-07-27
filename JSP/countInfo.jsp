<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>countInfo</title>
</head>

<body>
    <h1>/JSP/countInfo.jsp</h1>
    <hr>

    <h1>방문자 수 조회화면</h1>

    <%  // Scriptlet : App.Scope에 바인딩 되어있는 공유속성(방문자 수)을 얻어서 출력
        // application 내장객체의 타입 : ServletContext 객체
        int visitors = (Integer) application.getAttribute("countValue");
    %>

    <p>현재까지 총 방문자 수: <%= visitors %></p>
</body>
</html>