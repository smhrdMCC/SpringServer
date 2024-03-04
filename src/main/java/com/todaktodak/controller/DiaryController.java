package com.todaktodak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todaktodak.entity.Diary;
import com.todaktodak.entity.User;
import com.todaktodak.repository.DiaryRepository;
import com.todaktodak.repository.FeedbackRepository;

@Controller
public class DiaryController {

	@Autowired
	private DiaryRepository repo;
	
	private FeedbackRepository repo2;

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
		
		return diary.getDiarySeq().toString();
	}
	
	@ResponseBody
	@RequestMapping("/alterDiary")
	public String alterDiary(@RequestBody String info) {
		
		Diary diary = new Diary();
		User user = new User();
		
		String alterDiary = info.replaceAll("\"", "");
		String[] alter = alterDiary.split(":");
		Long seq = Long.parseLong(alter[0]);
		String diaryContent = alter[1];
		String userEmail = alter[2];
		
		repo2.deleteFeedDiarySeq(seq);
		repo.deleteDiaryDiarySeq(seq);
		
		diary.setDiaryContent(diaryContent);
		diary.setUserEmail(user);
		diary.setCreatedAt(alter[3]);
		
		repo.save(diary);
		
		return "alterDiary";
	}

}
