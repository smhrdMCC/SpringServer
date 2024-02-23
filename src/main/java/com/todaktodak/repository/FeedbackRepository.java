package com.todaktodak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todaktodak.entity.FeedBack;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack, Long>{
	
}