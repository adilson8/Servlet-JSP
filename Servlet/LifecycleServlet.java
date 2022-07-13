package org.zerock.myapp.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

// Servlet의 Lifecycle과 그 callback 메소드들을 이해하자
@WebServlet({ "/Lifecycle1", "/Lifecycle2" })
public class LifecycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void init(ServletConfig config) throws ServletException {
		log.trace("inint({}) invoked.", config);
	} // init

	@Override
	public void destroy() {
		log.trace("destroy({}) invoked.");
	} // destroy

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
	} // service

}
