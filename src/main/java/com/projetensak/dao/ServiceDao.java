package com.projetensak.dao;

import java.util.List;
import java.util.Set;

import com.projetensak.model.Projet;
import com.projetensak.model.Service;

public interface ServiceDao {
	public boolean addEntity(Service service) throws Exception;
	public Service getEntityById(long id) throws Exception;
	public Set<Projet> getServiceProjets(long id) throws Exception; 
	public List<Service> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
