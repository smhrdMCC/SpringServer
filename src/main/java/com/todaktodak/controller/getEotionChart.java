package com.todaktodak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.todaktodak.repository.DiaryRepository;

@Controller
public class getEotionChart {
	
	@Autowired
	private DiaryRepository repo;

}
