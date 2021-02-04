package com.kw.cine.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.kw.cine.domain.entity.News;
import com.kw.cine.domain.repository.NewsRepository;
import com.kw.cine.dto.NewsDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NewsService {

	private NewsRepository newsRepo;

	// 뉴스 조회
	@Transactional
	public List<NewsDto> findAll() {
		List<News> newsList = newsRepo.findAll(); // TO DO
		List<NewsDto> newsDtoList = new ArrayList<>();
		// 빌더를 통해 Entity 객체 데이터를 Dto에도 전달
		for (News newsEntity : newsList) {
			// Dto 빌드
			NewsDto newsDto = NewsDto.builder().idx(newsEntity.getIdx()).title(newsEntity.getTitle())
					.content(newsEntity.getContent()).imgfile(newsEntity.getImgfile()).pid(newsEntity.getPid()).build();
			// 리스트에 추가
			newsDtoList.add(newsDto);
		}

		return newsDtoList;
	}

	// 새 뉴스 등록 POST
	@Transactional
	public int saveNew(NewsDto newsDto) {
		return newsRepo.save(newsDto.toEntity()).getPid();
	}

	// 뉴스 정보 수정 Get
	@Transactional
	public NewsDto getNews(Long idx) {
		// 팀원 중에서 수정할 팀원을 골라 가져옴
		Optional<News> newsEntityWrapper = newsRepo.findById(idx);
		News newsEntity = newsEntityWrapper.get();

		NewsDto newsDto = NewsDto.builder().idx(newsEntity.getIdx()).title(newsEntity.getTitle())
				.content(newsEntity.getContent()).imgfile(newsEntity.getImgfile()).pid(newsEntity.getPid())
				.build();

		return newsDto;
	}

	// 뉴스 정보 수정 Put
	@Transactional
	public int newsUpdate(NewsDto newsDto) {
		return newsRepo.save(newsDto.toEntity()).getPid();
	}

	// 뉴스 정보 삭제 Delete
	@Transactional
	public int newsDelete(Long idx) {
		// TODO Auto-generated method stub
		News newsEntity = newsRepo.getOne(idx);
		int pid = newsEntity.getPid();
		newsRepo.deleteById(idx);
		return pid;
	}

}
