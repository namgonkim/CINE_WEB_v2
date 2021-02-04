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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kw.cine.dto.ResearchDto;
import com.kw.cine.service.ResearchService;

import lombok.AllArgsConstructor;

/**
 * @FileName : ResearchController.java
 * @Project : cine
 * @Date : 2021. 1. 26.
 * @작성자 : KNG
 * @변경이력 :
 * @프로그램 설명 : 리서치 컨트롤러
 */
@Controller
@AllArgsConstructor
public class ResearchController {

	private static final Logger logger = LogManager.getLogger(ResearchController.class);

	private ResearchService researchService;

	@GetMapping("/research")
	public ModelAndView researchList(@RequestParam("pid") int pid) {
		List<ResearchDto> rechList = researchService.findByPid(pid);
		ModelAndView mv = new ModelAndView("research");
		mv.addObject("title", "Researchs");
		String category = null;
		if (rechList.isEmpty()) {
			logger.info("연구 자료가 존재하지 않습니다.");
			mv.addObject("ResearchIsEmpty", true);
		} else
			mv.addObject("ResearchIsEmpty", false);
		logger.info("Research page access success");
		switch (pid) {
		case (110):
			category = "Research Area";
			break;
		case (111):
			category = "Research Project";
			break;
		case (112):
			category = "Industry-academia Project";
			break;
		}
		mv.addObject("category", category);
		mv.addObject("rechList", rechList);
		return mv;
	}

	// 새 리서치 등록 GET
	@GetMapping("/admin/research/new")
	public ModelAndView researchNew() {
		ModelAndView mv = new ModelAndView("research/new");
		logger.info("research/new access success");
		mv.addObject("title", "New Research");
		return mv;
	}


	 // 새 리서치 등록 POST
	@PostMapping("/admin/research/new")
	public String saveResearchNew(ResearchDto rechDto) {
		rechDto.setImgfile("https://placeimg.com/560/431/any");
		int retCode = researchService.saveNew(rechDto);
		if (retCode == -1) {
			logger.error("시스템 에러, 정상적으로 등록되지 않았습니다.");
			return "/admin/research/new";
		} else {
			logger.info(rechDto.getTitle() + "이 새로운 연구 자료로 등록되었습니다.");
			logger.info(retCode);
			return "redirect:/research?pid=" + retCode;
		}
	}

	// 리서치 수정 GET
	@GetMapping("/admin/research/modify/{idx}")
	public ModelAndView researchModify(@PathVariable("idx") Long idx) {
		ResearchDto rechDto = researchService.getResearch(idx);
		ModelAndView mv = null;
		if (rechDto == null) {
			logger.error("시스템 에러, 팀원 정보를 불러오지 못했습니다.");
			String num = Long.toString(idx);
			mv = new ModelAndView("research?pid=" + num);
			return mv;
		} else {
			logger.info(rechDto.getTitle() + "의 리서치 정보를 수정합니다.");
			mv = new ModelAndView("research/modify");
			mv.addObject("title", "Update Research");
			mv.addObject("rechDto", rechDto);
			return mv;
		}
	}

	// 리서치 수정 POST
	@PutMapping("/admin/research/modify/{idx}")
	public String researchUpdate(ResearchDto rechDto) {
		// rechDto.setImgfile("https://placeimg.com/365/376/any");
		int retCode = researchService.researchUpdate(rechDto);
		if (retCode == -1) {
			logger.error("시스템 에러, 정상적으로 수정되지 않았습니다.");
			return "/admin/research/modify/{idx}";
		} else {
			logger.info(rechDto.getTitle() + "의 연구자료 정보가 수정되었습니다.");
			return "redirect:/research?pid=" + retCode;
		}
	}

	// 리서치 삭제
	@DeleteMapping("/admin/research/delete/{idx}")
	public String researchDelete(@PathVariable("idx") Long idx) {
		int retCode = researchService.researchDelete(idx);
		if (retCode == -1) {
			logger.error("시스템 에러, 팀원 삭제가 정상적이지 못했습니다.");
			return "redirect:/research?pid=110";
		} else {
			logger.info("해당 정보를 삭제했습니다.");
			return "redirect:/research?pid=" + retCode;
		}
	}

}
