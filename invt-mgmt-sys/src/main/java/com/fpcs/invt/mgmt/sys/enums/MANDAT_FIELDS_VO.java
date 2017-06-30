package com.fpcs.invt.mgmt.sys.enums;

public enum MANDAT_FIELDS_VO {

	SHOP_REGISTRATION_VO("ShopRegistrationVO" , 
			new String[]{"shopName","shopOwner","shopLicenceNo","addressLine1","town","city","state","pincode","country"}),
	USER_REGISTRATION_VO("UserRegistrationVO" , 
			new String[]{"firstName","lastName","addressLine1","town","city","state","pincode","country"})
	;
	
	private final String voClass;
	private final String[] mandatFields;
	
	private MANDAT_FIELDS_VO(String voClass , String[] mandatFields) {
		this.voClass = voClass;
		this.mandatFields = mandatFields;
	}

	public String getVoClass() {
		return voClass;
	}

	public String[] getMandatFields() {
		return mandatFields;
	}
	
	
}
