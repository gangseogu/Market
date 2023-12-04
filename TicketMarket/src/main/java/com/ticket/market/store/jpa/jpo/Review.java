package com.ticket.market.store.jpa.jpo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Data
@EntityListeners(AuditingEntityListener.class)
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long reviewId;
	String userId;
	String movieId;
	@Column(length = 4000)
	String reviewContent;
	@Column(precision = 5, scale = 2)
	BigDecimal rating;
	@CreationTimestamp
	Date registDate;
	@UpdateTimestamp
	Date updateDate;
	String photoPath;

	public Review(String userId, String movieId, String reviewContent, String rating, String photoPath) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.reviewContent = reviewContent;
		this.rating = new BigDecimal(rating);
		this.photoPath = photoPath;
	}
}


