<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>current.jsp</title>
</head>

<body>
    <h1>/JSP/current.jsp</h1>
    <hr>

    <jsp:forward page="/JSP/forward.jsp">
        <jsp:param name="nickName" value="한글" />
    </jsp:forward>
</body>
</html>




