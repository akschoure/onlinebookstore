package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AuthorRepository;
import com.app.pojos.Author;


@Service
@Transactional
public class AuthorServiceImpl implements IAuthorService {
	
	@Autowired
	public AuthorRepository authorRepo;

	
	@Override
	public List<Author> getAllAuthor() {
		return authorRepo.findAll();
	}

	
	@Override
	public Author getAuthorDetails(int authorid) {
		return authorRepo.findById(authorid).orElseThrow();
	}

	
	@Override
	public Author addAuthor(Author author) {
		return authorRepo.save(author);
	}

	
	@Override
	public String deleteAuthor(int authorid) {
		authorRepo.deleteById(authorid);
		return "author deleted "+authorid;
	}

	
	@Override
	public Author updateAuthor(Author detachAuthor) {
		return authorRepo.save(detachAuthor);
	}
	
	

}
