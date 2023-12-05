package com.ticket.market.store.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.market.store.jpa.jpo.Review;

@Transactional(readOnly = true)
@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
	//영화번호로 조회하기
	List<Review> findByMovieId(String movieId);
	//reviewID로 조회하기
	Review findById(long id);
	List<Review> findByUserId(String userId);
}
