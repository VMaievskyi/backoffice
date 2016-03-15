package com.backoffice.dao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "product" })
@Entity(name = "images")
public class ImageModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String imageName;

	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "sku", referencedColumnName = "sku")
	private ProductModel product;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(final String imageName) {
		this.imageName = imageName;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(final ProductModel product) {
		this.product = product;
	}

}
