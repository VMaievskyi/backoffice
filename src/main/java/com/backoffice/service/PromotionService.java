package com.backoffice.service;

import com.backoffice.dao.models.OrderModel;

public interface PromotionService {

	void applyPromotions(OrderModel order);
}
