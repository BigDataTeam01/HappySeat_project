package com.javaproject.managerfunction;

import java.io.FileInputStream;
import java.sql.Date;

public class DtoLCY {
	
	String movie_title;
	String dist_company;
	String genre;
	String film_rating;
	String movie_desc;
	String run_time;
	Date rel_date;
	String rel_state;
	String made_in;
	FileInputStream poster;
	
	public DtoLCY() {
		// TODO Auto-generated constructor stub
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
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

	public String getMovie_desc() {
		return movie_desc;
	}

	public void setMovie_desc(String movie_desc) {
		this.movie_desc = movie_desc;
	}

	public String getRun_time() {
		return run_time;
	}

	public void setRun_time(String run_time) {
		this.run_time = run_time;
	}

	public Date getRel_date() {
		return rel_date;
	}

	public void setRel_date(Date rel_date) {
		this.rel_date = rel_date;
	}

	public String getRel_state() {
		return rel_state;
	}

	public void setRel_state(String rel_state) {
		this.rel_state = rel_state;
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
	
	
	
}
