package com.backoffice.service.impl;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backoffice.dao.StockDao;
import com.backoffice.dao.models.ProductModel;
import com.backoffice.dao.models.StockModel;
import com.backoffice.service.StockService;

@Service
public class DefaultStockService implements StockService {

	@Autowired
	private StockDao stockDao;

	@Override
	public void adjustStockLevel(final ProductModel product, final int stockAdjustment) {

		final StockModel stock = product.getStock();
		final Long reservedQuantity = stock.getReservedQuantity();
		final Long availabeQuantity = stock.getAvailabeQuantity();

		if (((availabeQuantity - reservedQuantity) + stockAdjustment) > NumberUtils.LONG_ZERO) {
			stock.setReservedQuantity(reservedQuantity + stockAdjustment);
		} else {
			throw new IllegalArgumentException("stock.not.sufficient");
		}
		stockDao.save(stock);
	}

}
