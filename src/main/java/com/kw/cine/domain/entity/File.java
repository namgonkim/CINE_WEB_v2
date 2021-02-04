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
@Table(name = "file")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File {
	
	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "orifilename")
	private String orifilename;
	
	@Column(name = "filename")
	private String filename;
	
	@Column(name = "filepath")
	private String filepath;
	
	@Builder
	public File(Long id, String orifilename, String filename, String filepath) {
		this.id = id;
		this.orifilename = orifilename;
		this.filename = filename;
		this.filepath = filepath;
	}
	

}
