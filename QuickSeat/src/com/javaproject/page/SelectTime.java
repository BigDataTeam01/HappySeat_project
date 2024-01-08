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
	 * Description : 영화시간선택화면 1. SelectTime에서 이전화면 버튼을 터치했을시 SelectCinema 화면으로 이동 2.
	 * SelectTime에서 영화시간 버튼 터치시 SelectHeadCount 화면으로 이동 3. SelectTime에서 첫화면 버튼을
	 * 터치했을시 SelectMenu화면으로 이동 4. SelectTime에서 이전시간,다음시간 버튼을 터치했을시 settext로 다음,이전
	 * 데이터를 보여줌
	 * 
	 * Date : 2024.01.05 (금요일) Author : 박정민,박지환
	 * 
	 * 
<<<<<<< HEAD
	 * * * * Update 2024.01.7 by J.park: 1. descripton 수정 3. kiosk set bound
	 * sharevar 에서 가져와 지정 4. diaog -> static 5. 배경 추가 5. 첫화면,이전화면, 시간선택 추가
=======
	 *  *  *  * Update 2024.01.8 by J.park:
	 * 			1. descripton 수정
	 * 			3. kiosk set bound sharevar 에서 가져와 지정
	 * 			4. diaog -> static 
	 * 			5. 배경 추가
	 * 			5. 첫화면,이전화면, 시간선택 추가
>>>>>>> d4df7ed6a56e40630e34ee9b4f15c8a34760699e
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

//	페이지 타이틀 
		JLabel lbl_pageTitle = new JLabel("시간 선택");
		lbl_pageTitle.setBounds(295, 10, 250, 100);
		lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

		contentPanel.add(lbl_pageTitle);

		contentPanel.add(lbl_pageTitle);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/GoFirstPage.png")));
		lblNewLabel_1.setBounds(628, 38, 172, 130);
		contentPanel.add(lblNewLabel_1);
		
					JLabel lblNewLabel_2 = new JLabel("");
					lblNewLabel_2.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/Backbtn.png")));
					lblNewLabel_2.setBounds(11, 39, 161, 130);
					contentPanel.add(lblNewLabel_2);

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
			// 첫화면으로 이전으로 가기 버튼
			contentPanel.add(lbl_background);
		}
	}

}// End
