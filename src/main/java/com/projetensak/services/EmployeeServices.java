package com.projetensak.services;

import java.util.List;
import java.util.Set;

import com.projetensak.model.Employee;
import com.projetensak.model.Role;
import com.projetensak.model.Service;
import com.projetensak.model.Tache;
import com.projetensak.model.TacheEmployee;

public interface EmployeeServices {
	public boolean addEntity(Employee employee) throws Exception;
	public Employee getEntityById(long id) throws Exception;
	public Employee getLogin(String email , String password ) throws Exception ; 
	public List<Employee> getEntityList() throws Exception;
	public Set<TacheEmployee> getEmployeeTache( long id ) throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public Role getEmployeeRole( long id ) throws Exception; 
	public Service getEmployeeService(long id) throws Exception ; 
}
