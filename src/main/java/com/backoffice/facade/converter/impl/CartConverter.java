package com.backoffice.facade.converter.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backoffice.dao.models.CartModel;
import com.backoffice.dao.models.CustomerModel;
import com.backoffice.dao.models.DeliveryInfo;
import com.backoffice.dao.models.OrderEntryModel;
import com.backoffice.facade.converter.AbstractConverter;
import com.backoffice.facade.converter.Converter;
import com.backoffice.facade.converter.data.CartData;
import com.backoffice.facade.converter.data.CartEntryData;
import com.backoffice.facade.converter.data.CustomerData;
import com.backoffice.facade.converter.data.DeliveryInfoData;
import com.google.common.base.Preconditions;

@Component("cartConverter")
public class CartConverter extends AbstractConverter<CartModel, CartData> {

	@Autowired
	private Converter<DeliveryInfo, DeliveryInfoData> deliveryInfoConverter;
	@Autowired
	private Converter<OrderEntryModel, CartEntryData> cartEntryConverter;
	@Autowired
	private Converter<CustomerModel, CustomerData> customerConverter;

	@Override
	public CartData convert(final CartModel source) {
		Preconditions.checkNotNull(source);
		final CartData target = createTarget();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(final CartModel source, final CartData target) {
		Preconditions.checkNotNull(source);
		Preconditions.checkNotNull(target);
		target.setTotal(source.getTotalPrice());
		target.setSubTotal(source.getSubTotal());
		target.setDeliveryInfoData(deliveryInfoConverter.convert(source.getDeliveryInfo()));
		target.setCartEntryData(cartEntryConverter.convertAll(source.getOrderEntries()));
		target.setCustomerData(customerConverter.convert(source.getCustomer()));
		// target.setBillingInfoData(billingInfoConverter.convert(source));

	}

	@Override
	public Collection<CartData> convertAll(final Collection<CartModel> sources) {
		Preconditions.checkNotNull(sources);
		return sources.parallelStream().map(cart -> convert(cart)).collect(Collectors.toList());
	}

	@Override
	protected CartData createTarget() {
		return new CartData();
	}

}
