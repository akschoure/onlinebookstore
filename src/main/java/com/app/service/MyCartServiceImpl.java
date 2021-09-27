package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.MyCartRepository;
import com.app.pojos.Mycart;

@Service
@Transactional
public class MyCartServiceImpl implements IMyCartService {

	@Autowired
	public MyCartRepository myCartRepo;
	
	@Override
	public List<Mycart> getAllMycart() {
		return myCartRepo.findAll();
	}

	
	@Override
	public Mycart getMycartDetails(int cartid) {
		return myCartRepo.findById(cartid).orElseThrow();
	}

	
	@Override
	public Mycart addMycart(Mycart mycart) {
		return myCartRepo.save(mycart);
	}

	
	@Override
	public String deleteMycart(int cartid) {
		myCartRepo.deleteById(cartid);
		return "cart item deleted "+cartid;
	}

	@Override
	public Mycart updateMycart(Mycart detachMycart) {
		
		return  myCartRepo.save(detachMycart);
	}

}
