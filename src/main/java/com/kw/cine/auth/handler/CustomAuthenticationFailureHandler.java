package com.kw.cine.auth.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kw.cine.auth.dto.ResponseDataCode;
import com.kw.cine.auth.dto.ResponseDataDto;
import com.kw.cine.auth.dto.ResponseDataStatus;

/**
 * 로그인 실패시 로직
 *
 */
@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
	
	private static final Logger logger = LogManager.getLogger(CustomAuthenticationFailureHandler.class);
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
			// org.springframework.security.core.AuthenticationException
		logger.info(exception.getMessage());
		logger.info("아이디 혹은 비밀번호가 일치하지 않았습니다.");
		
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