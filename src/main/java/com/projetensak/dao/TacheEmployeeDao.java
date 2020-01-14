package com.projetensak.dao;

import java.util.List;
import com.projetensak.model.TacheEmployee;

public interface TacheEmployeeDao {
	public boolean addEntity(TacheEmployee tache) throws Exception;
	public TacheEmployee getEntityById(long id) throws Exception;
	public List<TacheEmployee> getEntityList() throws Exception;
	public List<TacheEmployee> getEntityListByEmployee(long id ) throws Exception ;
	public boolean deleteEntity(long id) throws Exception;
	public boolean markDone(long id ) throws Exception ; 
}
