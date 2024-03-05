package com.todaktodak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todaktodak.entity.Diary;
import com.todaktodak.entity.DiaryShare;
import com.todaktodak.entity.FeedBack;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack, Long>{
	
	List<FeedBack> findByDiarySeq(Diary diarySeq);
	
	@Query(value = "delete from tb_feedback where diary_seq = :seq", nativeQuery = true)
	public String deleteFeedDiarySeq(@Param("seq") Long seq);
	
}