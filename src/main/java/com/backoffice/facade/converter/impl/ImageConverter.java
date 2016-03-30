package com.backoffice.facade.converter.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.backoffice.dao.models.ImageModel;
import com.backoffice.facade.converter.AbstractConverter;
import com.backoffice.facade.converter.data.ImageData;
import com.google.common.base.Preconditions;

@Component
public class ImageConverter extends AbstractConverter<ImageModel, ImageData> {

	@Override
	public ImageData convert(final ImageModel source) {
		Preconditions.checkNotNull(source);
		final ImageData target = createTarget();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(final ImageModel source, final ImageData target) {
		Preconditions.checkNotNull(source);
		Preconditions.checkNotNull(target);

		target.setName(source.getImageName());
		target.setUrl(source.getImageName());

	}

	@Override
	public Collection<ImageData> convertAll(final Collection<ImageModel> sources) {
		Preconditions.checkNotNull(sources);
		return sources.parallelStream().map(source -> convert(source)).collect(Collectors.toList());
	}

	@Override
	protected ImageData createTarget() {
		return new ImageData();
	}

}
