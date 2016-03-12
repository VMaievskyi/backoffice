package com.backoffice.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.backoffice.dao.models.ImageModel;

@Repository
public interface ImageDao extends PagingAndSortingRepository<ImageModel, Long> {

}
