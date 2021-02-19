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
	private Long imgfileId;
	private String imgfileSrc;
	private int pid;
	
	public Research toEntity() {
		Research researchEntity = Research.builder()
				.idx(idx).title(title).content(content).imgfileId(imgfileId).imgfileSrc(imgfileSrc).pid(pid)
				.build();
		return researchEntity;
	}
	
	@Builder
	public ResearchDto(Long idx, String title, String content, Long imgfileId, String imgfileSrc, int pid) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.imgfileId = imgfileId;
		this.imgfileSrc = imgfileSrc;
		this.pid = pid;
	}

}
