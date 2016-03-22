package com.backoffice.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backoffice.Starter;
import com.backoffice.dao.TestDataCreator;
import com.backoffice.dao.models.OrderModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Starter.class)
public class DefaultCalculationServiceTest {
	private static final double PRECISION = 0.01;

	@Autowired
	private CalculationService testInstanse;

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
