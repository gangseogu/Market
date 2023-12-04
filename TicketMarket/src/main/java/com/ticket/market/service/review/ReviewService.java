package com.ticket.market.service.review;

import java.util.List;

import com.ticket.market.store.jpa.jpo.Review;

public interface ReviewService {
	public boolean createReview(Review review);
	public List<Review> findAll();
	public Review findById(long reviewId);
	public boolean modifyReview(Review review);
	void delReview(long reviewId);
}
