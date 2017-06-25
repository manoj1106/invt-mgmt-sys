package com.fpcs.invt.mgmt.sys.service;

import java.util.Set;

public interface CacheService {

	public String getRole(Long roleId);

	Set<String> getRoles();
	
}
