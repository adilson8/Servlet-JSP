package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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

@WebServlet("/Member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override	
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");	
		
		try {
			// 1. 전송 파라미터 를 받아서 String 타입의 변수에 저장
			req.setCharacterEncoding("UTF-8"); // GET 방식, POST 방식 모두 무조건 해주자
			Enumeration<String> enu = req.getParameterNames(); // 전송되는 값이 여러개
			
			// 2. 응답문서 생성
			res.setContentType("text/html; charset=UTF-8");    // 문서 타입 설정
			@Cleanup                                           // 자원객체는 썼으면 닫자
			PrintWriter out = res.getWriter();
			
			out.println("<ol>");
			
			while (enu.hasMoreElements()) {
				String paramName = enu.nextElement();
				String paramValue = req.getParameter(paramName);
				log.info("\t+ paramName: {}, paramValue: {}", paramName, paramValue);
				
				out.println(String.format("<li> %s : %s </li>", paramName, paramValue));			
			} // while
			
			out.println("</ol>");
			
			out.flush();									   // 잔류 데이터 방출			
		} catch (Exception e) {
			throw new ServletException(e);
		} // try-catch
	} // service
} // end class
