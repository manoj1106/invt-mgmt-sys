package com.fpcs.invt.mgmt.sys.domain.static_data;
// default package
// Generated Jun 25, 2017 4:27:52 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CityId generated by hbm2java
 */
@SuppressWarnings("serial")
@Embeddable
public class CityId implements java.io.Serializable {

	private String city;
	private String state;
	private String country;

	public CityId() {
	}

	public CityId(String city, String state, String country) {
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Column(name = "city", unique = true, nullable = false, length = 50)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", unique = true, nullable = false, length = 50)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "country", unique = true, nullable = false, length = 50)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CityId))
			return false;
		CityId castOther = (CityId) other;

		return ((this.getCity() == castOther.getCity()) || (this.getCity() != null && castOther.getCity() != null
				&& this.getCity().equals(castOther.getCity())))
				&& ((this.getState() == castOther.getState()) || (this.getState() != null
						&& castOther.getState() != null && this.getState().equals(castOther.getState())))
				&& ((this.getCountry() == castOther.getCountry()) || (this.getCountry() != null
						&& castOther.getCountry() != null && this.getCountry().equals(castOther.getCountry())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCity() == null ? 0 : this.getCity().hashCode());
		result = 37 * result + (getState() == null ? 0 : this.getState().hashCode());
		result = 37 * result + (getCountry() == null ? 0 : this.getCountry().hashCode());
		return result;
	}

}
