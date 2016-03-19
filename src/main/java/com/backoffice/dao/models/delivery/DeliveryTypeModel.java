package com.backoffice.dao.models.delivery;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.backoffice.dao.models.AddressModel;

@Entity
public abstract class DeliveryTypeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String typeName;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_address")
	private AddressModel deliveryAddress;

	private double cost;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(final String typeName) {
		this.typeName = typeName;
	}

	public AddressModel getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(final AddressModel deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(final double cost) {
		this.cost = cost;
	}

}
