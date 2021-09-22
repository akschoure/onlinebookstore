package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.app.pojos.Review;
import com.app.service.IReviewService;

@RestController
@RequestMapping("/review")
public class ReviewRestController {
	
	@Autowired
	public IReviewService reviewService;
	
	@GetMapping
	public List<Review> getAllReview()
	{
		System.out.println(" in fetch api ");
		return reviewService.getAllReview();
	}
	
	@GetMapping("/{reviewid}")
	public ResponseEntity<?> getReviewDetails(@PathVariable int reviewid)
	{
		System.out.println("");
		try {
			return ResponseEntity.ok(reviewService.getReviewDetails(reviewid));
			
		} catch (RuntimeException e) {
			return new ResponseEntity<> (new ErrorResponse("fail to get by id",e.getMessage() ),HttpStatus.BAD_REQUEST);
		}
	}

	
	@PostMapping
	public ResponseEntity<?> addAuthor (@RequestBody Review transientReview)
	{
		System.out.println("");
		try {
			
			return new ResponseEntity<> (reviewService.addReview(transientReview),HttpStatus.CREATED);
			
		} catch (RuntimeException e) {
			
			return new ResponseEntity<> (new ErrorResponse("Review added fail!!",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@DeleteMapping("/{reviewid}")
	public ResponseEntity<ResponseDTO> deleteReview(@PathVariable int reviewid)
	{
		System.out.println("");
		return ResponseEntity.ok(new ResponseDTO(reviewService.deleteReview(reviewid)));
	}
	
	
	@PutMapping("/{reviewid}")
	public ResponseEntity<?> updateRiview(@RequestBody Review detachedReview, @PathVariable int reviewid)
	{
		try {
			System.out.println("in update");
			Review existingReview = reviewService.getReviewDetails(reviewid);
			return ResponseEntity.ok(reviewService.updateReview(detachedReview));
			
		} catch (RuntimeException e) {
			
			return new ResponseEntity<>(new ErrorResponse("update review fail!!", e.getMessage()),HttpStatus.BAD_REQUEST);
					
		}
		
	}
}
