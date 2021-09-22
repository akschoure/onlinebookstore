package com.app.service;

import java.util.List;

import com.app.pojos.Review;

public interface IReviewService {

	
	List<Review> getAllReview();
	
	Review getReviewDetails(int reviewid);

	Review addReview(Review review);
	
	String deleteReview(int reviewid);

	Review updateReview(Review detachedreview);
}
