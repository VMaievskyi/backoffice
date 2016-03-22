package com.backoffice.service.strategy.impl;

import com.backoffice.dao.models.CartModel;
import com.backoffice.dao.models.OrderEntryModel;
import com.backoffice.dao.models.ProductModel;
import com.backoffice.service.strategy.EntryModeificationStrategy;

public class NewEntryModificationStrategy implements EntryModeificationStrategy {

	@Override
	public OrderEntryModel modifyEntryQuantity(final CartModel cart, final ProductModel product, final int quantity) {

		final OrderEntryModel entry = new OrderEntryModel();
		entry.setProduct(product);
		entry.setQuantity(quantity);
		cart.getOrderEntries().add(entry);
		return entry;
	}

}
