package com.backoffice.service.impl;

import java.util.List;
import java.util.stream.DoubleStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backoffice.dao.models.OrderEntryModel;
import com.backoffice.dao.models.OrderModel;
import com.backoffice.service.CalculationService;
import com.backoffice.service.PromotionService;
import com.google.common.base.Preconditions;

@Service
public class DefaultCalculationService implements CalculationService {

	@Autowired
	private PromotionService promotionService;

	@Override
	public void calculateOrder(final OrderModel order) {
		Preconditions.checkNotNull(order);
		if (recalculationRequired()) {
			recalculate(order);
		}
	}

	@Override
	public void recalculate(final OrderModel order) {
		Preconditions.checkNotNull(order);
		promotionService.applyPromotions(order);

		calculateEntryPrices(order);

		order.setTotalPrice(
				DoubleStream.of(order.getSubTotal(), order.getDeliveryInfo().getDeliveryType().getCost()).sum());

	}

	private boolean recalculationRequired() {
		// TODO: Find out reasonable test
		return Boolean.TRUE;
	}

	private void calculateEntryPrices(final OrderModel order) {
		final List<OrderEntryModel> orderEntries = order.getOrderEntries();
		orderEntries.forEach(entry -> entry.setTotalPrice(entry.getProduct().getPrice() * entry.getQuantity()));

		final double totalProductPrices = orderEntries.stream().mapToDouble(entry -> entry.getTotalPrice()).sum();
		order.setSubTotal(totalProductPrices);

	}

}
