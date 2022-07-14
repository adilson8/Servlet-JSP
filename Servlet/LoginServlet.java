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

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked");
		
		try {
			// 1. 전송 파라미터 (Request Parameters)를 받아서 String 타입의 변수에 저장
			String userid = req.getParameter("userid");
			String passwd = req.getParameter("passwd");
			
			log.info("\t+ userid : {}, passwd : {}", userid, passwd);
			
			// 2. 응답 문서를 생성한다 (에코)
			res.setContentType("text/html; charset=UTF-8"); // 응답문서 타입 설정
			@Cleanup                                        // 자원객체 썼으면 닫자
			PrintWriter out = res.getWriter();
						
			out.println("<ul>");
			out.println("	<li>"+userid+"</li>");
			out.println("	<li>"+passwd+"</li>");
			out.println("</ul>");
			
			out.flush();                                    // 잔류 데이터 방출			
		} catch (Exception e) {
			throw new ServletException(e);  // ServletException, IOException 둘 중 하나 적어준다
		} // try-catch
	} // service
} // end class
