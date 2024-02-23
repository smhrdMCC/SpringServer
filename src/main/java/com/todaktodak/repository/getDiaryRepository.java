package com.todaktodak.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todaktodak.entity.Diary;
import com.todaktodak.entity.User;

@Repository
public interface getDiaryRepository extends JpaRepository<Diary, Long>{
	
	@Query(value="select * from tb_diary where user_email = :email and created_at = :date", nativeQuery = true)
	ArrayList<Diary> findTopByUserEmailOrderByCreatedAtDesc(String email, String date);
}