package com.promineotech.bakery.dao;

import java.util.List;

import com.promineotech.bakery.entity.Orders;

public interface OrdersDao {

	//method to read all orders from the orders table
	public List<Orders> fetchAllOrders();

}
