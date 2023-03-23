package com.promineotech.bakery.dao;

import java.util.List;
import java.util.Optional;

import com.promineotech.bakery.entity.Customer;

public interface CustomerDao {
	
	//Method to list all customers from the customer table
	List<Customer> fetchAllCustomers();
		
	
//method to create a new customer into the customer table
	Customer createCustomer(String firstName, String lastName, String phone);
	
//method to update an existing customer in the customer table
Customer updateCustomer(int customerId, Customer updatedCustomer);


//method to delete a customer from the customer table
void deleteCustomer(int customerId);











}





