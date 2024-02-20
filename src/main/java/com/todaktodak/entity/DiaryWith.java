package com.todaktodak.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_diary_with")
public class DiaryWith {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "diary_seq")
	private Long diarySeq;
	
	@Column(name = "diary_content")
	private String diaryContent;
	
	@Column(name = "created_at")
	private String createdAt;
	
	@OneToMany(mappedBy = "diarySeq")
	private List<DiaryShare> diaryShare;
	
	public String toString() {
		return "DIARY_WITH";
	}
}