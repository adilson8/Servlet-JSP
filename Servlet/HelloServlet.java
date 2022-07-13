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

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		log.trace("service(req, res) invoked.", req, res);
		
		try {
		
//		============ 응답 문서의 생성 및 전송 =============
			res.setCharacterEncoding("utf8");
			
			@Cleanup // 자원객체 닫는 방법 1 -> 순서 상관 없이 닫을 떄
			PrintWriter out = res.getWriter();
			
//			// 자원객체 닫는 방법2 -> 순서 있게 닫을 때
//			try (out) {			
				out.println("<html><head></head><body>");		
				out.println("<h1>Hello, World!!!</h1>");		
				out.println("</body></html>");
				
				out.flush();
//			} // try-with-resources
					
			
//			int value = Integer.parseInt("백"); // 예외발생코드 (예외가 생기면 어떻게 될까?)		
		} catch (Exception e) {
			throw new IOException(e);
		} // try-catch
	} // service

} // end class
