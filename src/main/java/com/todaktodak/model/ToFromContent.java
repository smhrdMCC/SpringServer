package com.todaktodak.model;

import lombok.Data;

@Data
public class ToFromContent {
	private String toUser;
	private String fromUser;
	private String content;
	
	public String toString() {
		return "TO_FROM_CONTENT";
	}

}
