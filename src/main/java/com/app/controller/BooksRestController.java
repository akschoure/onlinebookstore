package com.app.controller;

import java.util.List;


import com.app.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.pojos.Books;


@RestController
@RequestMapping("/books")
public class BooksRestController {
	@Autowired
	private IBooksService booksService;
	
	@GetMapping
	public List<Books> fetchAllBooks()
	{
		System.out.println(" in fetch");
		return booksService.getAllBooks();
	}
	
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
	
	@PostMapping
	public ResponseEntity <?> addNewBook (@RequestBody Books transientUser)
	{
		System.out.println(" ");
		try {
			return new ResponseEntity<>(booksService.addBook(transientUser),HttpStatus.CREATED);
		}
		catch(RuntimeException e)
		{
			
		}
	}
}
