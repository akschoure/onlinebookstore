package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.pojos.Books;
import com.app.pojos.Mycart;
import com.app.pojos.Order;
import com.app.service.MyCartServiceImpl;
import com.app.service.OrderServiceImpl;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderRestController {
	@Autowired
	public OrderServiceImpl orderService;
	
	@Autowired
	public MyCartServiceImpl mycartService;
	
	
	//@GetMapping
	@GetMapping("/allorder")
	public List<Order> getAllOrder()
	{
		return orderService.getAllOrder();
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrderDetails(@PathVariable int id)
	{
		  System.out.println("in getOrderid" +id);
	
	  try {
	    	return ResponseEntity.ok(orderService.getOrderDetails(id));
	
	  }
	    catch(RuntimeException e)
	  {
		return new ResponseEntity<>(new ErrorResponse ("fetch order failed",e.getMessage()),HttpStatus.BAD_REQUEST);
	  }
  }

	
//	
//
//	@PostMapping("/order/{id}")
//	public ResponseEntity <?> addNewOrder (@PathVariable int id)
//	{
//		System.out.println(" ");
////		List<Order> order=new ArrayList<Order>();
////		Random r=new Random();
////		int orderId=r.nextInt(999999);
////		for(Mycart c:mycartService.cartByUserId(id))
////		{
////			order.add(new Order(orderId,c.getQuantity(),id,c.getBooks().getBookid()));
////			mycar}
//		try {
//			return new ResponseEntity<>(orderService.addOrder(order),HttpStatus.CREATED);
//		}
//		catch(RuntimeException e)
//		{
//			return new ResponseEntity<>(new ErrorResponse ("Adding Book Failed !!" , e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

	
	
}

