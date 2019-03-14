package com.employee.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.employee.repository.DeptDao;
import com.employee.model.Dept;
@Service("deptService")
@Transactional
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptDao deptDao;
	public void saveDept(Dept dept) {
		deptDao.addDept(dept);
	}
	public void updateDept(Dept dept) {
		Dept deptObj = deptDao.findDept(dept.getDeptno());
		System.out.println(deptObj);
		if(deptObj != null) {
			deptObj.setDeptno(dept.getDeptno());
			deptObj.setDname(dept.getDname());
			deptObj.setLoc(dept.getLoc());
		}
	}
	public void deleteDept(String dname) {
		deptDao.deleteDeptByName(dname);
	}
	public boolean isDeptExist(Dept dept) {
		return getDeptByName(dept.getDname()) != null;
	}
	public Dept getDept(int deptno) {
		return deptDao.findDept(deptno);
	}
	public Dept getDeptByName(String dname) {
		return deptDao.findDeptByName(dname);
	}
	public List<Dept> getAllDept(){
		return deptDao.findAllDept();
	}
}
