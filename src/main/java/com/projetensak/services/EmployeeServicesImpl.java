package com.projetensak.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.dao.EmployeeDao;
import com.projetensak.model.Employee;
import com.projetensak.model.Role;
import com.projetensak.model.Service;
import com.projetensak.model.Tache;
import com.projetensak.model.TacheEmployee;

public class EmployeeServicesImpl implements EmployeeServices {

	@Autowired
	EmployeeDao dataDao;
	
	@Override
	public boolean addEntity(Employee employee) throws Exception {
		return dataDao.addEntity(employee);
	}

	@Override
	public Employee getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}
	public Role getEmployeeRole( long id ) throws Exception{
		return dataDao.getEmployeeRole(id) ; 
	}
	public Service getEmployeeService(long id) throws Exception{
		return dataDao.getEmployeeService(id) ; 
	}
	public Set<TacheEmployee> getEmployeeTache( long id ) throws Exception{
		return dataDao.getEmployeeTache(id) ; 
	}
	
	@Override
	public List<Employee> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}
	@Override 
	public Employee getLogin(String email , String password ) throws Exception{
		return dataDao.getLogin(email , password) ; 
	}
	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

}
