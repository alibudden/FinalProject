package com.promineotech.bakery.dao;

import java.util.List;

import com.promineotech.bakery.entity.Orders;

public interface OrdersDao {

	public List<Orders> fetchAllOrders();

}
