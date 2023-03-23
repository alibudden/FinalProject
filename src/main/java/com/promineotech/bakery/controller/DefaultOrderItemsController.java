package com.promineotech.bakery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.bakery.entity.Orders_Items;
import com.promineotech.bakery.service.OrderItemsService;

@RestController
public class DefaultOrderItemsController implements OrderItemsController {

	@Autowired
	private OrderItemsService orderItemsService;
	
//GET
	@Override
	public List<Orders_Items> fetchAllOrdersAndItems() {
		return orderItemsService.fetchAllOrdersAndItems();
	}

}
