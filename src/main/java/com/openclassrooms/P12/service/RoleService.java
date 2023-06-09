package com.openclassrooms.P12.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.P12.entities.Role;
import com.openclassrooms.P12.repository.RoleRepository;

@Service
public class RoleService {
	private final Logger logger = LoggerFactory.getLogger(RoleService.class);
	
	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> getAllRoles(){
		logger.info("in RoleService in getAllRoles method");
		return  roleRepository.findAll();
	}
	
public Role getOneRoleById(Integer id) {
	logger.info("in RoleService in getOneRole method");
	return roleRepository.getById(id);
	}
	
	public void saveRole(Role role) {
		logger.info("in RoleService in saveRole method");
		roleRepository.save(role);
	}
	
	
	public void deleteRole (Role role) {
		logger.info("in RoleService in deleteRole method");
		roleRepository.delete(role);
	}
	
	
}
