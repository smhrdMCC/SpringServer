package com.todaktodak.controller;

import java.util.ArrayList;
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
import com.todaktodak.model.DiaryListDTO;
import com.todaktodak.model.datemail;
import com.todaktodak.model.emotiondate;
import com.todaktodak.repository.CalenderRepository;
import com.todaktodak.repository.DiaryListRepository;

@Controller
public class CalenderController {

	@Autowired
	private CalenderRepository repo;
	
	@Autowired
	private DiaryListRepository repo2;
	
	@ResponseBody
	@PostMapping("/emotion")
	private String getEmotion(@RequestBody datemail inf) {
		
		System.out.println(" ");
		System.out.println("받아온 정보 " + inf);
		
		String date = inf.getDate().toString();
		String email = inf.getEmail().toString();
		
		List<FeedBack> emotion = repo.findByCreatedAtLike(date, email);
		
		System.out.println("피드백 : " + emotion);
		
		ArrayList<emotiondate> trans = new ArrayList<emotiondate>();
		
		for(int i=0; i<emotion.size(); i++) {
			trans.add(new emotiondate(emotion.get(i).getEmotionClassification(), emotion.get(i).getCreatedAt()));
		}
		
		System.out.println(trans);
		
		Gson gson = new GsonBuilder().create();
		
		String json = gson.toJson(trans);
		
		System.out.println("json 변환 " + json);	
		
		return json;
	}
	
	@ResponseBody
	@PostMapping("/dairyList")
	private String getDiaryList(@RequestBody datemail inf) {
		
		String date = inf.getDate().toString();
		String email = inf.getEmail().toString();

		System.out.println(date);
		
		List<FeedBack> feed = repo.findByCreatedAtLike(date, email);
		List<Diary> diary = repo2.findByCreatedAtAndUserEmail(date, email);
		
		System.out.println(feed.get(0).getEmotionClassification());
		System.out.println(diary.get(0).getDiaryContent());
		
		ArrayList<DiaryListDTO> trans = new ArrayList<DiaryListDTO>();
		
		for(int i=0; i<feed.size() && i<diary.size(); i++) {
			trans.add(new DiaryListDTO(diary.get(i).getCreatedAt(), feed.get(i).getEmotionClassification(), diary.get(i).getDiaryContent()));
		}
		
		System.out.println(trans.size());
		
		Gson gson = new GsonBuilder().create();
		
		String json = gson.toJson(trans);
		
		System.out.println("json 변환 " + json);
		
		return json;
	
	}
	

}
