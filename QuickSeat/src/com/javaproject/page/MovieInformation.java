package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font; // FONT library

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;




public class MovieInformation extends JDialog{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private static final String VIDEO_URL = "https://youtu.be/bLvqoHBptjg?si=nwLN3uBeu65fFt-q"; // 동영상 URL
	
	/*
	 * Description : 현재 상영중인 영화 목록을 보여주고 고객이 영화를 선택할수 있도록 하는 페이지
	 * 
	 * 				 0.이 페이지는 SelectCinema 으로 부터 이동됨.
	 * 				 1.MovieInformation에서 영화선택 btn -> SelectCinema 화면
	 * 
	 * 				 2.SelectInformation에서 이전화면 버튼을 터치했을시  SelectMovie 화면으로 이동?
	 * 				 3.SelectInformation에서 첫화면 버튼을 터치했을시  SelectMenu 화면으로 이동?
	 * 
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환, 박동근
	 * 
	 * Update 2024.01.06 by PDG:
	 * 			1. descripton 수정
	 * 			2. Test code 작성
	 * 			3. kiosk set bound sharevar 에서 가져와 지정
	 * 			4. diaog -> static 
	 * 			5. 배경 만듬
	 * 			6. 배민 도현 추가하여 페이지 타이틀 생성
	 */
	
	/**
	 * Launch the application.
	 */
	private static MovieInformation dialog = new MovieInformation();

	
	
	
	public static void main(String[] args) {
		
		
		
		
		try {
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MovieInformation() {
		setTitle("영화정보");
		setBounds(ShareVar.kiosk_loc_x, 
				  ShareVar.kiosk_loc_y, 
				  ShareVar.kiosk_width, 
				  ShareVar.kiosk_hight);
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblPoster = new JLabel("");
		lblPoster.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]포스터_포레스트검프.png")));
		lblPoster.setBounds(34, 101, ShareVar.poster_width, ShareVar.poster_hight);
		contentPanel.add(lblPoster);

		
		//	페이지 타이틀 예시 
		JLabel lblPageTitle = new JLabel("영화 정보");
		lblPageTitle.setFont(new Font(ShareVar.kiosk_title_font,
		 								Font.PLAIN, 
		 								ShareVar.kiosk_title_font_size));
		 								
		lblPageTitle.setBounds(ShareVar.kiosk_title_loc_x, 
								ShareVar.kiosk_title_loc_y, 
								ShareVar.kiosk_title_width,
								ShareVar.kiosk_title_hight);
		
		contentPanel.add(lblPageTitle);
		
		
		
		
		
		JLabel lblPageBackground = new JLabel("",SwingConstants.CENTER);
		//lblNewLabel.
		//Font font = new ("도현체")
		lblPageBackground.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lblPageBackground.setBounds(0, 0, 800, 600);
		contentPanel.add(lblPageBackground);
	}
	
	// Tescode 
	
	public void testMovieInformation() {
		
		
		// 1. 내가 이전 페이지 에서 선택한 영화의 정보를 DB 에서 불러올수 있는가?
		System.out.println("1. 내가 이전 페이지 에서 선택한 영화의 정보를 DB 에서 불러올수 있는가? ");
		String reuslt = "Error!";
		System.err.println(reuslt);
		

		
	}


	
	
}// END
