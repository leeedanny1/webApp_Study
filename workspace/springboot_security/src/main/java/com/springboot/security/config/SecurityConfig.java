package com.springboot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration //IOC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();	// csrf 비활성화
		http.authorizeRequests()
			.antMatchers("/", "/index", "/user/**") // 얘들은
			.authenticated() 	// 인증이 필요함
			.anyRequest() 	// antMatchers외의 다른 모든 요청은
			.permitAll() 		// 인증이 없어도 됨(모든 권한을 부여함)
			.and()
			.formLogin()		// 로그인 페이지 커스텀
			.loginPage("/auth/signin")				//get
			.loginProcessingUrl("/auth/signin")	//post. controller를 따로 만들 필요가 없음(security가 자동으로 처리)
			.defaultSuccessUrl("/");	// 로그인이 성공한 경우 이동할 페이지(index)
			
	}
	
}
