package com.kw.cine.dto;
/**
 * @FileName : OurteamDto.java
 * @Project : cine
 * @Date : 2021. 1. 22. 
 * @작성자 : KNG
 * @변경이력 :
 * @프로그램 설명 : JPA를 사용하게 되면 Entity와 DB 테이블이 1대1 매핑이 되기에 자칫 치명적인 결함이 발생할 수 있다.
 * 			 이에 Dto를 사용하여 서버 아래단에서는 Entity를 활용하고 서버 위단에서는 Dto를 사용한다.
 * 			 dto는 Controller <-> Service <-> Repository 간에 필요한 데이터를 캡슐화한 데이터 전달 객체
 * 			 각 계층에서 필요한 객체전달은 Entity 객체가 아닌 dto 객체를 통해 주고받는 것이 좋다
 */

import com.kw.cine.domain.entity.Ourteam;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OurteamDto {
	
	private Long idx;
	private String name;
	private String email;
	private String career;
	private String research;
	private Long imgfileId;
	private String imgfileSrc;
	private int pid;
	
	public Ourteam toEntity() {
		Ourteam ourteamEntity = Ourteam.builder()
				.idx(idx).name(name).email(email).career(career)
				.research(research).imgfileId(imgfileId).imgfileSrc(imgfileSrc).pid(pid)
				.build();
		return ourteamEntity;
	}
	
	@Builder
	public OurteamDto(Long idx, String name, String email, String career, String research, Long imgfileId, String imgfileSrc, int pid) {
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
