package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CategoryRepository;
import com.app.pojos.Category;


@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	public CategoryRepository categoryRepo;

	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepo.findAll();
	}

	@Override
	public Category getCategoryDetails(int categoyid) {
		return categoryRepo.findById(categoyid).orElseThrow();
	}

	@Override
	public Category addNewCategory(Category transientCategory) {
		return categoryRepo.save(transientCategory);
	}

	@Override
	public String deleteCategory(int categoryid) {
		categoryRepo.deleteById(categoryid);
		return "Category delete successfull for id"+categoryid;
	}

	@Override
	public Category updateCategory(Category detachedCategory) {
		return categoryRepo.save(detachedCategory);
	}

}
