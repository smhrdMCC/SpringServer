package com.todaktodak.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.todaktodak.serializer.diarySerializer;

import lombok.Data;

@Data
@Entity
@Table(name = "emotiondate")
public class FeedBack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_seq")
	private Long feedbackSeq;
	
	@ManyToOne
	@JsonSerialize(using = diarySerializer.class)
	@JoinColumn(name = "diarySeq")
	private Diary diarySeq;
	
	@Column(name = "emotion_classification")
	private String emotionClassification;
	
	@Column(name = "ai_recommendation")
	private String aiRecommendation;
	
	@Column(insertable = false,updatable = false,columnDefinition = "datetime default now()", name = "created_at")
	private String createdAt;
	
	public String toString() {
		return "FEEDBACK";
	}

}
