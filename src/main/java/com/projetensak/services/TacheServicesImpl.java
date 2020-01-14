package com.projetensak.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.dao.TacheDao;
import com.projetensak.model.Commentaire;
import com.projetensak.model.Tache;
import com.projetensak.model.TacheEmployee;

public class TacheServicesImpl implements TacheServices{
	@Autowired
	TacheDao dataDao;
	
	public boolean addEntity(Tache tache) throws Exception {
		return dataDao.addEntity(tache);
	}

	public Tache getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}
	public Set<Commentaire> getTacheCommentaires(long id ) throws Exception {
		return dataDao.getTacheCommentaires(id) ; 
	}

	public Set<TacheEmployee> getTacheEmployees(long id ) throws Exception {
		return dataDao.getTacheEmployees(id) ; 
	}
	public List<Tache> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}
	
	public List<Tache> getEntityListByEmployee(long id ) throws Exception {
		return dataDao.getEntityListByEmployee(id) ; 
	}


	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}
}
