package com.ticket.market;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ticket.market.service.review.ReviewService;
import com.ticket.market.store.jpa.jpo.Review;
import com.ticket.market.store.jpa.repository.ReviewRepository;

@SpringBootTest
public class test {
//    @Autowired
//    ReviewRepository reviewRepository;
    
    @Autowired
    ReviewService res;
    
//    @Test
//    void RepositoryTest() {
//    	List<Review> review = res.findByMovieId("1");
//    	System.out.println(review.toString());
//    }
    
//    @Test
//    public void ServiceTest() {
//    	Review review = new Review("user01", "tomcat", "꿀잼", "3.2", "/test/test");
//    	boolean isc = res.createReview(review);
//    	Review review2 = res.findById(1);
//    	review2.setReviewContent("조영인 병신새끼");
//    	res.modifyReview(review2);
//    	assertTrue(isc);
//    }
}
