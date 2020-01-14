package com.projetensak.controller;

import java.util.List;

import org.apache.log4j.Logger;
import com.projetensak.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projetensak.model.Commentaire;
import com.projetensak.services.CommentaireServices;

@Controller
@RequestMapping("/commentaire")
public class CommentaireController {

	@Autowired
	CommentaireServices dataServices;

	static final Logger logger = Logger.getLogger(CommentaireController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addCommentaire(@RequestBody Commentaire commentaire) {
		try {
			dataServices.addEntity(commentaire);
			return new Status(1, "Commentaire added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Commentaire getCommentaire(@PathVariable("id") long id) {
		Commentaire commentaire = null;
		try {
			commentaire = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentaire;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Commentaire> getCommentaire() {

		List<Commentaire> commentaireList = null;
		try {
			commentaireList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return commentaireList;
	}
	@RequestMapping(value = "/list/priorite/{id}", method = RequestMethod.GET)
	public @ResponseBody
	List<Commentaire> getCommentairepriorite(@PathVariable("id") long id) {

		List<Commentaire> commentaireList = null;
		try {
			commentaireList = dataServices.getEntityByPriorite(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return commentaireList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteCommentaire(@PathVariable("id") long id) {
		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Commentaire deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
}
