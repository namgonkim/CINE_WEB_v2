package com.kw.cine.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kw.cine.domain.entity.Ourteam;

/**
  * @FileName : OurteamRepository.java
  * @Project : cine
  * @Date : 2021. 1. 20. 
  * @작성자 : KNG
  * @변경이력 :
  * @프로그램 설명 :
  */

public interface OurteamRepository extends JpaRepository<Ourteam, Long>{
	
	// 전형적인 CRUD는 작성할 필요가 없다.
	
	// 페이지 id순으로 팀원을 조회하는 JPA
	List<Ourteam> findByPid(int pid);
	
	
}
