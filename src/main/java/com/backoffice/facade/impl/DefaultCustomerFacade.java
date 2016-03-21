package com.backoffice.facade.impl;

import org.springframework.stereotype.Component;

import com.backoffice.dao.models.CustomerModel;
import com.backoffice.facade.CustomerFacade;

@Component
public class DefaultCustomerFacade implements CustomerFacade {

	@Override
	public CustomerModel getCustomer() {
		return null;
	}

}
