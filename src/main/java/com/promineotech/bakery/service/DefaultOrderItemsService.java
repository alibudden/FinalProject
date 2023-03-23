package com.promineotech.bakery.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.bakery.dao.OrderItemsDao;
import com.promineotech.bakery.entity.Orders_Items;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DefaultOrderItemsService implements OrderItemsService {

	@Autowired
	private OrderItemsDao orderItemsDao;


	@Transactional
	@Override
	//GET
	public List<Orders_Items> fetchAllOrdersAndItems() {
		List<Orders_Items> ordersitems = orderItemsDao.fetchAllOrdersAndItems();
		if(ordersitems.isEmpty()) {
			String msg = String.format("We have zero orders that also contain zero items");
			throw new NoSuchElementException(msg);
		}
		return ordersitems;
	}

}
