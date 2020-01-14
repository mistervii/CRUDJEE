package com.projetensak.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.dao.RoleDao;
import com.projetensak.model.Role;

public class RoleServicesImpl implements RoleServices {
	@Autowired
	RoleDao dataDao;
	
	@Override
	public boolean addEntity(Role role) throws Exception {
		return dataDao.addEntity(role);
	}

	@Override
	public Role getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Role> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}
}
