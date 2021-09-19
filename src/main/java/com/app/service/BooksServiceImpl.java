package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BooksRepository;
import com.app.pojos.Books;

@Service
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
	public Books addBook(Books book) {
		// TODO Auto-generated method stub
		return booksRepo.save(book);
	}
	


}
