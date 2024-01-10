package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private static Page11_0_SelectPayment selectpayment = new Page11_0_SelectPayment();
	private static Page2_SelectMenu selectMenudialog = new Page2_SelectMenu();
	private static Page9_SelectSeat SelectSeatdialog = new Page9_SelectSeat();
	
	private JLabel lblNewLabel;

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
	//----Function----
	// 결제 방법 창으로 넘어 가는 기능 구현
	private void goToSelectPayment() {
		dispose();
		selectpayment.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectpayment.setVisible(true);
	}
	// 처음으로 돌아가는 기능 구현
	private void goToBack() {
		dispose();
		SelectSeatdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectSeatdialog.setVisible(true);
		
	}
	// 이전으로 돌아가는 기능 구현
	private void goToHome() {
		dispose();
		selectMenudialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
		
	}
	
	
	
	
	
	
	
}// End
