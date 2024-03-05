package com.todaktodak.model;

import lombok.Data;

@Data
public class DiaryListDTO {
    private String created_at;
	
    private String emotion_classification;
	
    private String diary_content;

    public String toString() {
		return "DIARYLIST";
	}
    
	public DiaryListDTO(String created_at, String emotion_classification, String diary_content) {
		this.created_at = created_at;
		this.emotion_classification = emotion_classification;
		this.diary_content = diary_content;
	}

	public DiaryListDTO() {
		
	}
}