package com.projetensak.controller;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.projetensak.model.Projet;
import com.projetensak.model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projetensak.model.Service;
import com.projetensak.services.ServiceServices;

@Controller
@RequestMapping("/service")
public class ServiceController {

	@Autowired
	ServiceServices dataServices;

	static final Logger logger = Logger.getLogger(ServiceController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addService(@RequestBody Service service) {
		try {
			dataServices.addEntity(service);
			return new Status(1, "Service added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Service getService(@PathVariable("id") long id) {
		Service service = null;
		try {
			service = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}
	@RequestMapping(value = "/projets/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Set<Projet> getServiceProjets(@PathVariable("id") long id) {
		Set<Projet> service = null;
		try {
			service = dataServices.getServiceProjets(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Service> getService() {

		List<Service> serviceList = null;
		try {
			serviceList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return serviceList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteService(@PathVariable("id") long id) {
		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Service deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
}
