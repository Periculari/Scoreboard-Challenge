package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serviceClasses.ScoreClass;
import com.services.ScoreboardService;

@Controller
public class MainController {
	
	@Autowired 
	private ScoreboardService scoreBoardService;
	
	@GetMapping("")
	public String scoreboardMain(Model model) {
		
		List<ScoreClass> scoreList = scoreBoardService.getScores();
		
		model.addAttribute("scoreList", scoreList);
		return "scoreboard";
	}
	
	@PostMapping(path= "/addScore", consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public String addScore(@RequestBody ScoreClass newScore) {
		
		if(scoreBoardService.addScore(newScore)) {
			return "500";		
		} else {
			return "";
		}
		
	}
}
