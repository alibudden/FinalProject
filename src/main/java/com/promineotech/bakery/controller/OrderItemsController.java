package com.promineotech.bakery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.bakery.entity.Items;
import com.promineotech.bakery.entity.Orders_Items;
import com.promineotech.bakery.service.OrderItemsService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/ordersitems")
@OpenAPIDefinition(info = @Info(title = "Items Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface OrderItemsController {
	
	@Operation(
		summary = "Returns the list of orders with chosen bakery items",
		description = "Returns a list of orders with chosen bakery items",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A list of orders with chosen bakery items",
				content = @Content (
						mediaType = "application/json",
						schema = @Schema(implementation = Orders_Items.class))),
			@ApiResponse(
					responseCode = "400",
					description = "The request parameters are invalid",
					content = @Content (mediaType = "application/json")),
			@ApiResponse(
					responseCode = "404",
					description = "No orders and bakery items were found",
					content = @Content (mediaType = "application/json")),
			@ApiResponse(
					responseCode = "500",
					description = "An unplanned error occured.",
					content = @Content (mediaType = "application/json")),
		}
)	
	
	@GetMapping("/allorderitems")
	@ResponseStatus(code = HttpStatus.OK)
	List<Orders_Items> fetchAllOrdersAndItems();
	
	
}