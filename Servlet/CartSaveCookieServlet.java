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

@WebServlet("/CartSaveCookie")
public class CartSaveCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		// step1. 화면에서 전송한 장바구니에 저장할 품목 (전송파라미터)를 획득
		String product = req.getParameter("product");
	
		// step2. 요청메시지의 헤더에 포함되어 있는 모든 쿠키 획득
		Cookie[] cookies = req.getCookies();
		
		// step3. 우리가 직접 새로운 쿠키를 생성하자
		Cookie cookie = null;
		
		if( cookies == null || cookies.length == 0 ) { // 위 스텝2에서 얻는 쿠키 배열이 무효하면
			cookie = new Cookie("product", product);   // 새로운 쿠키객체 생성
		} else {
			cookie = new Cookie("product" + (cookies.length + 1 ), product); // 새로운 쿠키객체 생성
		} //if-else
		
		// step4. 우리가 생성한 쿠키의 만료기간 설정
		cookie.setMaxAge(60 *60); // 1시간동안 유지 (브라우저에서)
		
		// step5. 응답메시지의 헤더에, 우리가 위 스텝3에서 생성한 쿠키객체를 저장
		res.addCookie(cookie); // 응답문서 헤더에 새로운 쿠키를 추가하여 응답으로 보냄
		
		// step6. 응답문서 생성 및 전송
		res.setContentType("text/html; charset=utf8");
		
		@Cleanup
		PrintWriter out = res.getWriter();
		
		out.print("Ptoduct 추가 <br>");
		out.print("<a href='/CarBasketCookie'> 장바구니 보기 </a>");

		out.flush();
	}// service

} // end class
