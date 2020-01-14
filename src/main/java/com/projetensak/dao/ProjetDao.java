package com.projetensak.dao;

import java.util.List;
import java.util.Set;

import com.projetensak.model.Employee;
import com.projetensak.model.Projet;
import com.projetensak.model.Tache;

public interface ProjetDao {

	public boolean addEntity(Projet projet) throws Exception;
	public Projet getEntityById(long id) throws Exception;
	public List<Projet> getEntityList() throws Exception;
	public List<Employee> getProjetEmployees( long id) throws Exception ; 
	public Set<Tache> getProjetTaches(long id ) throws Exception ; 
	public boolean deleteEntity(long id) throws Exception;

}
