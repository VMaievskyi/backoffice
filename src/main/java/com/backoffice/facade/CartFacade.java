package com.backoffice.facade;

import com.backoffice.dao.models.CartModel;

public interface CartFacade {

	CartModel getSessionCart();

	CartModel addToCart(String productCode, int quantity);

}
