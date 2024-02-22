package com.todaktodak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todaktodak.entity.FeedBack;


@Repository
public interface CalenderRepository extends JpaRepository<FeedBack, Long> {
	
	@Query(value = "SELECT * FROM tb_feedback WHERE created_at LIKE (:date '%') AND diary_seq IN (SELECT diary_seq FROM tb_diary WHERE user_email = :email)", nativeQuery = true)
	public List<FeedBack> findByCreatedAtLike(@Param("date") String date, @Param("email") String email);
	
}