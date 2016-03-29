package com.backoffice.facade.converter.data;

import java.util.Collection;

public class CartData {

	private Double subTotal;
	private Double total;
	private CustomerData customerData;
	private Collection<CartEntryData> cartEntryData;
	private DeliveryInfoData deliveryInfoData;
	private BillingInfoData billingInfoData;

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(final Double subTotal) {
		this.subTotal = subTotal;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(final Double total) {
		this.total = total;
	}

	public CustomerData getCustomerData() {
		return customerData;
	}

	public void setCustomerData(final CustomerData customerData) {
		this.customerData = customerData;
	}

	public Collection<CartEntryData> getCartEntryData() {
		return cartEntryData;
	}

	public void setCartEntryData(final Collection<CartEntryData> cartEntryData) {
		this.cartEntryData = cartEntryData;
	}

	public DeliveryInfoData getDeliveryInfoData() {
		return deliveryInfoData;
	}

	public void setDeliveryInfoData(final DeliveryInfoData deliveryInfoData) {
		this.deliveryInfoData = deliveryInfoData;
	}

	public BillingInfoData getBillingInfoData() {
		return billingInfoData;
	}

	public void setBillingInfoData(final BillingInfoData billingInfoData) {
		this.billingInfoData = billingInfoData;
	}

}
