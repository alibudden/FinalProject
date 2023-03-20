package com.promineotech.bakery.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder



public class Customer {
	
	//describes the variables within the customer table
	
	private int customerId;
	private String firstName;
	private String lastName;
	private String phone;
	

	

}
