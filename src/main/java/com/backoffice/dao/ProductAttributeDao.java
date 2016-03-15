package com.backoffice.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.backoffice.dao.models.ProductAttributeModel;

@Repository
public interface ProductAttributeDao extends PagingAndSortingRepository<ProductAttributeModel, Long> {

}
