package com.employee.service;
import java.util.List;
import com.employee.model.Dept;
public interface DeptService {
	void saveDept(Dept dept);
	void updateDept(Dept dept);
	void deleteDept(String dname);
	boolean isDeptExist(Dept dept);
	Dept getDept(int deptno);
	Dept getDeptByName(String dname);
	List<Dept> getAllDept();
}
