package com.fpcs.invt.mgmt.sys.domain;
// default package
// Generated 17 Jun, 2017 6:07:24 PM by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AvailableStock generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "available_stock", schema = "shop_data")
public class AvailableStock implements java.io.Serializable {

	private long itemId;
	private ShopDetails shopDetails;
	private Stock stock;
	private Long itemQty;
	private BigDecimal itemPrice;

	public AvailableStock() {
	}

	public AvailableStock(long itemId) {
		this.itemId = itemId;
	}

	public AvailableStock(long itemId, ShopDetails shopDetails, Stock stock, Long itemQty, BigDecimal itemPrice) {
		this.itemId = itemId;
		this.shopDetails = shopDetails;
		this.stock = stock;
		this.itemQty = itemQty;
		this.itemPrice = itemPrice;
	}

	@Id

	@Column(name = "item_id", unique = true, nullable = false)
	public long getItemId() {
		return this.itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	public ShopDetails getShopDetails() {
		return this.shopDetails;
	}

	public void setShopDetails(ShopDetails shopDetails) {
		this.shopDetails = shopDetails;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "item_name", referencedColumnName = "item_name"),
			@JoinColumn(name = "item_code", referencedColumnName = "item_code") })
	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@Column(name = "item_qty")
	public Long getItemQty() {
		return this.itemQty;
	}

	public void setItemQty(Long itemQty) {
		this.itemQty = itemQty;
	}

	@Column(name = "item_price", precision = 131089, scale = 0)
	public BigDecimal getItemPrice() {
		return this.itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

}
