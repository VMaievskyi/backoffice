package com.backoffice.dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.backoffice.dao.models.OrderModel;
@Repository
public interface OrderDao extends PagingAndSortingRepository<OrderModel,Long> {
	

}
