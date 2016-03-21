package com.backoffice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backoffice.dao.ProductDao;
import com.backoffice.dao.models.ProductModel;
import com.backoffice.service.ProductService;

@Service
public class DefaultProductService implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public Iterable<ProductModel> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Iterable<ProductModel> getProductByName(final String name) {
		return productDao.findByNameContaining(name);
	}

	@Override
	public void save(final ProductModel model) {
		productDao.save(model);
	}

	@Override
	public ProductModel getByCode(final String productCode) {
		return productDao.findOne(productCode);
	}

}
