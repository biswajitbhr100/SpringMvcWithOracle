package com.employee.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.employee.repository.EmpDao;
import com.employee.model.Emp;
@Service("empService")
@Transactional
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpDao empDao;
	public void saveEmp(Emp emp) {
		empDao.addEmp(emp);
	}
	public void updateEmp(Emp emp) {
		Emp empObj = empDao.findEmp(emp.getEmpno());
		if(empObj != null) {
			empObj.setEname(emp.getEname());
			empObj.setJob(emp.getJob());
			empObj.setSal(emp.getSal());
			empObj.setMgr(emp.getMgr());
			empObj.setHiredate(emp.getHiredate());
			empObj.setComm(emp.getComm());
			empObj.setDeptno(emp.getDeptno());
		}
	}
	public void deleteEmp(int empno) {
		empDao.deleteEmp(empno);
	}
	public boolean isEmpExist(Emp emp) {
		return getEmp(emp.getEmpno()) != null;
	}
	public Emp getEmp(int empno) {
		return empDao.findEmp(empno);
	}
	public List<Emp> getAllEmp(){
		return empDao.findAllEmp();
	}
}
