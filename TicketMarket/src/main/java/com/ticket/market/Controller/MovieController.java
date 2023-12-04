package com.ticket.market.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ticket.market.Dto.MovieDto;
import com.ticket.market.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("addmovie")
    public String test(Model model){
        List<MovieDto> cgvList = movieService.getCrawling();
        model.addAttribute("cgvList",cgvList);
        return "movie/movieSetting";
    }

    @GetMapping("addMoive.do")
    public void addMovie(Model model,
                         @RequestParam List<String> selectedMovies) throws JsonProcessingException {
        movieService.insertMovie(selectedMovies);
    }
}
