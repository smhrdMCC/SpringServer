package com.todaktodak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todaktodak.model.emailnick;
import com.todaktodak.repository.MypageRepository;

@Controller
public class MypageController {

	@Autowired
	private MypageRepository repo;
	
	@ResponseBody
	@PostMapping("/changeNick")
	private String changeNick(@RequestBody emailnick inf) {
		
		System.out.println(" ");
		System.out.println("받아온 정보 " + inf);
		
		String email = inf.getEmail().toString();
		String nick = inf.getNick().toString();
		
		repo.change(email, nick);
		
		return "1";
	}
	
}
