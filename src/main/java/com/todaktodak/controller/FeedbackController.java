package com.todaktodak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.todaktodak.entity.Diary;
import com.todaktodak.entity.FeedBack;
import com.todaktodak.entity.FeedBackDTO;
import com.todaktodak.repository.FeedbackRepository;
import com.todaktodak.repository.SaveFeedbackRepository;

@Controller
public class FeedbackController {
	
	@Autowired
	private FeedbackRepository repo;
	
	@Autowired
	private SaveFeedbackRepository repo2;

	@ResponseBody
	@PostMapping("/feedback")
	public String SaveText(@RequestBody String feedback) {
		FeedBack backFeed = new FeedBack();
		Diary diary = new Diary();
		System.out.println(feedback);
		Gson gson = new Gson();
		FeedBackDTO feedbackObject = gson.fromJson(feedback, FeedBackDTO.class);
		diary.setDiarySeq(feedbackObject.getDiarySeq());
		backFeed.setDiarySeq(diary);
		backFeed.setAiRecommendation(feedbackObject.getAiRecommendation());
		backFeed.setEmotionClassification("null");
		System.out.println(feedbackObject);
		repo.save(backFeed);
		//repo2.insertWithoutAiRecommendation(Seq, array[0].replaceAll("\"", ""));
		return "성공";
	}

}
