package com.backoffice.dao;

import javax.annotation.Resource;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.backoffice.dao.models.ProductModel;

@Resource
public interface ProductDao extends PagingAndSortingRepository<ProductModel, String> {

	Iterable<ProductModel> findByNameContaining(String name);

}
