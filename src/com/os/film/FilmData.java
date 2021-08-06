package com.os.film;

import java.util.ArrayList;

public class FilmData {

	private ArrayList<FilmCategory> filmCategories;
	private double review;
	private ArrayList<String> acts;
	private String director, producer, filmMaker, scriptWriter;
	
	public FilmData() {
		String s = "UNDEFINED";
		filmCategories = new ArrayList<>();
		acts = new ArrayList<>();
		review = 0f;
		director = s;
		producer = s;
		filmMaker = s;
		scriptWriter = s;
	}

	public ArrayList<FilmCategory> getFilmCategories() {
		return this.filmCategories;
	}
	
	public void addFilmCategory(FilmCategory filmCategory) {
		this.filmCategories.add(filmCategory);
	}

	public double getReview() {
		return this.review;//Not needed
	}

	public ArrayList<String> getActs() {
		return this.acts;
	}
	
	public void addAct(String actName) {
		this.acts.add(actName);
	}

	public String getDirector() {
		return this.director;
	}

	public String getProducer() {
		return this.producer;
	}

	public String getFilmMaker() {
		return this.filmMaker;
	}

	public String getScriptWriter() {
		return this.scriptWriter;
	}

}
