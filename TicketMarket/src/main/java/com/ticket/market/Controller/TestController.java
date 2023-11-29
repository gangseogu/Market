package com.ticket.market.Controller;

import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TestController {

    @GetMapping("test")
    public String test(Model model){
        System.out.println("test");
        return "main";
    }
}
