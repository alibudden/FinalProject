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

import com.promineotech.bakery.entity.Orders;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultOrdersDao implements OrdersDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Orders> fetchAllOrders() {
		log.info("In orders dao layer, fetch all orders:");
		
	String sql = ""
		+ "SELECT * "
		+ "FROM orders ";
	
	Map<String, Object> params = new HashMap<>();
	return jdbcTemplate.query(sql,  params, new RowMapper<Orders>() {
		@Override
		public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
			return Orders.builder()
				.order_id(rs.getInt("order_id"))
				.customer_id(rs.getInt("customer_id"))
				.order_date(rs.getDate("order_date"))
				.build();
		}
	});

}
}
