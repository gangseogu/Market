package com.ticket.market.Controller;

import com.ticket.market.Dto.MovieDto;
import com.ticket.market.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("test")
    public String test(Model model){
        List<MovieDto> cgvList = movieService.getCrawling();
        model.addAttribute("cgvList",cgvList);
        return "movie/movieSetting";
    }
}
