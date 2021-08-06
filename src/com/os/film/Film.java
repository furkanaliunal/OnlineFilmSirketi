package com.os.film;

public class Film implements IFilm{
	private int id;
	private String filmName;
	private FilmData filmData;
	private float sellPrice;
	private float rentPrice;
	
	public Film(String filmName) {
		filmData = new FilmData();
		this.filmName = filmName;
		this.sellPrice = 0f;
		this.rentPrice = 0f;
	}
	protected Film(String filmName, FilmData filmData, int id) {
		this.filmName = filmName;
		this.filmData = filmData;
		this.id = id;
		this.sellPrice = 0f;
		this.rentPrice = 0f;
	}
	
	@Override
	public String getFilmName() {
		return this.filmName;
	}

	@Override
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	@Override
	public FilmData getFilmData() {
		return this.filmData;
	}
	@Override
	public void setFilmData(FilmData filmData) {
		this.filmData = filmData;
	}
	
	@Override
	public String toString() {
		return "A film with ID: " + this.id + " named : " + this.getFilmName();
	}
	@Override
	public Boolean hasCategory(FilmCategory filmCategory) {
		return filmData.getFilmCategories().contains(filmCategory);
	}
	@Override
	public void addCategory(FilmCategory filmCategory) {
		filmData.addFilmCategory(filmCategory);
	}
	public void setSellPrice(Float price) {
		this.sellPrice = price;
	}
	
	public void setRentPrice(Float price) {
		this.rentPrice = price;
	}
	

	public Float getSellPrice() {
		return this.sellPrice;
	}
	public Float getRentPrice() {
		return this.rentPrice;
	}

	public int getFilmID() {
		return this.id;
	}
}
