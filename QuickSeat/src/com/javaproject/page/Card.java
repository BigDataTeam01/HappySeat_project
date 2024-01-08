package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Card extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 
	 * 				 1. Card화면에서 결제방법 선택으로 가기 버튼을 터치했을시 SelectPayment화면으로 이동
	 * Date : 2024.01.06 (토요일)
	 * Author : 박정민,박지환
	 * 
	 */
	/**
	 * Launch the application.
	 */
	
	
	private static SelectPayment selectPayment = new SelectPayment();
	
	
	
	public static void main(String[] args) {
		try {
			Card dialog = new Card();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Card() {
		setTitle("카드 결제");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		// 화면 제목
		JLabel lbl_pageTitle = new JLabel("카드 결제");
		lbl_pageTitle.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));

		lbl_pageTitle.setBounds(297, 13, 250, 100);

		contentPanel.add(lbl_pageTitle);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToSelectPayment();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Card.class.getResource("/com/javaproject/image/결제방법 선택으로가기.png")));
		btnNewButton.setBounds(83, 442, 650, 100);
		contentPanel.add(btnNewButton);
		//키오스크 배경화면
		JLabel lbl_backGround = new JLabel("");
		lbl_backGround.setIcon(
				new ImageIcon(ConfirmSeat.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_backGround.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_backGround);
	}
	//----------Function----------
	
	private void goToSelectPayment() {
		dispose();
		selectPayment.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectPayment.setVisible(true);
	}
	

}//END
