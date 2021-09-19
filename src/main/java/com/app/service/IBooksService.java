package com.app.service;

import java.util.List;

import com.app.pojos.Books;

public interface IBooksService {

	List<Books> getAllBooks ();
	
	Books getBookDetails (int bookid);
	
	Books addBook (Books book);
}
