/**
 * 
 */
package com.fpcs.invt.mgmt.sys.dao;

import com.fpcs.invt.mgmt.sys.domain.MenuItemAccess;

/**
 * @author Manoj Patel
 *
 */
public interface MenuItemAccessDAO {

	boolean saveMenuItemAccess(MenuItemAccess menuItemAccess);
	
	MenuItemAccess getMenuItemAccess(Long shopId,String role);
	
	
}
