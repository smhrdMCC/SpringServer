package com.todaktodak.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_diary_share")
public class DiaryShare{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "share_seq")
	private Long shareSeq;
	
	@ManyToOne
	@JoinColumn(name = "user_email")
	private User userEmail;
	
	@Column(name = "to_user")
	private String toUser;
	
	@Column(name = "diary_content")
	private String diaryContent;
	
	@Column(name = "created_at")
	private String createdAt;
	
	public String toString() {
		return "SHARE";
	}
}
