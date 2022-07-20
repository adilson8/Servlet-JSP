package org.zerock.myapp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.myapp.exception.BusinessException;

public interface Service {	
	public static final String DTO = "__DTO__";
	public static final String MODEL = "__MODEL__";
	
	public abstract void execute(HttpServletRequest req, HttpServletResponse res)
		throws BusinessException;
	
	
} // end class
