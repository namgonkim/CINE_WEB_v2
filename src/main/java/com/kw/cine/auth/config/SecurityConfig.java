package com.kw.cine.auth.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kw.cine.auth.handler.CustomAuthenticationFailureHandler;
import com.kw.cine.auth.handler.CustomAuthenticationSuccessHandler;
import com.kw.cine.auth.service.MemberService;

import lombok.AllArgsConstructor;

/**
  * @FileName : SecurityConfig.java
  * @Project : cine
  * @Date : 2021. 1. 25. 
  * @작성자 : KNG
  * @변경이력 :
  * @프로그램 설명 :
  * WebSecurityConfigurerAdapter클래스를 상속받아 메서드를 구현
  * WebSecurityConfigurer 인스턴스를 편리하게 생성하기 위한 클래스
  */
@Configuration
@EnableWebSecurity	// spring 시큐리티를 설정할 클래스라 정의
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// @Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	
	private MemberService memberService;
	private static final Logger logger = LogManager.getLogger(SecurityConfig.class);
	
	
	// 암호화 객체 Bcrypt 활용. 빈으로 등록한다.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// FilterChainProxy 생성 필터
	// 해당 결로의 파일들은 스프링 시큐리티가 무시하도록 설정
	@Override
	public void configure(WebSecurity web) throws Exception{
		// static 디렉토리 하위 파일 목록은 인증을 무시하고 항상 통과한다.
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}
	
	// 접근을 제어하고 역할에 따른 경로 접근 설정을 잡는다.
	// admin 페이지 활성화
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("지금부터 스프링 시큐리티가 적용됩니다.");
		http.authorizeRequests()
					// 페이지 권한 설정
				.antMatchers("/admin/**").hasRole("ADMIN")			// admin/* 주소는 모두 관리자
				.antMatchers("/**").permitAll()						// 다른 대부분은 이용할 수 있다.
				.anyRequest().authenticated()						// 사용자가 인증되지 않았다면, 이를 잡고 사용자를 로그인 페이지로 리다이렉트
			.and()	// 로그인 설정
				.formLogin()										// 로그인 form 사용
				.loginPage("/user/login")							// 로그인 페이지
				.loginProcessingUrl("/loginProcess")
				.successHandler(customAuthenticationSuccessHandler)	// 로그인 성공시 핸들러
				.failureHandler(customAuthenticationFailureHandler)	// 로그인 실패시 핸들러
				//.failureUrl("/user/login?error")
				.permitAll()
			.and()	// 로그아웃 설정
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
				.logoutSuccessUrl("/user/logout/result")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
			.and()
					// 403 예외처리
				.exceptionHandling().accessDeniedPage("/user/denied");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
	}
	
	

}
