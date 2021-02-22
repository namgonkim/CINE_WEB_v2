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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kw.cine.dto.FilesDto;
import com.kw.cine.dto.PublicationsDto;
import com.kw.cine.service.FileService;
import com.kw.cine.service.PublicationsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class PublicationsController {

	private static final Logger logger = LogManager.getLogger(PublicationsController.class);

	private PublicationsService publicationsService;
	private FileService fileService;

	@GetMapping("/publications")
	public ModelAndView pagePublications(@RequestParam("pid") int pid) {
		List<PublicationsDto> publList = publicationsService.findByPid(pid);
		ModelAndView mv = new ModelAndView("publications");
		mv.addObject("title", "Publications");
		String category = null;
		if (publList.isEmpty()) {
			logger.info("연구 자료가 존재하지 않습니다.");
			mv.addObject("PublicationsIsEmpty", true);
		} else
			mv.addObject("PublicationsIsEmpty", false);
		logger.info("Publications page access success");
		switch (pid) {
		case (220):
			category = "Journal Articles";
			break;
		case (221):
			category = "Communications";
			break;
		case (222):
			category = "Patents";
			break;
		}
		mv.addObject("category", category);
		mv.addObject("publList", publList);
		return mv;
	}

	// 새 퍼블리케이션 등록 GET
	@GetMapping("/admin/publications/new")
	public ModelAndView publicationsNew() {
		ModelAndView mv = new ModelAndView("publications/new");
		logger.info("publications/new access success");
		mv.addObject("title", "New Publications");
		return mv;
	}

	// 새 퍼블리케이션 등록 POST
	@PostMapping("/admin/publications/new")
	public String savePublicationsNew(PublicationsDto publDto) {
		try {

			int retCode = publicationsService.saveNew(publDto);
			if (retCode == -1) {
				logger.error("시스템 에러, 정상적으로 등록되지 않았습니다.");
				return "/admin/publications/new";
			} else {
				logger.info(publDto.getIdx() + "이 새로운 퍼블리케이션 자료로 등록되었습니다.");
				logger.info(retCode);
				return "redirect:/publications?pid=" + retCode;
			}

		} catch (Exception e) {
			// 이미지 파일 저장, publication 등록이 안되는 경우
			logger.error("[Publications ERROR] Where: new, 정상적으로 생성되지 않았습니다.");
			logger.error(e.getMessage());
			e.getStackTrace();
			return "redirect:/admin/publications/new";
		}

	}

	// 퍼블리케이션 수정 GET
	@GetMapping("/admin/publications/modify/{idx}")
	public ModelAndView publicationsModify(@PathVariable("idx") Long idx) {
		PublicationsDto publDto = publicationsService.getPublications(idx);
		ModelAndView mv = null;
		if (publDto == null) {
			logger.error("시스템 에러, 팀원 정보를 불러오지 못했습니다.");
			String num = Long.toString(idx);
			mv = new ModelAndView("publications?pid=" + num);
			return mv;
		} else {
			logger.info(publDto.getIdx() + "의 퍼블리케이션 정보를 수정합니다.");
			mv = new ModelAndView("publications/modify");
			mv.addObject("title", "Update publications");
			mv.addObject("publDto", publDto);
			return mv;
		}
	}

	// 퍼블리케이션 수정 POST
	@PutMapping("/admin/publications/modify/{idx}")
	public String publicationsUpdate(PublicationsDto publDto) {
		try {

			int retCode = publicationsService.publicationsUpdate(publDto);
			if (retCode == -1) {
				logger.error("시스템 에러, 정상적으로 등록되지 않았습니다.");
				return "/admin/publications/modify/{idx}";
			} else {
				logger.info(publDto.getIdx() + "이 새로운 퍼블리케이션 자료로 등록되었습니다.");
				logger.info(retCode);
				return "redirect:/publications?pid=" + retCode;
			}

		} catch (Exception e) {
			// 이미지 파일 저장, publication 등록이 안되는 경우
			logger.error("[Publications ERROR] Where: new, 정상적으로 생성되지 않았습니다.");
			logger.error(e.getMessage());
			e.getStackTrace();
			return "redirect:/admin/publications/modify/{idx}";
		}

	}

	// 퍼블리케이션 삭제
	@DeleteMapping("/admin/publications/delete/{idx}")
	public String publicationsDelete(@PathVariable("idx") Long idx) {
		int retCode = publicationsService.publicationsDelete(idx);
		if (retCode == -1) {
			logger.error("시스템 에러, 팀원 삭제가 정상적이지 못했습니다.");
			return "redirect:/publications?pid=110";
		} else {
			logger.info("해당 정보를 삭제했습니다.");
			return "redirect:/publications?pid=" + retCode;
		}
	}

}
