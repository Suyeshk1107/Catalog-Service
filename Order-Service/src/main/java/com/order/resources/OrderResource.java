package com.order.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.order.service.OrderService;

@RestController
public class OrderResource {
	@Autowired
	private OrderService orderService;
	

}
