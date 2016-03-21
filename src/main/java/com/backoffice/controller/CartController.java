package com.backoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.backoffice.dao.models.CartModel;
import com.backoffice.facade.CartFacade;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartFacade cartFacade;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public CartModel getCart() {
		return cartFacade.getSessionCart();
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT)
	public CartModel addToCart(@RequestParam(required = true) final String productCode,
			@RequestParam final int quantity) {
		return cartFacade.addToCart(productCode, quantity);
	}
}
