package com.ticket.market.store.jpa.jpo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
public class Movie {

    @Id
    private String movieId;
    private String movieName;
    private String startDate;
    private String expirationDate;
    private String movieImgUrl;
}
