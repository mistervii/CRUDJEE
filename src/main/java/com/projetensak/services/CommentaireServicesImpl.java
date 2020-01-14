package com.projetensak.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.dao.CommentaireDao;
import com.projetensak.model.Commentaire;

public class CommentaireServicesImpl implements CommentaireServices {
	@Autowired
	CommentaireDao dataDao;
	
	@Override
	public boolean addEntity(Commentaire commentaire) throws Exception {
		return dataDao.addEntity(commentaire);
	}

	@Override
	public Commentaire getEntityById(long id) throws Exception {
		return dataDao.getEntityById(id);
	}

	@Override
	public List<Commentaire> getEntityList() throws Exception {
		return dataDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return dataDao.deleteEntity(id);
	}

	@Override
	public List<Commentaire> getEntityByPriorite(long priorite) throws Exception {
		return dataDao.getEntityByPriorite(priorite);
	}

}
