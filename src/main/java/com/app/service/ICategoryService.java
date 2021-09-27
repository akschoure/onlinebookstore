package com.app.service;

import java.util.List;

import com.app.pojos.Category;

public interface ICategoryService {
	

   List<Category> getAllCategory();
   
   Category getCategoryDetails (int categoyid);
   
   Category addNewCategory(Category transientCategory);
   
   String deleteCategory (int categoryid);
   
   Category updateCategory (Category detachedCategory);
   
	
}
