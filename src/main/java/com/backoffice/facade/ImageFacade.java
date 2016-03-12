package com.backoffice.facade;

import com.backoffice.dao.models.ImageModel;

public interface ImageFacade {

	Iterable<ImageModel> getAll();
}
