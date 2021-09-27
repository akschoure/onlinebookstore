package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Mycart;

public interface MyCartRepository extends JpaRepository<Mycart, Integer> {

}
