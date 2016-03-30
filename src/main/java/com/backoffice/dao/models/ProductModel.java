package com.backoffice.dao.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "products")
public class ProductModel {

	@Id
	@Column(unique = true)
	private String sku;

	@Lob
	private String description;
	private Double price;
	@NotEmpty
	private String name;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "product", targetEntity = ImageModel.class, fetch = FetchType.LAZY, cascade = {
			CascadeType.ALL })
	private List<ImageModel> images;

	@OneToMany(mappedBy = "product", targetEntity = ProductAttributeModel.class, fetch = FetchType.LAZY, cascade = {
			CascadeType.ALL })
	private List<ProductAttributeModel> attributes;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "stock_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private StockModel stock;

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

	public String getSku() {
		return sku;
	}

	public void setSku(final String sku) {
		this.sku = sku;
	}

	public List<ImageModel> getImages() {
		return images;
	}

	public void setImages(final List<ImageModel> images) {
		if (images != null) {
			images.forEach(i -> i.setProduct(this));
		}
		this.images = images;
	}

	public List<ProductAttributeModel> getAttributes() {
		return attributes;
	}

	public void setAttributes(final List<ProductAttributeModel> attributes) {
		if (attributes != null) {
			attributes.forEach(a -> a.setProduct(this));
		}
		this.attributes = attributes;
	}

	public StockModel getStock() {
		return stock;
	}

	public void setStock(final StockModel stock) {
		this.stock = stock;
	}

}
