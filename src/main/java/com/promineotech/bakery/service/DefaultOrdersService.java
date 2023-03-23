package com.promineotech.bakery.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.bakery.dao.OrdersDao;
import com.promineotech.bakery.entity.Orders;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultOrdersService implements OrdersService {
	
	@Autowired
	private OrdersDao ordersDao;

	@Transactional
	@Override
	//GET
	public List<Orders> fetchAllOrders() {
		List<Orders> orders = ordersDao.fetchAllOrders();
		if(orders.isEmpty()) {
			String msg = String.format("we have zero orders");
			throw new NoSuchElementException(msg);
		}
		return orders;
	}
}

