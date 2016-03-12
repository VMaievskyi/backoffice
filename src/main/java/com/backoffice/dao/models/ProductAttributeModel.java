package com.backoffice.dao.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "attributes")
public class ProductAttributeModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String value;

	@ManyToOne(optional = true)
	@JoinColumn(name = "sku", referencedColumnName = "sku")
	private ProductModel product;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(final ProductModel product) {
		this.product = product;
	}

}
