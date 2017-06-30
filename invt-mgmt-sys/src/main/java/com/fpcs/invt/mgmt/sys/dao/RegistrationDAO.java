package com.fpcs.invt.mgmt.sys.dao;

import com.fpcs.invt.mgmt.sys.domain.shop_data.ShopDetails;
import com.fpcs.invt.mgmt.sys.domain.user_data.UserLogin;

public interface RegistrationDAO {

	public Long saveShopDetails(ShopDetails shopDetails);

	public boolean saveUserDetails(UserLogin userLogin);
	
}
