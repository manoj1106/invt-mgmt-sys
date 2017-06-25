package com.fpcs.invt.mgmt.sys.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpcs.invt.mgmt.sys.dao.CacheDAO;
import com.fpcs.invt.mgmt.sys.domain.Roles;
import com.fpcs.invt.mgmt.sys.service.CacheService;

@Service
public class CacheServiceImpl implements CacheService {

	private static final Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);
	
	@Autowired
	private CacheDAO cacheDAO;
	
	private static Map<Long,String> rolesMap;
	
	private static Set<String> roleSet;
	
	@PostConstruct
	public void createCache() {
		try {
			this.createRolesCache();
		} catch(Exception e) {
			logger.error("error occurred while creating cache..." , e);
		}
	}
	
	private void createRolesCache() {
		List<Roles> roles = cacheDAO.getRoles();
		if(null != roles && !roles.isEmpty()) {
			int size = roles.size();
			if(null == roleSet) {
				roleSet = new HashSet<>(size);
			}
			if(null == rolesMap) {
				rolesMap = new ConcurrentHashMap<>(size);
			}
			roles.forEach(role -> {
				rolesMap.put(role.getRoleId(), role.getRole());
				roleSet.add(role.getRole());
			});
		}
	}
	
	@Override
	public String getRole(Long roleId) {
		return rolesMap.get(roleId);
	}
	
	@Override
	public Set<String> getRoles() {
		return roleSet;
	}
	
}
