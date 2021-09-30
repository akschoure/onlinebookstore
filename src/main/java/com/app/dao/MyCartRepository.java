package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Mycart;

public interface MyCartRepository extends JpaRepository<Mycart, Integer> {
	Mycart findByUserUseridAndBooksBookid(int userId, int bookId);
	
//	@Query("select c from Mycart c where c.userid=:uid")
	
	
	List<Mycart> findByUserUserid(int userid);
}

