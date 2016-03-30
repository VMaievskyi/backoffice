package com.backoffice.facade;

import com.backoffice.dao.models.CartModel;
import com.backoffice.facade.converter.data.CartData;

public interface CartFacade {

	CartData getSessionCart();

	CartModel addToCart(String productCode, int quantity);

}
