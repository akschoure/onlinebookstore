package com.app.controller;

import java.util.List;

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
import com.app.pojos.Author;
import com.app.service.AuthorServiceImpl;

@RestController
@RequestMapping("/author")
public class AuthorRestController {
	@Autowired
	public AuthorServiceImpl authorService;
	
	@GetMapping
	public List<Author> getAllAuthor()
	{
		return authorService.getAllAuthor();
	}

	//get author by id
	
	@GetMapping("/{authorid}")
	public ResponseEntity<?> getAuthorDetails(@PathVariable int authorid)
	{
		System.out.println("");
		try {
			return ResponseEntity.ok(authorService.getAuthorDetails(authorid));
			
		    } catch (RuntimeException e)
	  	     {
			   return new ResponseEntity<>(new ErrorResponse("Fetch author fail", e.getMessage()),HttpStatus.BAD_REQUEST);
	         }
		
	}
	
	
	@PostMapping
	public ResponseEntity<?> addAuthor( @RequestBody Author transientauthor)
	{
		System.out.println("");
		try {
			return new ResponseEntity<>(authorService.addAuthor(transientauthor),HttpStatus.CREATED);
			
		} catch (RuntimeException e) {
			
			return new ResponseEntity<>(new ErrorResponse("fail to add", e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{authorid}")
	public ResponseEntity<ResponseDTO> deleteAuthor(@PathVariable int authorid)
	{
		System.out.println("");
		
		return ResponseEntity.ok(new ResponseDTO(authorService.deleteAuthor(authorid)));
	}
	
	
	@PutMapping("/{authorid}")
	public ResponseEntity<?> updateAuthor(@RequestBody Author detachAuthor , @PathVariable int authorid)
	{
		System.out.println("");
		try {
			Author exstingAuthor = authorService.getAuthorDetails(authorid);
			return ResponseEntity.ok(authorService.updateAuthor(detachAuthor));
			
		} catch (RuntimeException e) {
			
			return new ResponseEntity<> (new ErrorResponse("Author update failed !!",e.getMessage()),HttpStatus.BAD_REQUEST);
			
		}
	}

}
