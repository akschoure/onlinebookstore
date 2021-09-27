package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.OrderRepository;
import com.app.pojos.Order;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	public OrderRepository orderRepo;
	
	@Override
	public List<Order> getAllOrder() {
		return orderRepo.findAll();
	}

	
	@Override
	public Order getOrderDetails(int id) {
		return orderRepo.findById(id).orElseThrow();
	}
	
	
	@Override
	public Order addOrder(Order order) {
		return orderRepo.save(order);
	}

	
	@Override
	public String deleteOrder(int id) {
		orderRepo.deleteById(id);
		return "Order details deleted for id"+id;
	}

	
	@Override
	public Order updateBook(Order detachedOrder) {
		return orderRepo.save(detachedOrder);
	}

}
