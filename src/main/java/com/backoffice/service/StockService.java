package com.backoffice.service;

import com.backoffice.dao.models.ProductModel;

public interface StockService {

	void adjustStockLevel(ProductModel product, int stockAdjustment);
}
