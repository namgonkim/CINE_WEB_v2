package com.kw.cine.auth.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kw.cine.auth.domain.entity.MemberEntity;
import com.kw.cine.auth.dto.MemberDto;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
	
    Optional<MemberEntity> findByEmail(String userEmail);
}