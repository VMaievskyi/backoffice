package com.backoffice.dao.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.backoffice.pojo.StockStatus;

@Entity(name="stocks")
public class StockModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long availabeQuantity;
	private Long reservedQuantity;
	@Transient
	private StockStatus stockStatus;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAvailabeQuantity() {
		return availabeQuantity;
	}

	public void setAvailabeQuantity(Long availabeQuantity) {
		this.availabeQuantity = availabeQuantity;
	}

	public Long getReservedQuantity() {
		return reservedQuantity;
	}

	public void setReservedQuantity(Long reservedQuantity) {
		this.reservedQuantity = reservedQuantity;
	}

	public StockStatus getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(StockStatus stockStatus) {
		this.stockStatus = stockStatus;
	}
    
}
