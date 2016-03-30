package com.backoffice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backoffice.dao.models.UserModel;

@Repository
interface CustomerDao extends CrudRepository<UserModel, String> {

}
