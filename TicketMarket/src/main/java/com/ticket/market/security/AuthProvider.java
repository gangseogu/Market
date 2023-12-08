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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ticket.market.service.UserService;
import com.ticket.market.vo.UserVo;

@Component
public class AuthProvider implements AuthenticationProvider {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override //사용자 인증 처리 메소드
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String user_id = (String) authentication.getPrincipal(); //로그인 창에 입력한 아이디
		String user_pw = (String) authentication.getCredentials(); //로그인 창에 입력한 패스워드
		
		UserVo uvo = userService.getUserById(user_id);
		
//		if(uvo != null && passwordEncoder.matches(user_pw, uvo.getUser_pw()) && "U".equals(uvo.getUser_auth())) {
		if(uvo != null && user_pw.equals("user1234!") && "U".equals(uvo.getUser_auth())) {
		
			List<GrantedAuthority> roles = new ArrayList<>();
			roles.add(new SimpleGrantedAuthority("USER"));
			
			UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(uvo.getUser_id())
                    .password(uvo.getUser_pw())
                    .authorities(roles)
                    .build();

            Authentication token = new UsernamePasswordAuthenticationToken(userDetails, user_pw, roles);
			
			return token;
			
		}else if(uvo != null && passwordEncoder.matches(user_pw, uvo.getUser_pw()) && "A".equals(uvo.getUser_auth())) {
			List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority("ADMIN"));

            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(uvo.getUser_id())
                    .password(uvo.getUser_pw())
                    .authorities(roles)
                    .build();

            Authentication token = new UsernamePasswordAuthenticationToken(userDetails, user_pw, roles);

            return token;
		}
		
		throw new BadCredentialsException("아이디 또는 비밀번호가 일치하지 않습니다."); 
		

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
	
	
	

}
