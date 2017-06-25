/**
 * 
 */
package com.fpcs.invt.mgmt.sys.constants.datapopulator;

import com.fpcs.invt.mgmt.sys.domain.user_data.MenuItemAccess;
import com.fpcs.invt.mgmt.sys.vo.MenuItemAccessVO;

/**
 * @author Manoj Patel
 *
 */
public class MenuItemAccessDataPopulator {

	private MenuItemAccessDataPopulator() {
		
	}
	
	public static MenuItemAccess populateMenuItemAccess(MenuItemAccessVO menuItemAccessVO) {
		MenuItemAccess menuItemAccess = new MenuItemAccess();
		menuItemAccess.setShopId(menuItemAccessVO.getShopId());
		menuItemAccess.setRole(menuItemAccessVO.getRole());
		menuItemAccess.setMenuItem(menuItemAccessVO.getMenuItem());
		return menuItemAccess;
	}
	
}
