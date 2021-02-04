package com.kw.cine.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kw.cine.auth.service.MemberService;
import com.kw.cine.dto.FileDto;
import com.kw.cine.dto.OurteamDto;
import com.kw.cine.service.FileService;
import com.kw.cine.service.OurteamService;
import com.kw.cine.util.MD5Generator;

import lombok.AllArgsConstructor;

/**
 * @FileName : OurteamController.java
 * @Project : cine
 * @Date : 2021. 1. 20.
 * @작성자 : KNG
 * @변경이력 :
 * @프로그램 설명 :
 */

// @AllArgsConstructor 해당 어노테이션을 통해 생성자로 Bean 객체를 받는 방식을 해결
// 따라서 Service 객체를 주입받을 때 @Autowired 어노테이션을 부여하지 않아도 된다.
@Controller
@AllArgsConstructor
public class OurteamController {

	private static final Logger logger = LogManager.getLogger(OurteamController.class);

	// @Autowired
	OurteamService ourteamService;
	MemberService memberService;
	FileService fileService;

	// 팀원 조회 페이지
	@GetMapping("/ourteam")
	public ModelAndView ourteamList(@RequestParam("pid") int pid) {
		List<OurteamDto> teamlist = ourteamService.findByPid(pid);
		ModelAndView mv = new ModelAndView("ourteam");
		mv.addObject("title", "Ourteams");
		String category = null;
		if (teamlist.isEmpty()) {
			logger.info("팀원이 없습니다! 팀원을 모집하십시요!");
			mv.addObject("TeamIsEmpty", true);
		} else
			mv.addObject("TeamIsEmpty", false);
		logger.info("ourteam access success");
		switch (pid) {
		case (0):
			category = "Ph.D Course";
			break;
		case (1):
			category = "M.S Course";
			break;
		case (2):
			category = "Intern";
			break;
		case (3):
			category = "Alumni";
			break;
		}
		mv.addObject("category", category);
		mv.addObject("teamlist", teamlist);
		return mv;
	}

	// 팀원 등록 GET
	@GetMapping("/admin/ourteam/new")
	public ModelAndView ourteamNew() {
		ModelAndView mv = new ModelAndView("ourteam/new");
		logger.info("ourteam/new access success");
		mv.addObject("title", "New Member");
		return mv;
	}

	/*
	 * 팀원 등록 POST 변경할 사항: AJAX 콜을 통한 비동기 post 처리로 변환할 것, 이미지 업로드 기능 추가할 것
	 */
	@PostMapping("/admin/ourteam/new")
	public String postOurteamNew(@RequestParam("imgfile") MultipartFile files, OurteamDto teamDto,
			HttpServletRequest request) {
		try {
			
			String oriFilename = files.getOriginalFilename(); // 파일 원래 이름
			String filename = new MD5Generator(oriFilename).toString(); // 파일 변환 이름
			String sourceFileNameExtension = FilenameUtils.getExtension(oriFilename).toLowerCase(); // 파일 확장자
			// 변환된 파일 이름에 확장자를 붙인다
			filename = filename + "." + sourceFileNameExtension;
			// 실행되는 위치의 'images' 폴더에 파일이 저장된다.
			
			String savePath = System.getProperty("user.dir") + "\\images";
			
			// 파일이 저장되는 폴더가 없다면 폴더를 생성
			if (!new File(savePath).exists()) {
				try {
					new File(savePath).mkdir();
				} catch (Exception e) { // 이미지 파일을 저장할 폴더가 제대로 생성되지 않은 경우
					logger.error("시스템 에러, 정상적으로 이미지 폴더가 생성되지 않았습니다.");
					logger.error(e.getMessage());
					e.getStackTrace();
					return "/admin/ourteam/new";
				}
			}
			 
			// 파일 경로 저장
			String filePath = savePath + "\\" + filename;
			files.transferTo(new File(filePath));
			// Dto에 저장
			FileDto fileDto = new FileDto();
			fileDto.setOrifilename(oriFilename);
			fileDto.setFilename(filename);
			fileDto.setFilepath(filePath);
			
			// 파일 서비스
			Long fileId = fileService.saveFile(fileDto);
			teamDto.setImgfileId(fileId);
			teamDto.setImgfileSrc(fileDto.getFilename());
			int retCode = ourteamService.saveNew(teamDto);
			if (retCode == -1) {
				logger.error("시스템 에러, 정상적으로 등록되지 않았습니다.");
				return "redirect:/admin/ourteam/new";
			} else {
				logger.info(teamDto.getName() + "님이 새로운 팀원으로 등록되었습니다.");
				logger.info(retCode);
				return "redirect:/ourteam?pid=" + retCode;
			}

		} catch (Exception e) {
			// 이미지 파일 저장이 안된 경우
			logger.error("시스템 에러, 정상적으로 이미지파일이 저장되지 않았습니다.");
			logger.error(e.getMessage());
			e.getStackTrace();
			return "redirect:/admin/ourteam/new";
		}
	}

	// 팀원 수정 GET
	@GetMapping("/admin/ourteam/modify/{idx}")
	public ModelAndView ourteamModify(@PathVariable("idx") Long idx) {
		OurteamDto teamDto = ourteamService.getMember(idx);
		ModelAndView mv = null;
		if (teamDto == null) {
			logger.error("시스템 에러, 팀원 정보를 불러오지 못했습니다.");
			String num = Long.toString(idx);
			mv = new ModelAndView("ourteam?pid=" + num);
			return mv;
		} else {
			logger.info(teamDto.getName() + "님의 정보를 수정합니다.");
			mv = new ModelAndView("ourteam/modify");
			mv.addObject("title", "Update Member");
			mv.addObject("teamDto", teamDto);
			return mv;
		}
	}

	/*
	 * 팀원 수정 POST 변경할 사항: AJAX 콜을 통한 비동기 post 처리로 변환할 것, 이미지 업로드 기능 추가할 것
	 */
	@PutMapping("/admin/ourteam/modify/{idx}")
	public String ourteamUpdate(OurteamDto teamDto) {
		// teamDto.setImgfile("https://placeimg.com/365/376/any");
		int retCode = ourteamService.ourteamUpdate(teamDto);
		if (retCode == -1) {
			logger.error("시스템 에러, 정상적으로 수정되지 않았습니다.");
			return "/admin/ourteam/modify/{idx}";
		} else {
			logger.info(teamDto.getName() + "님의 정보가 수정되었습니다.");
			return "redirect:/ourteam?pid=" + retCode;
		}
	}

	// 팀원 삭제
	@DeleteMapping("/admin/ourteam/delete/{idx}")
	public String ourteamDelete(@PathVariable("idx") Long idx) {
		OurteamDto teamDto = ourteamService.getMember(idx);
		fileService.fileDelete(teamDto.getImgfileId(), teamDto.getImgfileSrc());
		int retCode = ourteamService.ourteamDelete(idx);
		if (retCode == -1) {
			logger.error("시스템 에러, 팀원 삭제가 정상적이지 못했습니다.");
			return "redirect:/ourteam?pid=0";
		} else {
			logger.info("해당 정보를 삭제했습니다.");
			return "redirect:/ourteam?pid=" + retCode;
		}
	}

}
