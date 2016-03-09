package com.backoffice.dao.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderModel {

  	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
  	
  	
}
