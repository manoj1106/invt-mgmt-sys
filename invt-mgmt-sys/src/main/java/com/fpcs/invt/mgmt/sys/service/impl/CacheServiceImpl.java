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
import com.fpcs.invt.mgmt.sys.domain.static_data.City;
import com.fpcs.invt.mgmt.sys.domain.static_data.State;
import com.fpcs.invt.mgmt.sys.domain.user_data.Roles;
import com.fpcs.invt.mgmt.sys.service.CacheService;

@Service
public class CacheServiceImpl implements CacheService {

	private static final Logger logger = LoggerFactory.getLogger(CacheServiceImpl.class);
	
	@Autowired
	private CacheDAO cacheDAO;
	
	private Map<Long,String> rolesMap;
	
	private List<String> countries;
	
	private Map<String,List<String>> statesMap;
	
	private Map<String,List<String>> citiesMap;
	
	private Set<String> roleSet;
	
	@PostConstruct
	public void createCache() {
		try {
			this.createRolesCache();
			this.createCountryCache();
			this.createStateCache();
			this.createCityCache();
		} catch(Exception e) {
			logger.error("error occurred while creating cache..." , e);
		}
	}
	
	private void createCountryCache() {
		if(null == countries) {
			countries = new ArrayList<>();
		}
		countries = cacheDAO.getCountries();
	}
	
	private void createStateCache() {
		
		if(null == statesMap) {
			statesMap = new ConcurrentHashMap<>();
		}
		
		List<State> states = cacheDAO.getStates();
		if(null != states && !states.isEmpty()) {
			states.forEach(state -> {
				if(null == statesMap.get(state.getId().getCountry())) {
					List<String> tempStates = new ArrayList<>();
					tempStates.add(state.getId().getState());
					statesMap.put(state.getId().getCountry(), tempStates);
				} else {
					statesMap.get(state.getId().getCountry()).add(state.getId().getState());
				}
			});
		}
		
	}
	
	private void createCityCache() {
		
		if(null == citiesMap) {
			citiesMap = new ConcurrentHashMap<>();
		}
		
		List<City> cities = cacheDAO.getCities();
		if(null != cities && !cities.isEmpty()) {
			cities.forEach(city -> {
				if(null == citiesMap.get(city.getId().getState())) {
					List<String> tempStates = new ArrayList<>();
					tempStates.add(city.getId().getCity());
					citiesMap.put(city.getId().getState(), tempStates);
				} else {
					citiesMap.get(city.getId().getState()).add(city.getId().getCity());
				}
			});
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
	
	@Override
	public List<String> getCountries() {
		return this.countries;
	}

	@Override
	public List<String> getStates(String country) {
		return this.statesMap.get(country);
	}

	@Override
	public List<String> getCities(String state) {
		return this.citiesMap.get(state);
	}

}
