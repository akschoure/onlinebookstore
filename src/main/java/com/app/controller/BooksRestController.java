package com.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.app.service.IBooksService;

import lombok.NoArgsConstructor;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.BooksRepository;
import com.app.dto.ErrorResponse;
import com.app.dto.ResponseDTO;
import com.app.pojos.Books;


@RestController
@RequestMapping("/books")
public class BooksRestController { 
	@Autowired
	private IBooksService booksService;
	@Autowired
	private BooksRepository booksRepo;
	
	
//fetching all books
	

	
	//@GetMapping
//	
//	public List<Books> fetchAllBooks(@RequestParam Integer authorid , @RequestParam  Integer categoryid)
//	{
//		// 2. receive author id and category id and get books for author and category id
//		System.out.println(" in fetch api authorid " + authorid+categoryid);
//		return booksRepo.findByAuthorIdAndCategoryId(authorid, categoryid);
//	}
//	
	
//	public List<Books> fetchAllBooks(@RequestParam Integer authorid , @RequestParam  Integer categoryid)
//	{
//	// 2. receive author id and category id and get books for author and category id
//		//System.out.println(" in fetch api authorid " + authorid+categoryid);
//		List<Integer> authorIdList=new ArrayList();
//		authorIdList.add(1);
//		List<Integer> categoryIdList=new ArrayList();
//		categoryIdList.add(1);
//		// 
//	return booksRepo.findByAuthorIdInAndCategoryIdIn(authorIdList, categoryIdList);
//	
//	}
//	
	//to get books by
	
	
//	public List<Books> fetchAllBooks(@RequestParam String authorIds , @RequestParam  String categoryIds)
//	{
//		
//		List<Integer> authorIdList=new ArrayList<Integer>();
//		for (String s :authorIds.split(",") ) {
//			 authorIdList.add(Integer.parseInt(s.trim()));
//		}
//		
//		List<Integer> categoryIdList=new ArrayList<Integer>();
//		for (String s :categoryIds.split(",") ) {
//			categoryIdList.add(Integer.parseInt(s.trim()));
//		}
//	return booksRepo.findByAuthorIdInAndCategoryIdIn(authorIdList, categoryIdList);
//	
//	}
	
//	@GetMapping
//	public List<Books> fetchBooksByCategoryId (@RequestParam String authorIds , @RequestBody String categoryIds)
//	{
//		if(authorIds==null)
//		{
//		List <Integer> categoryIdList = new ArrayList<Integer>();
//		for (String s :categoryIds.split(",") ) {
//			categoryIdList.add(Integer.parseInt(s.trim()));
//			
//			
//		}
//		return booksRepo.findByCategoryIdIn(categoryIdList);
//				
//	}
//		
//		return null;
//		
//	}
//	
//	
//	@GetMapping
//	public List<Books> findByAuthorIdIn (@RequestBody String authorIds)
//	{
//		//if(categoryIds==null)
//		{
//		List <Integer> authorIdList = new ArrayList<Integer>();
//		for (String s :authorIds.split(",") ) {
//			authorIdList.add(Integer.parseInt(s.trim()));
//		}
//	
//		return booksRepo.findByAuthorIdIn(authorIdList);		
//}
	//return null;
//	}
	
	
	@GetMapping
	public List<Books> fetchAllBooks(@RequestParam(required=false) String authorIds , @RequestParam(required=false)  String categoryIds)
	{
		if(authorIds==null)
			
		{
	     	List <Integer> categoryIdList = new ArrayList<Integer>();
	    	for (String s :categoryIds.split(",") ) {
			categoryIdList.add(Integer.parseInt(s.trim()));		
		}
	    	return booksRepo.findByCategoryIdIn(categoryIdList);			
	}
		
		else if (categoryIds==null)
			
		{
		   List <Integer> authorIdList = new ArrayList<Integer>();
	    	for (String s :authorIds.split(",") ) {
			authorIdList.add(Integer.parseInt(s.trim()));
		}
		return booksRepo.findByAuthorIdIn(authorIdList);		
	}
		
		else
			
		{
			List<Integer> authorIdList=new ArrayList<Integer>();
			for (String s :authorIds.split(",") ) {
				 authorIdList.add(Integer.parseInt(s.trim()));
			}
			
			List<Integer> categoryIdList=new ArrayList<Integer>();
			for (String s :categoryIds.split(",") ) {
				categoryIdList.add(Integer.parseInt(s.trim()));
			}
			return booksRepo.findByAuthorIdInAndCategoryIdIn(authorIdList, categoryIdList);
		}
			
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
		return new ResponseEntity<>(new ErrorResponse ("fetch book failed",e.getMessage()),HttpStatus.BAD_REQUEST);
	}
}
	
	
//add new book
	
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
			return new ResponseEntity<> (new ErrorResponse("Updating Books Details failed" ,e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	

	
	
	
		
}
