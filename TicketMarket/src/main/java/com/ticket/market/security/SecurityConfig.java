package com.ticket.market.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean(name = "securityFilterChain")
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    // 권한에 따라 허용하는 url 설정
        // /loginForm, /signUp 페이지는 모두 허용, 다른 페이지는 인증된 사용자만 허용
        http
		    .authorizeRequests()
		        .antMatchers("/test","/loginForm", "/checkSignUp","/signUpForm", "/assets/**").permitAll() // 페이지에 대해 모든 사용자에게 허용
		        .antMatchers("/**").hasAuthority("USER") // USER 롤을 가진 사용자에게만 접근 허용
		        .antMatchers("/admin/**").hasAuthority("ADMIN")// ADMIN 롤을 가진 사용자에게만 접근 허용
		        .anyRequest().authenticated()
                .and()
            .formLogin() //login 설정
                .loginPage("/loginForm")    // GET 요청 (login form을 보여줌)
                .usernameParameter("user_id")	// login에 필요한 id 값을 user_id로 설정 (default는 username)
                .passwordParameter("user_pw")	// login에 필요한 password 값을 user_pw로 설정 (default는 password)
                .loginProcessingUrl("/customLogin")    // POST 요청 (login 창에 입력한 데이터를 처리)
                .and()
            .logout() // logout 설정
                .logoutUrl("/logout")
                .logoutSuccessUrl("/test");	// logout에 성공하면 /로 redirect

        	
        return http.build();
		
		
	}
	
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	
	

}
