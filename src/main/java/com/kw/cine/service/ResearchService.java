package com.kw.cine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.kw.cine.domain.entity.Research;
import com.kw.cine.domain.repository.ResearchRepository;
import com.kw.cine.dto.ResearchDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResearchService {

	private ResearchRepository researchRepo;

	// 연구자료 조회
	@Transactional
	public List<ResearchDto> findByPid(int pid) {
		List<Research> rechList = researchRepo.findByPid(pid); // TO DO
		List<ResearchDto> rechDtoList = new ArrayList<>();
		// 빌더를 통해 Entity 객체 데이터를 Dto에도 전달
		for (Research researchEntity : rechList) {
			// Dto 빌드
			ResearchDto researchDto = ResearchDto.builder().idx(researchEntity.getIdx())
					.title(researchEntity.getTitle()).content(researchEntity.getContent())
					.imgfile(researchEntity.getImgfile()).pid(researchEntity.getPid()).build();
			// 리스트에 추가
			rechDtoList.add(researchDto);
		}

		return rechDtoList;
	}

	// 새 연구자료 등록 POST
	@Transactional
	public int saveNew(ResearchDto rechDto) {
		return researchRepo.save(rechDto.toEntity()).getPid();
	}

	// 팀원 정보 수정 Get
	@Transactional
	public ResearchDto getResearch(Long idx) {
		// 팀원 중에서 수정할 팀원을 골라 가져옴
		Optional<Research> researchEntityWrapper = researchRepo.findById(idx);
		Research researchEntity = researchEntityWrapper.get();

		ResearchDto researchDto = ResearchDto.builder().idx(researchEntity.getIdx()).title(researchEntity.getTitle())
				.content(researchEntity.getContent()).imgfile(researchEntity.getImgfile()).pid(researchEntity.getPid())
				.build();

		return researchDto;
	}

	// 리서치 정보 수정 Put
	@Transactional
	public int researchUpdate(ResearchDto rechDto) {
		// TODO Auto-generated method stub
		return researchRepo.save(rechDto.toEntity()).getPid();
	}

	// 리서치 정보 삭제 Delete
	@Transactional
	public int researchDelete(Long idx) {
		// TODO Auto-generated method stub
		Research researchEntity = researchRepo.getOne(idx);
		int pid = researchEntity.getPid();
		researchRepo.deleteById(idx);
		return pid;
	}

}
