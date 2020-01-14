package com.projetensak.dao;

import java.util.List;

import com.projetensak.model.Role;

public interface RoleDao {
	public boolean addEntity(Role role) throws Exception;
	public Role getEntityById(long id) throws Exception;
	public List<Role> getEntityList() throws Exception;
	public boolean deleteEntity(long id) throws Exception;
}
