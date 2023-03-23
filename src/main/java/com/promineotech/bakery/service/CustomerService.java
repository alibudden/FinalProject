package com.promineotech.bakery.service;

import java.util.List;
import java.util.Optional;

import com.promineotech.bakery.entity.Customer;

public interface CustomerService {

	
	//this class takes from the default controller and then gets handed off to the default service class

	
	//READ
	List<Customer> fetchAllCustomers();
	

//DELETE

	void deleteCustomer(int customerId);

//CREATE

	Customer createCustomer(String firstName, String lastName, String phone);


//UPDATE

	 Customer updateCustomer(int customerId, Customer updatedCustomer);
}
