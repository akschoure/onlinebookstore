package com.app.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.dto.ResponseDTO;
import com.app.pojos.Author;
import com.app.pojos.Category;
import com.app.service.ICategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryRestController {
	
	@Autowired
	public ICategoryService categoryService;
	
	
	//@GetMapping
	@GetMapping("/allCategory")
	public List<Category> getAllCategory()
	{
		return categoryService.getAllCategory();
	}
	
	
	@GetMapping("/{categoryid}")
	public ResponseEntity<?> getCategoryDetails(@PathVariable int categoryid)
	{
		try {
			return ResponseEntity.ok(categoryService.getCategoryDetails(categoryid));
		} catch (RuntimeException e) {
			
			return new ResponseEntity<>(new ErrorResponse("fetch category fail",e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping
	public ResponseEntity<?> addNewCategory( @RequestBody Category transientCategory)
	{
		try {
			return new ResponseEntity<>(categoryService.addNewCategory(transientCategory),HttpStatus.CREATED);
			
		} catch (RuntimeException e) {
			
			return new ResponseEntity<>(new ErrorResponse("fail to add category", e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{categoryid}")
	public ResponseEntity<ResponseDTO> deleteCategory(@PathVariable int categoryid)
	{

		return ResponseEntity.ok(new ResponseDTO(categoryService.deleteCategory(categoryid)));
	}
	
	
	@PutMapping("/{categoryid}")
	public ResponseEntity<?> updateCategory(@RequestBody Category detachCategory , @PathVariable int categoryid)
	{
		
		try {
			Category existingCategory = categoryService.getCategoryDetails(categoryid);
			return ResponseEntity.ok(categoryService.updateCategory(detachCategory));
			
		} catch (RuntimeException e) {
			
			return new ResponseEntity<> (new ErrorResponse("Category update failed !!",e.getMessage()),HttpStatus.BAD_REQUEST);
			
		}
	}


}