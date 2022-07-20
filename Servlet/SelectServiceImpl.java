package org.zerock.myapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.zerock.myapp.domain.EmpVO;
import org.zerock.myapp.exception.BusinessException;
import org.zerock.myapp.persistence.EmpDAO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class SelectServiceImpl implements Service {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
			throws BusinessException {
		log.trace("execute(req, res) invoked.");

		// 비지니스 로직을 수행하고, 그 결과 데이터인 Model을 생성하여 Req.Scope에 바인딩
		try {			 
			// step1. Req.Scope에서 DTO 객체 획득할 필요 없음
//			EmpDTO dto = (EmpDTO) req.getAttribute(Service.DTO);
			
			// step2. 획득한 DTO를 이용해서 DAO의 메소드 호출
			EmpDAO dao = new EmpDAO();
			
			// step3. 비지니스 로직 수행 (모든 사업 정보 획득)
			List<EmpVO> list = dao.selectAll(); // list : 비지니스 수행결과 데이터
			req.setAttribute(Service.MODEL, list);			
					
		} catch (Exception e) {
			throw new BusinessException(e);
		} // try-catch
		
	} // execute

} // end class
