package com.backoffice.dao;

import org.springframework.data.repository.CrudRepository;

import com.backoffice.dao.models.UserModel;

public interface UserDao extends CrudRepository<UserModel, String> {

}
