package com.serviceClasses;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ScoreClass {
	//note: if this app would be connected to a database, then this class would need additional Hibernate annotations
	
	//attributes
	@NotBlank
	private String name = "Blank";
	
	@Min(0)
	private int score = 1;
	
	//constructors
	public ScoreClass(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public ScoreClass() {}
	
	//getters/setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
