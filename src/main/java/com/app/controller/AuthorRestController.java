package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
	

}
