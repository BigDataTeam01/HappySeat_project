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
import javax.swing.JTextField;
import java.awt.Color;

public class Page11_1_Cash extends JDialog {

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
	
	private static  Page2_SelectMenu selectMenu = new Page2_SelectMenu();
	private static Page11_0_SelectPayment page11_0_SelectPayment = new Page11_0_SelectPayment();
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	
	
	
	public static void main(String[] args) {
		try {
			Page11_1_Cash dialog = new Page11_1_Cash();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page11_1_Cash() {
		setTitle("현금 결제");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		// 화면 제목
		JLabel lbl_pageTitle = new JLabel("현금 결제");
		lbl_pageTitle.setFont(new Font("BM Dohyeon", Font.PLAIN, 50));

		lbl_pageTitle.setBounds(275, 43, 250, 100);

		contentPanel.add(lbl_pageTitle);
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
		contentPanel.add(getTextField());
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Page11_1_Cash.class.getResource("/com/javaproject/image/CashPayMoney.png")));
		lblNewLabel_3.setBounds(43, 312, 414, 249);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("투입하신 금액");
		lblNewLabel_4.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		lblNewLabel_4.setBounds(511, 203, 250, 100);
		contentPanel.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 204));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(539, 281, 180, 60);
		contentPanel.add(textField_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToBack();
			}
		});
		lblNewLabel_5.setIcon(new ImageIcon(Page11_1_Cash.class.getResource("/com/javaproject/image/cashMoneyCancle.png")));
		lblNewLabel_5.setBounds(490, 456, 285, 115);
		contentPanel.add(lblNewLabel_5);
		//키오스크 배경화면
		JLabel lbl_backGround = new JLabel("");
		lbl_backGround.setIcon(
				new ImageIcon(Page10_ConfirmSeat.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_backGround.setBounds(6, 6, 800, 600);
		contentPanel.add(lbl_backGround);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("결제 금액");
			lblNewLabel.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
			lblNewLabel.setBounds(161, 166, 180, 100);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBackground(new Color(255, 255, 204));
			textField.setEditable(false);
			textField.setBounds(161, 245, 180, 60);
			textField.setColumns(10);
		}
		return textField;
	}
	//메인 화면으로 돌아가는기능 구현
	private void goToHome() {
		dispose();
		selectMenu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenu.setVisible(true);
	}
	
	// 이전 화면으로 돌아가는 기능 구현
	private void goToBack() {
		dispose();
		page11_0_SelectPayment.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		page11_0_SelectPayment.setVisible(true);
	}
}//End
