package com.backoffice.facade.converter.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backoffice.dao.models.OrderEntryModel;
import com.backoffice.dao.models.ProductModel;
import com.backoffice.facade.converter.AbstractConverter;
import com.backoffice.facade.converter.Converter;
import com.backoffice.facade.converter.data.CartEntryData;
import com.backoffice.facade.converter.data.ProductData;
import com.google.common.base.Preconditions;

@Component
public class CartEntryConverter extends AbstractConverter<OrderEntryModel, CartEntryData> {
	@Autowired
	private Converter<ProductModel, ProductData> productConverter;

	@Override
	public CartEntryData convert(final OrderEntryModel source) {
		Preconditions.checkNotNull(source);
		final CartEntryData target = createTarget();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(final OrderEntryModel source, final CartEntryData target) {
		target.setQuantity(source.getQuantity());
		target.setTotalPrice(source.getTotalPrice());
		target.setProduct(productConverter.convert(source.getProduct()));
	}

	@Override
	public Collection<CartEntryData> convertAll(final Collection<OrderEntryModel> sources) {
		Preconditions.checkNotNull(sources);
		return sources.parallelStream().map(source -> convert(source)).collect(Collectors.toList());
	}

	@Override
	protected CartEntryData createTarget() {
		return new CartEntryData();
	}

}
