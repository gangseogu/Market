package com.ticket.market.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticket.market.Dto.MovieDto;
import com.ticket.market.store.jpa.MovieStore;
import com.ticket.market.store.jpa.jpo.Movie;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieStore movieStore;

        private static Logger logger = LoggerFactory.getLogger(MovieService.class);

        public List<MovieDto> getCrawling() {
            Document doc;
            String gson = "";

            try {
                doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
                Elements ranks = doc.select(".rank");
                Elements imgs = doc.select(".thumb-image > img");
                Elements movieAges = doc.select(".ico-grade");
                Elements movieTitles = doc.select("div.box-contents strong.title");
                Elements movieTitleIds = doc.select("div.box-contents .link-reservation");
                Elements movieRates = doc.select(".percent span");
                Elements movieOpenDates = doc.select(".txt-info strong");
                Elements likes = doc.select(".count strong>i");
                List<MovieDto> list = new ArrayList<MovieDto>();

                for(int i = 0; i < ranks.size(); i++) {

                    String rank = ranks.get(i).text();
                    String img = imgs.get(i).attr("src");

                    String movieAge = "";

                    if(!movieAges.isEmpty()){
                        movieAge = movieAges.get(i).text();
                    }

                    String movieTitle = movieTitles.get(i).text();

                    //movieId값 가져오기
                    String hrefValue = movieTitleIds.get(i).attr("href");

                    // "MOVIE_CD=" 다음의 숫자를 추출
                    int startIndex = hrefValue.indexOf("MOVIE_CD=") + 9;
                    int endIndex = hrefValue.indexOf("&", startIndex);
                    if (endIndex == -1) {
                        endIndex = hrefValue.length();
                    }

                    // "MOVIE_CD=" 다음의 값 출력
                    String movieCdValue = hrefValue.substring(startIndex, endIndex);

                    String movieRate = movieRates.get(i).text();
                    String movieOpenDate = movieOpenDates.get(i).text();
                    String like = "";
                    if(!likes.isEmpty()) {
                        like = likes.get(i).text();
                    }
                    int seq = i;
                    MovieDto movieDto = new MovieDto(rank, img, movieAge, movieTitle, movieCdValue, movieRate, movieOpenDate, like, seq);

                    logger.info(movieDto.toString());
                    list.add(movieDto);

                }
                return list;

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            return null;
    }

    public void insertMovie(List<String> selectedMovies) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        HashMap<String, String> map = new HashMap<String, String>();
        List<HashMap<String, String>> maps = new ArrayList<>();

        for (String s : selectedMovies) {
            map = objectMapper.readValue(s, new TypeReference<HashMap<String, String>>() {});
            maps.add(map);
        }

        List<String> idList = new ArrayList<>();
        for(HashMap<String, String> mapItem : maps) {
            idList.add(mapItem.get("movieId"));
        }

        List<MovieDto> originList = getCrawling();
        // 이중포문 -> 선택한 열만 골라내기

        List<MovieDto> selectList = originList.stream()
                .filter(movieDto -> idList.contains(movieDto.getMovieId()))
                .collect(Collectors.toList());

        System.out.println("selectList = " + selectList);
        //저장
        selectList.forEach(movieDto -> movieStore.save(new Movie(movieDto)));

    }
}
