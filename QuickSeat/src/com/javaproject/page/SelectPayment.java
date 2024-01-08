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
		// 첫화면 아이콘
		lblNewLabel.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		JLabel lbl_pageTitle_1 = new JLabel("첫화면");
		lbl_pageTitle_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToHome();
				// 액션 넣기
			}
		});
		lbl_pageTitle_1
				.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/첫화면Icon.png")));

		lbl_pageTitle_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		lbl_pageTitle_1.setBounds(12, 30, 46, 68);
		contentPanel.add(lbl_pageTitle_1);
		
		JButton btnNewButton = new JButton("현금 결제");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToCash();
			}
		});
		btnNewButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		btnNewButton.setBounds(50, 150, 300, 150);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("문화누리카드");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToCard();
			}
		});
		btnNewButton_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		btnNewButton_1.setBounds(445, 150, 300, 150);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("신용카드");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToCard();
			}
		});
		btnNewButton_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		btnNewButton_2.setBounds(50, 346, 300, 150);
		contentPanel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("이전화면");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToConfirmSeat();
			}
		});
		btnNewButton_3.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		btnNewButton_3.setBounds(445, 346, 300, 150);
		contentPanel.add(btnNewButton_3);
		JLabel lbl_backGround = new JLabel("");
		lbl_backGround.setIcon(
				new ImageIcon(ConfirmSeat.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_backGround.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_backGround);
	}

	// ----------Function---------
	private void goToHome() {
		dispose();
		selectMenudialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}
	private void goToConfirmSeat() {
		dispose();
		confirmSeat.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		confirmSeat.setVisible(true);
	}
	private void goToCash() {
		dispose();
		cash.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		cash.setVisible(true);
	}
	private void goToCard() {
		dispose();
		card.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		card.setVisible(true);
	}
	
}// End
