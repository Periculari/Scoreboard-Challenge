package com.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serviceClasses.ScoreClass;
import com.services.ScoreboardService;

@Controller
public class MainController {
	
	@Autowired 
	private ScoreboardService scoreBoardService;
	
	@GetMapping("")
	public String test(@RequestParam(value = "name",	 defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	
	@GetMapping("/scoreboard")
	public String scoreboardMain(Model model) {
		
		List<ScoreClass> scoreList = scoreBoardService.getScores();
		
		model.addAttribute("scoreList", scoreList);
		return "scoreboard";
	}
	
	@PostMapping(path= "/scoreboard/addScore", consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public String addScore(@RequestBody ScoreClass newScore) {
		
		if(scoreBoardService.addScore(newScore)) {
			return "500";		
		} else {
			return "";
		}
		
	}
}
