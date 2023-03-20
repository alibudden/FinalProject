package com.promineotech.bakery.dao;

import java.util.List;

import com.promineotech.bakery.entity.Customer;

public interface CustomerDao {
	
	List<Customer> fetchAllCustomers();
		
	

	Customer createCustomer(String firstName, String lastName, String phone);
	

	Customer updateCustomer(int customerId, Customer updatedCustomer);



void deleteCustomer(int deleteId);






}





