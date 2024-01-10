package com.javaproject.kioskFunction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javaproject.base.ShareVar;

public class Dao_pdg {

	
	
	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
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
	
	// Constructor
	
	public Dao_pdg(int scr_code) {
		
		this.scr_code = scr_code;
		
	}
	
	public Dao_pdg() {
		
	}
		
	public Dao_pdg(int scr_code, String scr_movie_title, String scr_scroom_name, String seat_resv_code,
			String scr_start_time, int run_time, String scroom_name) {
		super();
		this.scr_code = scr_code;
		this.scr_movie_title = scr_movie_title;
		this.scr_scroom_name = scr_scroom_name;
		this.seat_resv_code = seat_resv_code;
		this.scr_start_time = scr_start_time;
		this.run_time = run_time;
		this.scroom_name = scroom_name;
	}
	
	public Dao_pdg(String seat_resv_code) {
		
		this.seat_resv_code = seat_resv_code;
		
	}
	
	
	
// Method 
	// 현재 좌석 예약상태를 불러오는 쿼리 
	public String currentSeatCode() {
		String seatCode = "";
		String fetchQuery = 
				  "select seat_resv_code "
				+ "from screen "
				+ "where scr_code = "+ scr_code;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(fetchQuery);
			while(rs.next()) {
				
				seatCode = rs.getString(1);
			}
			conn_mysql.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return seatCode;
		
	}
	
	
	// 페이지에서 선택된 좌석의 상태를 좌석 코드 업데이트 하는 쿼리 
	
	public void updateSeatCode() {
		PreparedStatement ps = null;
		String updateSeatCodeQuery = "update screen set seat_resv_code = ? "
				+ "where scr_code =  "+ ShareVar.scr_code;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
			
			ps = conn_mysql.prepareStatement(updateSeatCodeQuery);
			
			ps.setString(1, seat_resv_code);
			ps.executeUpdate();
			conn_mysql.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
