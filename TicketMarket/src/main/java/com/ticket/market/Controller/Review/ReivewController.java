package com.ticket.market.Controller.Review;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.ticket.market.service.review.ReviewService;
import com.ticket.market.store.jpa.jpo.Review;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReivewController {
	@Autowired
	ReviewService reviewService;
	
	//review하나 가져오기
	@GetMapping("getReview")
	public String getReview(long reviewId) {
		Review review = reviewService.findById(reviewId);
		return "";
	}
	
	@GetMapping("moview/getAllReview")
	public String getAllReview(String moviewId) {
		return "";
	}
	
	//리뷰 작성 폼으로 이동
	@GetMapping("/addReview")
	public String insertReview() {
		return "/review/reviewForm";
	}
	
	//리뷰 게시하기
	@PostMapping("review/postReview")
	public String PostReview(Review review, MultipartFile photo, HttpServletRequest req) throws FileNotFoundException{
		//session에서 가져올 예정
		String userId = "testId";
		review.setUserId(userId);
		if(photo != null) {
			String path = setPath(photo, req, review.getMovieId());
			review.setPhotoPath(path);
		}
		reviewService.createReview(review);
		
		return "redirect:/addReview";
	}
	
	public String updateReview() {
		return"";
	}
	
	public String deleteReview() {
		return"";
	}
	
	
	private String setPath(MultipartFile photo, HttpServletRequest req, String movieId) throws FileNotFoundException {
		String originalFileName = photo.getOriginalFilename();
		String saveFileName = UUID.randomUUID().toString()+originalFileName.substring(originalFileName.lastIndexOf("."));

		// 2) 저장 위치를 만든다
		String path = WebUtils.getRealPath(req.getSession().getServletContext(),"/reviewImg/"+movieId);// 상대경로
		
		// 3) 저장 위치가 없으면 만든다
		File storage = new File(path);
		if (!storage.exists()) {
			storage.mkdirs();
		}
		
		File newFile = new File(path+"/"+saveFileName);
		
		byte[] b = new byte[(int)photo.getSize()];
		try (InputStream inputStream = photo.getInputStream();
		     OutputStream outputStream = new FileOutputStream(newFile)) {

		    int read = 0;
		    while ((read=inputStream.read(b))!= -1) {
		        outputStream.write(b,0,read);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		// 웹 상에서 접근 가능한 상대 경로로 변환
		String webPath = path.substring(path.indexOf("reviewImg"));

		// 슬래시(/)로 경로를 통일
		webPath = webPath.replace("\\", "/");
		// 이미지 저장경로 저장
		String photoPath = "/"+webPath+"/"+saveFileName;
		return photoPath;
	}
}
