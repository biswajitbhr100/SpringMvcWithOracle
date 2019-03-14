package com.employee.repository;
import com.employee.model.Dept;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
@Repository("DeptRepository")
public class DeptDaoImpl extends AbstractDao<Integer,Dept> implements DeptDao{
	public void addDept(Dept dept) {
		persist(dept);
	}
	public void deleteDeptByName(String dname) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("dname", dname));
		Dept dept = (Dept)crit.uniqueResult();
		delete(dept);
	}
	public Dept findDeptById(int id) {
		return getByKey(id);
	}
	public Dept findDept(int deptno) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("deptno", deptno));
		return (Dept)crit.uniqueResult();
	}
	public Dept findDeptByName(String dname) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("dname", dname));
		return (Dept)crit.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Dept> findAllDept(){
		Criteria crit = createEntityCriteria().addOrder(Order.asc("dname"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Dept>)crit.list();
	}
	
}
