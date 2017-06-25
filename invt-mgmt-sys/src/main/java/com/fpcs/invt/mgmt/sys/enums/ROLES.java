package com.fpcs.invt.mgmt.sys.enums;

public enum ROLES {

	SYSTEM_ADMIN("SYSTEM_ADMIN");
	
	private final String role;
	
	private ROLES(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
}
