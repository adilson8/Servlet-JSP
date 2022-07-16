package org.zerock.myapp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

@WebServlet("/ContextFile")
public class ContextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try {			
			// ServletContext를 이용해 "src/main/webapp/WEB-INF/testFile.txt" 읽어내자
			// "/WEB-INF/testFile.txt" (웹 어플리케이션 기준으로 보면, Content Root가 사라짐)		
			ServletContext sc = req.getServletContext(); // this. 말고 req. 로 얻자 
			@Cleanup 
			InputStream is = sc.getResourceAsStream("/WEB-INF/testFile.txt");  // InputStream 객체 얻기
			@Cleanup 
			BufferedReader br = new BufferedReader(new InputStreamReader(is)); // 성능 향상
			
			// 응답문서 작성
			res.setContentType("text/html; charset=UTF-8");
			@Cleanup
			PrintWriter out = res.getWriter();
			
			out.println("<ol>");		
			
			String line;
			while ( (line = br.readLine()) != null) {
				out.println("<li>" + line + "</li>");
			} // while		
			
			out.println("</ol>");
			
			out.flush(); // 잔류 데이터 방출
			
		} catch (Exception e) {
			throw new IOException(e); 
		} // try-catch
		
	} // service
		

} // end class
