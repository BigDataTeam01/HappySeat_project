package com.javaproject.kioskFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.javaproject.base.ShareVar;
import com.javaproject.managerfunction.DtoWDH;

public class Dao_confirmSeat {
	
	
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	public static int Poster = 0;
	
	
	//Filed
	String movie_title;
	FileInputStream poster;
	int  movie_run_time;
	String cinema_branch;
	String scr_scroom_name;
	String scr_start_time;
	
	
	
	
	
	
	//construct
	public Dao_confirmSeat() {
		
	}

	public Dao_confirmSeat(String movie_title, FileInputStream poster, String cinema_branch,
			String scr_scroom_name, String scr_start_time) {
		super();
		this.movie_title = movie_title;
		this.poster = poster;
		this.cinema_branch = cinema_branch;
		this.scr_scroom_name = scr_scroom_name;
		this.scr_start_time = scr_start_time;
	}
	
	
	//Method
	
	public ArrayList<Dto_confirmSeat> showMyTicket (){
		ArrayList<Dto_confirmSeat> dto = new ArrayList<Dto_confirmSeat>();

		String select = "select m.movie_title , m.poster , s.scr_start_time , s.scr_scroom_name , r.cinema_branch ";
		String from = " from screen as s, movie as m , screening_room as r";
		String where = " where m.movie_title = s.scr_movie_title and s.scr_scroom_name = r.scroom_name and s.scr_movie_title = '" + ShareVar.selectedMovieTitle + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(select + from + where);

			while (rs.next()) {
				String wkMovie_title = rs.getString(1);
				String wkScr_start_time = rs.getString(3);
				String wkScr_scroom_name = rs.getString(4);
				String wkcinema_branch = rs.getString(5);
				
				// file
				Poster = Poster + 1;
				File file = new File(Integer.toString(Poster));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(2);
				byte[] buffer = new byte[1024];
				
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}

				Dto_confirmSeat Dto_confirmSeat = new Dto_confirmSeat(wkMovie_title, poster, wkcinema_branch, wkScr_scroom_name, wkScr_start_time, wkScr_scroom_name, wkScr_start_time);

				dto.add(Dto_confirmSeat);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	
	public void revertSeatStatus() {
		PreparedStatement ps = null;
		
		String where1 = "Update screen set seat_resv_code = '" + ShareVar.dbSeatCode + "'";
		String where2 = " where scr_code = " + ShareVar.scr_code;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			ps = conn_mysql.prepareStatement(where1+where2);
			ps.executeUpdate();
			
			conn_mysql.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "업데이트 중 문제발생");
		}
	}
	
	
	
	
}
