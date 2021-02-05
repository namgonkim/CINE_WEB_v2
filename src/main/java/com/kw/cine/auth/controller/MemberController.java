package com.kw.cine.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kw.cine.auth.dto.MemberDto;
import com.kw.cine.auth.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemberController {
	
	private static final Logger logger = LogManager.getLogger(MemberController.class);
	private MemberService memberService;
	
	 // 회원가입 페이지 -> 관리자 아이디 찾는 곳으로 변경할 예정
    @GetMapping("/user/signup")
    public String dispSignup(Model model) {
    	model.addAttribute("title", "Find Admin");
    	logger.info("sign up page access");
        return "/signup";
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(MemberDto memberDto) {
    	logger.info("register member");
        memberService.joinUser(memberDto);
        logger.info("register member success");

        return "redirect:/user/login";
    }
	
	// 관리자 로그인 페이지
	@GetMapping("/user/login")
	public String adminLogin(HttpServletRequest request) {
		logger.info("Login Page access");
		String referer = request.getHeader("Referer");
		if (referer == null) {
			request.getSession().setAttribute("prevPage", "/");
		} else
			request.getSession().setAttribute("prevPage", referer);

		logger.info("Referer site :" + referer);
		return "/login";
	}
	
	// 로그아웃 결과 페이지
	@GetMapping("/user/logout/result")
	public String adminLogout() {
		logger.info("admin logout!");
		return "/logout";
	}
	
	// 관리자 페이지
	@GetMapping("/admin")
	public String doAdmin() {
		logger.info("admin page access");
		return "/admin";
	}
	
	// 관리자 세팅 페이지
	@GetMapping("/admin/settings")
	public String settings(Authentication auth) {
		logger.info("admin setting page access");
		logger.info(auth.getPrincipal());
		return "/admin/settings";
	}
	
	// 관리자 세팅
	@PutMapping("/admin/settings")
	public String updateAdmin(String email, String password) {
		logger.info(email, password);
		memberService.updateUser(email, password);
		
		return "redirect:/user/logout";
	}
	
	// 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
    	logger.info("denied");
        return "/forbidden";
    }

}
