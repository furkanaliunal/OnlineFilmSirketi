package com.os.film;

import java.util.Collection;
import java.util.HashMap;



public class FilmManager {
	private HashMap<Integer, IFilm> films;
	private int lastID = 1;
	
	public FilmManager() {
		films = new HashMap<>();
	}
	
	public IFilm addFilm(IFilm film) {
		IFilm newFilm = new Film(film.getFilmName(), film.getFilmData(), lastID);
		films.put(lastID++, newFilm);
		return newFilm; 
	}
	public void removeFilm(int id) {
		films.remove(id);
	}
	public IFilm getIFilmFromID(int id) {
		return films.get(id);
	}
	public Film getFilmFromID(int id) {
		return (Film)getIFilmFromID(id);
	}
	public void listAllFilms() {
		for (int key : films.keySet()) {
			System.out.println(films.get(key).toString());
		}
	}
	public void listAllFilmsFromCategory(FilmCategory filmCategory) {
		for (int key : films.keySet()) {
			IFilm film = films.get(key);
			if (film.hasCategory(filmCategory)) {
				System.out.println(film.toString());
			}
		}
	}
	
	public Collection<IFilm> getAllFilms(){
		return films.values();
	}
}
