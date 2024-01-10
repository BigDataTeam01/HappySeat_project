package com.javaproject.rnd;

public class DtoChartExample {
	
	String resv_date;
	int ticket_price;
	int cust_age;
	String cust_type;

	public DtoChartExample() {
		// TODO Auto-generated constructor stub
	}
	
	

	public DtoChartExample(String resv_date, int ticket_price) {
		super();
		this.resv_date = resv_date;
		this.ticket_price = ticket_price;
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
	
	

}
