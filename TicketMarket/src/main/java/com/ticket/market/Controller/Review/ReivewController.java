package com.ticket.market.Controller.Review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ticket.market.store.jpa.repository.ReviewRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReivewController {
	@GetMapping("/getreview")
	public String getReview(String reviewId) {
		return "";
	}
	
	public String insertReview() {
		return "";
	}
	
	public String updateReview() {
		return"";
	}
	
	public String deleteReview() {
		return"";
	}
}
