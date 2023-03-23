package com.promineotech.bakery.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.bakery.entity.Customer;
import com.promineotech.bakery.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCustomerController implements CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//READ (GET)

	@Override
	public List<Customer> fetchAllCustomers() {
		return customerService.fetchAllCustomers();
	}

	//CREATE (POST)
	@Override
	public Customer createCustomer(String firstName, String lastName, String phone) {
		return customerService.createCustomer(firstName, lastName, phone);
	}

	//UPDATE (PUT)

	@Override
	public Customer updateCustomer(int customerId, @Valid Customer updatedCustomer) {
		return customerService.updateCustomer(customerId, updatedCustomer);

	}

	//DELETE
	@Override
	public void deleteCustomer(int customerId) {
		log.debug("customerId={}", customerId);
		customerService.deleteCustomer(customerId);

	}

}
