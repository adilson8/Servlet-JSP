package org.zerock.myapp.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

//@EqualsAndHashCode
//@ToString
//@Getter(lombok.AccessLevel.PUBLIC)
//@Setter(lombok.AccessLevel.PUBLIC)
//@NoArgsConstructor
//@AllArgsConstructor

@Value // 이거 하나만 쓰면 위에것 다 적용된다 
// Setter는 안 되는데 VO객체는 어짜피 Setter 안 씀 (DTO는 Setter필요)
public class EmpVO {
	private Integer empno;
	private String ename;
	private String job;
	private Integer mgr;
	private Date hireDate; // util 패키지로 임포트
	private Double sal;
	private Double comm;
	private Integer deptno;
	
	// 기본생성자 직접 만들기 (@NoArgsConstructor)
//	public EmpVO() {
//		;;
//	} // default constructor
	
	// 매개변수 있는 생성자 직접 만들기 (@AllArgsConstructor)
//	public EmpVO(Integer empno, String ename, 
//			     String job, Integer mgr, 
//			     Date hireDate,  Double sal, 
//			     Double comm, Integer deptno) {
//		this.empno = empno;
//		this.ename = ename;
//		this.job = job;
//		this.mgr = mgr;
//		this.hireDate = hireDate;
//		this.sal = sal;
//		this.comm = comm;
//		this.deptno = deptno;
//	} // constructor (필드이름과 매개변수 이름이 충돌하니 this를 이용해서 접근해  )
	
	// Getter 메소드 직접 만들기 (@Getter(lombok.AccessLevel.PUBLIC))
//	public Integer getEmpno() { return this.empno; }
//	public String getEname() { return this.ename; }
//	public String getJob() {return this.job;}
//	public Integer getMgr() { return this.mgr; }
//	public Date getHireDate() { return this.hireDate; }
//	public Double getSal() { return this.sal; }
//	public Double getComm() { return this.comm; }
//	public Integer getDeptno() { return this.deptno; }

	// Setter 메소드 직접 만들기 (@Setter(lombok.AccessLevel.PUBLIC))
//	public void setEmpno (Integer empno) { this.empno = empno; }
//	public void setEname (String ename) { this.ename = ename; }
//	public void setJob (String job) { this.job = job; }
//	public void setMgr (Integer mgr) { this.mgr = mgr; }
//	public void setHireDate (Date hireDate) { this.hireDate = hireDate; }
//	public void setSal (Double sal) { this.sal = sal; }
//	public void setComm (Double comm) { this.comm = comm; }
//	public void setDeptno (Integer deptno) { this.deptno = deptno; }
		
} // end class
