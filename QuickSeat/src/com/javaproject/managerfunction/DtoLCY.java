package com.javaproject.managerfunction;

import java.io.FileInputStream;
import java.sql.Date;

public class DtoLCY {
	
	String movie_title;
	String director;
	String actor;
	String dist_company;
	String genre;
	String film_rating;
	String made_in;
	FileInputStream poster;
	String movie_desc;
	Date rel_date;
	Date over_date;
	String rel_state;
	
	public DtoLCY() {
		// TODO Auto-generated constructor stub
	}
	
	// MovieSearchAction Method of DaoMovieControl Class 
	public DtoLCY(String movie_title, String director, String genre, Date rel_date, String film_rating, String made_in, String rel_status) {
		this.movie_title = movie_title;
		this.director = director;
		this.genre = genre;
		this.rel_date = rel_date;
		this.film_rating = film_rating;
		this.made_in = made_in;
		this.rel_state = rel_status;
	}
	
	// TableClick Method of DaoMovieControl Class 
	public DtoLCY(String movie_title, String director, String actor, String dist_company,
				  String genre, String film_rating, String made_in, String movie_desc,
				  Date rel_date, Date over_date, String rel_state) {
		this.movie_title = movie_title;
		this.director = director;
		this.actor = actor;
		this.dist_company = dist_company;
		this.genre = genre;
		this.film_rating = film_rating;
		this.made_in = made_in;
		this.movie_desc = movie_desc;
		this.rel_date = rel_date;
		this.over_date = over_date;
		this.rel_state = rel_state;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDist_company() {
		return dist_company;
	}

	public void setDist_company(String dist_company) {
		this.dist_company = dist_company;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getFilm_rating() {
		return film_rating;
	}

	public void setFilm_rating(String film_rating) {
		this.film_rating = film_rating;
	}

	public String getMade_in() {
		return made_in;
	}

	public void setMade_in(String made_in) {
		this.made_in = made_in;
	}

	public FileInputStream getPoster() {
		return poster;
	}

	public void setPoster(FileInputStream poster) {
		this.poster = poster;
	}

	public String getMovie_desc() {
		return movie_desc;
	}

	public void setMovie_desc(String movie_desc) {
		this.movie_desc = movie_desc;
	}

	public Date getRel_date() {
		return rel_date;
	}

	public void setRel_date(Date rel_date) {
		this.rel_date = rel_date;
	}

	public Date getOver_date() {
		return over_date;
	}

	public void setOver_date(Date over_date) {
		this.over_date = over_date;
	}

	public String getRel_state() {
		return rel_state;
	}

	public void setRel_state(String rel_state) {
		this.rel_state = rel_state;
	}

	
}
