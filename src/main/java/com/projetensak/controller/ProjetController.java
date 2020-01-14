package com.projetensak.controller;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.projetensak.model.Employee;
import com.projetensak.model.Status;
import com.projetensak.model.Tache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projetensak.model.Projet;
import com.projetensak.services.ProjetServices;
import com.projetensak.services.ServiceServices;

@Controller
@RequestMapping("/projet")
public class ProjetController {
	@Autowired
	ProjetServices dataServices;
	@Autowired
	ServiceServices service;
	static final Logger logger = Logger.getLogger(ProjetController.class);
	
	@RequestMapping(value = "/create/{serviceID}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addProjet(@RequestBody Projet projet , @PathVariable("serviceID") long servId) {
		try {
			System.out.print("service : "+servId);
			projet.setService(service.getEntityById(servId));
			dataServices.addEntity(projet);
			return new Status(1, "projet added Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, e.toString());
		}
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Projet getProjet(@PathVariable("id") long id) {
		Projet employee = null;
		try {
			employee = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	@RequestMapping(value= "/employees/{idprojet}")
	public @ResponseBody 
	List<Employee> getEmployees(@PathVariable("idprojet") long idprojet ){
		List<Employee> employees = null ; 
		try{
			employees = dataServices.getProjetEmployees(idprojet) ; 
		}catch(Exception e){
			e.printStackTrace();
		}
		return employees; 
	}
	@RequestMapping(value= "/taches/{idprojet}")
	public @ResponseBody 
	Set<Tache> getTaches(@PathVariable("idprojet") long idprojet ){
		Set<Tache> taches = null ; 
		try{
			taches = dataServices.getProjetTaches(idprojet) ; 
		}catch(Exception e){
			e.printStackTrace();
		}
		return taches; 
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Projet> getProjet() {

		List<Projet> projetList = null;
		try {
			projetList = dataServices.getEntityList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return projetList;
	}
}
