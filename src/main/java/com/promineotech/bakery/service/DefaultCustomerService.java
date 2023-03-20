package com.promineotech.bakery.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.bakery.dao.CustomerDao;
import com.promineotech.bakery.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCustomerService implements CustomerService {
	
	//creates an object in the dao layer
	@Autowired
	private CustomerDao customerDao;
	

	@Override
	public List<Customer> fetchAllCustomers() {
		List<Customer> customer = customerDao.fetchAllCustomers();
		if(customer.isEmpty()) {
			String msg = String.format("There are no customers :(");
			throw new NoSuchElementException(msg);
		}
		return customer;
				
	}

	@Override
	public Customer createCustomer(String firstName, String lastName, String phone) {
		log.info("creates customers in the service layer");
		return customerDao.createCustomer(firstName, lastName, phone);
	}

	@Override
	public Customer updateCustomer(int customerId, Customer updatedCustomer) {
		log.info("updates customers in service layer");
		return customerDao.updateCustomer(customerId, updatedCustomer);
	}

	@Override
	public void deleteCustomer(int deleteId) {
		log.info("The deleteCustomer method was called with customerId={}", deleteId);
		
		customerDao.deleteCustomer(deleteId);
	}

	

}
