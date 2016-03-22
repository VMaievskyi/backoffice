package com.backoffice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backoffice.dao.models.StockModel;

@Repository
public interface StockDao extends CrudRepository<StockModel, Long> {

}
