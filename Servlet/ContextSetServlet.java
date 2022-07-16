package org.zerock.myapp.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@WebServlet("/ContextSet")
public class ContextSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {
			// 속성값설정
			String name = "홍길동";
			int age = 20;
			
			ServletContext sc = req.getServletContext();
			sc.setAttribute("name", name);
			sc.setAttribute("age", age);
			
		} catch (Exception e) {
			throw new IOException(e);
		} // try-catch
				
	} // service

} // end class
