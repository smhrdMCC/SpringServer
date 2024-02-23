package com.todaktodak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todaktodak.entity.Diary;
import com.todaktodak.entity.FeedBack;
import com.todaktodak.entity.FeedBackDTO;
import com.todaktodak.repository.FeedbackRepository;

@Controller
public class FeedbackController {

	@Autowired
	private FeedbackRepository repo;

	@ResponseBody
	@PostMapping("/feedback")
	public String SaveText(@RequestBody String feedback) {
		FeedBack backFeed = new FeedBack();
		Diary diary = new Diary();
		FeedBackDTO dto = new FeedBackDTO();

		String saveData = feedback.replaceAll("\"", "");
		String[] array = saveData.split(":");

		dto.setDiarySeq(Long.parseLong(array[1]));
		diary.setDiarySeq(dto.getDiarySeq());

		backFeed.setDiarySeq(diary);
		backFeed.setAiRecommendation(array[0]);
		backFeed.setEmotionClassification("기쁨");

		repo.save(backFeed);
		return "성공";
	}

}
