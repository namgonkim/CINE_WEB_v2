package com.kw.cine.auth.handler;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kw.cine.auth.dto.ResponseDataCode;
import com.kw.cine.auth.dto.ResponseDataDto;
import com.kw.cine.auth.dto.ResponseDataStatus;

/**
 * 로그인 실패시 로직
 *
 */
@Configuration
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
			// org.springframework.security.core.AuthenticationException
		
		ObjectMapper mapper = new ObjectMapper();	//JSON 변경용
    	
    	ResponseDataDto responseDataDto = new ResponseDataDto();
    	responseDataDto.setCode(ResponseDataCode.ERROR);
    	responseDataDto.setStatus(ResponseDataStatus.ERROR);
    	response.setCharacterEncoding("UTF-8");
    	responseDataDto.setMessage("아이디 혹은 비밀번호가 일치하지 않습니다.");
    	    	
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print(mapper.writeValueAsString(responseDataDto));
        response.getWriter().flush();
	
	}
}