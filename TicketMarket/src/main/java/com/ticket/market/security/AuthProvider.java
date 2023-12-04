package com.ticket.market.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ticket.market.service.UserService;
import com.ticket.market.vo.UserVo;

@Component
public class AuthProvider implements AuthenticationProvider {
	
	@Autowired
	private UserService userService;

	@Override //사용자 인증 처리 메소드
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String user_id = (String) authentication.getPrincipal();
		String user_pw = (String) authentication.getCredentials();
		
		PasswordEncoder encoder = userService.passwordEncoder();
		UsernamePasswordAuthenticationToken token;
		UserVo uvo = userService.getUserById(user_id);
		
		if(uvo != null && encoder.matches(user_pw, uvo.getUser_pw()) && uvo.getUser_auth().equals("U")) {
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority("USER"));
			
			token = new UsernamePasswordAuthenticationToken(uvo.getUser_id(), null, roles);
			
			return token;
		}else if(uvo != null && encoder.matches(user_pw, uvo.getUser_pw()) && uvo.getUser_auth().equals("A")) {
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority("ADMIN"));
			
			token = new UsernamePasswordAuthenticationToken(uvo.getUser_id(), null, roles);
			
			return token;
		}
		
		throw new BadCredentialsException("No such user or wrong password."); 
		

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
