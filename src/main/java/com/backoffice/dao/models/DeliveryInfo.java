package com.backoffice.dao.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.backoffice.dao.models.delivery.DeliveryTypeModel;

@Entity(name = "delivery")
public class DeliveryInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_type")
	private DeliveryTypeModel deliveryType;

	public DeliveryTypeModel getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(final DeliveryTypeModel deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

}
