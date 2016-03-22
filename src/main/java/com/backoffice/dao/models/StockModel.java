package com.backoffice.dao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.backoffice.pojo.StockStatus;

@Entity(name = "stocks")
public class StockModel implements Serializable {

	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long availabeQuantity;
	private Long reservedQuantity;
	@Transient
	private StockStatus stockStatus;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Long getAvailabeQuantity() {
		return availabeQuantity;
	}

	public void setAvailabeQuantity(final Long availabeQuantity) {
		this.availabeQuantity = availabeQuantity;
	}

	public Long getReservedQuantity() {
		return reservedQuantity;
	}

	public void setReservedQuantity(final Long reservedQuantity) {
		this.reservedQuantity = reservedQuantity;
	}

	public StockStatus getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(final StockStatus stockStatus) {
		this.stockStatus = stockStatus;
	}

}
