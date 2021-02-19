package com.kw.cine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.kw.cine.domain.entity.Publications;
import com.kw.cine.domain.repository.PublicationsRepository;
import com.kw.cine.dto.PublicationsDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublicationsService {

	private PublicationsRepository publicationsRepo;

	// 퍼블리케이션 조회
	@Transactional
	public List<PublicationsDto> findByPid(int pid) {
		List<Publications> publList = publicationsRepo.findByPid(pid); // TO DO
		List<PublicationsDto> publDtoList = new ArrayList<>();
		// 빌더를 통해 Entity 객체 데이터를 Dto에도 전달
		for (Publications publicationsEntity : publList) {
			// Dto 빌드
			PublicationsDto publicationsDto = PublicationsDto.builder()
					.idx(publicationsEntity.getIdx())
					.year(publicationsEntity.getYear())
					.content(publicationsEntity.getContent())
					.imgfileId(publicationsEntity.getImgfileId())
					.imgfileSrc(publicationsEntity.getImgfileSrc())
					.pid(publicationsEntity.getPid())
					.build();
			// 리스트에 추가
			publDtoList.add(publicationsDto);
		}

		return publDtoList;
	}

	// 새 퍼블리케이션 등록 POST
	@Transactional
	public int saveNew(PublicationsDto publDto) {
		return publicationsRepo.save(publDto.toEntity()).getPid();
	}

	// 퍼플리케이션 정보 수정 Get
	@Transactional
	public PublicationsDto getPublications(Long idx) {
		// 팀원 중에서 수정할 팀원을 골라 가져옴
		Optional<Publications> publicationsEntityWrapper = publicationsRepo.findById(idx);
		if(!publicationsEntityWrapper.isPresent()) {
			return null;
			/*
			PublicationsDto nonDto = PublicationsDto.builder()
					.retcode("409") // DB 충돌, 수정하는 중간에 삭제를 한다면? -> 충돌 코드
					.build();
			return nonDto;
			*/
		}
		Publications publicationsEntity = publicationsEntityWrapper.get();

		PublicationsDto publicationsDto = PublicationsDto.builder()
				.idx(publicationsEntity.getIdx())
				.year(publicationsEntity.getYear())
				.content(publicationsEntity.getContent())
				.imgfileId(publicationsEntity.getImgfileId())
				.imgfileSrc(publicationsEntity.getImgfileSrc())
				.pid(publicationsEntity.getPid())
				.build();

		return publicationsDto;
	}

	// 퍼플리케이션 정보 수정 Put
	@Transactional
	public int publicationsUpdate(PublicationsDto publDto) {
		return publicationsRepo.save(publDto.toEntity()).getPid();
	}

	// 퍼플리케이션 정보 삭제 Delete
	@Transactional
	public int publicationsDelete(Long idx) {
		// TODO Auto-generated method stub
		Publications publicationsEntity = publicationsRepo.getOne(idx);
		int pid = publicationsEntity.getPid();
		publicationsRepo.deleteById(idx);
		return pid;
	}

}
