package com.javaproject.managerfunction;

public class DtoWDH {

	String scr_movie_title;
	String scr_scroom_name;
	int seat_resv_code;
	String scr_start_time;
	int run_time;
	String movie_title;
	String rel_date;
	String over_date;
	String rel_state;
	String scroom_name;
	int total_seat;

	public DtoWDH() {
		// TODO Auto-generated constructor stub
	}
	

	
	public DtoWDH(String scr_movie_title, String scr_scroom_name, String scr_start_time, int run_time, String rel_date,
			String over_date, String rel_state) {
		super();
		this.scr_movie_title = scr_movie_title;
		this.scr_scroom_name = scr_scroom_name;
		this.scr_start_time = scr_start_time;
		this.run_time = run_time;
		this.rel_date = rel_date;
		this.over_date = over_date;
		this.rel_state = rel_state;
	}



	// getter setter 
	public String getScr_movie_title() {
		return scr_movie_title;
	}

	public void setScr_movie_title(String scr_movie_title) {
		this.scr_movie_title = scr_movie_title;
	}

	public String getScr_scroom_name() {
		return scr_scroom_name;
	}

	public void setScr_scroom_name(String scr_scroom_name) {
		this.scr_scroom_name = scr_scroom_name;
	}

	public int getSeat_resv_code() {
		return seat_resv_code;
	}

	public void setSeat_resv_code(int seat_resv_code) {
		this.seat_resv_code = seat_resv_code;
	}

	public String getScr_start_time() {
		return scr_start_time;
	}

	public void setScr_start_time(String scr_start_time) {
		this.scr_start_time = scr_start_time;
	}

	public int getRun_time() {
		return run_time;
	}

	public void setRun_time(int run_time) {
		this.run_time = run_time;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public String getRel_date() {
		return rel_date;
	}

	public void setRel_date(String rel_date) {
		this.rel_date = rel_date;
	}

	public String getOver_date() {
		return over_date;
	}

	public void setOver_date(String over_date) {
		this.over_date = over_date;
	}

	public String getRel_state() {
		return rel_state;
	}

	public void setRel_state(String rel_state) {
		this.rel_state = rel_state;
	}

	public String getScroom_name() {
		return scroom_name;
	}

	public void setScroom_name(String scroom_name) {
		this.scroom_name = scroom_name;
	}

	public int getTotal_seat() {
		return total_seat;
	}

	public void setTotal_seat(int total_seat) {
		this.total_seat = total_seat;
	}

}
