package com.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.serviceClasses.ScoreClass;

@Repository
public class ScoreRepo {
	//this class would be used if there was an actual database to get the scores from
	
	public List<ScoreClass> getScoresFromDataBase() {
		
		//in this example Ill just create the objects manually that would be requested using Hibernate
		ScoreClass score0 = new ScoreClass("Robin", 10);
		ScoreClass score1 = new ScoreClass("Max", 15);
		ScoreClass score2 = new ScoreClass("Jon", 3);
		ScoreClass score3 = new ScoreClass("Alex", 24);
		ScoreClass score4 = new ScoreClass("Peter", 99);
		
		List<ScoreClass> scoreList = new ArrayList<>();
		scoreList.add(score0);
		scoreList.add(score1);
		scoreList.add(score2);
		scoreList.add(score3);
		scoreList.add(score4);
		
		return scoreList;
	}
}
