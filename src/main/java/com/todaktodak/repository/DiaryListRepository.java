package com.todaktodak.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todaktodak.entity.Diary;


@Repository
public interface DiaryListRepository extends JpaRepository<Diary, Long> {

	@Query(value = "SELECT * FROM tb_diary WHERE created_at LIKE (:date '%') AND user_email = :email", nativeQuery = true)
	public List<Diary> findByCreatedAtAndUserEmail(@Param("date") String date, @Param("email") String email);
	
}
