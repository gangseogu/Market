package com.ticket.market.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TestController {

    @GetMapping("/test")
    public String test(Authentication authentication){
        System.out.println("test");
        return "main";
    }
}
