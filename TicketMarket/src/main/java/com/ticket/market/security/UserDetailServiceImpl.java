package com.ticket.market.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ticket.market.service.UserService;
import com.ticket.market.vo.UserVo;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
	    UserVo uvo = userService.getUserById(user_id);

	    if (uvo == null) {
	        throw new UsernameNotFoundException("일치하는 아이디가 존재하지 않습니다" + user_id);
	    }

	    List<GrantedAuthority> roles = new ArrayList<>();
	    if (uvo != null && "A".equals(uvo.getUser_auth())) {
	    	roles.add(new SimpleGrantedAuthority("ADMIN"));
	    }else if(uvo != null && "U".equals(uvo.getUser_auth())){
	    	roles.add(new SimpleGrantedAuthority("USER"));
	    }

	    // UserDetails 객체를 생성하여 반환
	    return org.springframework.security.core.userdetails.User.builder()
	            .username(uvo.getUser_id())
	            .password(uvo.getUser_pw()) // 암호화된 비밀번호를 사용할 경우, 여기에는 암호화된 비밀번호를 설정
	            .authorities(roles)
	            .build();
	}

}
