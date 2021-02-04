package com.kw.cine.dto;

import com.kw.cine.domain.entity.Research;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResearchDto {
	
	private Long idx;
	private String title;
	private String content;
	private String imgfile;
	private int pid;
	
	public Research toEntity() {
		Research researchEntity = Research.builder()
				.idx(idx).title(title).content(content).imgfile(imgfile).pid(pid)
				.build();
		return researchEntity;
	}
	
	@Builder
	public ResearchDto(Long idx, String title, String content, String imgfile, int pid) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.imgfile = imgfile;
		this.pid = pid;
	}

}
