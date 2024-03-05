package com.todaktodak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
		
		System.out.println("feedback : " + feedback);
		FeedBack backFeed = new FeedBack();
		Diary diary = new Diary();
		FeedBackDTO dto = new FeedBackDTO();

		String saveData = feedback.replaceAll("\"", "");
		String[] array = saveData.split(":");

		dto.setDiarySeq(Long.parseLong(array[1]));
		diary.setDiarySeq(dto.getDiarySeq());

		backFeed.setDiarySeq(diary);
		backFeed.setAiRecommendation(array[0]);
		backFeed.setEmotionClassification(array[2]);
		backFeed.setCreatedAt(array[3]);

		repo.save(backFeed);
		return "성공";
	}

	@ResponseBody
	@PostMapping("/getFeedBackMessage")
	public String SendFeedBackText(@RequestBody String feedback) {
		
		String data = feedback.replaceAll("\"", "");
		Diary diary = new Diary();
		diary.setDiarySeq(Long.parseLong(data));
		
		List<FeedBack> list = repo.findByDiarySeq(diary);
		
		Gson gson = new GsonBuilder().create();

		String json = gson.toJson(list.get(0).getAiRecommendation());

		return json;
		
	}

}