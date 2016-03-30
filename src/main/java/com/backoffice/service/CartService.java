package com.backoffice.service;

import com.backoffice.dao.models.CartModel;

public interface CartService {

	CartModel modifyCartEntries(CartModel cart, String productCode, int quantity);

	CartModel saveCart(CartModel cart);

	CartModel getSessionCart();

}
