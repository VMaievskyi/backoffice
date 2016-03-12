package com.backoffice.service;

import com.backoffice.dao.models.ProductModel;

public interface ProductService {

	Iterable<ProductModel> getAllProducts();

	Iterable<ProductModel> getProductByName(String name);

	void save(ProductModel model);
}
