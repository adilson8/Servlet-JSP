<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // Step1. 전송파라미터 획득
    request.setCharacterEncoding("utf8"); // 내장객체 request 사용
    String userid = request.getParameter("userid");
    String passwd = request.getParameter("passwd");

    // step2. 로그인 처리
    // 무조건 성공이라고 가정(아이디와 암호가 정상 수신된 경우에만)
    if( (userid != null && !"".equals(userid)) &&
        (passwd != null && !"".equals(passwd)) ) { // if normal
        ;;
      } else { // if abnormal
        response.sendRedirect("/loginForm.html");
        System.out.println(">>>>>>>>>> Re-directed <<<<<<<<<<");

        return;     // _jspService() 메소드 블록을 즉시 종료 (깨고 나옴)
      } // if-else

    // step3. 로그인에 성공했다면, 다음으로 과연 무엇을 해야하는가?
    // 현재 로그인 한 웹브라우저와 생명주기가 동일한, Session Scope에
    // 로그인 아이디/암호 2개 정보를 올려 놓기로(공유속성으로 만듦)함.
    session.setAttribute("userid", userid);     // session 내장객체 사용
    session.setAttribute("passwd", passwd);     // session 내장객체 사용

%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>login</title>
</head>
<body>
    <h1>/JSP/login.jsp</h1>
    <hr>

    <ul>
        <li>1. 안녕하세요, <%= userid %>님</li>
        <li>2. <a href="/JSP/loginInfo.jsp">로그인 정보 보기</a></li>
    </ul>    
</body>
</html>