package com.javaproject.kioskFunction;

import java.io.FileInputStream;
import java.sql.Date;

public class Dto_PJH {
	
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
	String movie_run_time;
	String cinema_branch;
	String get_here;
	FileInputStream location_map;
	String cust_type;
	String discount_rate;
	int ticket_price;
	int moviePriceBeforeDiscount;
	int ticket_number;
	
	
	public Dto_PJH() {
		// TODO Auto-generated constructor stub
	}
	
	public Dto_PJH(String movie_title, String director, String genre, Date rel_date, String film_rating, String made_in, String rel_status) {
		this.movie_title = movie_title;
		this.director = director;
		this.genre = genre;
		this.rel_date = rel_date;
		this.film_rating = film_rating;
		this.made_in = made_in;
		this.rel_state = rel_status;
	}
	

	
		
	//영화선택을 위해 전부다 긁어오는dto
	public Dto_PJH(String director, String movie_title,  String actor, String dist_company, String genre,
			String film_rating, String made_in, String movie_desc, Date rel_date,
			Date over_date, String rel_state,String movie_run_time) {
		super();
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
		this.movie_run_time = movie_run_time;
		
	}
	
	//영화 상영관정보를 위해 모두 가져오는dto
	public Dto_PJH(String cinema_branch, String get_here) {
		super();
		this.cinema_branch = cinema_branch;
		this.get_here = get_here;
	}
	//영화가격을 위해 영화 할인전 가격을 가져오는 dto
	  public Dto_PJH(String movie_title, int moviePriceBeforeDiscount) {
	        this.movie_title = movie_title;
	        this.moviePriceBeforeDiscount = moviePriceBeforeDiscount;
	    }
	//영화 예매번호를 db에서 긁어오기
	  public Dto_PJH(int ticket_number) {
		  super();
		  this.ticket_number = ticket_number;
	  }
	
	
// getter&setter
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

	public String getMovie_run_time() {
		return movie_run_time;
	}

	public void setMovie_run_time(String movie_run_time) {
		this.movie_run_time = movie_run_time;
	}

	public String getCinema_branch() {
		return cinema_branch;
	}

	public void setCinema_branch(String cinema_branch) {
		this.cinema_branch = cinema_branch;
	}

	public String getGet_here() {
		return get_here;
	}

	public void setGet_here(String get_here) {
		this.get_here = get_here;
	}

	public FileInputStream getLocation_map() {
		return location_map;
	}

	public void setLocation_map(FileInputStream location_map) {
		this.location_map = location_map;
	}

	public String getCust_type() {
		return cust_type;
	}

	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
	}

	public String getDiscount_rate() {
		return discount_rate;
	}

	public void setDiscount_rate(String discount_rate) {
		this.discount_rate = discount_rate;
	}

	public int getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(int ticket_price) {
		this.ticket_price = ticket_price;
	}

	public int getMoviePriceBeforeDiscount() {
		return moviePriceBeforeDiscount;
	}

	public void setMoviePriceBeforeDiscount(int moviePriceBeforeDiscount) {
		this.moviePriceBeforeDiscount = moviePriceBeforeDiscount;
	}

	public int getTicket_number() {
		return ticket_number;
	}

	public void setTicket_number(int ticket_number) {
		this.ticket_number = ticket_number;
	}

	
}

