package com.todaktodak.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todaktodak.entity.Diary;
import com.todaktodak.entity.User;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@ComponentScan
@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
	
	

}