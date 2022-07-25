package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.zerock.uuid.UUIDGenerator;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@MultipartConfig(
		location="C:/temp/upload", 
		maxFileSize=1 * 1024 * 1024 * 2,       // 최대 파일 크기 : 2MB
		maxRequestSize=1 * 1024 * 1024 * 2)    // 한 요청당 최대크기 : 2MB
@WebServlet("/Upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");	

		// 응답 메시지 생성 및 전송
		req.setCharacterEncoding("utf8");
		res.setContentType("text/html; charset=utf8");
		@Cleanup
		PrintWriter out = res.getWriter();
		
		// multiple 속성이 있는 <input type=file multiple> 태그로 업로드 된 복수의 파일을 저장하는 로직
		Collection<Part> parts = req.getParts();		
//		parts.forEach( p -> log.info(p) );
		parts.forEach( p -> log.info( p.getName() ) );
		
		// 멀티파트를 구성하는 각 Part의 이름이란? => 각 파트를 구성하는 전송 파라미터의 이름
//		Part uploadFilePart = req.getPart("uploadFile");
//		log.info("uploadFile : {}", uploadFilePart);
		
		// 각 파트의 구성 헤더 정보에 접근해보자
		Iterator<Part> iter = parts.iterator();
		while(iter.hasNext()) {               // 그 다음 요소가 있느냐?
			Part part = iter.next();          // 있다면 그 다음 요소를 달라!
			
			// 이 Part에 포함된 
			log.info("========================================");
			log.info("\t+ 1. part.getName : {}", part.getName());               // 전송 파라미터 이름 (=파트이름)  
			log.info("\t+ 2. part.getContentType : {}", part.getContentType()); // Content-Type 헤더의 값  
			log.info("\t+ 3. part.getSize : {}", part.getSize());               // Body의 Content Length  
			log.info("\t+ 4. part.getSubmittedFileName : {}", part.getSubmittedFileName()); // 파일의 원본 파일명  
			log.info("\t+ 5. part.getHeaderNames : {}", part.getHeaderNames()); // 헤더명의 목록
			
			// 첨부파일만 포함하고 있는 Part를 필터링해서 첨부파일 저장
			if( part.getSubmittedFileName() != null ) { 
				// part.write(part.getSubmittedFileName()); // 원본파일명으로 지정된 폴더에 저장
				// 근데 실제 서비스에선 이렇게 하면 원본파일명이 겹치는 사용자가 있기 때문에 문제가 생김
				
				try {
					String uuid = UUIDGenerator.generateUniqueKeysWithUUIDAndMessageDigest();
					part.write(uuid); // 파일명 임시파일처럼 저장
					part.delete(); // 다운로드시 사용된 임시파일 삭제
					
					// 응답으로 각 파일의 다운로드 링크 생성
					String encodedFilename = URLEncoder.encode(part.getSubmittedFileName(), "utf8");
					String link = String.format("<a href='/FileDown?file_name=%s&uuid=%s'> 파일 다운로드 </a><br>", encodedFilename, uuid);
					out.println(link);
				} catch (Exception e) {;;}				
			} // if  
		} //while
		out.flush();
	}// service

} // end class
