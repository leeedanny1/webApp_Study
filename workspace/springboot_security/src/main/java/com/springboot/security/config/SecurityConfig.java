package com.springboot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.security.config.oauth2.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration //IOC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PrincipalOauth2UserService principalOauth2UserService;

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
				.defaultSuccessUrl("/")		// 로그인이 성공한 경우 이동할 페이지(index)
			.and()
			.oauth2Login()
				.loginPage("/auth/signin")
				.userInfoEndpoint()
				/*
				 * 1. 코드를 받아옴(인증처리)
				 * 2. 엑세스 토큰(권한)
				 * 3. 사용자 프로필 정보를 가져옴
				 */
				.userService(principalOauth2UserService);	// 가져온 프로필을 후처리(사용되어질 서비스가 필요함)
	}
	
}
