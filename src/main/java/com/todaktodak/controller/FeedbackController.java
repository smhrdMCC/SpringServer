package com.todaktodak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todaktodak.entity.FeedBack;
import com.todaktodak.repository.FeedbackRepository;

@Controller
public class FeedbackController {
	
	@Autowired
	private FeedbackRepository repo;


	@ResponseBody
	@PostMapping("/feedback")
	public String SaveText(@RequestBody String feedback) {
		FeedBack backFeed = new FeedBack();
		System.out.println(feedback);
		String[] array = feedback.split(":");
		
		backFeed.setAiRecommendation(array[0].replaceAll("\"", ""));
		repo.save(backFeed);
		
		
		
		return "성공";
	}

}
