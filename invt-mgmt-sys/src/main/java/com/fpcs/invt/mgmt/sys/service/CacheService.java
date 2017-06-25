package com.fpcs.invt.mgmt.sys.service;

import java.util.List;
import java.util.Set;

public interface CacheService {

	public String getRole(Long roleId);

	Set<String> getRoles();
	
	List<String> getCountries();
	
	List<String> getStates(String country);
	
	List<String> getCities(String state);
	
}
