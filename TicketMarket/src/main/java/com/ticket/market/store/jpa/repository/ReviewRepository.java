package com.ticket.market.store.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ticket.market.store.jpa.jpo.Review;

@Transactional(readOnly = true)
@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
	List<Review> findAll();
	Review findById(long id);
	
}
