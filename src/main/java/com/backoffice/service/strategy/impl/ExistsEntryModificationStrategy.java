package com.backoffice.service.strategy.impl;

import java.util.Optional;

import org.apache.commons.lang.math.NumberUtils;

import com.backoffice.dao.models.CartModel;
import com.backoffice.dao.models.OrderEntryModel;
import com.backoffice.dao.models.ProductModel;
import com.backoffice.service.strategy.EntryModeificationStrategy;

public class ExistsEntryModificationStrategy implements EntryModeificationStrategy {

	@Override
	public OrderEntryModel modifyEntryQuantity(final CartModel cart, final ProductModel product, final int quantity) {
		final Optional<OrderEntryModel> entry = cart.getOrderEntries().stream()
				.filter(lambdaEntry -> lambdaEntry.getProduct().equals(product)).findFirst();
		if (quantity <= NumberUtils.INTEGER_ZERO) {

			cart.getOrderEntries().remove(entry.get());
		} else {
			entry.get().setQuantity(quantity);
		}
		return entry.get();
	}

}
