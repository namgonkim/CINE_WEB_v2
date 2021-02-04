package com.kw.cine.auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kw.cine.auth.dto.MailDto;
import com.kw.cine.auth.service.MemberService;
import com.kw.cine.auth.service.SendEmailService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HelpController {

	private static final Logger logger = LogManager.getLogger(HelpController.class);
	private MemberService memberService;
	private SendEmailService sendEmailService;

	@GetMapping("/help")
	public ModelAndView help() {
		ModelAndView mv = new ModelAndView("help");
		return mv;
	}
	// Email과 name의 일치여부를 check하는 컨트롤러
	@GetMapping("/check/findPw")
	public @ResponseBody Map<String, Boolean> pw_find(String userEmail) {
		Map<String, Boolean> json = new HashMap<>();
		boolean pwFindCheck = memberService.userEmailCheck(userEmail);
		logger.info("Email Find : " + pwFindCheck);
		json.put("check", pwFindCheck);
		return json;
	}

	// 등록된 이메일로 임시비밀번호를 발송하고 발송된 임시비밀번호로 사용자의 pw를 변경하는 컨트롤러
	
	@GetMapping("/help/sendEmail")
	public @ResponseBody Map<String, Boolean> sendEmail(String userEmail) {
		Map<String, Boolean> json = new HashMap<>();
		logger.info("Send Email : " + userEmail);
		MailDto maildto = sendEmailService.createMailAndChangePassword(userEmail);
		sendEmailService.mailSend(maildto);
		json.put("check", true);
		return json;

	}

}
