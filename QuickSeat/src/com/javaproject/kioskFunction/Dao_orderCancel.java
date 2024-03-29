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

public class Dao_orderCancel {
	
	
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
	public Dao_orderCancel() {
		
	}

	public Dao_orderCancel(String movie_title, FileInputStream poster, String cinema_branch,
			String scr_scroom_name, String scr_start_time) {
		super();
		this.movie_title = movie_title;
		this.poster = poster;
		this.cinema_branch = cinema_branch;
		this.scr_scroom_name = scr_scroom_name;
		this.scr_start_time = scr_start_time;
	}
	
	
	//Method
	
	public ArrayList<Dto_orderCancel> reserv_ticket (){
		ArrayList<Dto_orderCancel> dto = new ArrayList<Dto_orderCancel>();

		String where1 = "select m.movie_title , m.poster , s.scr_start_time , s.scr_scroom_name , r.cinema_branch , v.ticket_number, v.seat_order";
		String where2 = " from screen as s, movie as m , screening_room as r , reserve as v "
						+ "where m.movie_title = s.scr_movie_title" + " and ticket_number = " + ShareVar.insertedOrderNum + " and v.resv_scr_scroom_name = r.scroom_name"
								+" and m.movie_title = v.resv_scr_movie_title"
								+" and s.scr_code = v.resv_scr_code";
		System.out.println(where1 + where2);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(where1 + where2);

			while (rs.next()) {
				String wkMovie_title = rs.getString(1);
				String wkScr_start_time = rs.getString(3);
				String wkScr_scroom_name = rs.getString(4);
				String wkcinema_branch = rs.getString(5);
				String wkreserv_ticket = rs.getString(6);
				String wkseat_order = rs.getString(7);
				
				// file
				Poster = Poster + 1;
				File file = new File(Integer.toString(Poster));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(2);
				byte[] buffer = new byte[1024];
				
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}

				Dto_orderCancel dto_orderCancel = new Dto_orderCancel(wkMovie_title, poster, wkcinema_branch, wkScr_scroom_name, wkScr_start_time, wkScr_scroom_name, wkScr_start_time , wkreserv_ticket, wkseat_order);

				dto.add(dto_orderCancel);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}
	
	private void deleteAction() {
		
		
		
	}

	
	
	
}
