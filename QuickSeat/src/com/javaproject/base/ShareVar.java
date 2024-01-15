package com.javaproject.base;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

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
	 * Update 2024.01.14 by PDG 
	 * 			1.  쓸데 없는 주석지우고 읽기편하게 함. 
	 * 			2.  키오스크 버튼에 들어갈 공용 칼라 만듬. 
	 * 
	 */
	
	// Field
	///////////////0-------------------------------- DB 정보 ------------------/////////////
	//
	public static String dbName = "jdbc:mysql://192.168.50.103:3306/quick_seat?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	//public static String dbName = "jdbc:mysql://127.0.0.1:3306/quick_seat?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static String dbUser = "root";
	public static String dbPass = "qwer1234";
	///////////////0---------------------------------스플레시 타임 정보------------------/////////////
	
	public static int backToSplashTime = 100 ; // 100 초후 스플래쉬로 돌아감. 
	
	///////////////0---------------------------------관리자 페이지 관련 정보 ------------------/////////////
	// manager page gui siz
	public static int managerXsize = 800;
	public static int managerYsize = 600;

	// manager page gui location
	public static int managerXlocation = 655;
	public static int managerYlocation = 250;
	
	///////////////0---------------------------------키오스크 관련 정보 ------------------/////////////
	
	///// -------키오스크 페이지 규격
	// kiosk page gui siz
	public static int kiosk_width = 800;
	public static int kiosk_hight = 600;
	// kosk page gui location
	public static int kiosk_loc_x = 655;
	public static int kiosk_loc_y = 250;

	///// -------키오스크 페이지 타이틀 규격
	
	// kiosk title size
	public static int kiosk_title_width = 250;
	public static int kiosk_title_hight = 100;
	
	// kosk title location
	public static int kiosk_title_loc_x = 295;
	public static int kiosk_title_loc_y = 10;
	public static int kiosk_title_font_size = 40;
	
	// kiosk font
	public static String kiosk_title_font = "BM Dohyeon";
	
	// kiosk button color
	
	public static Color btnFillColor = new Color(42, 93, 67);//#2a5d43ff = 42, 93, 67
	public static Color btnTextColor = new Color(243, 192, 0);//#f3c000  = 243, 192, 0
	
	// KIOSK BUTTON FILLET
	public static int btnFillet = 20;


	public static int filename = 0;
	public static int image = 0;

	///// -------포스터 이미지 규격
	public static int poster_width = 380;
	public static int poster_hight = 450;

	// 관리자 아이디 저장공간
	public static String managerID = "";

	// 선택된 영화 정보
	public static String selectedMovieTitle = "";

	// 상영하다 테이블 프라이머리 키 
	public static int scr_code = 0;

	// 관리자 페이지 차트 연도와 달 저장하기
	public static String year = "2020";
	public static String month = "01";

	// 영화관 지도 이미지
	public static String cinemaMapImageFileName = "";

	// 선택된 영화관
	public static String selectedCienma = "입력이 안되었습니다";

	// 선택된 나이
	public static int selectedCustage = 0;

	// 선택된 인원수
	public static int sumOfPersonNumbers = 0;
	
	// 선택된 영화포스터
	public static String posterFile = "";
	
	// 선택된 상영관 이륾
	public static String selectedScroomName ="";
	
	// 선택된 상영 영화 시작시간 
	public static String selectedScrStarttime="";
	
	// 입력된 발권번호
	public static String insertedOrderNum = "";

	//인원선택 분류 어레이 
	public static int[] personCategory = new int[5];
	
	// 구매방법(현금,카드 구분)
	public static String pay_method = "";
	
	// 발권가격(할인된 티켓가격의 총 가격)
	public static int totalPrice = 0;
	
	// 할인율 어레이
	
	// 각 할인율을 설정				      // 	일반  청소년		경로우대		유공자	장애인
	public static double[] discountRates = {    0.0,	   50.0,	 	   50.0,		  50.0,	  50.0 }; 
	
	// 각 인원분류별 할인 후의 가격
   // public static int[] totalDiscountedPrice = new int[5];
    public static int[] totalDiscountedPriceArray = {1000,1000,2000,4000,5000};
    
    // 예시로 만들어보자. 
    
    
    //
    public static ArrayList<Integer> selectedSeatSeq = new ArrayList<Integer>();
	
     // Db에서 불러온 영화에 대한 좌석 현황 Code
    public static StringBuilder dbSeatCode = new StringBuilder("");
    
    // 고객 시퀀스 불러오기
 	public static int cust_Seq = 0;
 	
 	//  하나 추가될때마다 sharvar.cust_age,cust_type,discount_rate 모두를 업데이트한다. 
	
 	public static String cust_type = "";
 	
 	public static int cust_age = 0;
	
 	public static double cust_discount_rate = 0;
 	
 	// 고객이 예매한 시간. 
 	public static String timeReserved ="";
 	
 	// 현재 추가되는 고객의 티켓에 대한 가격 이가격은 배열이아니다. !!!
 	public static int currentCutomersTicketPrice=0;
 	
 	public static int originalTicketPrice =0;

 	public static int currentSeatOrder= 0;
 	
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
		scr_code = 0;

		// 관리자 페이지 차트 연도와 달 저장하기
		year = "";
		month = "";

		// 영화관 지도 이미지
		cinemaMapImageFileName = "영화관 지도 이미지 입력이 안되었습니다";

		// 선택된 영화관
		selectedCienma = "선택된 영화관 입력이 안되었습니다";
		
		// 선택된 나이
		selectedCustage = 0;
		
		// 선택된 인원수
		sumOfPersonNumbers = 0;
		
		//입력된 발권번호숫자
		insertedOrderNum = "";
		
		// 인원선택 분류 어레이 (어레이라 다 지우려고 for문 사용)
		for (int i = 0; i < personCategory.length; i++) {
			personCategory[i] = 0;        	
		}

		//  각 인원분류별 할인 후의 가격 (어레이라 다 지우려고 for문 사용)
		for (int i = 0; i < totalDiscountedPriceArray.length; i++) {
			totalDiscountedPriceArray[i] = 0;        	
		}
		
		selectedSeatSeq.removeAll(selectedSeatSeq);



     // 구매방법(현금,카드 구분)
    	pay_method = "";
    	
    	// 발권가격(할인된 티켓가격의 총 가격)
    	totalPrice = 0;
    	
    	// 고객 시퀀스 불러오기
    	cust_Seq = 0;
	}
	
	
}
