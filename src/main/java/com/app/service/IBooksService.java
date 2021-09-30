package com.app.service;

import java.util.List;

import com.app.pojos.Books;

public interface IBooksService {

	List<Books> getAllBooksByCatId (int categoryid);
	
	List<Books> getAllBooksByAuthId (int authorid);
	
	List<Books> getAllBooks ();
	
	Books getBookDetails (int bookid);
	
	Books addBook (Books transientBook);
	
	String deleteBook (int bookid);
	
	Books updateBook (Books detachedBook);
	
   //List <Books> findByAuthorIdandCategoryId(int authorid , int categoryid);

}
