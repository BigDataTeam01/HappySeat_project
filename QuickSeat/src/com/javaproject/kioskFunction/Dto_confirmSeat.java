package com.javaproject.kioskFunction;

import java.io.FileInputStream;

public class Dto_confirmSeat {
	String movie_title;
	FileInputStream poster;
	String cinema_branch;
	String scr_scroom_name;
	String scr_start_time;
	
	
	public Dto_confirmSeat() {
		// TODO Auto-generated constructor stub
	}


	public Dto_confirmSeat(String movie_title , FileInputStream poster,String cinema_branch, String Scr_scroom_name, String Scr_start_time, String scr_scroom_name, String scr_start_time) {
		super();
		this.movie_title = movie_title;
		this.poster = poster;
		this.cinema_branch = cinema_branch;
		this.scr_scroom_name = scr_scroom_name;
		this.scr_start_time = scr_start_time;
	}


	public String getMovie_title() {
		return movie_title;
	}


	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}


	public FileInputStream getPoster() {
		return poster;
	}


	public void setPoster(FileInputStream poster) {
		this.poster = poster;
	}

	public String getCinema_branch() {
		return cinema_branch;
	}


	public void setCinema_branch(String cinema_branch) {
		this.cinema_branch = cinema_branch;
	}


	public String getScr_scroom_name() {
		return scr_scroom_name;
	}


	public void setScr_scroom_name(String scr_scroom_name) {
		this.scr_scroom_name = scr_scroom_name;
	}


	public String getScr_start_time() {
		return scr_start_time;
	}


	public void setScr_start_time(String scr_start_time) {
		this.scr_start_time = scr_start_time;
	}
	
	
	
	
	
}

