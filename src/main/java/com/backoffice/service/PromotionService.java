package com.backoffice.service;

import com.backoffice.dao.models.CartModel;

public interface PromotionService {

	void applyPromotions(CartModel order);
}
