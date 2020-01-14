package com.projetensak.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.dao.ProjetDao;
import com.projetensak.model.Employee;
import com.projetensak.model.Projet;
import com.projetensak.model.Tache;

public class ProjetServicesImpl implements ProjetServices{
	@Autowired
	ProjetDao dataDao;
	
	@Override
	public boolean addEntity(Projet projet) throws Exception {
		return dataDao.addEntity(projet);
	}
	@Override 
	public List<Employee> getProjetEmployees( long id ) throws Exception {
		return dataDao.getProjetEmployees(id) ; 
	}
	public Set<Tache> getProjetTaches(long id ) throws Exception{
		return dataDao.getProjetTaches(id)  ;
	}
	@Override
	public Projet getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}
	@Override
	public List<Projet> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}
}
