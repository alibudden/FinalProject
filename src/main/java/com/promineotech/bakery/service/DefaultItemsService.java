package com.promineotech.bakery.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.bakery.dao.ItemsDao;
import com.promineotech.bakery.entity.Items;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultItemsService implements ItemsService {
	
	@Autowired
	private ItemsDao itemsDao;

	@Transactional
	@Override
	//GET
	public List<Items> fetchAllItems() {
		List<Items> items = itemsDao.fetchAllItems();
		if(items.isEmpty()) {
			String msg = String.format("We have no bakery items");
			throw new NoSuchElementException(msg);
		}
		return items;
	}

}
