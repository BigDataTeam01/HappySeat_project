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

import com.javaproject.base.ShareVar;
import com.javaproject.kioskFunction.Dao_PJH;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;

public class Page11_2_Card extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 가드결제 화면 
	 * 				1. Card화면에서 결제방법 선택으로 가기 버튼을 터치했을시 SelectPayment화면으로 이동 
	 * 
	 * Date :2024.01.06 (토요일) Author : 박정민,박지환
	 * 
	 * *  *  * Update 2024.01.13 by PJH:
	 * 			1. Description 수정
	 * 			2. 인원선택에서 받아온 어레이값으로  각 할인율 어레이를 활용해 각각의 금액을 만들고 그 값을 더해 총 구매금액 확인 구현
	 * 			3. 앞에서 받아온 쉐어바의 값들은 db에 입력(구현중)
	 * 
	 */

	/**
	 * Launch the application.
	 */

	// private static SelectMenu selectMenu = new SelectMenu();
	//인원수 배열을 쉐어바에서 가져온다
	  private Dao_PJH dao;	
	  private JTextField textField;
	

	public static void main(String[] args) {
		try {
			Page11_2_Card dialog = new Page11_2_Card();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page11_2_Card() {
		dao = new Dao_PJH();
		// 인원선택에서 선택한 어레이로 각각의 할인율을 설정
		int[] discountRates = { 10, 30, 30, 50, 30 }; // 각 할인율을 설정
		int[] personNumbers = ShareVar.personNumbers;
		// 다오에서  할인 전 영화 가격 가져오기
		int moviePriceBeforeDiscount = dao.MoviePriceBeforeDiscount();
		int discountedPrice = calculateDiscountedPrice(personNumbers, discountRates, moviePriceBeforeDiscount);

		setTitle("카드 결제");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		// 화면 제목
		JLabel lbl_pageTitle = new JLabel("카드 결제");
		lbl_pageTitle.setFont(new Font("BM Dohyeon", Font.PLAIN, 50));

		lbl_pageTitle.setBounds(275, 43, 250, 100);

		contentPanel.add(lbl_pageTitle);
		// 첫화면으로 이전화면으로 버튼
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToHome();
			}
		});
		lblNewLabel_1.setIcon(
				new ImageIcon(Page11_0_SelectPayment.class.getResource("/com/javaproject/image/GoFirstPage.png")));
		lblNewLabel_1.setBounds(628, 38, 172, 130);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goBack();
			}
		});
		lblNewLabel_2
				.setIcon(new ImageIcon(Page11_0_SelectPayment.class.getResource("/com/javaproject/image/Backbtn.png")));
		lblNewLabel_2.setBounds(11, 39, 161, 130);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("결제 금액");
		lblNewLabel.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		lblNewLabel.setBounds(161, 166, 180, 100);
		contentPanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(new Color(255, 255, 204));
		textField.setBounds(161, 245, 180, 60);
		contentPanel.add(textField);
		textField.setColumns(10);
		textField.setText(Integer.toString(discountedPrice));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Page11_2_Card.class.getResource("/com/javaproject/image/InsertCard.png")));
		lblNewLabel_3.setBounds(43, 312, 414, 249);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToPaymentConfirm();
				ShareVar.totalPrice= Integer.toString(discountedPrice);
			}
		});
		lblNewLabel_4.setIcon(new ImageIcon(Page11_2_Card.class.getResource("/com/javaproject/image/cardAuthorization.png")));
		lblNewLabel_4.setBounds(490, 456, 285, 115);
		contentPanel.add(lblNewLabel_4);
		// 키오스크 배경화면
		JLabel lbl_backGround = new JLabel("");
		lbl_backGround.setIcon(
				new ImageIcon(Page10_ConfirmSeat.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_backGround.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_backGround);
		
	}
	
	//------Function------
	private void goToHome() {
		Page02_SelectMenu selectMenu = new Page02_SelectMenu();
		dispose();
		selectMenu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenu.setVisible(true);
	}
	
	private void goBack() {
		Page11_0_SelectPayment page11_0_SelectPayment  = new Page11_0_SelectPayment();
		dispose();
		page11_0_SelectPayment.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		page11_0_SelectPayment.setVisible(true);
	}
	
	private void goToPaymentConfirm() {
		Page12_PaymentConfirm page12_PaymentConfirm = new Page12_PaymentConfirm(); 
		dispose();
		page12_PaymentConfirm.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		page12_PaymentConfirm.setVisible(true);
		ShareVar.pay_method="카드";
		
	}

	//할인가격계산해서 전체 가격 내보내기
	private int calculateDiscountedPrice(int[] personNumbers, int[] discountRates, int moviePriceBeforeDiscount) {
		// 할인된 가격을 초기화(안하면 포문에서 오류남)
		int discountedPrice = 0;
		for (int i = 0; i < personNumbers.length; i++) {
			// 할인율계산(예:30프로할인-> 인원분류숫자*0.7)
			discountedPrice += (1 - (double) discountRates[i] / 100) * personNumbers[i] * moviePriceBeforeDiscount;
		}

		return discountedPrice;
	}
	

}// END
