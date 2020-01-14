package com.projetensak.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.model.Commentaire;
import com.projetensak.model.Tache;
import com.projetensak.model.TacheEmployee;

public class TacheDaoImpl implements TacheDao{
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Transactional
	public boolean addEntity(Tache tache) throws Exception {
		session = sessionFactory.openSession();
		session.save(tache);
		session.close();
		return false;
	}
	@Transactional
	public Set<Commentaire> getTacheCommentaires(long id ) throws Exception {
		Tache tach = this.getEntityById(id) ; 
		return tach.getCommentaire() ; 
	}
	@Transactional
	public Tache getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Tache tache = (Tache) session.load(Tache.class,
				new Long(id));
		session.beginTransaction();
		return tache;
	}
	@Transactional
	public Set<TacheEmployee> getTacheEmployees(long id ) throws Exception{
		Tache tach = this.getEntityById(id) ; 
		Set<TacheEmployee> taches = tach.getEmployee();
		return taches; 
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Tache> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		List<Tache> tacheList = session.createCriteria(Tache.class)
				.setFetchMode("lineItems", FetchMode.JOIN)  
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) 
				.list();
		session.close();
		return tacheList;
	}
	
	@Override 
	@Transactional
	public List<Tache> getEntityListByEmployee(long id) throws Exception{
		session = sessionFactory.openSession();
		List<Tache> tachelist = session.createCriteria(Tache.class).list(); 
		session.close() ; 
		return tachelist ; 
	}
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Tache.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
		return false;
	}
}
