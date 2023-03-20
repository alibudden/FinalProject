package com.promineotech.bakery.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders_Items {
	
	//describes the variables within the order_items table
	
	private int order_id;
	private int item_id;
	private String quantity;
	

}
