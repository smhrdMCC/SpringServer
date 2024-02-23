package com.todaktodak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.todaktodak.entity.Diary;
import com.todaktodak.entity.User;
import com.todaktodak.repository.getDiaryRepository;

@Controller
public class getDiaryController {

	@Autowired
	private getDiaryRepository repo;

	@ResponseBody
	@PostMapping("/getmsg")
	public String getmsg(@RequestBody User userEmail) {
		
		Diary getDiary = new Diary();
		getDiary.setUserEmail(userEmail);
		
		getDiary = repo.findTopByUserEmailOrderByCreatedAtDesc(userEmail);
		String DiaryContent = getDiary.getDiaryContent();
		Long DiaryCreatedAt = getDiary.getDiarySeq();
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(DiaryContent + ":" +DiaryCreatedAt);
		
		return json;
	}

}

