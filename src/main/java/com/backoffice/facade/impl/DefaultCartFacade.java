package com.backoffice.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.backoffice.dao.models.CartModel;
import com.backoffice.facade.CartFacade;
import com.backoffice.facade.CustomerFacade;
import com.backoffice.service.CartService;

@Component
public class DefaultCartFacade implements CartFacade {
	@Autowired
	private CustomerFacade customerFacade;
	@Autowired
	private CartService cartService;

	@Override
	public CartModel getSessionCart() {
		return customerFacade.getCustomer().getCart();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public CartModel addToCart(final String productCode, final int quantity) {
		final CartModel cart = getSessionCart();
		return cartService.modifyCartEntries(cart, productCode, quantity);
	}

}
