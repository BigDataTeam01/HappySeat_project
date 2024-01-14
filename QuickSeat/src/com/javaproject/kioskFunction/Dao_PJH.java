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

import com.javaproject.base.ShareVar;
import com.javaproject.managerfunction.DtoWDH;

public class Dao_PJH {
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
	int  movie_run_time;
	String cinema_branch;
	String get_here;
	FileInputStream location_map;
	int resv_cust_seq;
	int resv_scr_code;
	String resv_scr_movie_title;
	String resv_scr_scroom_name;
	String resv_date;	//++++++++++++++++++date 값 어떻게 받는지 확인필요(일단 스트링으로 받음)
	int ticket_price;
	int seat_order;
	
	//construct
	public  Dao_PJH() {
		
	}
	

	public Dao_PJH(String movie_title) {
		super();
		this.movie_title = movie_title;
	}








	//극장선택에 사용하는 Dao
	public Dao_PJH(String cinema_branch, String get_here, FileInputStream location_map) {
		super();
		this.cinema_branch = cinema_branch;
		this.get_here = get_here;
		this.location_map = location_map;
	}


	// 영화정보 Page에서 사용할 Dao
	public Dao_PJH(String movie_title, String director, String actor, String dist_company, String genre,
			String film_rating, String made_in, FileInputStream poster, String movie_desc, Date rel_date,
			Date over_date, String rel_state) {
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

	//Method
	public ArrayList<Dto_PJH> SelectedMovie() {
		ArrayList<Dto_PJH> dtoList = new ArrayList<Dto_PJH>();
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
//		System.out.println(fetchQuery);
		
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
				String wkmovie_run_time = rs.getString(13);
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
				
				
				Dto_PJH dto = new Dto_PJH(wkDirector, wkMovie_Title, wkActor, wkDist_Company, 
										  wkGenre, wkFilm_Rating, wkMade_In, wkMovie_Desc, 
										  wkRel_Date, wkOver_Date, wkRel_State, wkmovie_run_time);
						
				dtoList.add(dto);
			}
			
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public ArrayList<Dto_PJH> movie_Info() {
		ArrayList<Dto_PJH> dtoList = new ArrayList<Dto_PJH>();
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
				  		+ " m.rel_state,"	//12
				  		+ " m.movie_run_time"//13
						+ " from movie as m "
						+ " where m.movie_title ="
						+ " '" + movie_title + "'"; 
//		System.out.println(movie_title);
		
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
				String wkmovie_run_time = rs.getString(13);
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
				
				
				Dto_PJH dto = new Dto_PJH(wkDirector, wkMovie_Title, wkActor, wkDist_Company,
										  wkGenre, wkFilm_Rating, wkMade_In, wkMovie_Desc, 
										  wkRel_Date, wkOver_Date, wkRel_State, wkmovie_run_time);
						
						
				dtoList.add(dto);
			}
			
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	//상영관 정보 불러옴. 
	public ArrayList<Dto_PJH> cinema_Info() {
		ArrayList<Dto_PJH> dtoList = new ArrayList<Dto_PJH>();
		String fetchQuery = 
						  "select "
						+ " cinema_branch, " 		//1
						+ "	get_here, "				//2
						+ " location_map "			//3
						+ " from screening_room "	
						+ " where scroom_name "	
						+ " in (select scr_scroom_name"
						+ " from screen"
						+ " where scr_movie_title ="
						+ "'"+ ShareVar.selectedMovieTitle+"')"; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(fetchQuery);
			
			while(rs.next()) {
				String cinema_branch	= rs.getString(1);
				String get_here 	 	= rs.getString(2);
				// image file
				ShareVar.cinemaMapImageFileName = cinema_branch+ "_"+"MapImage";
				
				System.out.println(ShareVar.cinemaMapImageFileName);
				System.out.println("--------------------8998989");
				File location_mapImageFile = new File(ShareVar.cinemaMapImageFileName);
				FileOutputStream output = new FileOutputStream(location_mapImageFile);
				InputStream input = rs.getBinaryStream(3);
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
				
			
				Dto_PJH dto = new Dto_PJH(cinema_branch, get_here);				
				dtoList.add(dto);
				
			}
			
//			System.out.println(ShareVar.cinemaMapImageFileName);
//			System.out.println("어쩔티비");
			conn_mysql.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	// 상영코드 불러오기
	public int scr_code_fetch() {
		
		int scr_code_fetch = 0; 
		
		String whereA = "select s.scr_code";
		String whereB = " from screen as s, movie as m";
		String whereC = " where s.scr_movie_title = m.movie_title and s.scr_movie_title = '" + ShareVar.selectedMovieTitle + "'"
				+ " and s.scr_scroom_name = '"+ ShareVar.selectedScroomName + "'" + " and s.scr_start_time = '"+ ShareVar.selectedScrStarttime+"'"  ;
		
		System.out.println(whereA + whereB + whereC);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereA + whereB + whereC);

			while (rs.next()) {
				scr_code_fetch = rs.getInt(1);


			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return scr_code_fetch;
	}
	
	
	//선택된 영화 초기가격 불러옴. 
	public int MoviePriceBeforeDiscount() {
	    int moviePriceBeforeDiscount = 0;

	    String fetchQuery = "SELECT movie_price_beforediscount FROM movie WHERE movie_title = '" + ShareVar.selectedMovieTitle + "'";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();
	        ResultSet rs = stmt_mysql.executeQuery(fetchQuery);

	        if (rs.next()) {
	            moviePriceBeforeDiscount = rs.getInt("movie_price_beforediscount");
	        }

	        conn_mysql.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return moviePriceBeforeDiscount;
	}
	
	public boolean movieInsertAction() {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			
			String A = "INSERT INTO `quick_seat`.`reserve` (`resv_cust_seq`, `resv_scr_code`, `resv_scr_movie_title`, `resv_scr_scroom_name`, `resv_date`, `pay_method`, `ticket_price`, `seat_order`) \\r\\n "    
					+ " values (?,?,\" +ShareVar.selectedMovieTitle+ \",\"+ShareVar.selectedCienma+\",\"+\"선택된 시간이 들어갈 자리\"+\",\"+ShareVar.pay_method+ \",\"+ShareVar.totalPrice+\",\"+\"좌석번호가 들어갈 자리\"+\");\\r\\n";
			
			ps = conn_mysql.prepareStatement(A);
			ps.setInt(1, resv_cust_seq);
			ps.setInt(2, resv_scr_code);
			ps.setString(3, resv_scr_movie_title);
			ps.setString(4, resv_scr_scroom_name);
			ps.setString(5, resv_date);
			ps.setInt(6, ticket_price);
			ps.setInt(7, seat_order);
//			ps.setBinaryStream(8, poster);                           고객번호, 영화관 상영 코드 어떻게넣는지 확인필요@@@@@
//			ps.setBinaryStream(8, poster);
			ps.executeUpdate();
			
			conn_mysql.close();
			
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	
}

	
	
	

