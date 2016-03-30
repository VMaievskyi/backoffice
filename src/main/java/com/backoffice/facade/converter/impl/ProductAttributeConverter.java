package com.backoffice.facade.converter.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.backoffice.dao.models.ProductAttributeModel;
import com.backoffice.facade.converter.AbstractConverter;
import com.backoffice.facade.converter.data.ProductAttributeData;
import com.google.common.base.Preconditions;

@Component
public class ProductAttributeConverter extends AbstractConverter<ProductAttributeModel, ProductAttributeData> {

	@Override
	public ProductAttributeData convert(final ProductAttributeModel source) {
		Preconditions.checkNotNull(source);
		final ProductAttributeData target = createTarget();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(final ProductAttributeModel source, final ProductAttributeData target) {
		Preconditions.checkNotNull(source);
		Preconditions.checkNotNull(target);
		target.setName(source.getName());
		target.setValue(source.getValue());
	}

	@Override
	public Collection<ProductAttributeData> convertAll(final Collection<ProductAttributeModel> sources) {
		Preconditions.checkNotNull(sources);
		return sources.parallelStream().map(source -> convert(source)).collect(Collectors.toList());
	}

	@Override
	protected ProductAttributeData createTarget() {
		return new ProductAttributeData();
	}

}
