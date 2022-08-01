<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="myBean" class="org.zerock.myapp.domain.LoginBean" scope="page" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>exam01.jsp</title>
</head>

<body>
    <h1>/JSTL/exam01.jsp</h1>
    <hr>

    <h2>JSTL Core 라이브러리 실습#1</h2>
    <hr>

    <!-- set 태그의 목적 -->
    <!-- var 속성 : 바인딩되는 속성의 이름지정 -->
    <!-- value 속성: 바인딩되는 속성의 값 -->
    <!-- 이 태그의 var 속성의 값이 EL 변수명이 됨! -->

    <c:set var="__PAGE__"           value="VALUE_1" scope="page" />
    <c:set var="__REQUEST__"        value="VALUE_2" scope="request" />
    <c:set var="__SESSION__"        value="VALUE_3" scope="session" />
    <c:set var="__APPLICATION__"    value="VALUE_4" scope="application" />

    <!-- out 태그의 value 속성의 값: (1) 문자열 or (2) EL 표기법 -->
    1. <c:out value="Helllo World"/> <br>
    2. <c:out value="${ __PAGE__ }"/> <br>
    3. ${ __PAGE__ } <br>

    <h2>JSTL Core 라이브러리 실습#2</h2>
    <hr>

    <!-- 4개의 공유영역에 한군데에 정한 이름으로 정한 값을 바인딩 수행  -->

    <!-- 아래의 set 태그는 공유영역에 속성 바인딩을 수행하는 것이 아니라
    이미 공유영역에 바인딩 되어있는 자바빈즈 객체의 특정 프로퍼티의 값을
    설정 (set) 하는 태그 역할을 수행 -->

    <c:set target="${ myBean }" property="userid" value="trinity" />

    4. ${ myBean.userid } <br>
    5. <c:out value="${ myBean.userid }" />

    <h2>JSTL Core 라이브러리 실습 #3</h2>
    <hr>

    1. 삭제전 : <c:out value="${__REQUEST__}" /> <br>

    <c:remove var="__REQUEST__"/>

    2. 삭제후 : <c:out value="${ __REQUEST__ }" />
    
</body>
</html>