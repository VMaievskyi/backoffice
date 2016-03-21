package com.backoffice.service;

import com.backoffice.dao.models.CartModel;

public interface CalculationService {

	void calculateOrder(CartModel order);

	void recalculate(CartModel order);
}
