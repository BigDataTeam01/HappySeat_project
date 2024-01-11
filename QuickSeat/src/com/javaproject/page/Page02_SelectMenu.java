package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Page2_SelectMenu extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 영화예매,예매내역 을 하기위한 메인페이지 
	 * 				 1.SelectMenu에서 영화 예매을 터치했을시 SelectAge 화면으로 이동
	 * 				 2.SelectMenu에서 구매 내역을 터치했을시  Page2_1_0_OrderCheck 화면으로 이동
	 * Date : 2024.01.06 (토요일)
	 * Author : 박정민,박지환
	 * 
	 *  * Update 2024.01.07 by J.park:
	 * 			1. descripton 수정
	 * 			2. kiosk set bound sharevar 에서 가져와 지정
	 * 			3. diaog -> static 
	 * 			4. 배경 입력
	 * 			5. 영화예매,예매내역 사진추가
	 * 			6. 영화 예매을 터치했을시 SelectAge로,구매 내역을 터치했을시  OrderCheck로 가게 설정
	 * 			7. Class 이름 변경(숫자
	 */
	/**
	 * Launch the application.
	 */
	// 페이지 선언
	private static Page2_SelectMenu selectMenudialog = new Page2_SelectMenu();
	private static Page3_SelectAge SelectAgedialog = new Page3_SelectAge();
	private static Page2_1_0_OrderCheck OrderCheckdialog = new Page2_1_0_OrderCheck();

	public static void main(String[] args) {
		try {
			selectMenudialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			selectMenudialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page2_SelectMenu() {
		setTitle("메뉴선택");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// 페이지 타이틀
		JLabel lbl_pageTitle = new JLabel("메뉴 선택");
		lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

		lbl_pageTitle.setBounds(295, 10, 250, 100);

		contentPanel.add(lbl_pageTitle);
		//영화예매 아이콘
		JLabel BtnMoviePurchase = new JLabel("");
		BtnMoviePurchase
				.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/영화예매Icon.png")));
		BtnMoviePurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectAge();
			}
		});
		BtnMoviePurchase.setFont(new Font("배달의민족 도현", Font.PLAIN, 40));
		BtnMoviePurchase.setBounds(91, 200, 284, 319);
		contentPanel.add(BtnMoviePurchase);
		//예매내역 아이콘
		JLabel BtnPurchaseList = new JLabel("");
		BtnPurchaseList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToOrderCheck();
			}
		});
		BtnPurchaseList
				.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/예매내역Icon.png")));
		BtnPurchaseList.setFont(new Font("배달의민족 도현", Font.PLAIN, 40));
		BtnPurchaseList.setBounds(429, 200, 284, 319);
		contentPanel.add(BtnPurchaseList);

		// 배경화면
		JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
		lbl_background.setIcon(new ImageIcon(
				Page5_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_background.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_background);

	}

//--------------------------------Function------------------------------------
	// 나이선택화면으로 가기
	private void goToSelectAge() {
		dispose();
		selectMenudialog.setVisible(false);
		selectMenudialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectAgedialog.setVisible(true);
	}

	// 예매,주문내역 확인페이지로 가기
	private void goToOrderCheck() {
		dispose();
		selectMenudialog.setVisible(false);
		selectMenudialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		OrderCheckdialog.setVisible(true);
	}

}// End