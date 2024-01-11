package com.javaproject.rnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;

public class DaoChartExample {
	
	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;

	String resv_date;
	int ticket_price;
	int cust_age;
	String cust_type;
	
	// Constructor
	public DaoChartExample(){
		
	}
	
	// Method
	// 일별 가격을 알아보기 위한 Method
	public ArrayList<DtoChartExample> pricePerDay() {
		ArrayList<DtoChartExample> dataList = new ArrayList<DtoChartExample>();
		String where1 = "select date_format(resv_date, '%y-%m-%d') as date, sum(ticket_price)";
		String where2 = " from reserve group by date order by date desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(where1 + where2);

			while (rs.next()) {
				String wkResv_date = rs.getString(1);
				int wkTicket_price = rs.getInt(2);
				
				DtoChartExample dto = new DtoChartExample(wkResv_date, wkTicket_price);

				dataList.add(dto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataList;
	}

	
	
	
	
	

}
