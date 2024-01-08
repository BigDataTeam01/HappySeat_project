package com.javaproject.base;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

//import com.javaproject.page.MovieInformation;

public class ShareVar {
	//개발 시작
	
	/* Description : 공통변수 관리 
	 * 
	 * Update 2024.01.05 by LCY:	
	 * 			1.메니저페이지 사이즈및 위치 
	 * 	
	 * Update 2024.01.06 by PDG:
	 * 			1. sql DB server  로그인 정보 
	 * 			2. kiosk 사이즈 및 위치 
	 * 			3. kiosk page title 사이즈 및 위치
	 * 
	 */
	
	public static String dbName = "jdbc:mysql://192.168.50.103:3306/quick_seat?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static String dbUser = "root";
	public static String dbPass = "qwer1234";
	
	//manager page gui siz
	public static int managerXsize = 800;
	public static int managerYsize = 600;
	
	//manager page gui  location 
	public static int managerXlocation = 655;
	public static int managerYlocation = 250;
	
	
	/////-------키오스크 페이지 규격
	//kiosk page gui siz
	public static int kiosk_width = 800;
	public static int kiosk_hight = 600;
		//kosk page gui  location 
	public static int kiosk_loc_x = 655;
	public static int kiosk_loc_y = 250;
	/* 키오스크 규격 예시
	  	setTitle("영화정보");
		setBounds(ShareVar.kiosk_loc_x,
		 		  ShareVar.kiosk_loc_y,
		 		  ShareVar.kiosk_width, 
		 		  ShareVar.kiosk_hight);
	 */
		
	/////-------키오스크 페이지 타이틀 
	//kiosk title size
	public static int kiosk_title_width = 250;
	public static int kiosk_title_hight = 100;
	//kosk title  location 
	public static int kiosk_title_loc_x = 295;
	public static int kiosk_title_loc_y = 10;
	public static int kiosk_title_font_size = 40;
	public static String kiosk_title_font = "배달의민족 도현";
	
	/*	페이지 타이틀 예시 
		JLabel lbl_pageTitle = new JLabel("영화 선택");
		lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font,
		 								Font.PLAIN, 
		 								ShareVar.kiosk_title_font_size));
		 								
		lbl_pageTitle.setBounds(ShareVar.kiosk_title_loc_x, 
								ShareVar.kiosk_title_loc_y, 
								ShareVar.kiosk_title_width,
								ShareVar.kiosk_title_hight);
	 */
	
	
	
	/////-------포스터 이미지 규격
	public static int poster_width = 380;
	public static int poster_hight = 450;
	
	/*	포스터 규격 예시	
		lblPoster.setBounds(34, 101, ShareVar.poster_width, ShareVar.poster_hight);
	*/
	
	
	
	// constructor
	public ShareVar() {
		// TODO Auto-generated constructor stub
	}
	
	
}
