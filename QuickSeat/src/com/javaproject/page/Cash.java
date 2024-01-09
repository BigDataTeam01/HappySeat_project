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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cash extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 
	 * 				 1. Cash화면에서 결제방법 선택으로 가기 버튼을 터치했을시 SelectPayment화면으로 이동
	 * Date : 2024.01.06 (토요일)
	 * Author : 박정민,박지환
	 * 
	 */
	/**
	 * Launch the application.
	 */
	
	private static  Page1_SelectMenu selectMenu = new Page1_SelectMenu();
	private static SelectPayment selectPayment = new SelectPayment();
	
	
	
	public static void main(String[] args) {
		try {
			Cash dialog = new Cash();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cash() {
		setTitle("현금 결제");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		// 화면 제목
		JLabel lbl_pageTitle = new JLabel("현금 결제");
		lbl_pageTitle.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));

		lbl_pageTitle.setBounds(297, 13, 250, 100);

		contentPanel.add(lbl_pageTitle);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToHome();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/GoFirstPage.png")));
		lblNewLabel_1.setBounds(628, 38, 172, 130);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goBack();
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/Backbtn.png")));
		lblNewLabel_2.setBounds(11, 39, 161, 130);
		contentPanel.add(lblNewLabel_2);
		//키오스크 배경화면
		JLabel lbl_backGround = new JLabel("");
		lbl_backGround.setIcon(
				new ImageIcon(ConfirmSeat.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_backGround.setBounds(6, 6, 800, 600);
		contentPanel.add(lbl_backGround);
	}
	//메인 화면으로 돌아가는기능 구현
	private void goToHome() {
		dispose();
		selectMenu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenu.setVisible(true);
	}
	
	// 이전 화면으로 돌아가는 기능 구현
	private void goBack() {
		dispose();
		selectPayment.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectPayment.setVisible(true);
	}
	
	
	
	
}//End
