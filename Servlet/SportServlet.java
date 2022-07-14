package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

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

@WebServlet("/Sport")
public class SportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
			// 1. 전송 파라미터 를 받아서 String 타입의 변수에 저장
			req.setCharacterEncoding("utf8");  // 전송되는 값에 한글이 들어있기 때문에 타입을 설정해준다
			String gender = req.getParameter("gender");         // 전송되는 값이 하나
			String[] sports = req.getParameterValues("sports"); // 전송되는 값이 여러개 
			
			log.info("gender: {}, sports: {}", gender, Arrays.toString(sports));
			
			// 2. 응답문서 생성
			res.setContentType("text/html; charset=UTF-8");     // 응답문서 타입 설정
			@Cleanup                                            // 자원객체 썼으면 닫자
			PrintWriter out = res.getWriter();
			
			out.println("<ol>");
			
			out.println("<li>" + gender + "</li>");
			
			for(String sport : sports) {
				out.println("\t <li>" + sport + "</li>");
			} // enhanced for (iterable 하기에 사용 가능)
			
			out.println("</ol>");
						
			out.flush();                                        // 잔류 데이터 방출
		} catch (Exception e) {
			throw new ServletException(e);
		} // try-catch		
	} // service

} // end class
