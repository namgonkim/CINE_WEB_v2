package com.kw.cine.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kw.cine.domain.entity.Files;

public interface FileRepository extends JpaRepository<Files, Long>{
	
	// To do

}
