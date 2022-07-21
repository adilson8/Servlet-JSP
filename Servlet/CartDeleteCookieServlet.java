package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebServlet("/CartDeleteCookie")
public class CartDeleteCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 클라이언트 브라우저에 쿠키파일로 저장되어 있는 모든 장바구니 데이터를 삭제
	// 어떻게? => 각 쿠키의 만료 기간을 조작!!!
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		// step1. 웹 브라우저가 보낸 request 메시지의 헤더에 있는 모든 쿠키를 배열로 획득
		Cookie[] basket = req.getCookies();
		
		// step2. 각 쿠키의 만료기간을 1로 바꾸어서 바로 만료되게 만듦
		if(basket != null) { // 장바구니가 있다면
			for(Cookie cookie : basket) {
				cookie.setMaxAge(1); // 만료기간 1초로 변경 (바로 삭제)
				
				// 1초의 만료기간으로 변경된 쿠키들을 다시 웹 브라우저로 보내면
				// 웹 브라우저는 이 사이트 주소에 대해 파일로 보관중이던 
				// 모든 쿠키를 1초후에 파괴시켜버림
				res.addCookie(cookie); // 시간만료가 걸정된 쿠키를 브라우저로 전송
			} // enhanced for
		} // if
		
		// 응답문서 생성 및 전송
		res.setContentType("text/html charset=utf8");
		@Cleanup
		PrintWriter out = res.getWriter();
		
		out.print("<a href='product.html'>상품 선택 페이지</a>");
		
		out.flush();
	
	}// service

} // end class
