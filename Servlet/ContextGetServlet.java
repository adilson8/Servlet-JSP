package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
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

@WebServlet("/ContextGet")
public class ContextGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
				
		try {
			// 속성 값 얻기
			ServletContext sc = req.getServletContext();
			String name = (String)sc.getAttribute("name");
			int age = (Integer)sc.getAttribute("age");			
			
			// 응답문서 작성
			res.setContentType("text/html; charset=UTF-8");
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println("<html><body>");
			out.println("이름 : " + name + "<br>");
			out.println("나이 : " + age + "<br>");
			out.println("</html></body>");
			
			out.flush();			
			
			//----------
			
			sc.removeAttribute("name");  // 속성 값 내리기
			sc.removeAttribute("age");   // 속성 값 내리기
			
		} catch (Exception e) {
			throw new IOException(e);
		} // try-catch
				
	} // service

} // end class
