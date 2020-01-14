package com.projetensak.controller;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.projetensak.model.Role;
import com.projetensak.model.Service;
import com.projetensak.model.Status;
import com.projetensak.model.TacheEmployee;

//import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projetensak.model.Employee;
import com.projetensak.services.EmployeeServices;
import com.projetensak.services.TacheEmployeeServices;

@Controller
@RequestMapping("/employee")
public class EmployeeController{

	@Autowired
	EmployeeServices dataServices;
	@Autowired 
	TacheEmployeeServices tacheServices ; 
	static final Logger logger = Logger.getLogger(EmployeeController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addEmployee(@RequestBody Employee employee) {
		try {
			dataServices.addEntity(employee);
			return new Status(1, "Employee added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Employee getEmployee(@PathVariable("id") long id) {
		Employee employee = null;
		try {
			employee = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	@RequestMapping(value = "/taches/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Set<TacheEmployee> getEmployeeTache(@PathVariable("id") long id) {
		Set<TacheEmployee> employee = null;
		try {
			employee = dataServices.getEmployeeTache(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	@RequestMapping(value = "/tacheDone/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status markTachDone(@PathVariable("id") long id) {
		Set<TacheEmployee> employee = null;
		try {
			tacheServices.markDone(id);
			return new Status(1, "done Successfully !");
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, e.toString());
		}
	}
	@RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Role getEmployeeRole(@PathVariable("id") long id) {
		Role employee = null;
		try {
			employee = dataServices.getEmployeeRole(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	@RequestMapping(value = "/service/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Service getEmployeeService(@PathVariable("id") long id) {
		Service employee = null;
		try {
			employee = dataServices.getEmployeeService(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	@RequestMapping(value = "/login/{email}/{password}", method = RequestMethod.GET)
	public @ResponseBody
	Employee Login(@PathVariable("email") String email , @PathVariable("password") String password) {
		Employee employee = null;
		try {
			employee = dataServices.getLogin(email , password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Employee> getEmployee() {

		List<Employee> employeeList = null;
		try {
			employeeList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		;

		return employeeList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteEmployee(@PathVariable("id") long id) {
		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Employee deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
}
