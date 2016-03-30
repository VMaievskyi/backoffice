package com.backoffice.facade.converter.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backoffice.dao.models.ImageModel;
import com.backoffice.dao.models.ProductAttributeModel;
import com.backoffice.dao.models.ProductModel;
import com.backoffice.facade.converter.AbstractConverter;
import com.backoffice.facade.converter.Converter;
import com.backoffice.facade.converter.data.ImageData;
import com.backoffice.facade.converter.data.ProductAttributeData;
import com.backoffice.facade.converter.data.ProductData;
import com.google.common.base.Preconditions;

@Component
public class ProductConverter extends AbstractConverter<ProductModel, ProductData> {

	@Autowired
	private Converter<ProductAttributeModel, ProductAttributeData> productAttributeConverter;
	@Autowired
	private Converter<ImageModel, ImageData> imageConverter;

	@Override
	public ProductData convert(final ProductModel source) {
		Preconditions.checkNotNull(source);
		final ProductData target = createTarget();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(final ProductModel source, final ProductData target) {
		Preconditions.checkNotNull(source);
		Preconditions.checkNotNull(target);

		target.setAttributes(productAttributeConverter.convertAll(source.getAttributes()));
		target.setImages(imageConverter.convertAll(source.getImages()));
		target.setDescription(source.getDescription());
		target.setName(source.getName());
		target.setPrice(source.getPrice());
		target.setSku(source.getSku());

	}

	@Override
	public Collection<ProductData> convertAll(final Collection<ProductModel> sources) {
		Preconditions.checkNotNull(sources);
		return sources.parallelStream().map(source -> convert(source)).collect(Collectors.toList());
	}

	@Override
	protected ProductData createTarget() {
		return new ProductData();
	}

}
