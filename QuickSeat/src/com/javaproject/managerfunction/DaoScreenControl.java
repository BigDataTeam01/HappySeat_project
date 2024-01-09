package com.javaproject.managerfunction;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;
import com.mysql.cj.xdevapi.PreparableStatement;

public class DaoScreenControl {

	// Field
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;

	// screen에서 가져올 값
	int scr_code;
	String scr_movie_title;
	String scr_scroom_name;
	String admin_admin_id;
	String seat_resv_code;
	String scr_start_time;
	int run_time;
	// movie에서 가져올 값
	String movie_title;
	String rel_date;
	String over_date;
	String rel_state;
	// screening_room에서 가져올 값
	String scroom_name;
	int total_seat;

	// Constructor
	public DaoScreenControl() {
		// TODO Auto-generated constructor stub
	}

	public DaoScreenControl(String scroom_name) {
		super();
		this.scroom_name = scroom_name;
	}

	public DaoScreenControl(String scr_movie_title, String scr_scroom_name, String admin_admin_id,
			String seat_resv_code, String scr_start_time, int run_time) {
		super();
		this.scr_movie_title = scr_movie_title;
		this.scr_scroom_name = scr_scroom_name;
		this.admin_admin_id = admin_admin_id;
		this.seat_resv_code = seat_resv_code;
		this.scr_start_time = scr_start_time;
		this.run_time = run_time;
	}

	public DaoScreenControl(String scr_movie_title, String scr_scroom_name, String admin_admin_id,
			String seat_resv_code, String scr_start_time, int run_time, int scr_code) {
		super();
		this.scr_movie_title = scr_movie_title;
		this.scr_scroom_name = scr_scroom_name;
		this.admin_admin_id = admin_admin_id;
		this.seat_resv_code = seat_resv_code;
		this.scr_start_time = scr_start_time;
		this.run_time = run_time;
		this.scr_code = scr_code;
	}

	public DaoScreenControl(int scr_code) {
		super();
		this.scr_code = scr_code;
	}

	// Method
	// scroom 콤보박스에 들어갈 Item을 Array로 설정
	public ArrayList<String> scroomItem() {
		ArrayList<String> scroomList = new ArrayList<String>();
		String where = "select scroom_name from screening_room";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(where);

			while (rs.next()) {
				String wkScroom_name = rs.getString(1);

				scroomList.add(wkScroom_name);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return scroomList;
	}

	// movieTitle 콤보박스에 들어갈 Item을 Array로 설정
	public ArrayList<String> moiveTitleItem() {
		ArrayList<String> movieTitleList = new ArrayList<String>();
		String where = "select movie_title from movie";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(where);

			while (rs.next()) {
				String wkMovie_title = rs.getString(1);

				movieTitleList.add(wkMovie_title);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return movieTitleList;
	}

	// ScreenControl Class에서 가져온 scroom_name의 total_seat을 DB에서 가져 옴
	public int totalSeatCount() {
		int totalSeat = 0;
		String where = "select total_seat from screening_room where scroom_name = '" + scroom_name + "'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(where);

			if (rs.next()) {
				totalSeat = rs.getInt(1);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return totalSeat;
	}

	// app에 입력된 값을 DB screen Table에 insert
	public boolean screenInsert() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

			String insertA = "insert into screen (scr_movie_title, scr_scroom_name, admin_admin_id, seat_resv_code, scr_start_time, run_time)";
			String insertB = " values (?, ?, ?, ?, ?, ?)";

			ps = conn_mysql.prepareStatement(insertA + insertB);
			ps.setString(1, scr_movie_title);
			ps.setString(2, scr_scroom_name);
			ps.setString(3, admin_admin_id);
			ps.setString(4, seat_resv_code);
			ps.setString(5, scr_start_time);
			ps.setInt(6, run_time);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}

	// Table에 값을 띄우기 위해 DB에서 data값을 가져옴
	public ArrayList<DtoWDH> innerTable() {
		ArrayList<DtoWDH> innerTableModel = new ArrayList<DtoWDH>();

		String whereA = "select s.scr_movie_title, s.scr_scroom_name, s.scr_start_time, s.run_time, m.rel_date, m.over_date, m.rel_state, s.scr_code";
		String whereB = " from screen as s, movie as m";
		String whereC = " where s.scr_movie_title = m.movie_title";
		
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereA + whereB + whereC);

			while (rs.next()) {
				String wkScr_movie_title = rs.getString(1);
				String wkScr_scroom_name = rs.getString(2);
				String wkScr_start_time = rs.getString(3);
				int wkRun_time = rs.getInt(4);
				String wkRel_date = rs.getString(5);
				String wkOver_date = rs.getString(6);
				String wkRel_state = rs.getString(7);
				int wkScr_code = rs.getInt(8);

				DtoWDH dtoWDH = new DtoWDH(wkScr_movie_title, wkScr_scroom_name, 
								wkScr_start_time, wkRun_time, 
								wkRel_date, wkOver_date, 
								wkRel_state, wkScr_code);

				innerTableModel.add(dtoWDH);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return innerTableModel;
	}
	
	// 수정
	public boolean screenUpdate() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

			String insertA = "update screen set scr_movie_title = ?, scr_scroom_name = ?, admin_admin_id = ?, seat_resv_code = ?, scr_start_time = ?, run_time = ?";
			String insertB = " where scr_code = " + scr_code;

			ps = conn_mysql.prepareStatement(insertA + insertB);
			ps.setString(1, scr_movie_title);
			ps.setString(2, scr_scroom_name);
			ps.setString(3, admin_admin_id);
			ps.setString(4, seat_resv_code);
			ps.setString(5, scr_start_time);
			ps.setInt(6, run_time);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			return false;
		}
		return true;

	}
	
	public boolean screenDelete() {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

			String delete = "delete from screen where scr_code = " + scr_code;

			ps = conn_mysql.prepareStatement(delete);
			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e) {
			return false;
		}
		return true;

	}
	
	public ArrayList<DtoWDH> cbInnerTable() {
		ArrayList<DtoWDH> innerTableModel = new ArrayList<DtoWDH>();

		String whereA = "select s.scr_movie_title, s.scr_scroom_name, s.scr_start_time, s.run_time, m.rel_date, m.over_date, m.rel_state, s.scr_code";
		String whereB = " from screen as s, movie as m";
		String whereC = " where s.scr_movie_title = m.movie_title";
		String whereD = " and scr_scroom_name = '" + scroom_name + "'";
		
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereA + whereB + whereC + whereD);

			while (rs.next()) {
				String wkScr_movie_title = rs.getString(1);
				String wkScr_scroom_name = rs.getString(2);
				String wkScr_start_time = rs.getString(3);
				int wkRun_time = rs.getInt(4);
				String wkRel_date = rs.getString(5);
				String wkOver_date = rs.getString(6);
				String wkRel_state = rs.getString(7);
				int wkScr_code = rs.getInt(8);

				DtoWDH dtoWDH = new DtoWDH(wkScr_movie_title, wkScr_scroom_name, 
								wkScr_start_time, wkRun_time, 
								wkRel_date, wkOver_date, 
								wkRel_state, wkScr_code);

				innerTableModel.add(dtoWDH);
			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return innerTableModel;
	}




} // End
