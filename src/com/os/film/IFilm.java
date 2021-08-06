package com.os.film;

public interface IFilm {
	public String getFilmName();
	public void setFilmName(String filmName);
	public FilmData getFilmData();
	public void setFilmData(FilmData filmData);
	public String toString();
	public Boolean hasCategory(FilmCategory filmCategory);
	public void addCategory(FilmCategory filmCategory);
	public void setSellPrice(float price);
	public void setRentPrice(float price);
	public float getSellPrice();
	public float getRentPrice();
	public int getFilmID();
}
