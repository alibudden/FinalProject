package com.promineotech.bakery.dao;

import java.util.List;

import com.promineotech.bakery.entity.Orders_Items;

public interface OrderItemsDao {

	public List<Orders_Items> fetchAllOrdersAndItems();

}
