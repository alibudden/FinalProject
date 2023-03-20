package com.promineotech.bakery.dao;

import java.util.List;

import com.promineotech.bakery.entity.Items;

public interface ItemsDao {

	List<Items> fetchAllItems();

}
