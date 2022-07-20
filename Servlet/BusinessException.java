package org.zerock.myapp.exception;

import lombok.NoArgsConstructor;

// User-defined Exception으로, 비지니스 로직 수행시 오류가 발생하면
// 이 예외를 던지도록 설정

@NoArgsConstructor
public class BusinessException extends Exception {
	private static final long serialVersionUID = 1L;

	
//	public BusinessException() {
//		;;
//	} // default constructor
	
	public BusinessException(String message) {
		super(message);
	} // constructor

	public BusinessException(Exception e) {
		super(e);
	} // constructor
	
} // end class
