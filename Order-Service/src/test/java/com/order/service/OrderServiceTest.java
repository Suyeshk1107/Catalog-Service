package com.order.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.order.bean.Order;
import com.order.bean.OrderItem;
import com.order.persistence.OrderDao;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderServiceTest {
	private List<OrderItem> items;
	
	private Order order;
	
	@InjectMocks
	@Autowired
	private OrderServiceImpl orderService;
	
	@Mock
	private OrderDao orderDao;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void save_Order_T001() {
		OrderItem item1 = new OrderItem(1001l, 2001l, 100, 1000.0);
		OrderItem item2 = new OrderItem(1002l, 2002l, 200, 2000.0);	
		items = new ArrayList<>();
		items.addAll(Arrays.asList(item1, item2));		
		order = new Order();
		order.setId(1001l);
		order.setCustomerEmail("aaa@mail.com");
		order.setCustomerAddress("A-address");
		order.setItems(items);
		
		Mockito.when(orderDao.save(order)).thenReturn(order);
		assertEquals(order, orderService.saveOrder(order));
	}
	@Test
	void save_Order_T002() {
		Mockito.when(orderDao.save(null)).thenReturn(null);
		assertEquals(null, orderService.saveOrder(null));
		
	}

	@Test
	void find_Order_T001() {
		order = new Order();
		order.setId(1001l);
		order.setCustomerEmail("aaa@mail.com");
		order.setCustomerAddress("A-address");
		order.setItems(items);
		Mockito.when(orderDao.findById(1001l)).thenReturn(Optional.of(order));
		assertEquals(order,orderService.findOrderById(1001l));
	}
	@Test
	void find_Order_T002() {
		order = new Order();
		Mockito.when(orderDao.findById(1l)).thenReturn(Optional.empty());
		assertEquals(order,orderService.findOrderById(1l));
	}

}
