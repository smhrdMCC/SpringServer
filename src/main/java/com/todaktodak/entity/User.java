package com.todaktodak.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_user")
public class User {

	@Id
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_nick")
	private String userNick;
	
	@Column(insertable = false, updatable = false,columnDefinition = "datetime default now()",name="joined_at")
	private Date joinedAt;
	
	@OneToMany(mappedBy = "userEmail")
	private List<Diary> diary;
	
	@OneToMany(mappedBy = "userEmail")
	private List<DiaryShare> diaryShare;
	
	public User() {
    }
	
	public String toString() {
		return "USER";
	}
}