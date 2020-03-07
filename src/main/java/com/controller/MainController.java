package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/addScore")
	public void addScore() {
		
		
	}
}
