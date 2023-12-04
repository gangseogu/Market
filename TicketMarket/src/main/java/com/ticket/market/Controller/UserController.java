package com.ticket.market.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticket.market.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping(value = "/loginForm")
	public String loginForm() {
		System.out.println("로그인폼 이동");
		return "loginForm";
	}
	
	@PostMapping(value = "/login")
	public String login(@RequestParam String user_id, @RequestParam String user_pw, Model model) {
		System.out.println("로그인 처리");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication instanceof AnonymousAuthenticationToken) {
			return "loginForm";
		}
		SecurityContextHolder.getContext().setAuthentication(authentication);
		System.out.println("로그인 성공");
		
		return "main";
	}
	
	@GetMapping(value = "/CheckSignUp.do")
	public String CheckSignUp(String user_name, String user_id, String user_tel) {
		System.out.println("회원가입 여부 확인");
		Map<String, Object> map = new HashMap<>();
		map.put("user_name", user_name);
		map.put("user_id", user_id);
		map.put("user_tel", user_tel);
		
		
		return "afterCheck";
	}

}
