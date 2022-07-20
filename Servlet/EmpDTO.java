package org.zerock.myapp.domain;

import lombok.Data;

@Data // 필요한 메소드들을 다 만들어준다 (Outline 확인)
public class EmpDTO { // POJO : Plain Old Java Object	
	private Integer empno;
	private String ename;
	private Double sal;
	private Integer deptno;	

} // end class
