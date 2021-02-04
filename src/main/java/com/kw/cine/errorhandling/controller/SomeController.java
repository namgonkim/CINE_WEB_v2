package com.kw.cine.errorhandling.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kw.cine.errorhandling.exception.ForbiddenException;
/*
 * Exception을 발생시켜서 의도적으로 에러를 반환
 * 500 Error : Runtime Exception
 * 403 Error : Forbidden -> 커스텀 제작
 */

@RestController
public class SomeController {
	
	
	@GetMapping("/internalerror")
	public void internalerror() {
		throw new RuntimeException("500 Internal Error.");
	}
	
	@GetMapping("/forbidden")
	public void forbidden() {
		throw new ForbiddenException("Access Denied. 403 Forbidden Error.");
	}
}
