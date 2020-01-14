package com.projetensak.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.model.Employee;
import com.projetensak.model.Projet;
import com.projetensak.model.Service;
import com.projetensak.model.Tache;
import com.projetensak.services.ServiceServices;
import com.projetensak.services.ServiceServicesImpl;

public class ProjetDaoImpl implements ProjetDao{
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;


	@Override
	public boolean addEntity(Projet projet) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(projet);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	@Transactional
	public Projet getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Projet projet = (Projet) session.load(Projet.class,
				new Long(id));
		session.beginTransaction(); 
		session.close(); 
		return projet;
	}
	@Transactional
	public Set<Tache> getProjetTaches(long id ) throws Exception{
		session = sessionFactory.openSession(); 
		Projet proj = (Projet) session.load(Projet.class,
				new Long(id));
		return proj.getTache(); 
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Projet> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		List<Projet> projetList = session.createCriteria(Projet.class)
				.setFetchMode("lineItems", FetchMode.JOIN)  
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) 
				.list();
		return projetList;
	}
	@Override 
	@Transactional
	public List<Employee> getProjetEmployees(long id) throws Exception{
		session = sessionFactory.openSession() ; 
		Criteria cr = session.createCriteria(Projet.class); 
		Projet proj = (Projet) cr.add(Restrictions.eq("id", id))
				.uniqueResult();
		return proj.getEmployee();
	}
	@Override
	@Transactional
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Projet.class, id);
		session.beginTransaction();
		session.delete(o);
		return false;
	}
}
