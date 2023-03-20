package com.promineotech.bakery.entity;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders {
	
	//describes the variables within the orders table
	
	private int order_id;
	private int customer_id;
	private Date order_date;
	

}
