package com.kw.cine.domain.entity;

/**
 * @FileName : Ourteam.java
 * @Project : cine
 * @Date : 2021. 1. 20. 
 * @작성자 : KNG
 * @변경이력 :
 * @프로그램 설명 :
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 람복의 @Data로 getter, setter를 모두 불러와 사용할 수도 있지만
// 무분별한 setter 사용은 이루어지지 않아야 한다.
// https://www.popit.kr/%EC%8B%A4%EB%AC%B4%EC%97%90%EC%84%9C-lombok-%EC%82%AC%EC%9A%A9%EB%B2%95/
@Getter
@Entity
@Table(name = "ourteam")
@NoArgsConstructor(access =AccessLevel.PROTECTED)
public class Ourteam {
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private Long idx;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "career")
	private String career;
	
	@Column(name = "research")
	private String research;
	
	@Column(name = "imgfileId") // 이미지 번호
	private Long imgfileId;
	
	@Column(name = "imgfileSrc") // 이미지 저장된 주소
	private String imgfileSrc;
	
	@Column(name = "pid")
	private int pid;
	
	// 빌터패턴 클래스 생성 어노테이션
	// @Setter 대신 빌더패턴을 사용해야 안정성을 보장할 수 있음.
	@Builder
	public Ourteam(Long idx, String name, String email, String career, String research, Long imgfileId, String imgfileSrc, int pid) {
		this.idx = idx;
		this.name = name;
		this.email = email;
		this.career = career;
		this.research = research;
		this.imgfileId = imgfileId;
		this.imgfileSrc = imgfileSrc;
		this.pid = pid;
	}

}
