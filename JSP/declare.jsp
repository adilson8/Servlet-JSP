<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>declare.jsp</title>
</head>

<body>
    <h1>JSP/declare.jsp</h1>
    <hr>

    <h2>선언태그를 이용한 JSP Lifecycle 메소드</h2>
</body>

</html>

<%!
    // 1. 변환될 클래스 소스파일에 필드 선언
    private String initMesg="jspInit 메소드" ;
    private String delMesg="jspDestroy 메소드" ;

    // 2. 변활될 클래스 소스 파일에 메소드 선언
    // JSP Lifecycle (서블릿과 비슷하게) 메소드

    public void jspInit() { // when NEW state, called back.
        System.out.println(">>>>> " + initMesg + " <<<<<");
    } // jspInit

    public void jspDestroy() { // when DESTROY state, called back.
        System.out.println(">>>>> " + delMesg + " <<<<<");
    } // jspDestroy
%>