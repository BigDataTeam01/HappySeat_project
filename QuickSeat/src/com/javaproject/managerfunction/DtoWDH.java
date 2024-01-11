package com.javaproject.managerfunction;

public class DtoWDH {

	int scr_code;
	String scr_movie_title;
	String scr_scroom_name;
	String seat_resv_code;
	String scr_start_time;
	int run_time;
	String movie_title;
	String rel_date;
	String over_date;
	String rel_state;
	String scroom_name;
	int total_seat;
	String resv_date;
	int ticket_price;
	int cust_age;
	String cust_type;
	int count_cust_age;
	int count_cust_type;
	String admin_admin_id;


	public DtoWDH() {
		// TODO Auto-generated constructor stub
	}

	public DtoWDH(String scr_movie_title, String scr_scroom_name, String scr_start_time, int run_time, String rel_date,
			String over_date, String rel_state, int scr_code) {
		super();
		this.scr_movie_title = scr_movie_title;
		this.scr_scroom_name = scr_scroom_name;
		this.scr_start_time = scr_start_time;
		this.run_time = run_time;
		this.rel_date = rel_date;
		this.over_date = over_date;
		this.rel_state = rel_state;
		this.scr_code = scr_code;
	}

	public DtoWDH(String resv_date, int ticket_price) {
		super();
		this.resv_date = resv_date;
		this.ticket_price = ticket_price;
	}


	public DtoWDH(String resv_date, int count_cust_age, int count_cust_type) {
		super();
		this.resv_date = resv_date;
		this.count_cust_age = count_cust_age;
		this.count_cust_type = count_cust_type;
	}


	public DtoWDH(int scr_code, String scr_movie_title, String scr_scroom_name, String seat_resv_code,
			String scr_start_time, int run_time, String admin_admin_id) {
		super();
		this.scr_code = scr_code;
		this.scr_movie_title = scr_movie_title;
		this.scr_scroom_name = scr_scroom_name;
		this.seat_resv_code = seat_resv_code;
		this.scr_start_time = scr_start_time;
		this.run_time = run_time;
		this.admin_admin_id = admin_admin_id;
	}

	public String getAdmin_admin_id() {
		return admin_admin_id;
	}

	public void setAdmin_admin_id(String admin_admin_id) {
		this.admin_admin_id = admin_admin_id;
	}

	public String getResv_date() {
		return resv_date;
	}

	public void setResv_date(String resv_date) {
		this.resv_date = resv_date;
	}

	public int getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(int ticket_price) {
		this.ticket_price = ticket_price;
	}

	public int getCust_age() {
		return cust_age;
	}

	public void setCust_age(int cust_age) {
		this.cust_age = cust_age;
	}

	public String getCust_type() {
		return cust_type;
	}

	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
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

	public String getSeat_resv_code() {
		return seat_resv_code;
	}

	public void setSeat_resv_code(String seat_resv_code) {
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

	public int getScr_code() {
		return scr_code;
	}

	public void setScr_code(int scr_code) {
		this.scr_code = scr_code;
	}

	public int getCount_cust_age() {
		return count_cust_age;
	}

	public void setCount_cust_age(int count_cust_age) {
		this.count_cust_age = count_cust_age;
	}

	public int getCount_cust_type() {
		return count_cust_type;
	}

	public void setCount_cust_type(int count_cust_type) {
		this.count_cust_type = count_cust_type;
	}

}
