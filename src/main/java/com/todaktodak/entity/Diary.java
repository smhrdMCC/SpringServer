package com.todaktodak.entity;

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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

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

	@Column(name = "created_at")
	private String createdAt;

	@OneToMany(mappedBy = "diarySeq")
	private List<FeedBack> feedback;

	public String toString() {
		return "DIARY";
	}

	public Diary() {
		
	}
	@JsonCreator
    public Diary(@JsonProperty("diarySeq") Long diarySeq) {
        this.diarySeq = diarySeq;
    }
}
