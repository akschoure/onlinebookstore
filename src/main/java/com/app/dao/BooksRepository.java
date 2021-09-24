package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.pojos.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> 
{
    //  List <Books> findByAuthorIdAndCategoryId (Integer authorId , Integer  categoryId);
      
      List <Books> findByAuthorIdInAndCategoryIdIn (List<Integer> authorIdList , List<Integer> categoryIdList);

	// List <Books> findByCategoryIdIn (List <Integer> categoryIdList );
	  
	//  List <Books> findByAuthorIdIn (List <Integer> authorIdList );
}
