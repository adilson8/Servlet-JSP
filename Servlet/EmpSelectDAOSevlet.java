package org.zerock.myapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.domain.EmpVO;
import org.zerock.myapp.persistence.EmpDAO;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@WebServlet("/EmpSelectDAO")
public class EmpSelectDAOSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
		try { // DAO 객체 생성 및 selectAll 메소드 호출해서, 모든 사원정보를 리스트로 획득
			// 영속성 계층의 DAO 객체의 메소드 호출 
			EmpDAO dao = new EmpDAO();
			 
			 @Cleanup("clear")
			 List<EmpVO> list = dao.selectAll();
			 
			 // 응답문서 생성 및 전송
			 res.setContentType("text/html; charset=utf8");
			 @Cleanup
			 PrintWriter out = res.getWriter();
			 
			 out.println("<ol>");
			 
//			 for (EmpVO vo : list) {				 
//				 out.println("<li>" + vo + "</li>");
//			 } // enhanced for
			 
			 list.forEach(vo -> out.println("<li>" + vo + "</li>") ); // forEach
			 
			 out.println("</ol>");
			 
			 out.flush();			
		} catch(Exception e) {
			throw new IOException(e);
		} // try-catch		
	} // service

} // end class
