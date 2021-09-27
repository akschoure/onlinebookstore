package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	User  findByEmailidAndPassword(String emailid , String password);

}
