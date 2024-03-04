package com.todaktodak.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.todaktodak.entity.Diary;
import com.todaktodak.entity.GetDiaryDTO;
import com.todaktodak.model.datemail;
import com.todaktodak.repository.getDiaryRepository;

@Controller
public class getDiaryController {

	@Autowired
	private getDiaryRepository repo;

	@ResponseBody
	@PostMapping("/getmsg")
	public String getmsg(@RequestBody datemail info) {

		String email = info.getEmail();
		String date = info.getDate();

		ArrayList<Diary> getlist = repo.findTopByUserEmailOrderByCreatedAtDesc(email, date);

		ArrayList<GetDiaryDTO> trans = new ArrayList<GetDiaryDTO>();

		for (int i = 0; i < getlist.size(); i++) {
			trans.add(new GetDiaryDTO(getlist.get(i).getDiarySeq(), getlist.get(i).getDiaryContent()));
		}

		Gson gson = new GsonBuilder().create();

		String json = gson.toJson(trans);

		return json;
	}

}