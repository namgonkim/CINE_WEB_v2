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
@Table(name = "publications")
@NoArgsConstructor(access =AccessLevel.PROTECTED)
public class Publications {
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idx")
	private Long idx;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "imgfile")
	private String imgfile;
	
	@Column(name = "pid")
	private int pid;
	
	
	@Builder
	public Publications(Long idx, String year, String content, String imgfile, int pid) {
		this.idx = idx;
		this.year = year;
		this.content = content;
		this.imgfile = imgfile;
		this.pid = pid;
	}

}
