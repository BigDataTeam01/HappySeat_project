package com.javaproject.kioskFunction;

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

import javax.swing.ImageIcon;

import com.javaproject.base.ShareVar;
import com.javaproject.managerfunction.DtoLCY;

public class Dao_pjm {
	//Filed
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
	
	
	
	
	
	
	//construct
	public  Dao_pjm() {
		
	}





	// 영화선택 Page에서 사용할 Dao
	public Dao_pjm(String movie_title, String genre, String film_rating, FileInputStream poster) {
		super();
		this.movie_title = movie_title;
		this.genre = genre;
		this.film_rating = film_rating;
		this.poster = poster;
	}
	
	
	
	
	
	
	//Method
	
	
	public ArrayList<Dto_pjm> currentScreenMovie() {
		ArrayList<Dto_pjm> dtoList = new ArrayList<Dto_pjm>();
		String fetchQuery = "select "
						+ " m.movie_title," //1
						+ "	m.director,"	//2
						+ " m.actor, "		//3
						+ " m.dist_company,"//4
						+ " m.genre, "		//5
				  		+ " m.film_rating," //6
				  		+ " m.made_in,"		//7
				  		+ " m.poster,"		//8
				  		+ " m.movie_desc,"	//9
				  		+ " m.rel_date,"	//10
				  		+ " m.over_date,"	//11
				  		+ " m.rel_state"	//12
						+ " from movie as m "
						+ " where rel_state ="
						+ " '" + "상영중" + "'"; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ResultSet rs = stmt_mysql.executeQuery(fetchQuery);
			
			while(rs.next()) {
				String wkMovie_Title 	= rs.getString(1);
				String wkDirector 	 	= rs.getString(2);
				String wkActor 		 	= rs.getString(3);
				String wkDist_Company 	= rs.getString(4);
				String wkGenre 			= rs.getString(5);
				String wkFilm_Rating 	= rs.getString(6);
				String wkMade_In 		= rs.getString(7);
				String wkMovie_Desc 	= rs.getString(9);
				Date   wkRel_Date 		= rs.getDate  (10);
				Date   wkOver_Date 		= rs.getDate  (11);
				String wkRel_State 		= rs.getString(12);
				// image file
				ShareVar.filename = ShareVar.filename + 1;
//				System.out.println(ShareVar.filename);
				File posterImageFile = new File(Integer.toString(ShareVar.filename));
				FileOutputStream output = new FileOutputStream(posterImageFile);
				InputStream input = rs.getBinaryStream(8);
				byte[] buffer = new byte[1024];
				//System.out.println(wkActor);
				//System.out.println(wkMovie_Title);
				
				if (input != null) {
				    while(input.read(buffer) > 0) {
				        output.write(buffer);
				    }
				} else {
				    System.out.println("이 레코드에 대한 포스터가 null입니다.");
				}
				
				
				Dto_pjm dto = new Dto_pjm(wkDirector, wkMovie_Title, wkActor, wkDist_Company,
						wkGenre, wkFilm_Rating, wkMade_In, wkMovie_Desc,
						wkRel_Date, wkOver_Date, wkRel_State);
						
						
				dtoList.add(dto);
			}
			
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	
	
	
}
