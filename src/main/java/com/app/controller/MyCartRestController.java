package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.dto.ResponseDTO;
import com.app.pojos.Mycart;
import com.app.service.BooksServiceImpl;
import com.app.service.MyCartServiceImpl;
import com.app.service.UserServiceImpl;



@RestController
@RequestMapping("/mycart")
@CrossOrigin

public class MyCartRestController {

	@Autowired
	public MyCartServiceImpl myCartService;
	@Autowired
	public UserServiceImpl userService;
	@Autowired
	public BooksServiceImpl bookService;
	@GetMapping
	//@GetMapping("/allcart")
	public List<Mycart> getAllMycart() {
		return myCartService.getAllMycart();
	}

	// get cart by id

	@GetMapping("/{cartid}")
	public ResponseEntity<?> getMycartDetails(@PathVariable int cartid) {

		try {
			return ResponseEntity.ok(myCartService.getMycartDetails(cartid));

		} catch (RuntimeException e) {
			return new ResponseEntity<>(new ErrorResponse("Fetch cart fail", e.getMessage()), HttpStatus.BAD_REQUEST);
		}

	}
	
	
	
	@GetMapping("/byuserid/{userid}")
	public ResponseEntity<?> getMycartDetailsByUserId(@PathVariable int userid) {
			System.out.println("in cart by user id "+userid);
		try {
			return ResponseEntity.ok(myCartService.cartByUserId(userid));

		} catch (RuntimeException e) {
			return new ResponseEntity<>(new ErrorResponse("Fetch cart fail", e.getMessage()), HttpStatus.BAD_REQUEST);
		}

	}

	
	@PostMapping("/addcart/{uid}/{bid}")
	public ResponseEntity<?> addMycart(@PathVariable int uid, @PathVariable int bid) {
		System.out.println("In book add");
		
		Mycart cart = myCartService.cartByUserIdAndBookId(uid, bid);
		System.out.println(cart);
		if (cart != null) {
			cart.setQuantity(cart.getQuantity() + 1);
			return new ResponseEntity<>(myCartService.updateMycart(cart), HttpStatus.CREATED);
		} else {
			Mycart mycart=new Mycart();
			mycart.setUser(userService.getUserDetails(uid));
			mycart.setBooks(bookService.getBookDetails(bid));
			mycart.setQuantity(1);
			try {
				return new ResponseEntity<>(myCartService.addMycart(mycart), HttpStatus.CREATED);

			} catch (RuntimeException e) {

				return new ResponseEntity<>(new ErrorResponse("fail to add to MyCart", e.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}
	
  // @DeleteMapping("/{cartid}")
	@DeleteMapping("/removecart/{cartid}")
	public ResponseEntity<ResponseDTO> deleteAuthor(@PathVariable int cartid) {

		return ResponseEntity.ok(new ResponseDTO(myCartService.deleteMycart(cartid)));
	}

	// ***

	@PutMapping("/{cartid}")
	public ResponseEntity<?> updateMyEntity(@RequestBody Mycart detachAuthor, @PathVariable int cartid) {

		try {
			Mycart exstingAuthor = myCartService.getMycartDetails(cartid);
			return ResponseEntity.ok(myCartService.updateMycart(detachAuthor));

		} catch (RuntimeException e) {

			return new ResponseEntity<>(new ErrorResponse("Author update failed !!", e.getMessage()),
					HttpStatus.BAD_REQUEST);

		}
	}

}


