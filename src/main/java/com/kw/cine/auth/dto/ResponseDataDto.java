package com.kw.cine.auth.dto;

import lombok.Setter;
import lombok.Getter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseDataDto {
	
	private String code;
	private String status;
	private String message;
	private Object item;

}
