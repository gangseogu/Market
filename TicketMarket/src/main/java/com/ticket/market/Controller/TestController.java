package com.ticket.market.Controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TestController {

    @GetMapping("/test")
    public String test(Authentication authentication){
        System.out.println("test");
        
        //로그인한 경우
        if(authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
        	
        	if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
        		return "admin/main";
        	}else if(authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("USER"))) {
        		return "user/main";
        	}

        }
        
        return "main";
    }
}
