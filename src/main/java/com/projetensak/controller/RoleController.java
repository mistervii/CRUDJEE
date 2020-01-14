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

import com.projetensak.model.Role;
import com.projetensak.services.RoleServices;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleServices dataServices;

	static final Logger logger = Logger.getLogger(RoleController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addRole(@RequestBody Role role) {
		try {
			dataServices.addEntity(role);
			return new Status(1, "Role added Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Role getRole(@PathVariable("id") long id) {
		Role role = null;
		try {
			role = dataServices.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Role> getRole() {

		List<Role> roleList = null;
		try {
			roleList = dataServices.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return roleList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteRole(@PathVariable("id") long id) {
		try {
			dataServices.deleteEntity(id);
			return new Status(1, "Role deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
}
