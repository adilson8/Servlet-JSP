<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>count</title>

    <style>
        h2 {
            color : blue;
            background-color: azure;
            font-size: 2em;
            text-align: center;
            border: 5px double red;
            box-shadow: 5px 5px 30px aqua;
        }
    </style>
</head>

<body>
    <h1>/JSP/count.jsp</h1>
    <hr>
    
    <!-- Declaration Tag : 필드나 메소드 선언 -->
    <%! int count; %>

    <%  // Scriptlet Tag : 자바코드로 된 실행문장을 작성
        count++;
        System.out.println(">>> count.jsp : count : " + count);

        application.setAttribute("countValue", count);
    %>
    
    <!-- Expression Tag : 값을 생성 및 출력 -->
    <h2>Visitors: <%= count %></h2>

</body>
</html>