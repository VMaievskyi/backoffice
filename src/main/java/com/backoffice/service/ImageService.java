package com.backoffice.service;

import com.backoffice.dao.models.ImageModel;

public interface ImageService {

	Iterable<ImageModel> getAll();
}
