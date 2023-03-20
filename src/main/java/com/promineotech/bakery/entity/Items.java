package com.promineotech.bakery.entity;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder


public class Items {
	
	//describes the variables within the items table
	
	private int itemId;
	private Item_name itemName;
	private BigDecimal itemPrice;
	
	
	
	

}
