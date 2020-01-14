package com.projetensak.dao;

import java.util.List;
import java.util.Set;

import com.projetensak.model.Tache;
import com.projetensak.model.Commentaire; 
import com.projetensak.model.TacheEmployee;
public interface TacheDao {
	public boolean addEntity(Tache tache) throws Exception;
	public Tache getEntityById(long id) throws Exception;
	public List<Tache> getEntityList() throws Exception;
	public List<Tache> getEntityListByEmployee(long id ) throws Exception ;
	public Set<Commentaire> getTacheCommentaires(long id ) throws Exception ; 
	public boolean deleteEntity(long id) throws Exception;
	public Set<TacheEmployee> getTacheEmployees(long id ) throws Exception ;
}
