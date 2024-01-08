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

public class ConfirmSeat extends JDialog {

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
	private static SelectPayment selectpayment = new SelectPayment();
	private static SelectMenu selectMenudialog = new SelectMenu();
	private static SelectSeat SelectSeatdialog = new SelectSeat();

	public static void main(String[] args) {
		try {
			ConfirmSeat dialog = new ConfirmSeat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConfirmSeat() {
		setTitle("좌석 확정");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		// 페이지 타이틀
		JLabel lbl_pageTitle = new JLabel("좌석 확정");
		lbl_pageTitle.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));

		lbl_pageTitle.setBounds(297, 13, 250, 100);

		contentPanel.add(lbl_pageTitle);

		JButton btnBuy = new JButton("구 매");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goPaymentConfirm();
			}
		});
		btnBuy.setBackground(Color.WHITE);
		btnBuy.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		btnBuy.setBounds(456, 405, 200, 100);
		contentPanel.add(btnBuy);

		JButton btnBack = new JButton("이전 화면");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToSelectSeat();
			}
		});
		btnBack.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(144, 405, 200, 100);
		contentPanel.add(btnBack);
		// 첫화면으로 이전화면으로 버튼
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/GoFirstPage.png")));
		lblNewLabel_1.setBounds(628, 38, 172, 130);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/Backbtn.png")));
		lblNewLabel_2.setBounds(11, 39, 161, 130);
		contentPanel.add(lblNewLabel_2);

		// 키오스크 배경화면
		JLabel lbl_backGround = new JLabel("");
		lbl_backGround.setIcon(
				new ImageIcon(ConfirmSeat.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_backGround.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_backGround);
	}
	// ----------Function------------

	private void goPaymentConfirm() {
		dispose();
		selectpayment.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectpayment.setVisible(true);
	}

	private void goToSelectSeat() {
		dispose();
		SelectSeatdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectSeatdialog.setVisible(true);
	}

}// End
