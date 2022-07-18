package org.zerock.myapp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

//@WebListener // web.xml에서 해보자
public class ServletContextListenerImpl implements ServletContextListener {
	
	
//	public ServletContextListenerImpl() {
//		log.trace("Default Constructor invoked.");
//		
//	} // default constructor

	@Override
	public void contextInitialized(ServletContextEvent e)  { 
		log.trace("contextInitialized({}) invoked.", e);
		
		ServletContext sc = e.getServletContext();
		
		// web.xml에 등록된 컨텍스트 파라미터 획득
		String driver = sc.getInitParameter("driver");
		String jdbcUrl = sc.getInitParameter("jdbcUrl");
		String user = sc.getInitParameter("user");
		String pass = sc.getInitParameter("pass");
				
		log.info("\t+ driver : {}", driver);
		log.info("\t+ jdbcUrl : {}", jdbcUrl);
		log.info("\t+ user : {}", user);
		log.info("\t+ pass : {}", pass);	
		
		// Application scope에 올리자!
		sc.setAttribute("driver", driver);
		sc.setAttribute("jdbcUrl", jdbcUrl);
		sc.setAttribute("user", user);
		sc.setAttribute("pass", pass);
		
		} // contextInitialized

	@Override
    public void contextDestroyed(ServletContextEvent e)  { 
    	log.trace("contextDestroyed({}) invoked.", e);
    	
		ServletContext sc = e.getServletContext();    
		
		// 파괴될 때 내리자! 
		sc.removeAttribute("driver");
		sc.removeAttribute("jdbcUrl");
		sc.removeAttribute("user");
		sc.removeAttribute("pass");
    } // contextDestroyed
	
} // end class
