package com.fpcs.invt.mgmt.sys.vo;

public class ShopRegistrationVO {

	private Long shopId;
	private String shopName;
	private String shopLicenceNo;
	private String addressLine1;
	private String addressLine2;
	private String town;
	private Long pincode;
	private String city;
	private String state;
	private String country;
	private String shopOwner;
	private Long tanNumber;
	private String registrationDate;
	private String deletedOn;
	private String shopStartDate;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopLicenceNo() {
		return shopLicenceNo;
	}

	public void setShopLicenceNo(String shopLicenceNo) {
		this.shopLicenceNo = shopLicenceNo;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(String shopOwner) {
		this.shopOwner = shopOwner;
	}

	public Long getTanNumber() {
		return tanNumber;
	}

	public void setTanNumber(Long tanNumber) {
		this.tanNumber = tanNumber;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getDeletedOn() {
		return deletedOn;
	}

	public void setDeletedOn(String deletedOn) {
		this.deletedOn = deletedOn;
	}

	public String getShopStartDate() {
		return shopStartDate;
	}

	public void setShopStartDate(String shopStartDate) {
		this.shopStartDate = shopStartDate;
	}

}
