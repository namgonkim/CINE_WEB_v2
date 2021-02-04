package com.kw.cine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.AllArgsConstructor;

/**
  * @FileName : MainController.java
  * @Project : cine
  * @Date : 2021. 1. 20. 
  * @작성자 : KNG
  * @변경이력 :
  * @프로그램 설명 :
  */
@Controller
@AllArgsConstructor
public class MainController {
	
	private static final Logger logger = LogManager.getLogger(MainController.class);
	
	@GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("title","main");
        logger.info("Home page access");
        return "index";
    }
	
	@GetMapping("/professor")
	public String getProfessor(Model model) {
		model.addAttribute("title","professor");
		logger.info("Professor page access");
		return "professor";
	}
	
	@GetMapping("/contact")
	public String getContact(Model model) {
		model.addAttribute("title", "contact");
		logger.info("Contact page access");
		return "contact";
	}
	

}
