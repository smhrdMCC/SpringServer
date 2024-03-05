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
import com.todaktodak.entity.DiaryShare;
import com.todaktodak.entity.User;
import com.todaktodak.entity.userUser;
import com.todaktodak.model.MailContent;
import com.todaktodak.model.RandomDiary;
import com.todaktodak.model.ToFromContent;
import com.todaktodak.model.linkDiary;
import com.todaktodak.model.replyDiary;
import com.todaktodak.repository.SocialDiaryRepository;
import com.todaktodak.repository.UserRepository;

@Controller
public class SocialDiaryController {
	
	@Autowired
	private SocialDiaryRepository repo;
	
	@Autowired
	private UserRepository repo2;
	
	@ResponseBody
	@PostMapping("getReplyDiaryList")
	private String getReplyDiaryList(@RequestBody String email) {
		
		String saveData = email.replaceAll("\"", "");
		
		List<DiaryShare> diary = repo.getReplyDiaryList(saveData);
		
		ArrayList<String> nicklist = new ArrayList<String>();
		
		for(int i=0; i<diary.size(); i++) {
			String a = diary.get(i).getUserEmail().getUserEmail();
			User b = repo2.getNick(a);
			nicklist.add(b.getUserNick());
		}
		
		ArrayList<replyDiary> result = new ArrayList<replyDiary>();
		
		for(int i = 0; i < diary.size(); i++) {
		    boolean isDuplicate = false;
		    for(int j = 0; j < i; j++) {
		        if(diary.get(i).getUserEmail().getUserEmail().equals(diary.get(j).getUserEmail().getUserEmail())) {
		            isDuplicate = true;
		            break;
		        }
		    }
		    if(!isDuplicate) {
		    	result.add(new replyDiary(diary.get(i).getUserEmail().getUserEmail(), nicklist.get(i), diary.get(i).getDiaryContent(), diary.get(i).getCreatedAt()));
		    }
		}
		
		Gson gson = new GsonBuilder().create();
		
		String json = gson.toJson(result);
		
		return json;
		
	}
	
	@ResponseBody
	@PostMapping("getRandomDiaryList")
	private String getRandomDiaryList(String info) {
		
		List<DiaryShare> diary = repo.getRandomDiaryList(info);
		
		ArrayList<String> nicklist = new ArrayList<String>();
		
		for(int i=0; i<diary.size(); i++) {
			String a = diary.get(i).getUserEmail().getUserEmail();
			User b = repo2.getNick(a);
			nicklist.add(b.getUserNick());
		}
		
		ArrayList<RandomDiary> result = new ArrayList<RandomDiary>();
		
		for(int i=0; i<diary.size(); i++) {
			result.add(new RandomDiary(diary.get(i).getShareSeq(), diary.get(i).getUserEmail().getUserEmail(), nicklist.get(i), diary.get(i).getDiaryContent(), diary.get(i).getCreatedAt()));
		}
		
		Gson gson = new GsonBuilder().create();
		
		String json = gson.toJson(result);
		
		return json;
		
	}
	
	@ResponseBody
	@PostMapping("getDiaryRoomList")
	private String getDiaryRoomList(@RequestBody userUser info) {
		
		System.out.println("info : " + info.getUserA());
		
		String UserA = info.getUserA();
		String UserB = info.getUserB();
		
		System.out.println("userA : " + UserA);
		System.out.println("userB : " + UserB);
		
		List<DiaryShare> diary = repo.getDiaryRoomList(UserA, UserB);
		
		ArrayList<replyDiary> result = new ArrayList<replyDiary>();
		
		for(int i=0; i<diary.size(); i++) {
			result.add(new replyDiary(diary.get(i).getUserEmail().getUserEmail(), "", diary.get(i).getDiaryContent(), diary.get(i).getCreatedAt()));
		}
		
		Gson gson = new GsonBuilder().create();
		
		String json = gson.toJson(result);
		
		return json;
		
	}
	
	@ResponseBody
	@PostMapping("sendDiary")
	private String sendDiary(@RequestBody ToFromContent info) {
		
		String toUser = info.getToUser();
		String fromUser = info.getFromUser();
		String content = info.getContent();
		
		repo.sendDiary(toUser, fromUser, content);
		
		return "sendDiary";
		
	}
	
	@ResponseBody
	@PostMapping("linkUserDiary")
	private String linkUserDiary(@RequestBody linkDiary info) {
		
		String toUser = info.getToUser();
		String fromUser = info.getFromUser();
		String content = info.getContent();
		String inputContent = info.getInputcontent();
		
		repo.sendDiary(fromUser, toUser, content);
		repo.sendDiary(toUser, fromUser, inputContent);
		
		return "linkUserDiary";
		
	}
	
	@ResponseBody
	@PostMapping("openDiary")
	private String openDiary(@RequestBody String info) {
		
//		String user = info.getMail();
//		String content = info.getContent();
//		
//		repo.openDiary(user, content);
//		
//		return "openDiary";
		
		String saveDiary = info.replaceAll("\"", "");
		String[] save = saveDiary.split(":");
		String content = save[0];
		String user = save[1];
		
		repo.openDiary(user, content);
		
		return "openDiary";
	}
	
	
}
