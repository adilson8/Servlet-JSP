package org.zerock.myapp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		 
		if(command.equals("/insert.do")){
			System.out.println("insert 요청");
			
		}else if(command.equals("/delete.do")){
			System.out.println("delete 요청");
			
		}else if(command.equals("/update.do")){
			System.out.println("update 요청");
			
		}else{
			System.out.println("select 요청");
		} // if-else
		
	} // service

} // end class
