package com.ticket.market.store.jpa.jpo;

import com.ticket.market.Dto.MovieDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

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
    @Nullable
    private String expirationDate;
    private String movieImgUrl;

    public Movie(MovieDto movieDto) {
        this.movieId = movieDto.getMovieId();
        this.movieName = movieDto.getMovieTitle();
        this.startDate = movieDto.getMovieOpenDate();
        this.movieImgUrl = movieDto.getImg();
    }
}
