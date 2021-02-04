package com.kw.cine.errorhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * 해당 예외가 호출되면 403 error code를 반환하도록 한다.
 * + 메세지를 전달할 수 있도록 생성자도 추가한다.
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ForbiddenException(String message) {
		super(message);
	}

}
