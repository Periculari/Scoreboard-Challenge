package com.serviceClasses;

public class ScoreClass {
	//note: if this app would be connected to a database, then this class would need additional Hibernate annotations
	
	//attributes
	private String name;
	private int score;
	
	//constructor
	public ScoreClass(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
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
