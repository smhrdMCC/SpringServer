package com.todaktodak.entity;

import lombok.Data;

@Data
public class GetDiaryDTO {
	private Long diarySeq;
	private String content;
	
	public GetDiaryDTO(Long diarySeq, String content) {
		this.diarySeq = diarySeq;
		this.content = content;
	}
}