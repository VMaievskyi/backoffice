package com.backoffice.service.impl;

import java.util.List;
import java.util.stream.DoubleStream;

import org.springframework.stereotype.Service;

import com.backoffice.dao.models.OrderEntryModel;
import com.backoffice.dao.models.OrderModel;
import com.backoffice.service.CalculationService;
import com.google.common.base.Preconditions;

@Service
public class DefaultCalculationService implements CalculationService {

	@Override
	public void calculateOrder(final OrderModel order) {
		Preconditions.checkNotNull(order);
		calculateEntryPrices(order);

		order.setTotalPrice(
				DoubleStream.of(order.getSubTotal(), order.getDeliveryInfo().getDeliveryType().getCost()).sum());

	}

	private void calculateEntryPrices(final OrderModel order) {
		final List<OrderEntryModel> orderEntries = order.getOrderEntries();
		orderEntries.forEach(entry -> entry.setTotalPrice(entry.getProduct().getPrice() * entry.getQuantity()));

		final double totalProductPrices = orderEntries.stream().mapToDouble(entry -> entry.getTotalPrice()).sum();
		order.setSubTotal(totalProductPrices);

	}

}
