package com.javaproject.managerfunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;

public class DaoUserStatistics {

	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;

	String resv_date;
	int ticket_price;
	int cust_age;
	String cust_type;

	// Constructor
	public DaoUserStatistics() {

	}


	// Method
	// 일별 가격을 알아보기 위한 Method
	public ArrayList<DtoWDH> pricePerDay() {
		ArrayList<DtoWDH> dataList = new ArrayList<DtoWDH>();
		String where1 = "select date_format(resv_date, '%y-%m-%d') as date, sum(ticket_price)";
		String where2 = " from reserve where date_format(resv_date, '%y-%m') = '" + ShareVar.year + "-" + ShareVar.month + "'";
		String where3 = " group by date order by date desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(where1 + where2 + where3);

			while (rs.next()) {
				String wkResv_date = rs.getString(1);
				int wkTicket_price = rs.getInt(2);

				DtoWDH dto = new DtoWDH(wkResv_date, wkTicket_price);

				dataList.add(dto);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dataList;
	}

	// 월별 매출 현황
	public ArrayList<DtoWDH> pricePerMonth() {
		ArrayList<DtoWDH> dataList = new ArrayList<DtoWDH>();
		String where1 = "select date_format(resv_date, '%y-%m') AS month, SUM(ticket_price)";
		String where2 = " from reserve where date_format(resv_date, '%y') = '" + ShareVar.year + "'";
		String where3 = " group by month";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1 + where2 + where3);
			
			while (rs.next()) {
				String wkResv_date = rs.getString(1);
				int wkTicket_price = rs.getInt(2);
				
				DtoWDH dto = new DtoWDH(wkResv_date, wkTicket_price);
				
				dataList.add(dto);
			}
			
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataList;
	}

	// 연령별 사용자 통계
	public ArrayList<DtoWDH> ageUserStatistics() {
		ArrayList<DtoWDH> dataList = new ArrayList<DtoWDH>();
		String where1 = "SELECT DATE_FORMAT(r.resv_date, '%y-%m') AS month, c.cust_age, COUNT(*) AS age_count";
		String where2 = " FROM reserve AS r JOIN customer AS c ON r.resv_cust_seq = c.cust_seq";
		String where3 = " WHERE DATE_FORMAT(r.resv_date, '%y-%m') = '" + ShareVar.year + "-" + ShareVar.month + "'";
		String where4 = " GROUP BY month, c.cust_age order by c.cust_age asc";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1 + where2 + where3 + where4);
			
			while (rs.next()) {
				String wkResv_date = rs.getString(1);
				int wkCust_age = rs.getInt(2);
				int wkAge_count = rs.getInt(3);
				
				DtoWDH dto = new DtoWDH(wkResv_date, wkCust_age, wkAge_count);
				
				dataList.add(dto);
			}
			
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataList;
	}

	// 유형별 사용자 통계
	public ArrayList<DtoWDH> typeUserStatistics() {
		ArrayList<DtoWDH> dataList = new ArrayList<DtoWDH>();
		String where1 = "SELECT DATE_FORMAT(r.resv_date, '%y-%m') AS month, c.cust_type, COUNT(*) AS type_count";
		String where2 = " FROM reserve AS r JOIN customer AS c ON r.resv_cust_seq = c.cust_seq";
		String where3 = " WHERE DATE_FORMAT(r.resv_date, '%y-%m') = '" + ShareVar.year + "-" + ShareVar.month + "'";
		String where4 = " GROUP BY month, c.cust_type";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1 + where2 + where3 + where4);
			
			while (rs.next()) {
				String wkResv_date = rs.getString(1);
				String wkCust_type = rs.getString(2);
				int wkType_count = rs.getInt(3);
				
				DtoWDH dto = new DtoWDH(wkResv_date, wkCust_type, wkType_count);
				
				dataList.add(dto);
			}
			
			conn_mysql.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataList;
	}

}
