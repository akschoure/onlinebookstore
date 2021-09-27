package com.app.controller;

import java.util.List;

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
import com.app.pojos.Order;
import com.app.service.OrderServiceImpl;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderRestController {
	@Autowired
	public OrderServiceImpl orderService;
	
	
	
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

	

	@PostMapping
	public ResponseEntity <?> addNewOrder (@RequestBody Order transientOrder)
	{
		System.out.println(" ");
		try {
			return new ResponseEntity<>(orderService.addOrder(transientOrder),HttpStatus.CREATED);
		}
		catch(RuntimeException e)
		{
			return new ResponseEntity<>(new ErrorResponse ("Adding Book Failed !!" , e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	
}

