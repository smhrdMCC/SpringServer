package com.todaktodak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todaktodak.entity.Diary;
import com.todaktodak.entity.User;
import com.todaktodak.repository.DiaryRepository;

@Controller
public class DiaryController {

	@Autowired
	private DiaryRepository repo;

	@ResponseBody
	@RequestMapping("/diary")
	public String saveDiary(@RequestBody String userDiary) {

		Diary diary = new Diary();
		User user = new User();

		String saveDiary = userDiary.replaceAll("\"", "");
		String[] save = saveDiary.split(":");
		String diaryContent = save[0];
		String userEmail = save[1];

		user.setUserEmail(userEmail);

		diary.setDiaryContent(diaryContent);
		diary.setUserEmail(user);
		diary.setCreatedAt(save[2]);
		
		repo.save(diary);
		
		System.out.println(diary.getDiarySeq());
		

		return diary.getDiarySeq().toString();
	}

}
