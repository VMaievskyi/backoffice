package com.backoffice.facade.converter.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backoffice.dao.models.AddressModel;
import com.backoffice.dao.models.DeliveryInfo;
import com.backoffice.facade.converter.AbstractConverter;
import com.backoffice.facade.converter.Converter;
import com.backoffice.facade.converter.data.AddressData;
import com.backoffice.facade.converter.data.DeliveryInfoData;
import com.google.common.base.Preconditions;

@Component("deliveryInfoConverter")
public class DeliveryInfoConverter extends AbstractConverter<DeliveryInfo, DeliveryInfoData> {
	@Autowired
	private Converter<AddressModel, AddressData> addressConverter;

	@Override
	public DeliveryInfoData convert(final DeliveryInfo source) {
		Preconditions.checkNotNull(source);
		final DeliveryInfoData target = createTarget();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(final DeliveryInfo source, final DeliveryInfoData target) {
		Preconditions.checkNotNull(source);
		Preconditions.checkNotNull(target);

		target.setCost(source.getDeliveryType().getCost());
		target.setDeliveryAddress(addressConverter.convert(source.getDeliveryType().getDeliveryAddress()));
		target.setTypeName(source.getDeliveryType().getTypeName());
		target.setEmail(source.getContactInfo().getEmail());
		target.setHomePhone(source.getContactInfo().getHomePhone());
		target.setMobilePhone(source.getContactInfo().getMobilePhone());
	}

	@Override
	public Collection<DeliveryInfoData> convertAll(final Collection<DeliveryInfo> sources) {
		Preconditions.checkNotNull(sources);
		return sources.parallelStream().map(source -> convert(source)).collect(Collectors.toList());
	}

	@Override
	protected DeliveryInfoData createTarget() {
		return new DeliveryInfoData();
	}

}
