package com.promineotech.bakery.dao;

import java.util.List;

import com.promineotech.bakery.entity.Orders_Items;

public interface OrderItemsDao {

	//method to read all orders and items together in one table.
	public List<Orders_Items> fetchAllOrdersAndItems();

}
