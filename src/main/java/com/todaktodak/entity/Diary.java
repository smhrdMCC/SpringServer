package com.todaktodak.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_diary")
public class Diary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "diary_seq")
	private Long diarySeq;
	
	@ManyToOne
	@JoinColumn(name = "user_email")
	private User userEmail;
	
	@Column(name = "diary_content")
	private String diaryContent;
	
	
	@Column(name = "created_at", insertable = false,updatable = false,columnDefinition = "datetime default now()")
	private String createdAt;
	
	@OneToMany(mappedBy = "diarySeq")
	private List<FeedBack> feedback;
	
	public String toString() {
		return "DIARY";
	}

//	public String setUserEmail(String userEmail) {
//		
//		return "userEmail";
//		
//	}
}
