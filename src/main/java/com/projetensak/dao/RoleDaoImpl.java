package com.projetensak.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.projetensak.model.Role;

public class RoleDaoImpl implements RoleDao{
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addEntity(Role role) throws Exception {

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(role);
		tx.commit();
		session.close();

		return false;
	}

	@Override
	public Role getEntityById(long id) throws Exception {
		session = sessionFactory.openSession();
		Role role = (Role) session.load(Role.class,
				new Long(id));
		tx = session.getTransaction();
		session.beginTransaction();
		tx.commit();
		session.close();
		return role;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<Role> roleList = session.createCriteria(Role.class)
				.setFetchMode("lineItems", FetchMode.JOIN)  
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) 
				.list();
		tx.commit();
		session.close();
		System.out.print(""+roleList.size()) ; 
		return roleList;
	}
	
	@Override
	public boolean deleteEntity(long id)
			throws Exception {
		session = sessionFactory.openSession();
		Object o = session.load(Role.class, id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		session.close();
		return false;
	}

}
