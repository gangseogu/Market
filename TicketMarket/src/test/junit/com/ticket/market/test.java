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
//    	Review review = new Review("wjddns7828","test1","asdasd",new BigDecimal("3.14"), "asdasd");
//    	Review review2 = new Review("wjddns7828","test1","asdasd",new BigDecimal("3.14"), "asdasd");
//    	Review review3 = new Review("wjddns7828","test1","asdasd",new BigDecimal("3.14"), "asdasd");
//    	Review review4 = new Review("wjddns7828","test1","asdasd",new BigDecimal("3.14"), "asdasd");
//    	List<Review> revies = new ArrayList<>();
//    	revies.add(review);
//    	revies.add(review2);
//    	revies.add(review3);
//    	revies.add(review4);
//    	reviewRepository.saveAll(revies);
//    	reviewRepository.deleteById(review4.getReviewId());
//    	List<Review> list = reviewRepository.findAll();
//    	System.out.println(list);
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
