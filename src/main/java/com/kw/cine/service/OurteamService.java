package com.kw.cine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.kw.cine.domain.entity.Ourteam;
import com.kw.cine.domain.repository.OurteamRepository;
import com.kw.cine.dto.OurteamDto;

import lombok.AllArgsConstructor;

/**
  * @FileName : OurteamService.java
  * @Project : cine
  * @Date : 2021. 1. 20. 
  * @작성자 : KNG
  * @변경이력 :
  * @프로그램 설명 :
  */

@AllArgsConstructor
@Service
public class OurteamService {
	
	// @Autowired
	OurteamRepository ourteamRepo;
	
	
	// 연구실 전원 조회해 리스트 형태로 가져오기
	@Transactional
	public List<Ourteam> findAll() {
		List<Ourteam> list = ourteamRepo.findAll();
		return list;
	}
	
	// 석사, 박사 대학원 과정 구분하여 조회한 뒤 리스트 형태로 가져오기
	@Transactional
	public List<OurteamDto> findByPid(int pid) {
		List<Ourteam> teamlist = ourteamRepo.findByPid(pid); // TO DO
		List<OurteamDto> teamDtolist = new ArrayList<>();
		// 빌더를 통해 Entity 객체 데이터를 Dto에도 전달
		for(Ourteam ourteamEntity : teamlist) {
			// Dto 빌드
			OurteamDto teamDto = OurteamDto.builder()
					.idx(ourteamEntity.getIdx())
					.name(ourteamEntity.getName())
					.email(ourteamEntity.getEmail())
					.career(ourteamEntity.getCareer())
					.research(ourteamEntity.getResearch())
					.imgfileId(ourteamEntity.getImgfileId())
					.imgfileSrc(ourteamEntity.getImgfileSrc())
					.pid(ourteamEntity.getPid())
					.build();
			// 리스트에 추가
			teamDtolist.add(teamDto);
		}
		
		return teamDtolist;
	}

	// 새로운 팀원 등록 Post
	@Transactional
	public int saveNew(OurteamDto teamDto) {
		return ourteamRepo.save(teamDto.toEntity()).getPid();
	}

	// 팀원 정보 수정 Get
	@Transactional
	public OurteamDto getMember(Long idx) {
		// 팀원 중에서 수정할 팀원을 골라 가져옴
		Optional<Ourteam> ourteamEntityWrapper = ourteamRepo.findById(idx);
		Ourteam ourteamEntity = ourteamEntityWrapper.get();
		
		OurteamDto teamDto = OurteamDto.builder()
				.idx(ourteamEntity.getIdx())
				.name(ourteamEntity.getName())
				.email(ourteamEntity.getEmail())
				.career(ourteamEntity.getCareer())
				.research(ourteamEntity.getResearch())
				.imgfileId(ourteamEntity.getImgfileId())
				.imgfileSrc(ourteamEntity.getImgfileSrc())
				.pid(ourteamEntity.getPid())
				.build();
		
		return teamDto;
	}
	
	// 팀원 정보 수정 Put
	@Transactional
	public int ourteamUpdate(OurteamDto teamDto) {
		// TODO Auto-generated method stub
		return ourteamRepo.save(teamDto.toEntity()).getPid();
	}

	//팀원 정보 삭제 Delete
	@Transactional
	public int ourteamDelete(Long idx) {
		// TODO Auto-generated method stub
		Ourteam ourteamEntity = ourteamRepo.getOne(idx);
		int pid = ourteamEntity.getPid();
		ourteamRepo.deleteById(idx);
		return pid;
	}

}
