package com.employee.repository;
import java.util.List;
import com.employee.model.Emp;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
@Repository("empRepository")
public class EmpDaoImpl extends AbstractDao<Integer,Emp> implements EmpDao {
	public void addEmp(Emp emp) {
		persist(emp);
	}
	public void deleteEmp(int empno) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("empno", empno));
		Emp emp = (Emp)crit.uniqueResult();
		delete(emp);
	}
	public Emp findEmp(int empno) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("empno", empno));
		return (Emp)crit.uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Emp> findAllEmp(){
		Criteria crit = createEntityCriteria().addOrder(Order.asc("ename"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return (List<Emp>)crit.list();
	}
}
