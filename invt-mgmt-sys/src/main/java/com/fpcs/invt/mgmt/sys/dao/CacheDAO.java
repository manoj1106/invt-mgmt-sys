package com.fpcs.invt.mgmt.sys.dao;

import java.util.List;

import com.fpcs.invt.mgmt.sys.domain.static_data.City;
import com.fpcs.invt.mgmt.sys.domain.static_data.State;
import com.fpcs.invt.mgmt.sys.domain.user_data.Roles;

public interface CacheDAO {

	public List<Roles> getRoles();
	
	public List<String> getCountries();
	
	public List<State> getStates();
	
	public List<City> getCities();
	
}
