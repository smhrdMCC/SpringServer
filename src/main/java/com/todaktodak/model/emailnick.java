package com.todaktodak.model;

import lombok.Data;

@Data
public class emailnick {
	private String email;
	private String nick;
	
	public String toString() {
		return "EMAIL_NICK";
	}
}
