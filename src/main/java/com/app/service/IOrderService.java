package com.app.service;

import java.util.List;

import com.app.pojos.Order;

public interface IOrderService {
	

		List<Order> getAllOrder ();
		
		Order getOrderDetails (int id);
		
		Order addOrder (Order order);
		
		String deleteOrder (int id);
		
		Order updateBook (Order detachedOrder);

}
