<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>

<!-- JSP 코드 내에서 사용하는 자바타입이 있는 경우에는 아래와 같이 import 속성으로 자바타입을 기재한다. -->

<%@page
    import="java.util.Date"
    import="java.util.Calendar"
    import="java.util.List" 
%>

<%  // Scriptlet Tag : 자바 실행문장(조각)들을 실행
    Date now = new Date();
    System.out.println("- now: " + now);

    int age = 23;
%>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>currentTime.jsp</title>
</head>

<body>
    <h1>현재 날짜 출력 실습</h1>

    <h2>Now: <%= now %></h2>
    <h2>1. 이름 : <%= "Yoseph" %></h2>
    <h2>2. 산술연산식의 결과 : <%= 10+100 %> </h2>
    <h2>3. 강사의 나이: <%= age %></h2>
</body>
</html>

