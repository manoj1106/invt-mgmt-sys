/**
 * 
 */
package com.fpcs.invt.mgmt.sys.vo;

/**
 * @author Manoj Patel
 *
 */
public class MenuItemAccessVO {

	private Long shopId;
	private String role;
	private String menuItem;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

}
