package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>
{
	 

}
