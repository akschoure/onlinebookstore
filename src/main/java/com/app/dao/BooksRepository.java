package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Books;

public interface BooksRepository extends JpaRepository<Books, Integer> {

	 @Query("select b from Books b where b.category.categoryid=:categoryid")
	 List <Books> findByCategoryId (@Param("categoryid") int categoryid );
	 
	 
	 @Query("select b from Books b where b.author.authorid=:authorid")
	List <Books> findByAuthorId(@Param("authorid") int authorid);
	 
	 
	// List <Books> findByAuthorIdAndCategoryId (Integer authorId , Integer
	// categoryId);

	// List <Books> findByAuthorIdInAndCategoryIdIn (List<Integer> authorIdList ,
	// List<Integer> categoryIdList);
//
//	List<Books> findByCategoryIn(List<Integer> categoryIdList);
//
//////	  
//	List<Books> findByAuthorIn(List<Integer> authorIdList);
//	
//	@Query("select b from Books b where b.author.id=:tid and c.dealer.city.id=:cid and c.carStatus=false")
//	List<Car> findByCarTypeAndCity(@Param("tid") int tid,@Param("cid") int cid);
}
