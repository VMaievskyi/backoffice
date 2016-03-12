package com.backoffice.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backoffice.dao.models.ProductModel;
import com.backoffice.facade.ProductFacade;
import com.backoffice.service.ProductService;
import com.google.common.base.Preconditions;

@Component("productFacade")
public class DefaultProductFacade implements ProductFacade {

	@Autowired
	private ProductService productService;

	@Override
	public Iterable<ProductModel> getAllProducts() {
		return productService.getAllProducts();
	}

	@Override
	public Iterable<ProductModel> getProductByName(final String name) {
		return productService.getProductByName(name);
	}

	@Override
	public void save(final ProductModel model) {
		Preconditions.checkNotNull(model);
		productService.save(model);

	}

}
