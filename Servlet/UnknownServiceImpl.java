package org.zerock.myapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.zerock.myapp.exception.BusinessException;


import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class UnknownServiceImpl implements Service {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) 
			throws BusinessException {
		log.trace("execute(req, res) invoked.");
		
		try {
			req.setAttribute(Service.MODEL, "Bad Request");	
		} catch (Exception e) {
			throw new BusinessException(e);
		} // try-catch
		
	} // execute

} // end class
