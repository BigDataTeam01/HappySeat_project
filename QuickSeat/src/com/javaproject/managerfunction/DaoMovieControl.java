package com.javaproject.managerfunction;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.security.auth.login.AccountException;
import javax.swing.ImageIcon;

//import com.javalec.function.Dto;
import com.javaproject.base.ShareVar;

public class DaoMovieControl {
	
	private final String url_mysql = ShareVar.dbName;
	private final String id_mysql = ShareVar.dbUser;
	private final String pw_mysql = ShareVar.dbPass;

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
	
	public DaoMovieControl() {
		// TODO Auto-generated constructor stub
	}

	public DaoMovieControl(String movie_title) {
		super();
		this.movie_title = movie_title;
	}
	
	
	
	public ArrayList<DtoLCY> selectList() {
		ArrayList<DtoLCY> dtoList = new ArrayList<DtoLCY>();
		String where1 = "select m.movie_title, m.director, m.genre, m.rel_date, m.film_rating, m.made_in, m.rel_state ";
		String where2 = "from movie as m ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1+where2);
			
			while(rs.next()) {
				String wkMovie_Title = rs.getString(1);
				String wkDirector = rs.getString(2);
				String wkGenre = rs.getString(3);
				Date wkRel_Date = rs.getDate(4);
				String wkFilm_Rating = rs.getString(5);
				String wkMade_In = rs.getString(6);
				String wkRel_Status = rs.getString(7);
				
				DtoLCY dto = new DtoLCY(wkMovie_Title, wkDirector, wkGenre, wkRel_Date, wkFilm_Rating, wkMade_In, wkRel_Status);
				dtoList.add(dto);
			}
			
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	} 

	// innerTable의 Row를 클릭하면 그 영화에 대한 상세정보를 MovieControl Class로 전달 
	public DtoLCY movieTableClick() {
		DtoLCY dto = null;
		String where1 = "select m.movie_title, m.director, m.actor, m.dist_company, m.genre, "
					  + "m.film_rating, m.made_in, m.poster, m.movie_desc, m.rel_date, m.over_date, m.rel_state "; 
		String where2 = "from movie as m ";
		String where3 = "where movie_title = '" + movie_title + "'"; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1+where2+where3);
			
			if(rs.next()) {
				String wkMovie_Title = rs.getString(1);
				String wkDirector = rs.getString(2);
				String wkActor = rs.getString(3);
				String wkDist_Company = rs.getString(4);
				String wkGenre = rs.getString(5);
				String wkFilm_Rating = rs.getString(6);
				String wkMade_In = rs.getString(7);
				String wkMovie_Desc = rs.getString(9);
				Date wkRel_Date = rs.getDate(10);
				Date wkOver_Date = rs.getDate(11);
				String wkRel_State = rs.getString(12);
				
				
				// file
				ShareVar.filename = ShareVar.filename + 1;
				File file = new File(Integer.toString(ShareVar.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(8);
				byte[] buffer = new byte[1024];
				
				ImageIcon icon = new ImageIcon(buffer);
				Image img = icon.getImage();
				Image changeImg = img.getScaledInstance(164, 278, Image.SCALE_SMOOTH);
				
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
				
				dto = new DtoLCY(wkMovie_Title, wkDirector, wkActor, wkDist_Company, wkGenre,
						  wkFilm_Rating, wkMade_In, wkMovie_Desc, wkRel_Date, wkOver_Date, wkRel_State);
			}
			
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	} 
	
	
}
