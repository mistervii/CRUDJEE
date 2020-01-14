package com.projetensak.services;

import java.util.List;

import com.projetensak.model.Commentaire;

public interface CommentaireServices {
	public boolean addEntity(Commentaire commentaire) throws Exception;
	public Commentaire getEntityById(long id) throws Exception;
	public List<Commentaire> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
	public List<Commentaire> getEntityByPriorite(long priorite) throws Exception;
}
