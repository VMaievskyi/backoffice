package com.backoffice.service;

import com.backoffice.dao.models.OrderModel;

public interface CalculationService {

	void calculateOrder(OrderModel order);
}
