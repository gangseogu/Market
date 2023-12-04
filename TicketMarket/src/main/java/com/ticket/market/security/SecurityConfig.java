package com.ticket.market.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    // 권한에 따라 허용하는 url 설정
        // /loginForm, /signUp 페이지는 모두 허용, 다른 페이지는 인증된 사용자만 허용
        http
            .authorizeRequests()
                .antMatchers("/test","/loginForm", "/signUp").permitAll()
                .antMatchers("/user/**").hasAuthority("USER")
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin() //login 설정
                .loginPage("/loginForm")    // GET 요청 (login form을 보여줌)
                .loginProcessingUrl("/login")    // POST 요청 (login 창에 입력한 데이터를 처리)
                .usernameParameter("user_id")	// login에 필요한 id 값을 user_id로 설정 (default는 username)
                .passwordParameter("user_pw")	// login에 필요한 password 값을 user_pw로 설정 (default는 password)
                .defaultSuccessUrl("/test")	// login에 성공하면 /test로 redirect
                .and()
            .logout() // logout 설정
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");	// logout에 성공하면 /로 redirect

        return http.build();
		
		
	}
	
	
	

}
