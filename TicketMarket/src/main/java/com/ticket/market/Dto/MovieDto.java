package com.ticket.market.Dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MovieDto {
        String rank;
        String img;
        String movieAge;
        String movieTitle;
        String movieRate; //예매율
        String movieOpenDate; //개봉일
        String like;
        int seq;
}
