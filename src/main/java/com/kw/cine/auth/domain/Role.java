package com.kw.cine.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
	ADMIN("ROLE_ADMIN");
	
	private String value;
}
