package org.zerock.myapp.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebServlet("/FileDown")
public class FileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		req.setCharacterEncoding("utf8");
		
		// step1. 다운로드에 필요한 전송 파라미터 획득
		String file_name = req.getParameter("file_name");
		String uuid = req.getParameter("uuid");
		log.info("\t+ 1. file_name : {}", file_name); // 원본파일명
		log.info("\t+ 2. uuid : {}", uuid);           // 저장파일명
		
		// step2. 저장파일명을 이용해서, 파일데이터를 응답메시지의 Body에 Write.		
		String path = "C:/temp/upload/" + uuid; // 저장파일에 대한 절대경로
		
		@Cleanup
		FileInputStream fis = new FileInputStream(path);
		
		// step3. 다운로드할 대상 파일의 Mime Type 획득		
		ServletContext sc = req.getServletContext();
		String mimeType = sc.getMimeType(file_name);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		} // if
		
		// step4. 응답문서의 Content Type 헤더의 값을 Mime Type으로 지정 (***)
		res.setContentType(mimeType);
		
		// step5. 응답문서의 헤더영역에 아래의 새로운 헤더 추가 (***)
		// Content-Disposition : attachment; filename=원본파일명
		// 주의할 점 : 원본파일명은 ASCII (ISO-8859-1) 문자집합으로 인코딩해서 넣어야 함.
		String encodedFN = new String(file_name.getBytes("utf8"), "ISO-8859-1");
		res.setHeader("Content-Disposition", "attachment; filename=" + encodedFN );
		
		// step6. 저장파일명(uuid)을 이용하여, 파일데이터를 읽어 응답메시지 body에 write & send
		byte [] bagagi = new byte[100]; // 바가지 준비
		int readBytes = 0;              // 실제 한번 바가지로 읽어낸 바이트 수를 저장
		
		// 응답메시지의 body에 바이트 기반 출력스트림을 획득
		@Cleanup		
		ServletOutputStream sos = res.getOutputStream();
		
		while ((readBytes = fis.read(bagagi)) != -1) {        // -1 : EOF (End Of File)
			sos.write(bagagi, 0, readBytes);
		} // while
		
		sos.flush();
	}// service

} // end class
