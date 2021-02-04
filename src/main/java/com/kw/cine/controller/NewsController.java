package com.kw.cine.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kw.cine.dto.NewsDto;
import com.kw.cine.service.NewsService;

import lombok.AllArgsConstructor;

/**
 * @FileName : NewsController.java
 * @Project : cine
 * @Date : 2021. 1. 26.
 * @작성자 : KNG
 * @변경이력 :
 * @프로그램 설명 : 리서치 컨트롤러
 */
@Controller
@AllArgsConstructor
public class NewsController {

	private static final Logger logger = LogManager.getLogger(NewsController.class);

	private NewsService newsService;

	// new 페이지
	@GetMapping("/news")
	public ModelAndView newsList() {
		List<NewsDto> newsList = newsService.findAll();
		ModelAndView mv = new ModelAndView("news");
		mv.addObject("title", "News");
		String category = "News";
		if (newsList.isEmpty()) {
			logger.info("뉴스 자료가 존재하지 않습니다.");
			mv.addObject("NewsIsEmpty", true);
		} else
			mv.addObject("NewsIsEmpty", false);
		logger.info("News page access success");
		mv.addObject("category", category);
		mv.addObject("newsList", newsList);
		return mv;
	}

	// 새 뉴스 등록 GET
	@GetMapping("/admin/news/new")
	public ModelAndView newsNew() {
		ModelAndView mv = new ModelAndView("news/new");
		logger.info("news/new access success");
		mv.addObject("title", "New News");
		return mv;
	}

	// 새 리서치 등록 POST
	@PostMapping("/admin/news/new")
	public String saveNewsNew(NewsDto newsDto) {
		newsDto.setImgfile("https://placeimg.com/560/431/any");
		int retCode = newsService.saveNew(newsDto);
		if (retCode == -1) {
			logger.error("시스템 에러, 정상적으로 등록되지 않았습니다.");
			return "/admin/news/new";
		} else {
			logger.info(newsDto.getTitle() + "이 새로운 뉴스 자료로 등록되었습니다.");
			logger.info(retCode);
			return "redirect:/news?pid=" + retCode;
		}
	}

	// 리서치 수정 GET
	@GetMapping("/admin/news/modify/{idx}")
	public ModelAndView newsModify(@PathVariable("idx") Long idx) {
		NewsDto newsDto = newsService.getNews(idx);
		ModelAndView mv = null;
		if (newsDto == null) {
			logger.error("시스템 에러, 팀원 정보를 불러오지 못했습니다.");
			String num = Long.toString(idx);
			mv = new ModelAndView("news?pid=" + num);
			return mv;
		} else {
			logger.info(newsDto.getTitle() + "의 뉴스 정보를 수정합니다.");
			mv = new ModelAndView("news/modify");
			mv.addObject("title", "Update news");
			mv.addObject("newsDto", newsDto);
			return mv;
		}
	}

	// 리서치 수정 POST
	@PutMapping("/admin/news/modify/{idx}")
	public String newsUpdate(NewsDto newsDto) {
		// rechDto.setImgfile("https://placeimg.com/365/376/any");
		int retCode = newsService.newsUpdate(newsDto);
		if (retCode == -1) {
			logger.error("시스템 에러, 정상적으로 수정되지 않았습니다.");
			return "/admin/news/modify/{idx}";
		} else {
			logger.info(newsDto.getTitle() + "의 연구자료 정보가 수정되었습니다.");
			return "redirect:/news?pid=" + retCode;
		}
	}

	// 리서치 삭제
	@DeleteMapping("/admin/news/delete/{idx}")
	public String newsDelete(@PathVariable("idx") Long idx) {
		int retCode = newsService.newsDelete(idx);
		if (retCode == -1) {
			logger.error("시스템 에러, 팀원 삭제가 정상적이지 못했습니다.");
			return "redirect:/news?pid=110";
		} else {
			logger.info("해당 정보를 삭제했습니다.");
			return "redirect:/news?pid=" + retCode;
		}
	}

}
