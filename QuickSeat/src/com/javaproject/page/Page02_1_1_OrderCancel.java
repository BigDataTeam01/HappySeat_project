package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import com.javaproject.kioskFunction.BackSplashTimer;
import com.javaproject.kioskFunction.ButtonDesign_ver1;
import com.javaproject.kioskFunction.Dao_confirmSeat;
import com.javaproject.kioskFunction.Dao_orderCancel;
import com.javaproject.kioskFunction.Dto_confirmSeat;
import com.javaproject.kioskFunction.Dto_orderCancel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

public class Page02_1_1_OrderCancel extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	BackSplashTimer backSplashTimer;
	private JLabel lbl_movie_poster;
	private JLabel lblmovie_title;
	private JLabel lblcinema_branch;
	private JLabel lblscr_scroom_name;
	private JLabel lblscr_start_time;
	private JLabel lblseat_code;
	private JLabel lblscr_start_time_data;
	private JLabel lblseat_code_data;
	private JLabel lblmovie_title_data;
	private JLabel lblcinema_branch_data;
	private JLabel lblscr_scroom_name_data;
	private JLabel lblmovie_ticket_number;
	private JLabel lblmovie_ticket_number_data;
	/*
	 * Description : 영화티켓 취소 
	 * 				 1. OrderCancle에서 을 첫화면 버튼을 터치했을시 MenuSelect 화면으로 이동
	 * 				 2. OrderCancle에서 을 구매취소 버튼을 터치했을시 "구매취소 되었습니다." ShowMessageDialog 화면을 띄운다(추후의 변경예정)
	 * 				 3. OrderCancle에서 을 이전화면 버튼을 터치했을시 Page02_1_0_OrderCheck 화면으로 이동
	 * Date : 2024.01.06 (토요일)
	 * Author : 박정민,박지환
	 * 
	 *  *  * Update 2024.01.09 by J.park:
	 * 			1. descripton 수정
	 * 			2. kiosk set bound sharevar 에서 가져와 지정
	 * 			3. diaog -> static 
	 * 			4. 배경 추가
	 * 			5. 처음으로,이전으로,예매취소 버튼 Update
	 * 
	 * Update 2024. 01.14 by PDG
	 * 			1. 구매 취소 버튼 수정. 
	 * 			2. 페이지 구성이 제대로 안되어 있어서 하나하나 추가함. 
	 */
	/**
	 * Launch the application.
	 */

	
	public static void main(String[] args) {
		try {
			Page02_1_1_OrderCancel OrderCancledialog = new Page02_1_1_OrderCancel();
			OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			OrderCancledialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	
		/**
		 * Create the dialog.
	 */
	public Page02_1_1_OrderCancel() {
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowActivated(WindowEvent e) {
					backSplashTimeEnd();
				}
				
				@Override
				public void windowClosed(WindowEvent e) {
					stopTimer();
				}
			});
		setTitle("예매 취소");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);

		//입력완료 버튼 넣기
		contentPanel.add(getBtnNewButton());
		contentPanel.add(getLbl_movie_poster());
		contentPanel.add(getLblmovie_title());
		contentPanel.add(getLblmovie_ticket_number());
		contentPanel.add(getLblcinema_branch());
		contentPanel.add(getLblscr_scroom_name());
		contentPanel.add(getLblscr_start_time());
		contentPanel.add(getLblseat_code());
		contentPanel.add(getLblscr_start_time_data());
		contentPanel.add(getLblmovie_title_data());
		contentPanel.add(getLblcinema_branch_data());
		contentPanel.add(getLblscr_scroom_name_data());
		contentPanel.add(getLblseat_code_data());
		
		//영화배경
		JLabel lblMovieBackGround = new JLabel("");
		lblMovieBackGround.setIcon(new ImageIcon(Page02_1_1_OrderCancel.class.getResource("/com/javaproject/image/SeatConfirmBack.png")));
		lblMovieBackGround.setForeground(new Color(183, 220, 149));
		lblMovieBackGround.setBackground(new Color(183, 220, 149));
		lblMovieBackGround.setBounds(148, 162, 500, 270);
		contentPanel.add(lblMovieBackGround);
				
//		페이지 타이틀 
		JLabel lbl_pageTitle = new JLabel("예매 확인");
		lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

		lbl_pageTitle.setBounds(295, 10, 250, 100);

		contentPanel.add(lbl_pageTitle);
		// 이전으로버튼
				JLabel BtnBack = new JLabel("");
				BtnBack.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						goToOredrCheck();
					}
				});
				BtnBack.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
				BtnBack.setBounds(11, 18, 170, 130);
				contentPanel.add(BtnBack);
				
		// 첫화면으로가기
		JLabel BtnGoToFirstPage = new JLabel("첫화면");
		BtnGoToFirstPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMenu();
			}
		});
		BtnGoToFirstPage
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));

		BtnGoToFirstPage.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		BtnGoToFirstPage.setBounds(628, 17, 180, 130);
		contentPanel.add(BtnGoToFirstPage);

		// 배경화면
		JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
		lbl_background.setIcon(new ImageIcon(
				Page05_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_background.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_background);
		contentPanel.add(getLblmovie_ticket_number_data());
	}	private JLabel getLbl_movie_poster() {
		if (lbl_movie_poster == null) {
			lbl_movie_poster = new JLabel("");
			lbl_movie_poster.setBounds(171, 181, 230, 240);
		}
		return lbl_movie_poster;
	}
	private JLabel getLblmovie_title() {
		if (lblmovie_title == null) {
			lblmovie_title = new JLabel("영화 :");
			lblmovie_title.setBounds(423, 207, 30, 30);
		}
		return lblmovie_title;
	}
	private JLabel getLblcinema_branch() {
		if (lblcinema_branch == null) {
			lblcinema_branch = new JLabel("장소 :");
			lblcinema_branch.setBounds(423, 235, 30, 30);
		}
		return lblcinema_branch;
	}
	private JLabel getLblscr_scroom_name() {
		if (lblscr_scroom_name == null) {
			lblscr_scroom_name = new JLabel("상영관 :");
			lblscr_scroom_name.setBounds(423, 264, 45, 30);
		}
		return lblscr_scroom_name;
	}
	private JLabel getLblscr_start_time() {
		if (lblscr_start_time == null) {
			lblscr_start_time = new JLabel("상영시간");
			lblscr_start_time.setBounds(423, 294, 55, 30);
		}
		return lblscr_start_time;
	}
	private JLabel getLblseat_code() {
		if (lblseat_code == null) {
			lblseat_code = new JLabel("좌석");
			lblseat_code.setBounds(423, 355, 200, 30);
		}
		return lblseat_code;
	}
	private JLabel getLblscr_start_time_data() {
		if (lblscr_start_time_data == null) {
			lblscr_start_time_data = new JLabel("");
			lblscr_start_time_data.setBounds(423, 323, 200, 30);
		}
		return lblscr_start_time_data;
	}
	private JLabel getLblseat_code_data() {
		if (lblseat_code_data == null) {
			lblseat_code_data = new JLabel("");
			lblseat_code_data.setBounds(423, 391, 200, 30);
		}
		return lblseat_code_data;
	}
	private JLabel getLblmovie_title_data() {
		if (lblmovie_title_data == null) {
			lblmovie_title_data = new JLabel("");
			lblmovie_title_data.setBounds(454, 207, 180, 30);
		}
		return lblmovie_title_data;
	}
	private JLabel getLblcinema_branch_data() {
		if (lblcinema_branch_data == null) {
			lblcinema_branch_data = new JLabel("");
			lblcinema_branch_data.setBounds(454, 235, 180, 30);
		}
		return lblcinema_branch_data;
	}
	private JLabel getLblscr_scroom_name_data() {
		if (lblscr_scroom_name_data == null) {
			lblscr_scroom_name_data = new JLabel("");
			lblscr_scroom_name_data.setBounds(464, 264, 170, 30);
		}
		return lblscr_scroom_name_data;
	}
	

//---------------------------Function---------------------
	// 첫화면으로 가기
	public void goToSelectMenu() {
		Page02_1_1_OrderCancel OrderCancledialog = new Page02_1_1_OrderCancel();
		Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
		dispose();
		OrderCancledialog.setVisible(false);
		OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}
	
	// 이전화면(예매확인)으로 가기
	public void goToOredrCheck() {
			Page02_1_1_OrderCancel OrderCancledialog = new Page02_1_1_OrderCancel();
			Page02_1_0_OrderCheck OrderCheckdialog = new Page02_1_0_OrderCheck();

			dispose();
			OrderCancledialog.setVisible(false);
			OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			OrderCheckdialog.setVisible(true);
		}

	// 구매취소0
	public void OrderCancleAction() {
		//JOptionPane에 배경화면 지정 불가... 따라서 새로운 클래스 생성하고 그 클래스의 매소드르
		JOptionPane.showMessageDialog(null, "구매취소되었습니다.");
		Page02_1_1_OrderCancel OrderCancledialog = new Page02_1_1_OrderCancel();
		Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();


		OrderCancledialog.setVisible(false);
		OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
//		Page02_1_1_OrderCancel_Dialog OrderCancledialogdialog= new Page02_1_1_OrderCancel_Dialog();
//		OrderCancledialogdialog.setVisible(true);
		selectMenudialog.setVisible(true);
		
	}
	// 구매취소버튼
	private JButton getBtnNewButton() {
		ButtonDesign_ver1 customButton = new ButtonDesign_ver1("구 매 취 소", ShareVar.btnFillColor);
		customButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		customButton.setForeground(ShareVar.btnTextColor);
		customButton.setBounds(146, 450, 500, 100);
		customButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(ShareVar.insertedOrderNum);
				OrderCancleAction();
			}
		});
		return customButton;
	}
	
	private void reserv_ticket() {
		
		String movie_title = ShareVar.selectedMovieTitle;
		Dao_orderCancel dao = new Dao_orderCancel();
		ArrayList<Dto_orderCancel> dtolist = dao.reserv_ticket();
		lblmovie_ticket_number_data.setText(ShareVar.insertedOrderNum.toString());
		lblmovie_title_data.setText(dtolist.get(0).getMovie_title().toString());
		lblcinema_branch_data.setText(dtolist.get(0).getCinema_branch());
		lblscr_scroom_name_data.setText(dtolist.get(0).getScr_scroom_name());
		lblscr_start_time_data.setText(dtolist.get(0).getScr_start_time());
		imageInsert(lbl_movie_poster, ShareVar.filename);
		
		
		
		
		for(int i = 0; i < ShareVar.sumOfPersonNumbers; i++) {	 
			lblseat_code_data.setText(ShareVar.selectedSeatSeq.toString() + "석");
		}
		
		
		
	}
	
	
	
	
	private void imageInsert(JLabel poster, int filename) {
		
		// Image 처리 : filename이 달라야 보여주기가 가능
		String filePath = Integer.toString(filename);
		poster.setIcon(new ImageIcon(filePath));
		
		ImageIcon icon = new ImageIcon(filePath);
		// img 에 이미지를 담는다.
		Image img = icon.getImage();
		// 이미지 사이즈 조절
		Image changeImg = img.getScaledInstance(220, 250, Image.SCALE_SMOOTH);
		// 변경된 이미지를 다시 icon 에 담는다.
		ImageIcon changeIcon = new ImageIcon(changeImg);
		poster.setIcon(changeIcon);
		
		poster.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		// System.out.println(ShareVar.filename);
//		file.delete();
		
	}
	
	// splash Class로 돌아가기
	public void backSplashTimeEnd() {
			BackSplashTimer backSplashTimer = new BackSplashTimer(ShareVar.backToSplashTime, this);
		}
	// 만약에 내가 타이머가 다 돌아가기 전에 페이지를 종료한다면 이것이 실행 되지 말아야한다. 
	public void stopTimer() {
		 
		backSplashTimer.stop();
		
	}

	private JLabel getLblmovie_ticket_number() {
		if (lblmovie_ticket_number == null) {
			lblmovie_ticket_number = new JLabel("발권번호 :");
			lblmovie_ticket_number.setBounds(423, 181, 55, 30);
		}
		return lblmovie_ticket_number;
	}
	private JLabel getLblmovie_ticket_number_data() {
		if (lblmovie_ticket_number_data == null) {
			lblmovie_ticket_number_data = new JLabel("발권번호 :");
			lblmovie_ticket_number_data.setBounds(479, 181, 150, 30);
		}
		return lblmovie_ticket_number_data;
	}
}
