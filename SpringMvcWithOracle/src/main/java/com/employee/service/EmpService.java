package com.employee.service;
import java.util.List;
import com.employee.model.Emp;
public interface EmpService {
	void saveEmp(Emp emp);
	void updateEmp(Emp emp);
	void deleteEmp(int empno);
	boolean isEmpExist(Emp emp);
	Emp getEmp(int empno);
	List<Emp> getAllEmp();
}
