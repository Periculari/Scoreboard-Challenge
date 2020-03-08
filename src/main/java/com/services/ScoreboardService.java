package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositories.ScoreRepo;
import com.serviceClasses.ScoreClass;

@Service
public class ScoreboardService {
	private static final Logger LOGGER = Logger.getLogger(ScoreboardService.class.getName());
	
	@Autowired
	private ScoreRepo scoreRepo;
	
	public List<ScoreClass> getScores() {
		List<ScoreClass> scoreList= new ArrayList<>();
		
		//usually this method of this class would be used to get scores from a database; simplified in this code example
		scoreList = scoreRepo.getScoresFromDataBase();
		//afterwards this service class would be used to edit/filter data that was acquired from the database
		LOGGER.info("got scores from scoreRepo");
		
		return scoreList;
	}
	
	//service method to add score to dataBase
	public boolean addScore(ScoreClass newScore) {
		if(scoreRepo.addScoretoDataVase(newScore)) {
			LOGGER.info("added score to dataBase via scoreRepo");
			return true;
		} else {
			LOGGER.severe("could not add score to dataBase");
			return false;
		}
	}
}
