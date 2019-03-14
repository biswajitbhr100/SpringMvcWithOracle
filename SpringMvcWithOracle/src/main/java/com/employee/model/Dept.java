package com.employee.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Id;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.OneToMany;
@Entity
@Table(name = "DEPARTMENT")
@JsonIgnoreProperties(value = {"emps"})
public class Dept implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	@Column(name = "DEPTNO",nullable = false,unique = true)
	private int deptno;
	@Column(name = "DNAME",nullable = false,unique = true)
	private String dname;
	@Column(name = "LOC",nullable = false)
	private String loc;
	@OneToMany(mappedBy = "dept",fetch = FetchType.LAZY)
	private Set<Emp> emps = new HashSet<Emp>();
	public Dept() {
		
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDname() {
		return dname;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getLoc() {
		return loc;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	public Set<Emp> getEmps(){
		return emps;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int)deptno;
		result = prime * result + ((dname == null) ? 0 : dname.hashCode());
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
		Dept u = (Dept)obj;
		if(deptno != u.deptno)
			return false;
		if(dname == null) {
			if(u.dname != null)
				return false;
		}else if(!dname.equals(u.dname)) 
			return false;
		return true;
	}
}
