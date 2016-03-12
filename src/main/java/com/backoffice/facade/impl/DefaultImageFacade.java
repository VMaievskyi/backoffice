package com.backoffice.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backoffice.dao.models.ImageModel;
import com.backoffice.facade.ImageFacade;
import com.backoffice.service.ImageService;

@Component
public class DefaultImageFacade implements ImageFacade {

	@Autowired
	private ImageService imageService;

	@Override
	public Iterable<ImageModel> getAll() {
		return imageService.getAll();
	}

}
