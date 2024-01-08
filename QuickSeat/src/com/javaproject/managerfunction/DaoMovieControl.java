package com.javaproject.managerfunction;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//import com.javalec.function.Dto;
import com.javaproject.base.ShareVar;

public class DaoMovieControl {
	
//	private void String url_mysql = ShareVar.dbName;
//	private void String id_mysql = ShareVar.dbUser;
//	private void String pw_mysql = ShareVar.dbPass;

	String movie_title;
	String dist_company;
	String genre;
	String film_rating;
	String movie_desc;
	String run_time;
	Date rel_date;
	String rel_state;
	String made_in;
	FileInputStream poster;
	
	public DaoMovieControl() {
		// TODO Auto-generated constructor stub
	}

	public DaoMovieControl(String movie_title) {
		super();
		this.movie_title = movie_title;
	}
	
	
	
//	public ArrayList<DtoLCY> selectList() {
//		ArrayList<DtoLCY> dtoList = new ArrayList<DtoLCY>();
//		String whereDefault = "select "
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
//			
//			ResultSet rs = stmt_mysql.executeQuery(whereDefault);
//			
//			while(rs.next()) {
//				int wkSeq = rs.getInt(1);
//				String wkName = rs.getString(2);
//				String wkTelno = rs.getString(3);
//				String wkRelation = rs.getString(4);
//				
//				Dto dto = new Dto(wkSeq, wkName, wkTelno, wkRelation);
//				dtoList.add(dto);
//			}
//			
//			conn_mysql.close();
//			
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return dtoList;
//	} 

}
