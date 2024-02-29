package com.todaktodak.model;

import lombok.Data;

@Data
public class SeqMailContent {
	private Long seq;
	private String email;
	private String content;
	
	public String toString() {
		return "SEQ_MAIL_CONTENT";
	}
	
	public SeqMailContent(Long seq, String email, String content) {
		this.seq = seq;
		this.email = email;
		this.content = content;
	}
	public SeqMailContent() {
	}
	
}
