package com.backoffice.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.backoffice.dao.models.ProductModel;
import com.backoffice.facade.ProductFacade;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductFacade productFacade;

	@ResponseBody
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public Iterable<ProductModel> getAllProducts() {
		LOG.debug("getAllProducts is called");
		return productFacade.getAllProducts();
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", params = { "name" })
	public Iterable<ProductModel> getProductByName(@RequestParam("name") final String name) {
		LOG.debug("getAllProducts is called");
		return productFacade.getProductByName(name);
	}

	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST)
	public void createProduct(@Valid @RequestBody final ProductModel model) {
		LOG.debug("getAllProducts is called");
		productFacade.save(model);
	}

}
