package com.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.bean.Order;
import com.order.persistence.OrderDao;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order saveOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDao.save(order);
	}

	@Override
	public Order findOrderById(Long id) {
		// TODO Auto-generated method stub
		Optional<Order> order = orderDao.findById(id);
		if(order.isPresent()) {
			return order.get();
		}
		return new Order();
	}

}
