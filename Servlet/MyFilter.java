
package org.zerock.myapp.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

// @WebFilter("/*") // 이렇게 쓰면 어떤 servlet이던 이 필터를 통과함
// @WebFilter({ "/Lifecycle1", "/Lifecycle2" }) 
// 이렇게 쓰면 /Lifecycle1, /Lifecycle2만 이 필터를 통과함
// web.xml에서 수동으로 등록해보자!

public class MyFilter 
	extends HttpFilter 
	implements Filter {
       
//	public MyFilter() {
//        super(); // 부모 클래스의 생성자를 가장 먼저 호출해야한다.
//        log.trace("Default Constructor invoked.");
//    } // default constructor

    
    @Override
	public void init(FilterConfig config) throws ServletException {
		log.trace("init({}) invoked.", config);
	} // init


    @Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws IOException, ServletException {		
		log.trace("doFilter(req, res, {}) invoked.", chain);
		
		// 1. 요청에 대한 선처리 (Pre-processing)
		log.info("\t+ Pre-processing for request");
		
//		boolean isValid = false;
//		
//		if(!isValid) {
//			res.setContentType("text/html; charset=utf8");
//			@Cleanup
//			PrintWriter out = res.getWriter();
//			out.println("<h1> Bad request. </h1>");
//			out.flush();
//			return;
//		} // if		
		
		// 요청(request)에 대한 선처리와, 응답(response)에 대한 후처리를 제어하는 호출
    	// chain 객체를 이용해 request, response를 넘긴다
		chain.doFilter(req, res); 

		// 2. 요청에 대한 후처리 (Post-processing)
		log.info("\t+ Post-processing for response");
	} // doFilter


    @Override
	public void destroy() {
		log.trace("destroy() invoked.");
	} // destroy
    
} // end class