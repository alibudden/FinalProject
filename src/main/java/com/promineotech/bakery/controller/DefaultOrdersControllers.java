package com.promineotech.bakery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.bakery.entity.Orders;
import com.promineotech.bakery.service.OrdersService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultOrdersControllers implements OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	
	//GET
	
	@Override
	public List<Orders> fetchAllOrders() {
		return ordersService.fetchAllOrders();
	}

}
