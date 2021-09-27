package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BooksRepository;
import com.app.pojos.Books;

@Service
@Transactional
public class BooksServiceImpl implements IBooksService {

	@Autowired
	private BooksRepository booksRepo;
	@Override
	public List<Books> getAllBooks() {
		
		return booksRepo.findAll();
	}
	
	
	@Override
	public Books getBookDetails(int bookid) {
		return booksRepo.findById(bookid).orElseThrow();
	}


	@Override
	public Books addBook(Books transientBook) {
		return booksRepo.save(transientBook);
	}


	@Override
	public String deleteBook(int bookid) {
		booksRepo.deleteById(bookid);
		return "Books details deleted for id"+bookid;
	}


	@Override
	public Books updateBook(Books detachedBook) {
		
		return booksRepo.save(detachedBook);
	}



    

}
