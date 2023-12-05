package com.ticket.market.service.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.market.store.jpa.jpo.Review;
import com.ticket.market.store.jpa.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public boolean createReview(Review review) {
		return  reviewRepository.save(review) !=null?true:false;
	}

	@Override
	public List<Review> findByMovieId(String movieId) {
		return reviewRepository.findByMovieId(movieId);
	}

	@Override
	public boolean modifyReview(Review review) {
		return reviewRepository.save(review) !=null?true:false;
	}

	@Override
	public void delReview(long reviewId) {
		reviewRepository.deleteById(reviewId);
	}

	@Override
	public Review findById(long reviewId) {
		Review review = reviewRepository.findById(reviewId);
		return review;
	}

	@Override
	public List<Review> findByUserid(String userId) {
		return reviewRepository.findByUserId(userId);
	}

}
