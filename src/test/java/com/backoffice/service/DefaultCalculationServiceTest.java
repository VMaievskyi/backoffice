package com.backoffice.service;

import org.junit.Assert;
import org.junit.Test;

import com.backoffice.dao.TestDataCreator;
import com.backoffice.dao.models.OrderModel;
import com.backoffice.service.impl.DefaultCalculationService;

public class DefaultCalculationServiceTest {
	private static final double PRECISION = 0.01;

	private final CalculationService testInstanse = new DefaultCalculationService();

	@Test
	public void shouldCaluclateOrder() {
		final OrderModel order = TestDataCreator.createOrder();
		order.getOrderEntries().add(TestDataCreator.createOrderEntry());
		order.getOrderEntries().add(TestDataCreator.createOrderEntry());
		testInstanse.calculateOrder(order);
		final double expectedSubtotal = order.getOrderEntries().size() * TestDataCreator.QUANTITY
				* TestDataCreator.PRODUCT_PRICE;
		Assert.assertEquals("wrong subtotal", expectedSubtotal, order.getSubTotal(), PRECISION);
		Assert.assertEquals("wrong total", expectedSubtotal + order.getDeliveryInfo().getDeliveryType().getCost(),
				order.getTotalPrice(), PRECISION);
	}

}
