package com.todaktodak.model;

import lombok.Data;

@Data
public class RandomDiary {
	private Long seq;
	private String fromUser;
	private String nick;
	private String content;
	private String date;
	
	public String toString() {
		return "RANDOM_DIARY";
	}
	
	public RandomDiary() {
		
	}
	
	public RandomDiary(Long seq, String fromUser, String nick, String content, String date) {
		this.seq = seq;
		this.fromUser = fromUser;
		this.nick = nick;
		this.content = content;
		this.date = date;
	}
	
}
