package com.order.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.bean.Order;
import com.order.bean.OrderItem;
import com.order.persistence.OrderDao;

@SpringBootTest
class OrderServiceApplicationTests {
	
	@Autowired
	private OrderDao orderDao;
	private List<OrderItem> items;
	
	private Order order;
	
	
	@Test
	public void save_order_T001() {

		OrderItem item1 = new OrderItem(1001l, 2001l, 100, 1000.0);
		OrderItem item2 = new OrderItem(1002l, 2002l, 200, 2000.0);	
		items = new ArrayList<>();
		items.addAll(Arrays.asList(item1, item2));
		
		order = new Order();
		order.setId(1003l);
		order.setCustomerEmail("ccc@mail.com");
		order.setCustomerAddress("C-address");
		assertEquals(order, orderDao.save(order));
	}
	
	
//	@Test
//	public void save_order_T002() {
//		
//		OrderItem item1 = new OrderItem(1001l, 2001l, 100, 1000.0);
//		OrderItem item2 = new OrderItem(1002l, 2002l, 200, 2000.0);	
//		items = new ArrayList<>();
//		items.addAll(Arrays.asList(item1, item2));
//		
//		order = new Order();
////		order.setId(1l);
////		order.setCustomerEmail(null);
////		order.setCustomerAddress(null);
//		assertEquals(null, orderDao.save(order));
//	}
	@Test
	public void find_Order_T001() {
		OrderItem item1 = new OrderItem(1001l, 2001l, 100, 1000.0);
		OrderItem item2 = new OrderItem(1002l, 2002l, 200, 2000.0);	
		items = new ArrayList<>();
//		items.addAll(Arrays.asList(item1, item2));
		
		order = new Order();
		order.setId(1002l);
		order.setCustomerEmail("bbb@mail.com");
		order.setCustomerAddress("B-address");
		order.setItems(items);
		assertEquals(order,orderDao.findById(1002l).get());
	}
	@Test
	public void find_Order_T002() {
		assertTrue(orderDao.findById(0000l).isEmpty());
	}
	

}
