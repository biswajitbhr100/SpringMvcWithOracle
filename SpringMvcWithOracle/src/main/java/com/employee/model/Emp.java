package com.employee.model;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.ManyToOne;
@Entity
@Table(name = "EMPLOYEE")
public class Emp implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "EMPNO",nullable = false,unique = true)
	private int empno;
	@Column(name = "ENAME",nullable = false)
	private String ename;
	@Column(name = "JOB",nullable = false)
	private String job;
	@Column(name = "MGR")
	private Integer mgr;
	@Column(name = "HIREDATE",nullable = false)
	//@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private String hiredate;
	@Column(name = "SAL",nullable = false)
	private Integer sal;
	@Column(name = "COMM")
	private Integer comm;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPTNO",referencedColumnName = "DEPTNO",nullable = false)
	private Dept dept;
	public Emp() {
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEname() {
		return ename;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getJob() {
		return job;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public Integer getSal() {
		return sal;
	}
	public void setComm(Integer comm) {
		this.comm = comm;
	}
	public Integer getComm() {
		return comm;
	}
	public void setDeptno(Dept dept) {
		this.dept = dept;
	}
	public Dept getDeptno() {
		return dept;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int)empno;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof Dept))
			return false;
		Emp u = (Emp)obj;
		if(empno != u.empno)
			return false;
		if(ename == null) {
			if(u.ename != null)
				return false;
		}else if(!ename.equals(u.ename)) 
			return false;
		return true;
	}
}
