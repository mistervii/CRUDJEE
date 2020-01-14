package com.projetensak.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.dao.ServiceDao;
import com.projetensak.model.Projet;
import com.projetensak.model.Service;

public class ServiceServicesImpl implements ServiceServices {
	@Autowired
	ServiceDao dataDao;
	
	@Override
	public boolean addEntity(Service service) throws Exception {
		return dataDao.addEntity(service);
	}

	@Override
	public Service getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}
	public Set<Projet> getServiceProjets(long id) throws Exception {
		return dataDao.getServiceProjets(id); 
	}
	@Override
	public List<Service> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}
}
