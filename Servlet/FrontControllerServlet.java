package org.zerock.myapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.domain.EmpDTO;
import org.zerock.myapp.exception.BusinessException;
import org.zerock.myapp.service.DeleteServiceImpl;
import org.zerock.myapp.service.InsertServiceImpl;
import org.zerock.myapp.service.SelectServiceImpl;
import org.zerock.myapp.service.Service;
import org.zerock.myapp.service.UnknownServiceImpl;
import org.zerock.myapp.service.UpdateServiceImpl;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

@WebServlet("*.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		log.trace("service(req, res) invoked.");
		
//		String requestURI = req.getRequestURI();
//		String contextPath = req.getContextPath();		
//		log.info("\t+ requestURI : {}, contextPath: {}", requestURI, contextPath);
		
		// step 1. 모든 전송파라미터 획득 및 DTO 객체로 수집
		
//		req.setCharacterEncoding("utf8"); // MyFilter에서 이미 처리
		
		String empno = req.getParameter("empno");
		String ename = req.getParameter("ename");
		String sal = req.getParameter("sal");
		String deptno = req.getParameter("deptno");
		
		log.info("\t+ empno : {}, ename : {}, sal : {}, deptno : {}", empno, ename, sal, deptno);
		
//		---
		
		// 수집된 모든 전송 파라미터를 DTO객체의 필드로 수집(저장)
		// 이 DTO (Data Transfer Object, 데이터 전달 객체)는 웹 3계층에서 앞 -> 뒤로 전달됨
		EmpDTO dto = new EmpDTO();
		
		if(empno != null && !"".equals(empno)) {
			dto.setEmpno(Integer.parseInt(empno));			
		} // if
		
		dto.setEname(ename);
		
		if(sal != null && !"".equals(sal)) {
			dto.setSal(Double.parseDouble(sal));
		} // if
		
		if(deptno != null && !"".equals(deptno)) {
			dto.setDeptno(Integer.parseInt(deptno));
		} // if
		
		log.info("\t+ dto : {}", dto);
		
//		---
		
		// 현재의 Request에 대한, Response가 나가기 전까지 살아있는
		// Request Scope에 DTO 객체를 binding 해주어서, 웹 3계층의 어디에서든 사용할 수 있도록 공유
		
		req.setAttribute(Service.DTO, dto); // 공유속성 이름 : __DTO__
		
		// step 2. Reqeust URI를 획득하여 요청을 식별
		String command = req.getRequestURI();
		log.info("\t+ command : {}", command);
		
		// step 3. 얻어낸 command를 처리할 비지니스 수행 객체(=서비스 객체)를
		//    식별하고 처리를 위임 (Delegation) => Command Pattern 적용
		
		try { // 비지니스 계층의 서비스 객체가 로직을 수행하고 나면 반드시 Model이 생성됨			
			// Command Pattern에 따라, 각 Command를 처리할 객체가 반드시 구현할 메소드를
			// 인터페이스로 규격화하고, 이에 맞게 Command 처리객체를 생성할 수 있도록 클래스 구현하는 패턴
			switch(command) {  // 유형별로 처리를 위임 (Delegation)
			case "/insert.do": new InsertServiceImpl().execute(req, res); break;
			case "/select.do": new SelectServiceImpl().execute(req, res); break;
			case "/update.do": new UpdateServiceImpl().execute(req, res); break;
			case "/delete.do": new DeleteServiceImpl().execute(req, res); break; 
			default			 : new UnknownServiceImpl().execute(req, res);	break;			
			} // switch
			
		} catch (BusinessException e) {
			throw new ServletException(e);
		} // try-catch
		
		// step 4. 비지니스 수행결과 데이터인 Model을 함께 전달하여 
		// 응답결과 화면을 동적으로 생석하도록 View 호출
		RequestDispatcher dispatcher = req.getRequestDispatcher("/View"); // View는 맵핑된 URI
		dispatcher.forward(req, res);
		
		log.info("\t+ forwarded request into /View");
				
	} // service

} // end class
