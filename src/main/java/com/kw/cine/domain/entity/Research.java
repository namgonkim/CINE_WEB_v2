package com.kw.cine.domain.entity;

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

@Getter
@Entity
@Table(name = "research")
@NoArgsConstructor(access =AccessLevel.PROTECTED)
public class Research {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private Long idx;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "imgfileId") // 이미지 번호
	private Long imgfileId;
	
	@Column(name = "imgfileSrc") // 이미지 저장된 주소
	private String imgfileSrc;
	
	@Column(name = "pid")
	private int pid;
	
	
	@Builder
	public Research(Long idx, String title, String content, Long imgfileId, String imgfileSrc, int pid) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.imgfileId = imgfileId;
		this.imgfileSrc = imgfileSrc;
		this.pid = pid;
	}
}
