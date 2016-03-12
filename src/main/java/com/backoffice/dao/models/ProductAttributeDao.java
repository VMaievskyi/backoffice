package com.backoffice.dao.models;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeDao extends PagingAndSortingRepository<ProductAttributeModel, Long> {

}
