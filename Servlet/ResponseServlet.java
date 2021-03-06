package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebServlet("/Response")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.", req, res);
		
		// step1. 공유데이터 영역(Req.Scope)에서 Model 얻어내기
		String name = (String) req.getAttribute("name");
		String address = (String) req.getAttribute("address");
		
		log.info("Model - name : {}, address : {}", name, address);
		
		// step2. Model을 이용한 응답문서의 생성 및 전송
		res.setContentType("text/html; charset=utf8");
		
		@Cleanup
		PrintWriter out = res.getWriter();
		
		out.println("<h1>/Response</h1>");
		out.println("<hr>");
		
		out.println("<h2> 1. name : " + name + "<h2>");
		out.println("<h2> 2. address : " + address + "<h2>");

		out.flush();		
	} // service

} // end class


//try {	// 웹 어플리케이션의 예외처리를 따로 또 해주어야한다!		
//	
//	// 문서의 타입 설정
//	res.setContentType("text/html; charset=UTF-8");
//	
//	// 자바 입출력 (I/O)
//	@Cleanup  // 자원객체는 썼으면 닫자 (try-with로 닫는건 HelloServlet.java 참고)
//	PrintWriter out = res.getWriter();
//	
//	// html 작성 및 출력
//	out.println("<html><body>");
//	out.println("응답 문서 생성 성공!!");
//	out.println("</body></html>");
//	
//	out.flush(); // 잔류 데이터 방출
////	out.close(); // @Cleanup 혹은 try-with-resources로 닫자
//	
//} catch (Exception e) {        // 어떠한 예외가 발생해도 다 잡아라
//	throw new IOException(e);  // 발생한 그 예외를 여기로 던져라 
//} // try-catch // 웹 어플리케이션의 예외처리를 따로 또 해주어야한다!