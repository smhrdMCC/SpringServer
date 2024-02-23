package com.todaktodak.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.todaktodak.entity.FeedBack;

@Repository
public interface SaveFeedbackRepository extends CrudRepository<FeedBack, Long> {
	//@Query(value = "SELECT * FROM tb_diary WHERE created_at LIKE (:date '%') AND user_email = :email", nativeQuery = true)
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO FeedBack (diarySeq, emotionClassification) VALUES (:diarySeq, :emotionClassification)", nativeQuery=true)
	void insertWithoutAiRecommendation(Long diarySeq, String emotionClassification);

}
