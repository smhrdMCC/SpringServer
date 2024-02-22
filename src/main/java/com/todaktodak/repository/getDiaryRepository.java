package com.todaktodak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todaktodak.entity.Diary;
import com.todaktodak.entity.User;

@Repository
public interface getDiaryRepository extends JpaRepository<Diary, Long>{
	Diary findTopByUserEmailOrderByCreatedAtDesc(User userEmail);
}
