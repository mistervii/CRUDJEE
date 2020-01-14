package com.projetensak.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.model.Projet;
import com.projetensak.model.Service;

public class ServiceDaoImpl implements ServiceDao {
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Service service) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(service);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Service getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Service service = (Service) session.load(Service.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return service;
	}
	
	public Set<Projet> getServiceProjets(long id) throws Exception{
		session = sessionFactory.openSession();
		Service service = (Service) session.load(Service.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		return service.getProjet(); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Service> serviceList = session.createCriteria(Service.class)
				.setFetchMode("lineItems", FetchMode.JOIN)  
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) 
				.list();
		tx.commit();
		session.close();
		return serviceList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Service.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
		return false;
	}
}
