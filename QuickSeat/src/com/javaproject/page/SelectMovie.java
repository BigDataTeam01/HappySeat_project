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

public class SelectMovie extends JDialog {

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
	
	private static SelectMovie SelectMoviedialog = new SelectMovie();
	private static SelectMenu selectMenudialog = new SelectMenu();
	private static MovieInformation MovieInformationdialog = new MovieInformation();
	private static SelectAge SelectAgedialog = new SelectAge();
	
	public static void main(String[] args) {
		try {
			SelectMovie dialog = new SelectMovie();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectMovie() {
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
		
//		페이지 타이틀 
			JLabel lbl_pageTitle = new JLabel("영화 선택");
			lbl_pageTitle.setBounds(295, 10, 250, 100);
			lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font,
			 								Font.PLAIN, 
			 								ShareVar.kiosk_title_font_size));
			
			contentPanel.add(lbl_pageTitle);
			
			//배경화면
			JLabel lbl_background = new JLabel("",SwingConstants.CENTER);
			lbl_background.setBounds(-16, 0, 800, 600);
			lbl_background.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
			contentPanel.add(lbl_background);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
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