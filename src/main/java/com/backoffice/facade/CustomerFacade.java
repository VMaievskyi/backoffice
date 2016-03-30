package com.backoffice.facade;

import com.backoffice.dao.models.UserModel;
import com.backoffice.facade.converter.data.CartData;

public interface CustomerFacade {

	UserModel getCustomer();

	CartData getSessionCart();

}
