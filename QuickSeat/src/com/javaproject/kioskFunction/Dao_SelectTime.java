package com.javaproject.kioskFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;
import com.javaproject.managerfunction.DtoWDH;

public class Dao_SelectTime {

	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;
	
	public static int screenPoster1 = 0;

	// Field
	int scr_code;
	String scr_movie_title;
	String scr_scroom_name;
	String admin_admin_id;
	String seat_resv_code;
	String scr_start_time;
	int run_time;
	FileInputStream screenPoster;

	public Dao_SelectTime() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<DtoWDH> showScreen() {
		ArrayList<DtoWDH> dto = new ArrayList<DtoWDH>();

		String where1 = "select s.scr_code, s.scr_movie_title, s.scr_scroom_name, s.admin_admin_id, s.seat_resv_code, s.scr_start_time, s.run_time, m.poster";
		String where2 = " from screen as s, movie as m where m.movie_title = s.scr_movie_title and scr_movie_title = '" +ShareVar.selectedMovieTitle+"'";
		// 조커를 ShareVar에서 가져온 영화타이틀로 바꿔야 함
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(where1 + where2);

			while (rs.next()) {
				int wkScr_code = rs.getInt(1);
				String wkMovie_title = rs.getString(2);
				String wkScr_scroom_name = rs.getString(3);
				String wkAdmin_id = rs.getString(4);
				String wkSeat_Resv_code = rs.getString(5);
				String wkScr_start_time = rs.getString(6);
				int wkRun_time = rs.getInt(7);
				
				
				// file
				screenPoster1 = screenPoster1 + 1;
				File file = new File(Integer.toString(screenPoster1));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(8);
				byte[] buffer = new byte[1024];
				
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}

				DtoWDH dtoWDH = new DtoWDH(wkScr_code, wkMovie_title, wkScr_scroom_name, wkSeat_Resv_code,
						wkScr_start_time, wkRun_time, wkAdmin_id);

				dto.add(dtoWDH);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

}
