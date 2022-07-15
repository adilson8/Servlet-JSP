package org.zerock.myapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebServlet( // 아래 내용은 직접 코딩하는게 아니고 위저드에서 작성해주면 된다
		urlPatterns = { "/InitParamAnno" }, 
		initParams = { // 위저드에서 입력한 대로 initialization parameters가 배열의 원소 형태로 입력된다. 
				@WebInitParam(name = "dirPath", value = "_DIRPATH_", description = "디렉토리경로"), 
				@WebInitParam(name = "userid", value = "아이디")
		})
public class InitParamAnnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		String dirPath = this.getInitParameter("dirPath"); // this. 안 써도 되지만 까먹지 말자 
		String userid = this.getInitParameter("userid");   // this. 안 써도 되지만 까먹지 말자
		
		log.info("\t+ dirPath : {}, userid : {}", dirPath, userid);
		
	} // service

} // end class
