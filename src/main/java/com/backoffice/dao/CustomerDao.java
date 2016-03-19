package com.backoffice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backoffice.dao.models.CustomerModel;

@Repository
public interface CustomerDao extends CrudRepository<CustomerModel, Long> {

}
