package com.todaktodak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todaktodak.entity.User;
import com.todaktodak.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@PostMapping("/join")
	@ResponseBody
	public String join(@RequestBody User user) {
		User users = new User();
		
		users.setUserEmail(user.getUserEmail());
		users.setUserNick(user.getUserNick());
		repo.save(users);
		return "JOIN 성공";
		
	}
}
