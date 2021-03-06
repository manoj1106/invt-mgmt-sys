package com.fpcs.invt.mgmt.sys.domain.shop_data;
// default package
// Generated Jun 25, 2017 4:35:15 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StockId generated by hbm2java
 */
@SuppressWarnings("serial")
@Embeddable
public class StockId implements java.io.Serializable {

	private String itemName;
	private String itemCode;

	public StockId() {
	}

	public StockId(String itemName, String itemCode) {
		this.itemName = itemName;
		this.itemCode = itemCode;
	}

	@Column(name = "item_name", nullable = false, length = 300)
	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "item_code", nullable = false, length = 15)
	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StockId))
			return false;
		StockId castOther = (StockId) other;

		return ((this.getItemName() == castOther.getItemName()) || (this.getItemName() != null
				&& castOther.getItemName() != null && this.getItemName().equals(castOther.getItemName())))
				&& ((this.getItemCode() == castOther.getItemCode()) || (this.getItemCode() != null
						&& castOther.getItemCode() != null && this.getItemCode().equals(castOther.getItemCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getItemName() == null ? 0 : this.getItemName().hashCode());
		result = 37 * result + (getItemCode() == null ? 0 : this.getItemCode().hashCode());
		return result;
	}

}
