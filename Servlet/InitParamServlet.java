package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

//어노테이션 말고 web.xml에 직접 등록 해보자 -> 현재 web.xml에 등록 안 되어있음!
//@WebServlet("/InitParam") 
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {			
			
			// 1. GenericServlet의 getInitParameter(name) 메서드를 사용하여 web.xml에 설정한 초기화 파라미터를 얻자.
			String dirPath = this.getInitParameter("dirPath"); // 상속받은 메소드는 그냥 사용도 가능하지만 클래스.메소드로 써줘야한다 
			String userid = this.getInitParameter("userid");   // 상속받으면 내꺼니까 this. 붙여주면 된다.
			
			log.info("\t+ dirPath : {}, userid: {}", dirPath, userid);
			
			// 2. 응답문서 생성
			res.setContentType("text/html; charset=UTF-8");
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println("<html><body>");
			out.println("디렉토리 경로 :" + dirPath + "<br>");
			out.println("아이디 값 : " + userid + "<br>");
			out.println("</body></html>");			
			out.flush();
		} catch(Exception e) {
			throw new IOException();
		} // try-catch
 
	} // service
	
} // end class




//// 강사님 코드
//public class InitParamServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	private Connection conn; 	
//
//	@Override
//	public void init(ServletConfig config) throws ServletException { // 서블릿에서 사용될 자원객체를 생성
//		
//		try {			
//			super.init(config); // 반드시 수행해야 물려받은 모든 메소드가 정상작동함
//			
//			log.trace("init({}) invoked.", config);
//			
//			// getInitParameter(name) 메서드를 사용하여 web.xml에 설정한 초기화 파라미터를 얻자.
//			String jdbcDriver = this.getInitParameter("jdbcDriver");  
//			String jdbcUrl =  this.getInitParameter("jdbcUrl");   
//			String user =  this.getInitParameter("user");
//			String pass =  this.getInitParameter("pass");
//			
//			log.info("\t+ jdbcDriver : {}, jdbcUrl: {}, user : {}, pass: {}", jdbcDriver, jdbcUrl, user, pass);
//
//			// Oracle Cloud ATP에 대한 JDBC Connection 생성		
//			Class.forName(jdbcDriver);
//			this.conn = DriverManager.getConnection(jdbcUrl, user, pass);
//			
//		} catch (Exception e) {
//			throw new ServletException(e);
//		} // try-catch
//	} // init	
//	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse res) 
//			throws ServletException, IOException {
//		log.trace("service(req, res) invoked.");
//		
//		try {
//			// 비지니스 로직 수행 - 현재의 날짜와 시간을 얻어라
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT current_date FROM dual");
//			
//			Date now = null;
//			
//			if(rs.next()) {
//				now = rs.getDate("current_date");
//			} // if
//			
//			// 응답문서 생성
//			res.setContentType("text/html; charset=UTF-8");
//			@Cleanup
//			PrintWriter out = res.getWriter();
//			
//			out.println("<h1> Current Time :" + now + "</h1>");				
//			out.flush();			
//		} catch(Exception e) {
//			throw new IOException();
//		} // try-catch
// 
//	} // service
//
//	@Override
//	public void destroy() { // 서블릿에서 사용된 자원객체를 해제
//		log.trace("destroy() invoked.");
//		
//		try {
//			if(this.conn != null && !this.conn.isClosed())
//				this.conn.close();			
//		} catch (SQLException e) {;;}
//
//	} // destroy
//
//} // end class
