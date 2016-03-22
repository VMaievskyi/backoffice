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
import com.backoffice.service.strategy.EntryModeificationStrategy;
import com.backoffice.service.strategy.EntryModificationType;
import com.backoffice.service.strategy.impl.EntryModificationStrategyFactory;

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
	@Autowired
	private EntryModificationStrategyFactory entryModificationStrategyFactory;

	@Override
	public CartModel modifyCartEntries(final CartModel cart, final String productCode, final int quantity) {
		final ProductModel product = productService.getByCode(productCode);
		if (product == null) {
			throw new NotFoundException(String.format("profuct with sku: '%s' not found", productCode));
		}
		if (quantity <= NumberUtils.INTEGER_ZERO) {
			throw new BadRequestException("cart.add.new.quantity.wrong");
		}

		EntryModeificationStrategy strategy;
		int stockAdjustment;

		final Optional<OrderEntryModel> entry = cart.getOrderEntries().stream()
				.filter(lambdaEntry -> lambdaEntry.getProduct().getSku().equals(productCode)).findFirst();
		if (entry.isPresent()) {
			strategy = entryModificationStrategyFactory.getStrategy(EntryModificationType.EXISTS);
			stockAdjustment = entry.get().getQuantity() + quantity;
		} else {
			strategy = entryModificationStrategyFactory.getStrategy(EntryModificationType.NEW);
			stockAdjustment = quantity;
		}
		stockService.adjustStockLevel(product.getSku(), stockAdjustment);
		strategy.modifyEntryQuantity(cart, product, quantity);
		calculationService.recalculate(cart);
		return cartDao.save(cart);
	}

	@Override
	public CartModel saveCart(final CartModel cart) {
		return cartDao.save(cart);
	}

}
