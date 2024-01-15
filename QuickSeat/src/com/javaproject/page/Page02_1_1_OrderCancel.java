package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import com.javaproject.kioskFunction.BackSplashTimer;
import com.javaproject.kioskFunction.ButtonDesign_ver1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Page02_1_1_OrderCancel extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	BackSplashTimer backSplashTimer;
	/*
	 * Description : 영화티켓 취소 
	 * 				 1. OrderCancle에서 을 첫화면 버튼을 터치했을시 MenuSelect 화면으로 이동
	 * 				 2. OrderCancle에서 을 구매취소 버튼을 터치했을시 "구매취소 되었습니다." ShowMessageDialog 화면을 띄운다(추후의 변경예정)
	 * 				 3. OrderCancle에서 을 이전화면 버튼을 터치했을시 Page02_1_0_OrderCheck 화면으로 이동
	 * Date : 2024.01.06 (토요일)
	 * Author : 박정민,박지환
	 * 
	 *  *  * Update 2024.01.09 by J.park:
	 * 			1. descripton 수정
	 * 			2. kiosk set bound sharevar 에서 가져와 지정
	 * 			3. diaog -> static 
	 * 			4. 배경 추가
	 * 			5. 처음으로,이전으로,예매취소 버튼 Update
	 * 
	 * Update 2024. 01.14 by PDG
	 * 			1. 구매 취소 버튼 수정. 
	 * 			2. 페이지 구성이 제대로 안되어 있어서 하나하나 추가함. 
	 */
	/**
	 * Launch the application.
	 */

	
	public static void main(String[] args) {
		try {
			Page02_1_1_OrderCancel OrderCancledialog = new Page02_1_1_OrderCancel();
			OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			OrderCancledialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	
		/**
		 * Create the dialog.
	 */
	public Page02_1_1_OrderCancel() {
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowActivated(WindowEvent e) {
					backSplashTimeEnd();
				}
				
				@Override
				public void windowClosed(WindowEvent e) {
					stopTimer();
				}
			});
		setTitle("예매 취소");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);

		//입력완료 버튼 넣기
		contentPanel.add(getBtnNewButton());
				
//		페이지 타이틀 
		JLabel lbl_pageTitle = new JLabel("예매 확인");
		lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

		lbl_pageTitle.setBounds(295, 10, 250, 100);

		contentPanel.add(lbl_pageTitle);
		// 이전으로버튼
				JLabel BtnBack = new JLabel("");
				BtnBack.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						goToOredrCheck();
					}
				});
				BtnBack.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
				BtnBack.setBounds(11, 18, 170, 130);
				contentPanel.add(BtnBack);
				
		// 첫화면으로가기
		JLabel BtnGoToFirstPage = new JLabel("첫화면");
		BtnGoToFirstPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMenu();
			}
		});
		BtnGoToFirstPage
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));

		BtnGoToFirstPage.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		BtnGoToFirstPage.setBounds(628, 17, 180, 130);
		contentPanel.add(BtnGoToFirstPage);
		
		//영화배경
		JLabel MovieBackGround = new JLabel("");
		MovieBackGround.setForeground(new Color(183, 220, 149));
		MovieBackGround.setBackground(new Color(183, 220, 149));
		MovieBackGround.setBounds(148, 162, 500, 287);
		contentPanel.add(MovieBackGround);

		// 배경화면
		JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
		lbl_background.setIcon(new ImageIcon(
				Page05_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_background.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_background);
	}

//---------------------------Function---------------------
	// 첫화면으로 가기
	public void goToSelectMenu() {
		Page02_1_1_OrderCancel OrderCancledialog = new Page02_1_1_OrderCancel();
		Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
		dispose();
		OrderCancledialog.setVisible(false);
		OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}
	
	// 이전화면(예매확인)으로 가기
	public void goToOredrCheck() {
			Page02_1_1_OrderCancel OrderCancledialog = new Page02_1_1_OrderCancel();
			Page02_1_0_OrderCheck OrderCheckdialog = new Page02_1_0_OrderCheck();

			dispose();
			OrderCancledialog.setVisible(false);
			OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			OrderCheckdialog.setVisible(true);
		}

	// 구매취소0
	public void OrderCancleAction() {
		//JOptionPane에 배경화면 지정 불가... 따라서 새로운 클래스 생성하고 그 클래스의 매소드르
		JOptionPane.showMessageDialog(null, "구매취소되었습니다.");
		Page02_1_1_OrderCancel OrderCancledialog = new Page02_1_1_OrderCancel();
		Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();


		OrderCancledialog.setVisible(false);
		OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
//		Page02_1_1_OrderCancel_Dialog OrderCancledialogdialog= new Page02_1_1_OrderCancel_Dialog();
//		OrderCancledialogdialog.setVisible(true);
		selectMenudialog.setVisible(true);
		
	}
	// 구매취소버튼
	private JButton getBtnNewButton() {
		ButtonDesign_ver1 customButton = new ButtonDesign_ver1("구 매 취 소", ShareVar.btnFillColor);
		customButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		customButton.setForeground(ShareVar.btnTextColor);
		customButton.setBounds(146, 450, 500, 100);
		customButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(ShareVar.insertedOrderNum);
				OrderCancleAction();
			}
		});
		return customButton;
	}	
	
	// splash Class로 돌아가기
	public void backSplashTimeEnd() {
			BackSplashTimer backSplashTimer = new BackSplashTimer(ShareVar.backToSplashTime, this);
		}
	// 만약에 내가 타이머가 다 돌아가기 전에 페이지를 종료한다면 이것이 실행 되지 말아야한다. 
	public void stopTimer() {
		 
		backSplashTimer.stop();
		
	}

}
