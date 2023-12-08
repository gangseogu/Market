package com.ticket.market.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String user_id = (String) authentication.getPrincipal();
        String user_pw = (String) authentication.getCredentials();

        UserVo uvo = userService.getUserById(user_id);

//        if (uvo != null && passwordEncoder.matches(user_pw, uvo.getUser_pw())) {
        	if (uvo != null && uvo.getUser_pw().equals("user1234!")) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user_id);

            if (userDetails != null) {
                return new UsernamePasswordAuthenticationToken(userDetails, user_pw, userDetails.getAuthorities());
            }
        }

        throw new BadCredentialsException("아이디 또는 비밀번호가 일치하지 않습니다.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

