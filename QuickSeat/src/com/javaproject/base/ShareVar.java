package com.javaproject.base;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//import com.javaproject.page.Page5_MovieInformation;

public class ShareVar {
	// 개발 시작

	/*
	 * Description : 공통변수 관리
	 * 
	 * Update 2024.01.05 by LCY: 1.메니저페이지 사이즈및 위치
	 * 
	 * Update 2024.01.06 by PDG: 1. sql DB server 로그인 정보 2. kiosk 사이즈 및 위치 3. kiosk
	 * page title 사이즈 및 위치
	 * 
	 */

	public static String dbName = "jdbc:mysql://192.168.50.103:3306/quick_seat?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static String dbUser = "root";
	public static String dbPass = "qwer1234";

	// manager page gui siz
	public static int managerXsize = 800;
	public static int managerYsize = 600;

	// manager page gui location
	public static int managerXlocation = 655;
	public static int managerYlocation = 250;

	///// -------키오스크 페이지 규격
	// kiosk page gui siz
	public static int kiosk_width = 800;
	public static int kiosk_hight = 600;
	// kosk page gui location
	public static int kiosk_loc_x = 655;
	public static int kiosk_loc_y = 250;
	/*
	 * 키오스크 규격 예시 setTitle("영화정보"); setBounds(ShareVar.kiosk_loc_x,
	 * ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);
	 */

	///// -------키오스크 페이지 타이틀
	// kiosk title size
	public static int kiosk_title_width = 250;
	public static int kiosk_title_hight = 100;
	// kosk title location
	public static int kiosk_title_loc_x = 295;
	public static int kiosk_title_loc_y = 10;
	public static int kiosk_title_font_size = 40;
	public static String kiosk_title_font = "BM Dohyeon";

	/*
	 * 페이지 타이틀 예시 JLabel lbl_pageTitle = new JLabel("영화 선택");
	 * lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN,
	 * ShareVar.kiosk_title_font_size));
	 * 
	 * lbl_pageTitle.setBounds(ShareVar.kiosk_title_loc_x,
	 * ShareVar.kiosk_title_loc_y, ShareVar.kiosk_title_width,
	 * ShareVar.kiosk_title_hight);
	 */

	public static int filename = 0;
	public static int image = 0;

	///// -------포스터 이미지 규격
	public static int poster_width = 380;
	public static int poster_hight = 450;

	/*
	 * 포스터 규격 예시 lblPoster.setBounds(34, 101, ShareVar.poster_width,
	 * ShareVar.poster_hight);
	 */

	// 관리자 아이디 저장공간
	public static String managerID = "admin";

	// 선택된 영화 정보
	public static String selectedMovieTitle = "";

	// 상영하다 테이블 프라이머리 키 
	public static int scr_code = 7;

	// 관리자 페이지 차트 연도와 달 저장하기
	public static String year = "";
	public static String month = "";
	
	// 영화관 지도 이미지
	public static String cinemaMapImageFileName = "";
	

	// 선택된 영화관
	public static String selectedCienma = "입력이 안되었습니다";
	
	
	
	// constructor
	public ShareVar() {
		// TODO Auto-generated constructor stub
	}

	//Method
	
	public void shareVarInint() {
		System.out.println(" 초기화 됨 ");
		// 관리자 아이디 저장공간
		managerID = "메니저 아이디가 입력이 안되었습니다";

		// 선택된 영화 정보
		selectedMovieTitle = "선택된 영화 정보 입력이 안되었습니다";

		// 상영하다 테이블 프라이머리 키
		scr_code = 7;

		// 관리자 페이지 차트 연도와 달 저장하기
		year = "";
		month = "";

		// 영화관 지도 이미지
		cinemaMapImageFileName = "영화관 지도 이미지 입력이 안되었습니다";

		// 선택된 영화관
		selectedCienma = "선택된 영화관 입력이 안되었습니다";
		
		
		
	}
	
	
}