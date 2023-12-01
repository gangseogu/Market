package com.ticket.market.service;

import com.ticket.market.Dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;

@Service
@RequiredArgsConstructor
public class MovieService {


        private static Logger logger = LoggerFactory.getLogger(MovieService.class);

        public List<com.ticket.market.Dto.MovieDto> getCrawling() {
            Document doc;
            String gson = "";

            try {
                doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
                System.out.println("doc = " + doc);
                /* Elements */
                Elements ranks = doc.select(".rank");
                /* logger.info("rank" + ranks); */
                System.out.println("ranks = " + ranks);
                Elements imgs = doc.select(".thumb-image > img");
                /* logger.info("imgs" + imgs); */

                Elements movieAges = doc.select(".ico-grade");
                System.out.println("movieAges = " + movieAges);
                /* logger.info("ico-grade" + movieAges); */

                Elements movieTitles = doc.select("div.box-contents strong.title");
                /* logger.info("titles" + movieTitles); */

                Elements movieRates = doc.select(".percent span");
                /* logger.info("percents" + movieRates); */


                Elements movieOpenDates = doc.select(".txt-info strong");
                /* logger.info("percents" + movieOpenDates); */

                Elements likes = doc.select(".count strong>i");
                /* logger.info("counts" + likes); */
                List<MovieDto> list = new ArrayList<MovieDto>();

                for(int i = 0; i < ranks.size(); i++) {

                    String rank = ranks.get(i).text();
                    String img = imgs.get(i).attr("src");

                    String movieAge = "";

                    if(!movieAges.isEmpty()){
                        movieAge = movieAges.get(i).text();
                    }

                    String movieTitle = movieTitles.get(i).text();
                    String movieRate = movieRates.get(i).text();
                    String movieOpenDate = movieOpenDates.get(i).text();
                    String like = "";
                    if(!likes.isEmpty()) {
                        like = likes.get(i).text();
                    }
                    int seq = i;
                    MovieDto movieDto = new MovieDto(rank, img, movieAge, movieTitle, movieRate, movieOpenDate, like, seq);

                    logger.info(movieDto.toString());
                    list.add(movieDto);

                    return list;
                }
                gson = new Gson().toJson(list);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            return null;
    }
}
