package com.projetensak.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.model.Employee;
import com.projetensak.model.Role;
import com.projetensak.model.Service;
import com.projetensak.model.TacheEmployee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Employee employee) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Employee getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Employee employee = (Employee) session.load(Employee.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return employee;
	}
	@Transactional 
	public Set<TacheEmployee> getEmployeeTache(long id) throws Exception{
		Employee employee = this.getEntityById(id) ;
		Set<TacheEmployee> taches = employee.getTaches();
		return taches ;
	}
	public Role getEmployeeRole( long id ) throws Exception{
		Employee emp = this.getEntityById(id) ; 
		return emp.getRole();
	}
	public Service getEmployeeService(long id) throws Exception {
		Employee emp = this.getEntityById(id); 
		return emp.getService();  
	}
	@Override 
	public Employee getLogin(String email , String password ) throws Exception{
		session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(Employee.class); 
		Employee emp = (Employee) cr.add(Restrictions.eq("email", email))
									.add(Restrictions.eq("pass" , password))
									.uniqueResult();
		tx= session.getTransaction(); 
		session.beginTransaction(); 
		tx.commit(); 
		session.close();
		//long id=emp.getService().getId();
		return emp ;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Employee> employeeList = session.createCriteria(Employee.class)
				.setFetchMode("lineItems", FetchMode.JOIN)  
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) 
				.list();
		tx.commit();
		session.close();
		return employeeList;
	}
	
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Employee.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
		return false;
	}

}
