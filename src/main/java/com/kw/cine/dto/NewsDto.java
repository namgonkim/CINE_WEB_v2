package com.kw.cine.dto;

import com.kw.cine.domain.entity.News;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NewsDto {
	
	private Long idx;
	private String title;
	private String content;
	private String imgfile;
	private int pid;
	
	public News toEntity() {
		News newsEntity = News.builder()
				.idx(idx).title(title).content(content).imgfile(imgfile).pid(pid)
				.build();
		return newsEntity;
	}
	
	@Builder
	public NewsDto(Long idx, String title, String content, String imgfile, int pid) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.imgfile = imgfile;
		this.pid = pid;
	}

}
