package com.projetensak.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.model.TacheEmployee;

public class TacheEmployeeDaoImpl implements TacheEmployeeDao{
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	public boolean addEntity(TacheEmployee tache) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(tache);
		tx.commit();
		session.close();
		return false;
	}
	public boolean markDone(long id ) throws Exception { 
		//TODO : 
		return false ; 
	}
	public TacheEmployee getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		TacheEmployee tache = (TacheEmployee) session.load(TacheEmployee.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return tache;
	}

	@SuppressWarnings("unchecked")
	public List<TacheEmployee> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<TacheEmployee> tacheList = session.createCriteria(TacheEmployee.class)
				.setFetchMode("lineItems", FetchMode.JOIN)  
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) 
				.list();
		tx.commit();
		session.close();
		return tacheList;
	}
	
	@Override 
	public List<TacheEmployee> getEntityListByEmployee(long id) throws Exception{
		session = sessionFactory.openSession(); 
		tx = session.beginTransaction(); 
		List<TacheEmployee> tachelist = session.createCriteria(TacheEmployee.class).list(); 
		tx.commit(); 
		session.close() ; 
		return tachelist ; 
	}
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(TacheEmployee.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
		return false;
	}
}
