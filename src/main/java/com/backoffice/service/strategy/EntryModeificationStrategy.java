package com.backoffice.service.strategy;

import com.backoffice.dao.models.CartModel;
import com.backoffice.dao.models.OrderEntryModel;
import com.backoffice.dao.models.ProductModel;

public interface EntryModeificationStrategy {

	OrderEntryModel modifyEntryQuantity(CartModel cart, ProductModel product, int quantity);
}
