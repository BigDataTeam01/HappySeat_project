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
import java.awt.Color;

public class SelectCinema extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	/*
	 * Description : 영화선택 화면
	 * 				 1. SelectCinema에서 이전화면 버튼을 터치했을시 MovieInformation 화면으로 이동
	 * 				 2. SelectCinema에서 극장 버튼을 터치했을시  SelectTime 화면으로 이동
	 * 				 3. SelectCinema에서 첫화면 버튼을 터치했을시  SelectMenu화면으로 이동
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환
	 * 
	 *   *  *  * Update 2024.01.07 by J.park:
	 * 			1. descripton 수정
	 * 			3. kiosk set bound sharevar 에서 가져와 지정
	 * 			4. diaog -> static 
	 * 			5. 배경 추가
	 * 			5. 첫화면, 이전화면, 극장선택버튼 추가
	 * 			5. 
	 * 
	 */
	
	
	/**
	 * Launch the application.
	 */
	private static SelectCinema SelectCinemadialog = new SelectCinema();
	private static SelectMenu selectMenudialog = new SelectMenu();
	private static MovieInformation MovieInformationdialog = new MovieInformation();
	private static SelectTime SelectTimedialog = new SelectTime();


	public static void main(String[] args) {
		try {
			SelectCinemadialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			SelectCinemadialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectCinema() {
		//타이틀 설정
		setTitle("극장 선택");
		setBounds(ShareVar.kiosk_loc_x, 
				  ShareVar.kiosk_loc_y, 
				  ShareVar.kiosk_width, 
				  ShareVar.kiosk_hight);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
//			페이지 타이틀 
				JLabel lbl_pageTitle = new JLabel("극장 선택");
				lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font,
				 								Font.PLAIN, 
				 								ShareVar.kiosk_title_font_size));
				 								
				lbl_pageTitle.setBounds(295, 
										10, 
										250,
										100);
				
				contentPanel.add(lbl_pageTitle);
				
				//첫화면 아이콘
				JLabel lbl_pageTitle_1 = new JLabel("첫화면");
				lbl_pageTitle_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						goToSelectMenu();
					}
				});
				lbl_pageTitle_1.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));

				lbl_pageTitle_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
				lbl_pageTitle_1.setBounds(623, 20, 170, 130);
				contentPanel.add(lbl_pageTitle_1);
				
				//극장선택 배경(총 4개)
				JLabel lbl_CinemaBackGround1 = new JLabel("");
				lbl_CinemaBackGround1.addMouseListener(new MouseAdapter() {
					@Override
					// 시간선택으로 가기
					public void mouseClicked(MouseEvent e) {
						goToSelectTime();
					}
				});
				lbl_CinemaBackGround1.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
				lbl_CinemaBackGround1.setBounds(117, 98, 254, 132);
				contentPanel.add(lbl_CinemaBackGround1);
				
				JLabel lbl_CinemaBackGround2 = new JLabel("");
				lbl_CinemaBackGround2.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
				lbl_CinemaBackGround2.setBounds(429, 98, 254, 132);
				contentPanel.add(lbl_CinemaBackGround2);
				
				JLabel lbl_CinemaBackGround3 = new JLabel("");
				lbl_CinemaBackGround3.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
				lbl_CinemaBackGround3.setBounds(117, 256, 254, 132);
				contentPanel.add(lbl_CinemaBackGround3);
				
				JLabel lbl_CinemaBackGround4 = new JLabel("");
				lbl_CinemaBackGround4.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
				lbl_CinemaBackGround4.setBounds(429, 256, 254, 132);
				contentPanel.add(lbl_CinemaBackGround4);
				
				//이전으로 버튼
				JLabel BtnBackToPrevious = new JLabel("");
				BtnBackToPrevious.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						goToMovieInformation();
					}
				});
				BtnBackToPrevious.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
				BtnBackToPrevious.setBounds(6, 21, 170, 130);
				contentPanel.add(BtnBackToPrevious);
				
				//배경화면
				JLabel lbl_background = new JLabel("",SwingConstants.CENTER);
				lbl_background.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
				lbl_background.setBounds(-16, 0, 800, 600);
				contentPanel.add(lbl_background);
		}
	}
//--------------------Function--------------------------
	//다음화면(시간선택)로 가기
	private void goToSelectTime() {
		dispose();
		SelectCinemadialog.setVisible(false);
		SelectCinemadialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectTimedialog.setVisible(true);
	}
	//이전화면(영화정보)으로 가기
	private void goToMovieInformation() {
		dispose();
		SelectCinemadialog.setVisible(false);
		SelectCinemadialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		MovieInformationdialog.setVisible(true);
	}
	//첫화면으로 가기
		private void goToSelectMenu() {
			dispose();
			SelectCinemadialog.setVisible(false);
			SelectCinemadialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			selectMenudialog.setVisible(true);
		}
	
}//End
