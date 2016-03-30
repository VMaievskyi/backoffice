package com.backoffice.facade.converter.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.backoffice.dao.models.AddressModel;
import com.backoffice.facade.converter.AbstractConverter;
import com.backoffice.facade.converter.data.AddressData;
import com.google.common.base.Preconditions;

@Component("addressConverter")
public class AddressConverter extends AbstractConverter<AddressModel, AddressData> {

	@Override
	public AddressData convert(final AddressModel source) {
		Preconditions.checkNotNull(source);
		final AddressData target = createTarget();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(final AddressModel source, final AddressData target) {
		Preconditions.checkNotNull(source);
		Preconditions.checkNotNull(target);
		target.setAdditionalInfo(source.getAdditionalInfo());
		target.setAppartment(source.getAppartment());
		target.setBuilding(source.getBuilding());
		target.setCity(source.getCity());
		target.setCountry(source.getCountry());
		target.setDoorCode(source.getDoorCode());
		target.setPostalCode(source.getPostalCode());
		target.setStreet(source.getStreet());
	}

	@Override
	public Collection<AddressData> convertAll(final Collection<AddressModel> sources) {
		Preconditions.checkNotNull(sources);
		return sources.parallelStream().map(source -> convert(source)).collect(Collectors.toList());
	}

	@Override
	protected AddressData createTarget() {
		return new AddressData();
	}

}
