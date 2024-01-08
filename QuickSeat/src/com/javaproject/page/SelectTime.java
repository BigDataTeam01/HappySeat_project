package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;

public class SelectTime extends JDialog {

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

	private static SelectTime SelectTimedialog = new SelectTime();
	private static SelectCinema SelectCinemadialog = new SelectCinema();
	private static SelectMenu selectMenudialog = new SelectMenu();
	private static SelectHeadCount SelectHeadCountdialog = new SelectHeadCount();

	public static void main(String[] args) {
		try {
			SelectTimedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			SelectTimedialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectTime() {
		// 타이틀 설정
		setTitle("시간 선택");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// 이전화면, 다음화면 버튼
		JLabel lbl_PreviousMovie = new JLabel("");
		lbl_PreviousMovie.setBounds(117, 398, 145, 49);
		lbl_PreviousMovie
				.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn이전버튼.png")));
		contentPanel.add(lbl_PreviousMovie);

//	페이지 타이틀 
		JLabel lbl_pageTitle = new JLabel("시간 선택");
		lbl_pageTitle.setBounds(295, 10, 250, 100);
		lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

		contentPanel.add(lbl_pageTitle);

		// 첫화면 아이콘
		JLabel lbl_pageTitle_1 = new JLabel("첫화면");
		lbl_pageTitle_1.setBounds(12, 30, 46, 68);
		lbl_pageTitle_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMenu();
			}
		});
		lbl_pageTitle_1
				.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/첫화면Icon.png")));

		lbl_pageTitle_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		contentPanel.add(lbl_pageTitle_1);

		// 시간선택 배경(총 4개)
		JLabel lbl_MovieBackGround1 = new JLabel("");
		lbl_MovieBackGround1.setBounds(117, 98, 254, 132);
		lbl_MovieBackGround1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectHeadCount();
			}
		});
		lbl_MovieBackGround1
				.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_MovieBackGround1);

		JLabel lbl_MovieBackGround2 = new JLabel("");
		lbl_MovieBackGround2.setBounds(429, 98, 254, 132);
		lbl_MovieBackGround2
				.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_MovieBackGround2);

		JLabel lbl_MovieBackGround3 = new JLabel("");
		lbl_MovieBackGround3.setBounds(117, 256, 254, 132);
		lbl_MovieBackGround3
				.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_MovieBackGround3);

		JLabel lbl_MovieBackGround4 = new JLabel("");
		lbl_MovieBackGround4.setBounds(429, 256, 254, 132);
		lbl_MovieBackGround4
				.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_MovieBackGround4);

		JLabel lbl_NextMovie = new JLabel("");
		lbl_NextMovie.setBounds(538, 398, 145, 60);
		lbl_NextMovie.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn다음버튼.png")));
		contentPanel.add(lbl_NextMovie);

		// 이전화면으로 가기
		JLabel BtnBackToPrevious = new JLabel("");
		BtnBackToPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectCinema();
			}
		});
		BtnBackToPrevious
				.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn 이전화면.png")));
		BtnBackToPrevious.setBounds(295, 441, 200, 100);
		contentPanel.add(BtnBackToPrevious);

		// 배경화면
		JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
		lbl_background.setBounds(-16, 0, 800, 600);
		lbl_background.setIcon(new ImageIcon(
				MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		contentPanel.add(lbl_background);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

//---------------------------Function------------------------
	// 다음화면(정화정보)로 가기
	private void goToSelectHeadCount() {
		dispose();
		SelectTimedialog.setVisible(false);
		SelectTimedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectHeadCountdialog.setVisible(true);
	}

	// 이전화면(극장선택)으로 가기
	private void SelectCinema() {
		dispose();
		SelectTimedialog.setVisible(false);
		SelectTimedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectCinemadialog.setVisible(true);
	}

	// 첫화면으로 가기
	private void goToSelectMenu() {
		dispose();
		SelectTimedialog.setVisible(false);
		SelectTimedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}

}// End
