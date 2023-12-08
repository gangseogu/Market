package com.ticket.market.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticket.market.service.UserService;
import com.ticket.market.vo.UserVo;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("로그인폼 이동");
		return "loginForm";
	}
	
	@PostMapping("/customLogin")
	public String login(Model model) {
		System.out.println("로그인 처리");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication instanceof AnonymousAuthenticationToken) {
			return "loginForm";
		}
		
		boolean isAdmin = false;
		boolean isUser = false;

		for (GrantedAuthority authority : authentication.getAuthorities()) {
		    if ("ADMIN".equals(authority.getAuthority())) {
		        isAdmin = true;
		        break;
		    } else if ("USER".equals(authority.getAuthority())) {
		        isUser = true;
		        break;
		    }
		}
		if (isAdmin) {
		    System.out.println("관리자 로그인 성공");
			
			List<UserVo> lists = userService.findAllUsers();
			model.addAttribute("allUserList",lists);
			
			return "admin_main";
		} else if (isUser) {
		    System.out.println("일반회원 로그인 성공");
		    String user_id = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    UserVo uvo = userService.getUserById(user_id);
		    uvo.setUser_pw(null);
		    model.addAttribute("uvo", uvo);
		    
		    return "userMain";
		}
		return "redirect:/test";
	}
	
	@GetMapping("/admin/admin_main")
	public String adminMain(Model model) {
		System.out.println("관리인 메인페이지 이동");
		String user_id = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserVo uvo = userService.getUserById(user_id);
		uvo.setUser_pw(null);
		model.addAttribute("uvo",uvo);
		
		return "admin_main";
	}
	
	@GetMapping("/checkSignUp")
	public String signUp() {
		System.out.println("가입 여부 확인 페이지");
		return "checkSignUp";
	}
	
	@PostMapping("/checkSignUp")
	public String CheckSignUp(@RequestParam String user_name, @RequestParam String user_birth, @RequestParam String user_tel, HttpServletResponse response) throws IOException {
	    System.out.println("회원가입 여부 확인");
	    
	    Map<String, Object> map = new HashMap<>();
	    map.put("user_tel", user_tel);
	    map.put("user_name", user_name);
	    map.put("user_birth", user_birth);

	    int n = userService.CheckSignUp(map);

//	    response.setContentType("text/html; charset=UTF-8");
//	    PrintWriter out = response.getWriter();
	    if(n >= 1) {
//	        out.println("<script>alert('가입된 아이디가 존재합니다. 로그인을 진행해주세요.')</script>");
	        return "loginForm";
	    } else {
//	        out.println("<script>alert('가입된 아이디가 존재하지 않습니다. 회원가입을 진행합니다.')</script>");
	        return "redirect:/signUp";
	    }
	}

	
	@GetMapping("/signUp")
	public String signUpForm() {
		System.out.println("회원가입 폼");
		return "signUpForm";
	}

}
