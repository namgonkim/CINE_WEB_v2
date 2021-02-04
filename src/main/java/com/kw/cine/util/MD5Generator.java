package com.kw.cine.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
  * @FileName : MD5Generator.java
  * @Project : cine
  * @Date : 2021. 1. 29. 
  * @작성자 : KNG
  * @변경이력 :
  * @프로그램 설명 : 파일이 업로드되면, MD5 체크섬의 값으로 서버에 저장되게 구현
  */
public class MD5Generator {
	private String result;
	
	public MD5Generator(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		MessageDigest mdMD5 = MessageDigest.getInstance("MD5");
		mdMD5.update(input.getBytes("UTF-8"));
		byte[] md5Hash = mdMD5.digest();
		StringBuilder hexMD5hash = new StringBuilder();
		for(byte b : md5Hash) {
			String hexString = String.format("%02x", b);
			hexMD5hash.append(hexString);
		}
		result = hexMD5hash.toString();
	}
	
	public String toString() {
		return result;
	}

}
