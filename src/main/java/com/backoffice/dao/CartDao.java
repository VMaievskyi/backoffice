package com.backoffice.dao;

import org.springframework.data.repository.CrudRepository;

import com.backoffice.dao.models.CartModel;

public interface CartDao extends CrudRepository<CartModel, Long> {

}
