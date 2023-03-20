package com.promineotech.bakery.dao;

import java.math.BigDecimal;
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

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultItemsDao implements ItemsDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Items> fetchAllItems() {
		log.info("In items dao layer, fetch all bakery items");
		String sql = ""
			+ "SELECT * "
			+ "FROM items ";
		
		Map<String, Object> params = new HashMap<>();
		return jdbcTemplate.query(sql,  params, new RowMapper<Items>() {
			@Override
			public Items mapRow(ResultSet rs, int rowNum) throws SQLException {
				return Items.builder()
					.itemId(rs.getInt("item_id"))
					.itemName(Item_name.valueOf(rs.getString("item_name")))
					.itemPrice(rs.getBigDecimal("item_price"))
					.build();
			}});
		
	}
}
