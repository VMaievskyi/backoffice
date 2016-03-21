package com.backoffice.dao.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.backoffice.dao.models.promotion.PromotionModel;

@Entity(name = "carts")
public class CartModel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true)
	private long orderCode;

	@Enumerated
	private OrderStatus orderStatus;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<OrderEntryModel> orderEntries;

	@ManyToOne(targetEntity = CustomerModel.class, fetch = FetchType.EAGER)
	private CustomerModel customer;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "delivery_id")
	private DeliveryInfo deliveryInfo;

	@Transient
	private List<PromotionModel> promotions;

	private double subTotal;

	private Double totalPrice;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public long getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(final long orderCode) {
		this.orderCode = orderCode;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(final OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderEntryModel> getOrderEntries() {
		return orderEntries;
	}

	public void setOrderEntries(final List<OrderEntryModel> orderEntries) {
		this.orderEntries = orderEntries;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(final CustomerModel customer) {
		this.customer = customer;
	}

	public DeliveryInfo getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(final DeliveryInfo deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(final Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<PromotionModel> getPromotions() {
		return promotions;
	}

	public void setPromotions(final List<PromotionModel> promotions) {
		this.promotions = promotions;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(final double subTotal) {
		this.subTotal = subTotal;
	}

	public void setId(final long id) {
		this.id = id;
	}
}
