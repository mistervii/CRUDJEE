package com.projetensak.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
//import org.json.simple.JSONObject;
import com.projetensak.model.Commentaire;

public class CommentaireDaoImpl implements CommentaireDao{
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Commentaire commentaire) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(commentaire);
		tx.commit();
		session.close();
		return false;
	}

	@Override
	public Commentaire getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Commentaire commentaire = (Commentaire) session.load(Commentaire.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close(); 
		return commentaire;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commentaire> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Commentaire> commentaireList = session.createCriteria(Commentaire.class)
				.setFetchMode("lineItems", FetchMode.JOIN)  
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) 
				.list();
		tx.commit();
		session.close();
		System.out.print(""+commentaireList.size()) ; 
		return commentaireList;
	}

	@Override
	public List<Commentaire> getEntityByPriorite(long priorite) throws Exception {

			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(Commentaire.class);
			List<Commentaire> com =  cr.setFetchMode("lineItems", FetchMode.JOIN)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
					.add(Restrictions.eq("priorite", priorite))
					.list();
			tx= session.getTransaction();
			session.beginTransaction();
			tx.commit();

			session.close();
			//long id=emp.getService().getId();
			return com ;

	}

	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Commentaire.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		session.close(); 
		tx.commit();
		return false;
	}
}
