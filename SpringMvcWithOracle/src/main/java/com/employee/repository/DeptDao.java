package com.employee.repository;
import com.employee.model.Dept;
import java.util.List;
public interface DeptDao {
	void addDept(Dept dept);
	void deleteDeptByName(String dname);
	Dept findDept(int deptno);
	Dept findDeptById(int id);
	Dept findDeptByName(String dname);
	List<Dept> findAllDept();
}
