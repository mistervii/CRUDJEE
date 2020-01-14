package com.projetensak.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.dao.TacheEmployeeDao;
import com.projetensak.model.TacheEmployee;

public class TacheEmployeeServicesImpl implements TacheEmployeeServices{
	@Autowired
	TacheEmployeeDao dataDao;
	
	public boolean addEntity(TacheEmployee tache) throws Exception {
		return dataDao.addEntity(tache);
	}

	public TacheEmployee getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	public boolean markDone(long id ) throws Exception {
		return dataDao.markDone(id) ; 
	}
	
	public List<TacheEmployee> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}
	
	public List<TacheEmployee> getEntityListByEmployee(long id ) throws Exception {
		return dataDao.getEntityListByEmployee(id) ; 
	}


	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}
}
