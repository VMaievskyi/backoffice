package com.backoffice.facade;

import com.backoffice.dao.models.ProductModel;

public interface ProductFacade {

	Iterable<ProductModel> getAllProducts();

	Iterable<ProductModel> getProductByName(String name);

	void save(ProductModel model);
}
