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
@Table(name = "tb_feedback")
public class FeedBack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_seq")
	private Long feedbackSeq;
	
	@ManyToOne
	@JoinColumn(name = "diarySeq")
	private Diary diarySeq;
	
	@Column(name = "emotion_classification")
	private String emotionClassification;
	
	@Column(name = "ai_recommendation")
	private String aiRecommendation;
	
	@Column(name = "created_at")
	private String createdAt;
	
	public String toString() {
		return "FEEDBACK";
	}

}
