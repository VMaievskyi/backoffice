package com.backoffice.service.impl;

import java.util.Optional;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backoffice.dao.CartDao;
import com.backoffice.dao.models.CartModel;
import com.backoffice.dao.models.OrderEntryModel;
import com.backoffice.dao.models.ProductModel;
import com.backoffice.service.CalculationService;
import com.backoffice.service.CartService;
import com.backoffice.service.ProductService;
import com.backoffice.service.StockService;

@Component
public class DefaultCartService implements CartService {
	@Autowired
	private ProductService productService;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private StockService stockService;
	@Autowired
	private CalculationService calculationService;

	@Override
	public CartModel modifyCartEntries(final CartModel cart, final String productCode, final int quantity) {
		// TODO: CHECK IF STOCK SUFFICIENT
		final ProductModel product = productService.getByCode(productCode);
		if (product == null) {
			throw new NotFoundException(String.format("profuct with sku: '%s' not found", productCode));
		}

		final Optional<OrderEntryModel> entry = cart.getOrderEntries().stream()
				.filter(lambdaEntry -> lambdaEntry.getProduct().getSku().equals(productCode)).findFirst();
		if (entry.isPresent()) {
			final OrderEntryModel entryToProcess = entry.get();
			modifyEntryCount(cart, entryToProcess, entryToProcess.getQuantity() + quantity);
		} else {
			createEntry(cart, product, quantity);
		}
		calculationService.recalculate(cart);
		return cartDao.save(cart);
	}

	private void createEntry(final CartModel cart, final ProductModel product, final int quantity) {
		if (quantity <= NumberUtils.INTEGER_ZERO) {
			throw new BadRequestException("cart.add.new.quantity.wrong");
		}
		final OrderEntryModel entry = new OrderEntryModel();
		entry.setProduct(product);
		entry.setQuantity(quantity);
		cart.getOrderEntries().add(entry);
	}

	private void modifyEntryCount(final CartModel cart, final OrderEntryModel entry, final int newQuantity) {
		int stockAdjustment = NumberUtils.INTEGER_ZERO;
		if (newQuantity <= NumberUtils.INTEGER_ZERO) {
			cart.getOrderEntries().remove(entry);
			stockAdjustment = entry.getQuantity();
		} else {
			stockAdjustment = entry.getQuantity() - newQuantity;
			entry.setQuantity(newQuantity);
		}

		stockService.adjustStockLevel(entry.getProduct().getSku(), stockAdjustment);
	}

	@Override
	public CartModel saveCart(final CartModel cart) {
		return cartDao.save(cart);
	}

}
