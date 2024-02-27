package com.todaktodak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todaktodak.entity.Diary;
import com.todaktodak.entity.FeedBack;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack, Long>{
	
	//List<FeedBack> findByDiarySeqAndCreatedAt(Long diarySeq, String createdAt);
	List<FeedBack> findByDiarySeq(Diary diarySeq);
	
}