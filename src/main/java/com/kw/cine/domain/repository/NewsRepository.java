package com.kw.cine.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kw.cine.domain.entity.News;

public interface NewsRepository extends JpaRepository<News, Long> {

	// 페이지 id순으로 연구 구분 조회 JPA
		List<News> findByPid(int pid);
}
