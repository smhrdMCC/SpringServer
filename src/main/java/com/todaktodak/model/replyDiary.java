package com.todaktodak.model;

import lombok.Data;

@Data
public class replyDiary {
	private String email;
	private String nick;
	private String content;
	private String date;
	
	public String toString() {
		return "REPLYDIARY";
	}
	
	public replyDiary(String email, String nick, String content, String date) {
		this.email = email;
		this.nick = nick;
		this.content = content;
		this.date = date;
	}

	public replyDiary() {

	}
}
