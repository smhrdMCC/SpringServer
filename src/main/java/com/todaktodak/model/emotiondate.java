package com.todaktodak.model;

import lombok.Data;

@Data
public class emotiondate {
	
	private String emotion;
	
	private String createdAt;
	
	public String toString() {
		return "EMOTIONDATE";
	}

	public emotiondate(String emotion, String createdAt) {
		this.emotion = emotion;
		this.createdAt = createdAt;
	}
	
}
