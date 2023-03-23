package com.promineotech.bakery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.bakery.entity.Item_name;
import com.promineotech.bakery.entity.Items;
import com.promineotech.bakery.entity.Orders_Items;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultOrderItemsDao implements OrderItemsDao {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	//method to list all orders and bakery items together in one table.
	public List<Orders_Items> fetchAllOrdersAndItems() {
		String sql = ""
				+ "SELECT * "
				+ "FROM order_items ";
		
	
		Map<String, Object> params = new HashMap<>();
		return jdbcTemplate.query(sql,  params, new RowMapper<>() {
			@Override
			
		public Orders_Items mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Orders_Items.builder()
				.order_id(rs.getInt("order_id"))
				.item_id(rs.getInt("item_id"))				
				.quantity(rs.getString("quantity"))
				.build();
							
			}
		});

	}
	}
