package com.app.controller;

import java.util.List;


import com.app.service.IBooksService;
import com.app.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.app.pojos.Books;


@RestController
@RequestMapping("/books")
public class BooksRestController { 
	@Autowired
	private IBooksService booksService;
	
//fetching all books
	
	@GetMapping
	public List<Books> fetchAllBooks()
	{
		System.out.println(" in fetch api ");
		return booksService.getAllBooks();
	}
	
//get book by using id 
	
	@GetMapping("/{bookid}")
	public ResponseEntity<?> getBookDetails(@PathVariable int bookid)
	{
		System.out.println("in getBookDetails" +bookid);
	
	try {
		return ResponseEntity.ok(booksService.getBookDetails(bookid));
	
	}
	catch(RuntimeException e)
	{
		return new ResponseEntity<>(new ErrorResponse ("fetch user failed",e.getMessage()),HttpStatus.BAD_REQUEST);
	}
}
	
//add new book*****************************
	
	@PostMapping
	public ResponseEntity <?> addNewBook (@RequestBody Books transientUser)
	{
		System.out.println(" ");
		try {
			return new ResponseEntity<>(booksService.addBook(transientUser),HttpStatus.CREATED);
		}
		catch(RuntimeException e)
		{
			return new ResponseEntity<>(new ErrorResponse ("Adding Book Failed !!" , e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//delete book by id
	
	@DeleteMapping("/{bookid}")
	public ResponseEntity <ResponseDTO> deleteBookDetails (@PathVariable int bookid)
	{
		System.out.println("");
		
		return ResponseEntity.ok(new ResponseDTO(booksService.deleteBook(bookid)));
	}

//update book by id
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBookDetails(@RequestBody Books detachedBook , @PathVariable int bookid)
	{
		System.out.println("");
		try {
			Books existingBook = booksService.getBookDetails(bookid);
			return ResponseEntity.ok(booksService.updateBook(detachedBook));		
		}
		catch(RuntimeException e)
		{
			System.out.println("");
			return new ResponseEntity<> (new ErrorResponse("Updating Books Details failed" ,e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	//get book by using id 
	
		
}
