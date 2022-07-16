package org.zerock.myapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {

	// * Context = Web application 
	
	// 우리가 만든 Web Application이 WAS를 따라 올라오면서 초기화 될때 
	// Servlet Container에 의해 콜백 된다 (WAS를 start 시키고 로그 확인)
	@Override
	public void contextInitialized(ServletContextEvent e)  { 
		log.trace("contextInitialized({}) invoked", e);
	} // contextInitialized
	
	// 우리가 만든 Web Application이 WAS를 따라 내려가면서 초기화 될때
	/// Servlet Container에 의해 콜백 된다	(WAS를 stop 시키고 로그 확인)
	@Override
    public void contextDestroyed(ServletContextEvent e)  { 
		log.trace("contextDestroyed({}) invoked", e);
    } // contextDestroyed
		
} // end class
