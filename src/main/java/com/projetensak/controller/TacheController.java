package com.projetensak.controller;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.projetensak.model.Projet;
import com.projetensak.model.Status;
import com.projetensak.model.TacheEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projetensak.model.Tache;
import com.projetensak.services.ProjetServices;
import com.projetensak.services.TacheServices;
import com.projetensak.model.Commentaire ; 

@Controller
@RequestMapping("/tache")
public class TacheController {

	@Autowired
	TacheServices dataServices;
	@Autowired 
	ProjetServices projet ;
	static final Logger logger = Logger.getLogger(TacheController.class);

	@RequestMapping(value = "/create/{projetID}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addTache(@RequestBody Tache tache , @PathVariable("projetID") long id) {
		try {
			Projet proj = projet.getEntityById(id) ; 
			tache.setProjet(proj);
			dataServices.addEntity(tache);
			return new Status(1, "Tache added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Tache getTache(@PathVariable("id") long id) {
		Tache tache = null;
		try {
			tache = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tache;
	}
	@RequestMapping(value = "/commentaires/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Set<Commentaire> getTacheCommentaires(@PathVariable("id") long id) {
		Set<Commentaire> tache = null;
		try {
			tache = dataServices.getTacheCommentaires(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tache;
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Tache> getTache() {
		List<Tache> tacheList = null;
		try {
			tacheList = dataServices.getEntityList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tacheList;
	}
	@RequestMapping(value = "/listByEmployee/{empId}", method = RequestMethod.GET)
	public @ResponseBody
	List<Tache> getTacheByEmployee(@PathVariable("empId") long id ) {

		List<Tache> tacheList = null;
		try {
			tacheList = dataServices.getEntityListByEmployee(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tacheList;
	}
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Set<TacheEmployee> getTacheEmployees( @PathVariable("id") long id ) {
		Set<TacheEmployee> tacheList = null;
		try {
			tacheList = dataServices.getTacheEmployees(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tacheList;
	}
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteTache(@PathVariable("id") long id) {
		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Tache deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
}
