package com.promineotech.bakery.controller;

import java.util.List;

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

	@Override
	public List<Customer> fetchAllCustomers() {
		return customerService.fetchAllCustomers();
	}

	@Override
	public Customer createCustomer(String firstName, String lastName, String phone) {
		return customerService.createCustomer(firstName, lastName, phone);
	}

	@Override
	public Customer updateCustomer(int customerId, @Valid Customer updatedCustomer) {
		return customerService.updateCustomer(customerId, updatedCustomer);
	}

	@Override
	public void deleteCustomer(int deleteId) {
		log.debug("customerId={}", deleteId);
		customerService.deleteCustomer(deleteId);

	}

}
