package com.promineotech.bakery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.bakery.entity.Items;
import com.promineotech.bakery.service.ItemsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j


public class DefaultItemsController implements ItemsController {

	@Autowired
	private ItemsService itemsService;
	
	//GET
	@Override
	public List<Items> fetchAllItems() {
		return itemsService.fetchAllItems();
	}

}
