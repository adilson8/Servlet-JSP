package org.zerock.myapp.servlet;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

@WebServlet("/PostPre")
public class PostPreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
	} // service	

	@Override
	public void init(ServletConfig config) throws ServletException { 
		log.trace("inint({}) invoked.", config);
	} // init
	
	@Override
	public void destroy() {
		log.trace("destroy() invoked.");		
	} // destroy
	
	@PostConstruct  // init 보다 먼저 호출됨
	public void postConstruct(){
		log.trace("postConstruct() invoked.");
	} // postConstruct
	
	@PreDestroy     // destroy 보다 늦게 호출됨
	public void preDestroy(){
		log.trace("preDestroy() invoked.");
	} // preDestroy

} // end class
