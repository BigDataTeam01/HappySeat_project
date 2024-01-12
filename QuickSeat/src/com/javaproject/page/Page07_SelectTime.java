package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import com.javaproject.kioskFunction.Dao_SelectTime;
import com.javaproject.kioskFunction.Dao_pjm;
import com.javaproject.managerfunction.DtoWDH;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;

public class Page07_SelectTime extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 영화시간선택화면
	 * 				 1. SelectTime에서 이전화면 버튼을 터치했을시 SelectCinema 화면으로 이동
	 * 				 2. SelectTime에서 영화시간 버튼 터치시  SelectHeadCount 화면으로 이동
	 * 				 3. SelectTime에서 첫화면 버튼을 터치했을시  SelectMenu화면으로 이동
	 * 				 4. SelectTime에서 이전시간,다음시간 버튼을 터치했을시 settext로 다음,이전 데이터를 보여줌
	 * 	
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환
	 * 
	 * 
	 *  *  *  * Update 2024.01.8 by J.park:
	 * 			1. descripton 수정
	 * 			3. kiosk set bound sharevar 에서 가져와 지정
	 * 			4. diaog -> static 
	 * 			5. 배경 추가
	 * 			5. 첫화면,이전화면, 시간선택 추가
	 */
	
	
	/**
	 * Launch the application.
	 */

	private JLabel lblScreenRoom;
	private JLabel lblScr_Start_Time;
	private JLabel lblscreenPoster;
	private JLabel lblremainSeat;
	

	public static void main(String[] args) {
		
		try {
			Page07_SelectTime selectTimedialog = new Page07_SelectTime();
			selectTimedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			selectTimedialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page07_SelectTime() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				showCurrentScreen();
			}
		});
		// 타이틀 설정
		setTitle("시간 선택");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
//		setUndecorated(true);

		// 이전상영관 시간 버튼
		JLabel lbl_PreviousMovie = new JLabel("");
		lbl_PreviousMovie.setBounds(103, 503, 260, 50);
		lbl_PreviousMovie
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn이전버튼.png")));
//		contentPanel.add(lbl_PreviousMovie);

		//	페이지 타이틀 
		JLabel lbl_pageTitle = new JLabel("시간 선택");
		lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

		lbl_pageTitle.setBounds(295, 10, 250, 100);

		contentPanel.add(lbl_pageTitle);

		// 첫화면 아이콘
		JLabel lbl_pageTitle_1 = new JLabel("첫화면");
		lbl_pageTitle_1.setBounds(623, 20, 170, 130);
		lbl_pageTitle_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMenu();
			}
		});
		lbl_pageTitle_1
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));

		lbl_pageTitle_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		contentPanel.add(lbl_pageTitle_1);

		// 시간선택 배경(총 4개)
		
		
		JLabel lbl_MovieBackGround1 = new JLabel("");
		lbl_MovieBackGround1.setBounds(122, 170, 254, 132);
		lbl_MovieBackGround1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectHeadCount();
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("상영관");
		lblNewLabel_1.setBounds(248, 179, 115, 16);
//		contentPanel.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_1_3 = new JLabel("상영 시작시간");
		lblNewLabel_1_3.setBounds(248, 253, 115, 16);
//		contentPanel.add(lblNewLabel_1_3);
		
		
//		contentPanel.add(getLblScreenRoom());
//		contentPanel.add(getLblScr_Start_Time());
		contentPanel.add(getLblscreenPoster());
		showCurrentScreen();
//		contentPanel.add(getLblRemainSeat());
		
		lbl_MovieBackGround1
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_MovieBackGround1);
		

		JLabel lbl_MovieBackGround2 = new JLabel("");
		lbl_MovieBackGround2.setBounds(425, 170, 254, 132);
		lbl_MovieBackGround2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectHeadCount();
			}
		});
		lbl_MovieBackGround2
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_MovieBackGround2);
		

		JLabel lbl_MovieBackGround3 = new JLabel("");
		lbl_MovieBackGround3.setBounds(122, 340, 254, 132);
		lbl_MovieBackGround3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectHeadCount();
			}
		});
		lbl_MovieBackGround3
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_MovieBackGround3);

		JLabel lbl_MovieBackGround4 = new JLabel("");
		lbl_MovieBackGround4.setBounds(425, 340, 254, 132);
		lbl_MovieBackGround4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectHeadCount();
			}
		});
		lbl_MovieBackGround4
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_MovieBackGround4);
		
	
		// 다음상영관버튼
		JLabel lbl_NextMovie = new JLabel("");
		lbl_NextMovie.setBounds(561, 503, 198, 57);
		lbl_NextMovie.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn다음버튼.png")));
//		contentPanel.add(lbl_NextMovie);

		// 이전화면으로 가기
		JLabel BtnBackToPrevious = new JLabel("");
		BtnBackToPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectCinema();
			}
		});
		BtnBackToPrevious
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
		BtnBackToPrevious.setBounds(6, 21, 170, 130);
		contentPanel.add(BtnBackToPrevious);

		// 배경화면
		JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
		lbl_background.setBounds(0, 0, ShareVar.kiosk_width, ShareVar.kiosk_hight);
		lbl_background.setIcon(new ImageIcon(
				Page05_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		contentPanel.add(lbl_background);
		
	}
	
	private JLabel getLblScreenRoom() {
		if(lblScreenRoom == null) {
			this.lblScreenRoom = new JLabel("상영관 텍스트");
			lblScreenRoom.setBounds(248, 197, 115, 16);
		}
		return lblScreenRoom;
	}
	
	private JLabel getLblScr_Start_Time() {
		if (lblScr_Start_Time == null) {

			this.lblScr_Start_Time = new JLabel("상영시간 써줄거");
			lblScr_Start_Time.setBounds(248, 270, 115, 16);
			
			
		}
		return lblScr_Start_Time;
	}
	private JLabel getLblscreenPoster() {
		if (lblscreenPoster == null) {
			
			this.lblscreenPoster = new JLabel("");
			lblscreenPoster.setBounds(133, 179, 80, 110);

			
		}
		return lblscreenPoster;
	}

	private JLabel getLblRemainSeat() {
		if (lblremainSeat == null) {
			
			this.lblremainSeat = new JLabel("");
			lblremainSeat.setBounds(248, 234, 115, 16);
		}
		return lblremainSeat;
	}
	
//---------------------------Function------------------------
	// 다음화면(정화정보)로 가기
	private void goToSelectHeadCount() {
		Page08_SelectHeadCount selectHeadCountdialog = new Page08_SelectHeadCount();
		dispose();
		this.setVisible(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectHeadCountdialog.setVisible(true);
	}

	// 이전화면(극장선택)으로 가기
	private void SelectCinema() {
		dispose();
		Page06_SelectCinema selectCinemadialog = new Page06_SelectCinema();
		this.setVisible(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectCinemadialog.setVisible(true);
	}

	// 첫화면으로 가기
	private void goToSelectMenu() {
		dispose();
		Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
		this.setVisible(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}
	
	private void showCurrentScreen() {
		JLabel[] lblscr_scroom_nameArray = makeLabel();
		JLabel[] lblstart_timeArray = makeLabel();
		JLabel[] lblremainSeatCountArray = makeLabel();
		JLabel[] lblscrPosterArray = makeLabel();
		
		int boxNum = 4;
		for(int boxj = 0; boxj < boxNum; boxj++) {
			
			int remainSeatCount = 0;
			Dao_SelectTime dao = new Dao_SelectTime();
			ArrayList<DtoWDH> dtolist = dao.showScreen();
			String scr_scroom_name = dtolist.get(boxj).getScr_scroom_name();
			dtolist.get(boxj).getScr_start_time();
			String start_time = dtolist.get(boxj).getScr_start_time().substring(2,16);
			String remainSeat = dtolist.get(boxj).getSeat_resv_code();
			
			
			
			for(int ri = 0; ri < remainSeat.length(); ri++) {
				if(remainSeat.charAt(ri) == '0') {
					remainSeatCount++;
				}
			}
			
			int gapVertName = 20;
			int gapVertTime = 40;
			int gapVertRemain = 60;
			int gapLineVert1 = 20;
			int gapLineVert2 = 40;
			int gapLineVert3 = 60;
			int boxyPos_01 = 95;
			int boxyPos_02 = 265;
			
			
			int line_01 = boxyPos_01 + gapVertName;
			int line_02 = boxyPos_02 + gapVertName;
			// 첫번째행 
			if (boxj < 2) {	//							       pos_x			      pos_y		  			 			 width	   height
				lblscrPosterArray[boxj].setBounds		(133 + boxj * 300, 			179, 80, 110);
				lblscr_scroom_nameArray[boxj].setBounds	(220 + boxj * 300, 	 	line_01 + gapVertName  ,	  			   250, 	110);
				lblremainSeatCountArray[boxj].setBounds	(220 + boxj * 300,	 	line_01 + gapVertTime + gapLineVert1 , 	   250, 	110);
				lblstart_timeArray[boxj].setBounds		(220 + boxj * 300, 	 	line_01 + gapVertRemain + gapLineVert2 ,   250, 	110);
				
				
			//두번째행 1열
			} else if (boxj == 2) {
				lblscrPosterArray[boxj].setBounds		(133,						 349, 									80, 	110);
				lblscr_scroom_nameArray[boxj].setBounds	(220 ,			 	 	line_02 + gapVertName , 	   			   250,	    110);
				lblremainSeatCountArray[boxj].setBounds	(220 , 				  	line_02 + gapVertTime + gapLineVert1,	   250, 	110);
				lblstart_timeArray[boxj].setBounds		(220 , 				 	line_02 + gapVertRemain + gapLineVert2,    250, 	110);
			}
			//세번째행 2열
			else {
				lblscrPosterArray[boxj].setBounds		(133 + boxj * 300 / 3, 		 349, 									80, 	110);
				lblscr_scroom_nameArray[boxj].setBounds	(220 + boxj * 300 / 3, line_02 + gapVertName , 	  				   250,	    110);
				lblremainSeatCountArray[boxj].setBounds	(220 + boxj * 300 / 3, line_02 + gapVertTime + gapLineVert1 , 	   250, 	110);
				lblstart_timeArray[boxj].setBounds		(220 + boxj * 300 / 3, line_02 + gapVertRemain + gapLineVert2,	   250, 	110);
			}
			lblscr_scroom_nameArray[boxj].setText(scr_scroom_name);
			lblstart_timeArray[boxj].setText(start_time);
			lblremainSeatCountArray[boxj].setText("남은좌석 : " + Integer.toString(remainSeatCount) + "석");
			
			// Image 처리
			String filePath = Integer.toString(dao.screenPoster1);
			
			ImageIcon icon = new ImageIcon(filePath);
			Image changeImg = icon.getImage().getScaledInstance(80, 110, Image.SCALE_SMOOTH);
			
			lblscrPosterArray[boxj].setIcon(new ImageIcon(changeImg));
			lblscrPosterArray[boxj].setHorizontalAlignment(SwingConstants.CENTER);
			
			File file = new File(filePath);
			file.delete();
			
			}
		
				
	}

	private JLabel[] makeLabel() {
//		ArrayList<JLabel> makeLabel = new ArrayList<JLabel>();
		JLabel[] makeLabel = new JLabel[4];

		for (int i = 0; i < 4; i++) {
			JLabel temp = new JLabel();
			temp.setVisible(true);
			makeLabel[i] = temp;
//			int y = 200;
//			if (i > 2) {
//				
//				makeLabel[i].setBounds(133, 179 + y, 80, 110);
//			} else {
//				makeLabel[i].setBounds( 130 + i * 90, 179, 80, 110);
//			}
			makeLabel[i].setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			contentPanel.add(makeLabel[i]);
			
		}
		return makeLabel;
	}

}// End
