<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 현재 페이지 : main.jsp-->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
</head>

<body>
    <h1>/JSP/main2.jsp</h1>
    <hr>

    <h1>include 지시어 태그 실습</h1>

    현재 시간을 구하는 예제입니다. 다음 줄에 header.jsp를 삽입하겠습니다. <br>

    <!-- 동적인 삽입 수행 -->
    <jsp:include page="/JSP/header.jsp" flush="true">
        <jsp:param name="nickName" value="홍길동" />
    </jsp:include>

    <hr>

    <!-- 정적인 삽입 수행 -->
    <!-- <%@ include file="/JSP/header.jsp" %> -->

</body>
</html>