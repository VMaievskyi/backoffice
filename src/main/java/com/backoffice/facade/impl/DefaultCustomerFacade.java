package com.backoffice.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backoffice.dao.models.CartModel;
import com.backoffice.dao.models.UserModel;
import com.backoffice.facade.CustomerFacade;
import com.backoffice.facade.converter.Converter;
import com.backoffice.facade.converter.data.CartData;
import com.backoffice.service.CartService;

@Component
public class DefaultCustomerFacade implements CustomerFacade {

	@Autowired
	private Converter<CartModel, CartData> cartConverter;
	@Autowired
	private CartService cartService;

	@Override
	public UserModel getCustomer() {
		return null;
	}

	@Override
	public CartData getSessionCart() {
		final CartModel cart = cartService.getSessionCart();
		return cartConverter.convert(cart);
	}

}
