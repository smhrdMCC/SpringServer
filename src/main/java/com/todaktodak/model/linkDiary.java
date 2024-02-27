package com.todaktodak.model;

import lombok.Data;

@Data
public class linkDiary {
	private String toUser;
	private String fromUser;
	private String content;
	private String inputcontent;
	
	public String toString() {
		return "LINK_DIARY";
	}
}
