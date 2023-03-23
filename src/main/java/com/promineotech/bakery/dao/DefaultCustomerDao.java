package com.promineotech.bakery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.promineotech.bakery.entity.Customer;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCustomerDao implements CustomerDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	//Get method to read the entire list of customers from the Bakery database
	@Override
	public List<Customer> fetchAllCustomers() {
		String sql = ""
				+ "SELECT * "
				+ "FROM customers ";
			
			Map<String, Object> params = new HashMap<>();
		
			
			return jdbcTemplate.query(sql, params, new RowMapper<>() {
			
	@Override
	//this method maps the columns name to the variables in the customer table
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Customer.builder()
				.customerId(rs.getInt("customer_id"))
				.firstName(rs.getString("first_name"))
				.lastName(rs.getString("last_name"))
				.phone(rs.getString("phone"))
				.build();
		}});
	}
	@Override
	
	//create method to create new customer in the database
	public Customer createCustomer(String firstName, String lastName, String phone) {
		SqlParams params = new SqlParams();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		params.sql = ""
			+ "INSERT into customers "
			+ "(first_name, last_name, phone) "
			+ "VALUES (:first_name, :last_name, :phone)";
		params.source.addValue("first_name", firstName);
		params.source.addValue("last_name", lastName);
		params.source.addValue("phone", phone);
		
		jdbcTemplate.update(params.sql, params.source, keyHolder);
		return Customer.builder()
				.customerId(keyHolder.getKey().intValue())
				.firstName(firstName)
				.lastName(lastName)
				.phone(phone)
				.build();
	}
	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}


	@Override
	
	//method to update existing customer in database
	public Customer updateCustomer(int customerId, Customer updatedCustomer) {
		String sql = ""
				+ "UPDATE customers "
				+ "SET "
				+ "first_name = :first_name, "
				+ "last_name = :last_name, "
				+ "phone = :phone "
				+ "WHERE customer_id = :customer_id; ";
			
			Map<String, Object> params = new HashMap<>();
			params.put("first_name", updatedCustomer.getFirstName());
			params.put("last_name", updatedCustomer.getLastName());
			params.put("phone", updatedCustomer.getPhone());
			params.put("customer_id", customerId);
			
			if (jdbcTemplate.update(sql,params) == 0) {
				throw new NoSuchElementException("failed to update customer");
			}
			
			return Customer.builder()
				.customerId(customerId)
				.firstName(updatedCustomer.getFirstName())
				.lastName(updatedCustomer.getLastName())
				.phone(updatedCustomer.getPhone())
				.build();
		}
	
		

	@Override
	public void deleteCustomer(int deleteId) {
		String sql = ""
				+ "DELETE FROM customers "
				+ "WHERE customer_id = :customer_id;";
			
			Map<String, Object> params = new HashMap<>();
			
			params.put("customer_id", deleteId);
			if (jdbcTemplate.update(sql, params) == 0) throw new NoSuchElementException();
	
	}

}


