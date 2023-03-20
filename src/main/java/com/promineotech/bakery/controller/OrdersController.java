package com.promineotech.bakery.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.bakery.entity.Orders;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/orders")
@OpenAPIDefinition(info = @Info(title = "Orders List"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface OrdersController {
	
	@Operation(
		summary = "Returns the list of orders",
		description = "Returns a list of orders",
		responses = {
			@ApiResponse(
				responseCode = "200",
				description = "A list of orders",
				content = @Content (
						mediaType = "application/json",
						schema = @Schema(implementation = Orders.class))),
			@ApiResponse(
					responseCode = "400",
					description = "The request parameters are invalid",
					content = @Content (mediaType = "application/json")),
			@ApiResponse(
					responseCode = "404",
					description = "No orders were found",
					content = @Content (mediaType = "application/json")),
			@ApiResponse(
					responseCode = "500",
					description = "An unplanned error occured.",
					content = @Content (mediaType = "application/json")),

		}
)	
	
	@GetMapping("/allorders")
	@ResponseStatus(code = HttpStatus.OK)
	List<Orders> fetchAllOrders(
			);
}
