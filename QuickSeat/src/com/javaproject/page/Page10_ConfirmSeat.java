package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import com.javaproject.kioskFunction.Dao_PJH;
import com.javaproject.kioskFunction.Dao_confirmSeat;
import com.javaproject.kioskFunction.Dto_PJH;
import com.javaproject.kioskFunction.Dto_confirmSeat;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Page10_ConfirmSeat extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/*
	 * Description : 1. ConfirmSeat에서 이전화면 버튼을 터치했을시 SelectSeat화면으로 이동 2.
	 * ConfirmSeat에서 구매 버튼을 터치했을시 SelectMenu화면으로 이동 4. ConfirmSeat에서 첫화면 버튼을 터치했을시
	 * SelectMenu화면으로 이동 Date : 2024.01.06 (토요일) Author : 박정민,박지환
	 * 
	 */
	/**
	 */
	/**
	 * Launch the application.
	 */
	
	
	private JLabel lblNewLabel;
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

	public static void main(String[] args) {
		try {
			Page10_ConfirmSeat dialog = new Page10_ConfirmSeat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page10_ConfirmSeat() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				showMyTicket();
			}
		});
		setTitle("좌석 확정");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		// 페이지 타이틀
		JLabel lbl_pageTitle = new JLabel("좌석 확정");
		lbl_pageTitle.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));

		lbl_pageTitle.setBounds(297, 13, 250, 100);

		contentPanel.add(lbl_pageTitle);
		// 첫화면으로 이전화면으로 버튼
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToHome();
			}
		});
		contentPanel.add(getLblmovie_title());
		contentPanel.add(getLblcinema_branch());
		contentPanel.add(getLblscr_scroom_name());
		contentPanel.add(getLblscr_start_time());
		contentPanel.add(getLblseat_code());
		contentPanel.add(getLblscr_start_time_data());
		contentPanel.add(getLblseat_code_data());
		contentPanel.add(getLbl_movie_poster());
		contentPanel.add(getLblmovie_title_data());
		contentPanel.add(getLblcinema_branch_data());
		contentPanel.add(getLblscr_scroom_name_data());
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Page10_ConfirmSeat.class.getResource("/com/javaproject/image/SeatConfirmBack.png")));
		lblNewLabel_3.setBounds(149, 165, 500, 270);
		contentPanel.add(lblNewLabel_3);
		lblNewLabel_1.setIcon(new ImageIcon(Page11_0_SelectPayment.class.getResource("/com/javaproject/image/GoFirstPage.png")));
		lblNewLabel_1.setBounds(628, 38, 172, 130);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToBack();
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(Page11_0_SelectPayment.class.getResource("/com/javaproject/image/Backbtn.png")));
		lblNewLabel_2.setBounds(11, 39, 161, 130);
		contentPanel.add(lblNewLabel_2);
		contentPanel.add(getLblNewLabel());

		// 키오스크 배경화면
		JLabel lbl_backGround = new JLabel("");
		lbl_backGround.setIcon(
				new ImageIcon(Page10_ConfirmSeat.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_backGround.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_backGround);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectPayment();
				}
			});
			lblNewLabel.setIcon(new ImageIcon(Page10_ConfirmSeat.class.getResource("/com/javaproject/image/BuyBtn.png")));
			lblNewLabel.setBounds(149, 449, 510, 100);
		}
		return lblNewLabel;
	}
	private JLabel getLbl_movie_poster() {
		if (lbl_movie_poster == null) {
			lbl_movie_poster = new JLabel("사진넣을곳");
			lbl_movie_poster.setBounds(171, 181, 230, 240);
		}
		return lbl_movie_poster;
	}
	private JLabel getLblmovie_title() {
		if (lblmovie_title == null) {
			lblmovie_title = new JLabel("영화 :");
			lblmovie_title.setBounds(423, 193, 30, 30);
		}
		return lblmovie_title;
	}
	private JLabel getLblcinema_branch() {
		if (lblcinema_branch == null) {
			lblcinema_branch = new JLabel("장소 :");
			lblcinema_branch.setBounds(423, 221, 30, 30);
		}
		return lblcinema_branch;
	}
	private JLabel getLblscr_scroom_name() {
		if (lblscr_scroom_name == null) {
			lblscr_scroom_name = new JLabel("상영관 :");
			lblscr_scroom_name.setBounds(423, 250, 45, 30);
		}
		return lblscr_scroom_name;
	}
	private JLabel getLblscr_start_time() {
		if (lblscr_start_time == null) {
			lblscr_start_time = new JLabel("상영시간");
			lblscr_start_time.setBounds(423, 280, 55, 30);
		}
		return lblscr_start_time;
	}
	private JLabel getLblseat_code() {
		if (lblseat_code == null) {
			lblseat_code = new JLabel("좌석");
			lblseat_code.setBounds(423, 341, 200, 30);
		}
		return lblseat_code;
	}
	private JLabel getLblscr_start_time_data() {
		if (lblscr_start_time_data == null) {
			lblscr_start_time_data = new JLabel("상영시간 넣을공간");
			lblscr_start_time_data.setBounds(423, 309, 200, 30);
		}
		return lblscr_start_time_data;
	}
	private JLabel getLblseat_code_data() {
		if (lblseat_code_data == null) {
			lblseat_code_data = new JLabel("좌석넣을 공간");
			lblseat_code_data.setBounds(423, 377, 200, 30);
		}
		return lblseat_code_data;
	}
	
	private JLabel getLblmovie_title_data() {
		if (lblmovie_title_data == null) {
			lblmovie_title_data = new JLabel("영화 :");
			lblmovie_title_data.setBounds(460, 193, 180, 30);
		}
		return lblmovie_title_data;
	}
	private JLabel getLblcinema_branch_data() {
		if (lblcinema_branch_data == null) {
			lblcinema_branch_data = new JLabel("장소 :");
			lblcinema_branch_data.setBounds(460, 221, 180, 30);
		}
		return lblcinema_branch_data;
	}
	private JLabel getLblscr_scroom_name_data() {
		if (lblscr_scroom_name_data == null) {
			lblscr_scroom_name_data = new JLabel("상영관 :");
			lblscr_scroom_name_data.setBounds(470, 250, 170, 30);
		}
		return lblscr_scroom_name_data;
	}
	//----Function----
	// 결제 방법 창으로 넘어 가는 기능 구현
	private void goToSelectPayment() {
		Page11_0_SelectPayment SelectPaymentdialog = new Page11_0_SelectPayment();
		dispose();
		SelectPaymentdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectPaymentdialog.setVisible(true);
	}
	// 처음으로 돌아가는 기능 구현
	private void goToBack() {
		Page09_SelectSeat_ver2 SelectSeatdialog = new Page09_SelectSeat_ver2();

		dispose();
		SelectSeatdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectSeatdialog.setVisible(true);
		
	}
	// 이전으로 돌아가는 기능 구현
	private void goToHome() {
		Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
		dispose();
		selectMenudialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
		
	}
	private void showMyTicket() {
		
		String movie_title = ShareVar.selectedMovieTitle;
		Dao_confirmSeat dao = new Dao_confirmSeat();
		ArrayList<Dto_confirmSeat> dtolist = dao.showMyTicket();
		lblmovie_title_data.setText(dtolist.get(0).getMovie_title().toString());
		lblcinema_branch_data.setText(dtolist.get(0).getCinema_branch());
		lblscr_scroom_name_data.setText(dtolist.get(0).getScr_scroom_name());
		lblscr_start_time_data.setText(dtolist.get(0).getScr_start_time());
		imageInsert(lbl_movie_poster, ShareVar.filename);
		
		
		
		
		for(int i = 0; i < ShareVar.sumOfPersonNumbers; i++) {	 
			lblseat_code_data.setText(ShareVar.selectedSeatSeq.get(i).toString());
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
		Image changeImg = img.getScaledInstance(319, 390, Image.SCALE_SMOOTH);
		// 변경된 이미지를 다시 icon 에 담는다.
		ImageIcon changeIcon = new ImageIcon(changeImg);
		poster.setIcon(changeIcon);
		
		poster.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
		// System.out.println(ShareVar.filename);
//		file.delete();
		
	}
}// End
