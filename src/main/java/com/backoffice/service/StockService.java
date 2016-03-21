package com.backoffice.service;

public interface StockService {

	void adjustStockLevel(String sku, int stockAdjustment);
}
