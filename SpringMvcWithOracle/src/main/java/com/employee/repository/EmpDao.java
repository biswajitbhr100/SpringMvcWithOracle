package com.employee.repository;
import java.util.List;

import com.employee.model.Emp;
public interface EmpDao {
	void addEmp(Emp emp);
	void deleteEmp(int empno);
	Emp findEmp(int empno);
	List<Emp> findAllEmp();
}
