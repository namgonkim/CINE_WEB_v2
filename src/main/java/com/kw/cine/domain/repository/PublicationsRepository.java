package com.kw.cine.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kw.cine.domain.entity.Publications;

public interface PublicationsRepository extends JpaRepository<Publications, Long> {

	// 페이지 id순으로 연구 구분 조회 JPA 220 /221 /222
		List<Publications> findByPid(int pid);
}
