package com.backoffice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backoffice.dao.ImageDao;
import com.backoffice.dao.models.ImageModel;
import com.backoffice.service.ImageService;

@Service
public class DefaultImageService implements ImageService {

	@Autowired
	private ImageDao imageDao;

	@Override
	public Iterable<ImageModel> getAll() {
		return imageDao.findAll();
	}

}
