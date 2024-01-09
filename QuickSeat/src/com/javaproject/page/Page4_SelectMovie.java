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
import java.awt.Font;

import com.javaproject.base.ShareVar;

public class Page4_SelectMovie extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	/*
	 * Description : 영화 선택화면 
	 * 				 1.SelectMovie에서 영화 버튼을 터치했을시 Movieinformation 화면으로 이동
	 * 				 2.SelectMovie에서 이전 화면 버튼을 터치했을시  SelectAge 화면으로 이동
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환
	 * 
	 *  *  *  * Update 2024.01.7 by J.park:
	 * 			1. descripton 수정
	 * 			3. kiosk set bound sharevar 에서 가져와 지정
	 * 			4. diaog -> static 
	 * 			5. 배경 추가
	 * 			5. 첫화면,이전화면, 영화선택 추가
	 * 
	 */

	/**
	 * Launch the application.
	 */
	
	private static Page4_SelectMovie SelectMoviedialog = new Page4_SelectMovie();
	private static Page2_SelectMenu selectMenudialog = new Page2_SelectMenu();
	private static Page5_MovieInformation MovieInformationdialog = new Page5_MovieInformation();
	private static Page3_SelectAge SelectAgedialog = new Page3_SelectAge();
	
	public static void main(String[] args) {
		try {
			Page4_SelectMovie dialog = new Page4_SelectMovie();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page4_SelectMovie() {
		setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		setTitle("영화 선택");
		setBounds(100, 100, 800, 600);
		//타이틀 설정
		setTitle("영화 선택");
		setBounds(ShareVar.kiosk_loc_x, 
				  ShareVar.kiosk_loc_y, 
				  ShareVar.kiosk_width, 
				  ShareVar.kiosk_hight);
		
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			
			//이전화면, 다음화면 버튼
			JLabel lbl_PreviousMovie = new JLabel("");
			lbl_PreviousMovie.setBounds(103, 503, 260, 50);
			lbl_PreviousMovie.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn이전버튼.png")));
			contentPanel.add(lbl_PreviousMovie);
		
//		페이지 타이틀 
			JLabel lbl_pageTitle = new JLabel("영화 선택");
			lbl_pageTitle.setBounds(295, 10, 250, 100);
			lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font,
			 								Font.PLAIN, 
			 								ShareVar.kiosk_title_font_size));
			
			contentPanel.add(lbl_pageTitle);
			
			//처음으로 버튼
			JLabel lbl_pageTitle_1 = new JLabel("첫화면");
			lbl_pageTitle_1.setBounds(623, 20, 170, 130);
			lbl_pageTitle_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectMenu();
				}
			});
			lbl_pageTitle_1.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));

			lbl_pageTitle_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			contentPanel.add(lbl_pageTitle_1);
			
			//영화선택 배경(총 4개)
			JLabel lbl_MovieBackGround1 = new JLabel("");
			lbl_MovieBackGround1.setBounds(122, 167, 254, 132);
			lbl_MovieBackGround1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToMovieInformation();
				}
			});
			lbl_MovieBackGround1.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
			contentPanel.add(lbl_MovieBackGround1);
			
			JLabel lbl_MovieBackGround2 = new JLabel("");
			lbl_MovieBackGround2.setBounds(425, 167, 254, 132);
			lbl_MovieBackGround2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToMovieInformation();
				}
			});

			lbl_MovieBackGround2.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
			contentPanel.add(lbl_MovieBackGround2);
			
			JLabel lbl_MovieBackGround3 = new JLabel("");
			lbl_MovieBackGround3.setBounds(122, 341, 254, 132);
			lbl_MovieBackGround3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToMovieInformation();
				}
			});
			lbl_MovieBackGround3.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
			contentPanel.add(lbl_MovieBackGround3);
			
			JLabel lbl_MovieBackGround4 = new JLabel("");
			lbl_MovieBackGround4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToMovieInformation();
				}
			});
			lbl_MovieBackGround4.setBounds(425, 341, 254, 132);
			lbl_MovieBackGround4.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
			contentPanel.add(lbl_MovieBackGround4);
			
			JLabel lbl_NextMovie = new JLabel("");
			lbl_NextMovie.setBounds(561, 503, 198, 57);
			
			lbl_NextMovie.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn다음버튼.png")));
			contentPanel.add(lbl_NextMovie);
			
			//이전화면으로 가기
			JLabel BtnBackToPrevious = new JLabel("");
			BtnBackToPrevious.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectAge();
				}
			});
			BtnBackToPrevious.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
			BtnBackToPrevious.setBounds(6, 21, 170, 130);
			contentPanel.add(BtnBackToPrevious);
			
			//배경화면
			JLabel lbl_background = new JLabel("",SwingConstants.CENTER);
			lbl_background.setBounds(0, 0, 800, 600);
			lbl_background.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
			contentPanel.add(lbl_background);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
//-----------------------------Function------------
	//다음화면(정화정보)로 가기
		private void goToMovieInformation() {
			dispose();
			SelectMoviedialog.setVisible(false);
			SelectMoviedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			MovieInformationdialog.setVisible(true);
		}
		//이전화면(연령선택)으로 가기
				private void goToSelectAge() {
					dispose();
					SelectMoviedialog.setVisible(false);
					SelectMoviedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					SelectAgedialog.setVisible(true);
				}
				
		//첫화면으로 가기
		private void goToSelectMenu() {
			dispose();
			SelectMoviedialog.setVisible(false);
			SelectMoviedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			selectMenudialog.setVisible(true);
		}
	
	

}//End