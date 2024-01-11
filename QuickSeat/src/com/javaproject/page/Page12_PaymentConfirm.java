package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Page12_PaymentConfirm extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2_1_2;
	private JLabel lblNewLabel_2_1_3;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JLabel lblNewLabel_2_2;
	/*
	 * Description : 결제완료페이지
	 * 				 1.5초후 SelectMenu화면으로 이동
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환
	 * 
	 * 
	 * 
	 * 
	 * Update 2024.01.11 by pdg
	 * 		1. 화면 누르면 스플레시로 돌아가는 기능 추가 
	 * 
	 * 
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Page12_PaymentConfirm dialog = new Page12_PaymentConfirm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page12_PaymentConfirm() {
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLblNewLabel_2_1());
		contentPanel.add(getLblNewLabel_2_1_1());
		contentPanel.add(getLblNewLabel_2_1_2());
		contentPanel.add(getLblNewLabel_2_1_3());
		contentPanel.add(getLblNewLabel_3());
		contentPanel.add(getTextField());
		contentPanel.add(getLblNewLabel_2_2());
		// 키오스크 배경화면
		JLabel lbl_backGround = new JLabel("");
		lbl_backGround.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				goSplashAction();
			}
		});
		lbl_backGround.setIcon(
				new ImageIcon(Page10_ConfirmSeat.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_backGround.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_backGround);
		
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("신속 좌석");
			lblNewLabel.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
			lblNewLabel.setBounds(310, 43, 180, 100);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("발권 완료");
			lblNewLabel_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
			lblNewLabel_1.setBounds(310, 140, 180, 100);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("결제가 완료되었습니다.");
			lblNewLabel_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(294, 233, 220, 40);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("카드리더기에서");
			lblNewLabel_2_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			lblNewLabel_2_1.setBounds(243, 264, 140, 40);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("카드를 제거하세요.");
			lblNewLabel_2_1_1.setForeground(Color.RED);
			lblNewLabel_2_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			lblNewLabel_2_1_1.setBounds(388, 264, 180, 40);
		}
		return lblNewLabel_2_1_1;
	}
	private JLabel getLblNewLabel_2_1_2() {
		if (lblNewLabel_2_1_2 == null) {
			lblNewLabel_2_1_2 = new JLabel("영수증");
			lblNewLabel_2_1_2.setForeground(Color.RED);
			lblNewLabel_2_1_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			lblNewLabel_2_1_2.setBounds(300, 298, 60, 40);
		}
		return lblNewLabel_2_1_2;
	}
	private JLabel getLblNewLabel_2_1_3() {
		if (lblNewLabel_2_1_3 == null) {
			lblNewLabel_2_1_3 = new JLabel("을 찾아가세요");
			lblNewLabel_2_1_3.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			lblNewLabel_2_1_3.setBounds(365, 298, 140, 40);
		}
		return lblNewLabel_2_1_3;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("발권 번호");
			lblNewLabel_3.setBounds(358, 350, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBackground(new Color(255, 255, 204));
			textField.setEditable(false);
			textField.setBounds(245, 378, 300, 50);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("이용해주셔서 감사합니다.");
			lblNewLabel_2_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			lblNewLabel_2_2.setBounds(285, 481, 220, 40);
		}
		return lblNewLabel_2_2;
	}
	
	private void goSplashAction() {
		
		Page01_Splash splash = new Page01_Splash();
		this.setVisible(false);
		this.dispose();
		splash.setVisible(true);
		
		
		
		
	}
	
}// ENd
