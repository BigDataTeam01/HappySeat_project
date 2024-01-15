package com.javaproject.kioskFunction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.Timestamp;
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
	String pay_method;
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
	
	// 영화 오리지날 가격 불러옴 
	public int fetchOriginalPrice() {
	    int originalPrice = 0;

	    String fetchQuery = "SELECT original_price FROM movie WHERE movie_title = '" + ShareVar.selectedMovieTitle + "'";

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
	        Statement stmt_mysql = conn_mysql.createStatement();	
	        ResultSet rs = stmt_mysql.executeQuery(fetchQuery);

	        if (rs.next()) {
	        	originalPrice = rs.getInt(1);
	        	
	        	ShareVar.originalTicketPrice = originalPrice;
	        }

	        conn_mysql.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return originalPrice;
	}
	//선택한 예약정보 db에 입력하기
	public boolean reserveInsertAction() {
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);



			//ps.setString(5, now); // 준비된 문에서 포맷된 타임스탬프를 resv_date 열에 설정
			
			String insertQuery = " insert into reserve ("
					+ "resv_cust_seq," 			//1 int
					+ "resv_scr_code," 			//2 int
					+ "resv_scr_movie_title," 	//3 string
					+ "resv_scr_scroom_name," 	//4 string
					+ "resv_date," 				//5 string
					+ "pay_method," 			//6 string
					+ "ticket_price," 			//7 int
					+ "seat_order)" 				//8 int
					+ " values (?,?,?,?,?,?,?,?)";
			
			System.out.println(" 쿼리들어가기 전");
			System.out.println(insertQuery);
			ps = conn_mysql.prepareStatement(insertQuery);
			ps.setInt	(1, ShareVar.cust_Seq);
			ps.setInt	(2, ShareVar.scr_code);
			ps.setString(3, ShareVar.selectedMovieTitle);
			ps.setString(4, ShareVar.selectedScroomName);
			ps.setString(5, ShareVar.timeReserved);
			ps.setString(6, ShareVar.pay_method);
			ps.setInt	(7, ShareVar.currentCutomersTicketPrice);
			ps.setInt	(8, ShareVar.selectedSeatSeq.get(ShareVar.currentSeatOrder));
			System.out.println(" 쿼리업데이트  전");
			System.out.println(ps);
//			ps.setBinaryStream(8, poster);                           고객번호, 영화관 상영 코드 어떻게넣는지 확인필요@@@@@
//			ps.setBinaryStream(8, poster);
			ps.executeUpdate();
			
			System.out.println("---------------------------최종 쿼리");
			
			System.out.println(ps);
			conn_mysql.close();
			
			
			
//			
//			String A = " ``, `resv_date`, `pay_method`, `ticket_price`, `seat_order`) \\r\\n "    
//					+ " values (?,?,\" +ShareVar.selectedMovieTitle+ \",\"+ShareVar.selectedCienma+\","
//					+ "\"+\"선택된 시간이 들어갈 자리\"+\",\"+ShareVar.pay_method+ \",\"+ShareVar.totalPrice+\","
//					+ "\"+\"좌석번호가 들어갈 자리\"+\");\\r\\n";
			
		}catch(Exception e) {
			return false;
		}
		return true;
	}

	public class MovieDAO {
		// 선택된 영화의 초기 가격을 불러오는 메서드
		public int fetchMoviePriceBeforeDiscount(String selectedMovieTitle) {
			int moviePriceBeforeDiscount = 0;

			String fetchQuery = "SELECT movie_price_beforediscount FROM movie WHERE movie_title = '"
					+ selectedMovieTitle + "'";

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
	}

	
	// db에서 발권번호 가지고 오기
	public String confirmReservedTicket() {
		String ticketNumber = null;

		String fetchQuery = "SELECT ticket_number FROM reserve";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(fetchQuery);

			if (rs.next()) {
				ticketNumber = rs.getString("ticket_number");
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ticketNumber;
	}
	
	// 고객 나이 입력
	public void insertCustomerInfo() {
		System.out.println("쿼리실행");

		try {
			// 0 1 2 3 4
			// 일 청 경 유 장
			String[] personCategory_String = { "일반", "청소년", "경로우대", "국가유공자", "장애인" };
			// [2 0 3 0 4]

			// personCategory= [1,0,0,0,2]

			for (int i = 0; i < 5; i++) {

				if (ShareVar.personCategory[i] != 0) {

					String customerType_String = "";

					// 고객 유형의 인트값을 스트링으로 변환하여 실제 한글을 보여주는 코드
					customerType_String = personCategory_String[i];

					// 만약 일반이 1이 아니라 2명세명일 경우 그 숫자만큼 티켓을 생성해야함. 그래서 이중포문!
					for (int j = 0; j < ShareVar.personCategory[i]; j++) {

						PreparedStatement ps = null;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);

						String insertQuery = "INSERT INTO customer (cust_age, cust_type, discount_rate) VALUES (?,?,?)";
						
						
						// 우리는 여기서 무엇을 할것인가?
						// 먼저. 커스터머 테이블에 레코드를 추가한다. 
						// 그리고 하나 추가될때마다 sharvar.cust_age,cust_type,discount_rate 모두를 업데이트한다. 
						// 그다음에? 
						// fetchCurrentCustomerSeq 메서드를 이용해서 가장 최근의 customoer 의 primary key 를 가져온다. 
						// 그리고 그 primary key 를 sharVar. cust_seq 에 저장한다. 
						
						// 최종적으로 reserve table 에 cust_seq를 포함한 모든것을 추가하여 업데이트한다. 
						// 이와같은 행동을 마치면 다시 이 포문으로 들어와서 실행을 반복한다. 
						
						
						
						ps = conn_mysql.prepareStatement(insertQuery);
						ps.setInt(1, ShareVar.selectedCustage);
						ps.setString(2, customerType_String);
						ps.setString(3, Integer.toString((int)ShareVar.discountRates[i]));
						ps.executeUpdate();
						System.out.println("고객나이 입력됨");
						conn_mysql.close();
						
						ShareVar.currentCutomersTicketPrice = (int) ((int) ShareVar.originalTicketPrice *(1-(ShareVar.discountRates[i]/100.0)));
						
						System.out.println("-------------=-=-=-=-=-");
						System.out.println(ShareVar.originalTicketPrice);
						System.out.println(ShareVar.discountRates[i]);
						System.out.println("원래 티켓 가격: " + ShareVar.originalTicketPrice);
						System.out.println("할인율: " + ShareVar.discountRates[i]);
						ShareVar.currentSeatOrder = i;
						
						//맨 마지막 고객의 cust_seq를 sharevar에 넣어준다
						fetchCurrentCustomerSeq();
						
						System.out.println(" 이새끼가 되야한다. 알겠냐?");
						reserveInsertAction();
						
						
					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	//만약 고객 db에 들어간 row 갯수가 5개라면 
	//db 고객테이블에서 결제한 고객의 custSeq 가져오기
	public void fetchCurrentCustomerSeq() {
		String timeNow= null;

		String fetchCustSeqQuerry = "select *,now() from customer order by cust_seq desc limit 1";
		String fetchNow = " select now()";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(fetchCustSeqQuerry);

			if (rs.next()) {
				ShareVar.cust_Seq = rs.getInt(1);

			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(fetchNow);

			if (rs.next()) {

				System.out.println("current time");
				System.out.println(rs.getString(1));
				timeNow = rs.getString(1);
			}
			

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ShareVar.timeReserved= timeNow;
		

	}
	

	
	
}//-------------end


	

