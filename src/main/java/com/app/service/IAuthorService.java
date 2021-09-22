package com.app.service;

import java.util.List;

import com.app.pojos.Author;

public interface IAuthorService {
	
	List <Author> getAllAuthor();
	
	Author getAuthorDetails (int authorid);
	
	Author addAuthor (Author author);
	
	String deleteAuthor (int authorid);
	
	Author updateAuthor (Author detachAuthor);

}
