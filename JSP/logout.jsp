<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    // step1. 해당 브라우저에 할당된 Session Scope 파괴
    session.invalidate();

    // step2. 로그아웃처리 후에, 웹브라우저는 어느 화면으로 이동할까?
    response.sendRedirect("/loginForm.html");  // Re-direct

    // RequestDispatcher dispatcher = request.getRequestDispatcher("/loginForm.html");
    // dispatcher.forward(request, response); // Request Forwarding

%>