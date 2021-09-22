package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ReviewRepository;
import com.app.pojos.Review;

@Service
@Transactional
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	public ReviewRepository reviewRepo;
	
	@Override
	public List<Review> getAllReview() {
		
		return reviewRepo.findAll() ;
	}

	@Override
	public Review getReviewDetails(int reviewid) {
		return reviewRepo.findById(reviewid).orElseThrow();   //use exception
	}

	@Override
	public Review addReview(Review review) {
		return reviewRepo.save(review);
	}

	@Override
	public String deleteReview(int reviewid) {
		reviewRepo.deleteById(reviewid);
		return "review deleted for id "+reviewid;
	}

	@Override
	public Review updateReview(Review detachreview) {
		return reviewRepo.save(detachreview);
	}

}
