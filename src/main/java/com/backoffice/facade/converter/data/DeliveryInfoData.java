package com.backoffice.facade.converter.data;

public class DeliveryInfoData {

	private String typeName;
	private double cost;

	private AddressData deliveryAddress;

	private String mobilePhone;
	private String homePhone;
	private String email;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(final String typeName) {
		this.typeName = typeName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(final double cost) {
		this.cost = cost;
	}

	public AddressData getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(final AddressData deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(final String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(final String homePhone) {
		this.homePhone = homePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

}
