package com.kw.cine.dto;

import com.kw.cine.domain.entity.Publications;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PublicationsDto {
	
	private Long idx;
	private String year;
	private String content;
	private String imgfile;
	private int pid;
	
	public Publications toEntity() {
		Publications publicationsEntity = Publications.builder()
				.idx(idx).year(year).content(content).imgfile(imgfile).pid(pid)
				.build();
		return publicationsEntity;
	}
	
	@Builder
	public PublicationsDto(Long idx, String year, String content, String imgfile, int pid) {
		this.idx = idx;
		this.year = year;
		this.content = content;
		this.imgfile = imgfile;
		this.pid = pid;
	}

}
