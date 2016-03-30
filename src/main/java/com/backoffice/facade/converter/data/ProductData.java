package com.backoffice.facade.converter.data;

import java.util.Collection;

public class ProductData {

	private String sku;

	private String description;
	private Double price;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	private Collection<ImageData> images;

	private Collection<ProductAttributeData> attributes;

	public String getSku() {
		return sku;
	}

	public void setSku(final String sku) {
		this.sku = sku;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(final Double price) {
		this.price = price;
	}

	public Collection<ImageData> getImages() {
		return images;
	}

	public void setImages(final Collection<ImageData> images) {
		this.images = images;
	}

	public Collection<ProductAttributeData> getAttributes() {
		return attributes;
	}

	public void setAttributes(final Collection<ProductAttributeData> attributes) {
		this.attributes = attributes;
	}

}
