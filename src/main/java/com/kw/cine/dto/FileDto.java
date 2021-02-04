package com.kw.cine.dto;

import com.kw.cine.domain.entity.File;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class FileDto {
	private Long id;
	private String orifilename;
	private String filename;
	private String filepath;
	
	public File toEntity() {
		File file = File.builder()
				.id(id).orifilename(orifilename).filename(filename).filepath(filepath)
				.build();
		
		return file;
	}
	
	@Builder
	public FileDto(Long id, String orifilename, String filename, String filepath) {
		this.id = id;
		this.orifilename = orifilename;
		this.filename = filename;
		this.filepath = filepath;
	}
}
