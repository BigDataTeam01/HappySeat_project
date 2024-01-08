package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectPayment extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 1. SelectPayment에서 첫화면 버튼을 터치했을시 SelectMenu화면으로 이동 2.
	 * SelectPayment에서 이전화면 버튼을 터치했을시 ConfirmSeat화면으로 이동 3. SelectPayment에서 현금결제 버튼을
	 * 터치했을시 Cash화면으로 이동 4. SelectPayment에서 문화누리카드 버튼을 터치했을시 Card화면으로 이동 5.
	 * SelectPayment에서 신용카드 버튼을 터치했을시 Card화면으로 이동 Date : 2024.01.06 (토요일) Author :
	 * 박정민,박지환
	 * 
	 * Update 2024.01.06 by J.Park: 1. 클라스 이름 SelectPayment로 변경
	 */
	/**
	 * Launch the application.
	 */

	private static SelectMenu selectMenudialog = new SelectMenu();
	private static Cash cash = new Cash();
	private static Card card = new Card();
	private static ConfirmSeat confirmSeat = new ConfirmSeat();

	public static void main(String[] args) {
		try {
			SelectPayment dialog = new SelectPayment();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectPayment() {
		setTitle("결제 방법");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("결제 방법");
		lblNewLabel.setBounds(297, 13, 250, 100);
		contentPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/GoFirstPage.png")));
		lblNewLabel_1.setBounds(628, 38, 172, 130);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/Backbtn.png")));
		lblNewLabel_2.setBounds(11, 39, 161, 130);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/cashPay.png")));
		lblNewLabel_3.setBounds(57, 249, 310, 110);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/CultureCard.png")));
		lblNewLabel_3_1.setBounds(444, 249, 310, 110);
		contentPanel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/cardPay.png")));
		lblNewLabel_3_2.setBounds(248, 419, 310, 110);
		contentPanel.add(lblNewLabel_3_2);
		JLabel lbl_backGround = new JLabel("");
		lbl_backGround.setIcon(
				new ImageIcon(ConfirmSeat.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_backGround.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_backGround);
	}

}// End
