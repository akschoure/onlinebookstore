package com.app.service;

import java.util.List;

import com.app.pojos.Mycart;

public interface IMyCartService {
	
    List <Mycart> getAllMycart();
	
    Mycart getMycartDetails (int cartid);
	
    Mycart addMycart (Mycart mycart);
	
	String deleteMycart (int cartid);
	
	Mycart updateMycart (Mycart detachMycart);

	Mycart cartByUserIdAndBookId(int userId, int bookId);
	
	List<Mycart> cartByUserId(int userId);
}
