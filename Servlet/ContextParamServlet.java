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

@WebServlet("/ContextParam")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @Override  
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
			// Context Parameters를 얻어보자!!
			// 웹 어플리케이션(=context)마다 생성되는 'ServletContext' 객체가 필요하다
			// HttpServletRequest 타입의 req 객체를 통해 'ServletContext' 타입의 객체를 얻자
			ServletContext sc = req.getServletContext();	
			String driver = sc.getInitParameter("driver");     
			String savePath = sc.getInitParameter("savePath"); 
			
			log.info("driver : {}, savePath : {}", driver, savePath);
			
			// 응답 문서 생성
			res.setContentType("text/html; charset=UTF-8");
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println("<html><body>");
			out.println("드라이버명: " + driver +"<br>");
			out.println("저장경로: " + savePath +"<br>");
			out.println("</html></body>");
			
			out.flush();			
			
		} catch(Exception e) {
			throw new IOException();
		} // try-catch 
		
	} // service
    
} // end class
