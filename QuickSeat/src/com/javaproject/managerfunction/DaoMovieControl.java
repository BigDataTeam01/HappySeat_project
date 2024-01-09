package com.javaproject.managerfunction;

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
	String rel_date;
	String over_date;
	String rel_state;
	
	public DaoMovieControl() {
		// TODO Auto-generated constructor stub
	}

	public DaoMovieControl(String movie_title) {
		super();
		this.movie_title = movie_title;
	}
	
	
	public DaoMovieControl(String movie_title, String director, String actor, String dist_company, String genre,
			String film_rating, String made_in, FileInputStream poster ,String movie_desc, String rel_date, String over_date, String rel_state) {
		super();
		this.movie_title = movie_title;
		this.director = director;
		this.actor = actor;
		this.dist_company = dist_company;
		this.genre = genre;
		this.film_rating = film_rating;
		this.made_in = made_in;
		this.poster = poster;
		this.movie_desc = movie_desc;
		this.rel_date = rel_date;
		this.over_date = over_date;
		this.rel_state = rel_state;
	}

	// Movie Table에서 MovieControl의 innerTable로 목록 전달 
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
	
	public boolean movieInsertAction() {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String A = "Insert into movie (movie_title, director, actor, dist_company, genre, film_rating, made_in, poster, movie_desc, rel_date, over_date, rel_state)";
			String B = " values (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, movie_title);
			ps.setString(2, director);
			ps.setString(3, actor);
			ps.setString(4, dist_company);
			ps.setString(5, genre);
			ps.setString(6, film_rating);
			ps.setString(7, made_in);
			ps.setBinaryStream(8, poster);
			ps.setString(9, movie_desc);
			ps.setString(10, rel_date);
			ps.setString(11, over_date);
			ps.setString(12, rel_state);
			ps.executeUpdate();
			
			conn_mysql.close();
			
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean movieUpdateAction() {
		PreparedStatement ps = null;
		boolean result;
		
		String where1 = "Update movie set movie_title = ?, director = ?, actor = ?, dist_company = ?, genre = ?, film_rating = ?, "
					  + "made_in = ?, poster = ?, movie_desc = ?, rel_date = ?, over_date = ?, rel_state = ?";
		String where2 = " where movie_title = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//			Statement stmt_mysql = conn_mysql.createStatement();
			
			ps = conn_mysql.prepareStatement(where1+where2);
			ps.setString(1, movie_title);
			ps.setString(2, director);
			ps.setString(3, actor);
			ps.setString(4, dist_company);
			ps.setString(5, genre);
			ps.setString(6, film_rating);
			ps.setString(7, made_in);
			ps.setBinaryStream(8, poster);
			ps.setString(9, movie_desc);
			ps.setString(10, rel_date);
			ps.setString(11, over_date);
			ps.setString(12, rel_state);
			ps.setString(13, movie_title);
			ps.executeUpdate();
			
			conn_mysql.close();
			
		}catch(Exception e) {
			result = false;
		}
		result = true;
		return result;
	}
	
	public int checkMovieTitle() {
		int count = 0;
		
		String where1 = "select Count(movie_title) from movie ";
		String where2 = "where movie_title = '" + movie_title + "'";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(where1+where2);
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			conn_mysql.close();
			
		}catch(Exception e) {
			JOptionPane.showInternalMessageDialog(null, "check Movie_Title Error");
		}
		return count;
	}
}
