package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositories.ScoreRepo;
import com.serviceClasses.ScoreClass;

@Service
public class ScoreboardService {
	
	@Autowired
	private ScoreRepo scoreRepo;
	
	public List<ScoreClass> getScores() {
		List<ScoreClass> scoreList= new ArrayList<>();
		
		//usually this method of this class would be used to get scores from a database; simplified in this code example
		scoreList = scoreRepo.getScoresFromDataBase();
		//afterwards this service class would be used to edit/filter data that was acquired from the database
		
		return scoreList;
	}
}
