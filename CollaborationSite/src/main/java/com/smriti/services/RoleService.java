package com.smriti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smriti.dao.RoleDAO;
import com.smriti.model.Roles;

@Service
public class RoleService {

	@Autowired
	private RoleDAO roleDAO;
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}
	
	
	@Transactional
	public void add(Roles role) {
		this.roleDAO.add(role);
	}
}
