package com.backoffice.facade.converter.data;

public class CartEntryData {

	private ProductData product;

	private int quantity;

	private double totalPrice;

	public ProductData getProduct() {
		return product;
	}

	public void setProduct(final ProductData product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(final double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
