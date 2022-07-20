package org.zerock.myapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.domain.EmpDTO;
import org.zerock.myapp.exception.BusinessException;
import org.zerock.myapp.persistence.EmpDAO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class DeleteServiceImpl implements Service {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
			throws BusinessException {
		log.trace("execute(req, res) invoked.");

		// 비지니스 로직을 수행하고, 그 결과 데이터인 Model을 생성하여 Req.Scope에 바인딩
		try { 
			// step1. Req.Scope에서 DTO 객체 획득
			EmpDTO dto = (EmpDTO) req.getAttribute(Service.DTO);
			
			// step2. 획득한 DTO를 이용해서 DAO의 메소드 호출
			EmpDAO dao = new EmpDAO();
			
			// step3. 비지니스 로직 수행 (특정사원삭제)
			int deletedRows = dao.delete(dto); // deletedRows : 비지니스 수행결과 데이터
			
			req.setAttribute(Service.MODEL, deletedRows);	// Auto-boxing : Integer 객체로 저장		
		} catch (Exception e) {
			throw new BusinessException(e);
		} // try-catch
		
	} // execute

} // end class
