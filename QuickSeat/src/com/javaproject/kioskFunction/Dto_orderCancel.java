package com.javaproject.kioskFunction;

import java.io.FileInputStream;

import javax.sound.sampled.ReverbType;

public class Dto_orderCancel {
	String movie_title;
	FileInputStream poster;
	String cinema_branch;
	String scr_scroom_name;
	String scr_start_time;
	String reserv_ticket;
	String seat_order;
	
	
	public Dto_orderCancel() {
		// TODO Auto-generated constructor stub
	}


	public Dto_orderCancel(String movie_title , FileInputStream poster,String cinema_branch, String Scr_scroom_name, String Scr_start_time, String scr_scroom_name, String scr_start_time , String reserv_ticket, String seat_order) {
		super();
		this.movie_title = movie_title;
		this.poster = poster;
		this.cinema_branch = cinema_branch;
		this.scr_scroom_name = scr_scroom_name;
		this.scr_start_time = scr_start_time;
		this.reserv_ticket = reserv_ticket;
		this.seat_order = seat_order;
	}


	public String getSeat_order() {
		return seat_order;
	}


	public void setSeat_order(String seat_order) {
		this.seat_order = seat_order;
	}


	public String getMovie_title() {
		return movie_title;
	}


	public String getReserv_ticket() {
		return reserv_ticket;
	}


	public void setReserv_ticket(String reserv_ticket) {
		this.reserv_ticket = reserv_ticket;
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

