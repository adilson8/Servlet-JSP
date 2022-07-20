package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.service.Service;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebServlet("/View")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		// 최종으로 request scope에 공유된 Model(비지니스 수행데이터)와
		// 넘겨받은 request, response를 이용하여, 최종으로 동적인 응답화면 생성 및 전송
		res.setContentType("text/html; charset=utf8");		
		@Cleanup
		PrintWriter out = res.getWriter();
		
		Object bizResult = req.getAttribute(Service.MODEL);
		
		out.println("<p>" + bizResult + "</p>");
		

		out.flush();	
		
	} // service

} // end class
