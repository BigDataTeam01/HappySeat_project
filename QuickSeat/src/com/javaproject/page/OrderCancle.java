package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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

public class OrderCancle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 영화티켓 취소 
	 * 				 1. OrderCancle에서 을 첫화면 버튼을 터치했을시 MenuSelect 화면으로 이동
	 * 				 2. OrderCancle에서 을 구매취소 버튼을 터치했을시 "구매취소 되었습니다." ShowMessageDialog 화면을 띄운다(추후의 변경예정)
	 * 				 3. OrderCancle에서 을 이전화면 버튼을 터치했을시 OrderCheck 화면으로 이동
	 * Date : 2024.01.06 (토요일)
	 * Author : 박정민,박지환
	 * 
	 *  *  * Update 2024.01.06 by J.park:
	 * 			1. descripton 수정
	 * 			2. kiosk set bound sharevar 에서 가져와 지정
	 * 			3. diaog -> static 
	 * 			4. 배경 추가
	 * 			5. 첫화면Icon 추가
	 */
	/**
	 * Launch the application.
	 */
	private static OrderCancle OrderCancledialog = new OrderCancle();
	private static SelectMenu selectMenudialog = new SelectMenu();

	public static void main(String[] args) {
		try {
			OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			OrderCancledialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrderCancle() {
		setTitle("예매내역");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);

//		페이지 타이틀 
			JLabel lbl_pageTitle = new JLabel("예매내역");
			lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font,
			 								Font.PLAIN, 
			 								ShareVar.kiosk_title_font_size));
			 								
			lbl_pageTitle.setBounds(295, 
									10, 
									250,
									100);
			
			contentPanel.add(lbl_pageTitle);
			//구매취소버튼(클릭시 다이얼로그 띄어주고 초기화면으로 이동
			JLabel BtnOrderCancle = new JLabel("");
			BtnOrderCancle.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					OrderCancleAction();
				}
			});
			BtnOrderCancle.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn 구매취소.png")));
			BtnOrderCancle.setBounds(504, 359, 200, 100);
			contentPanel.add(BtnOrderCancle);
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/GoFirstPage.png")));
			lblNewLabel_1.setBounds(628, 38, 172, 130);
			contentPanel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(SelectPayment.class.getResource("/com/javaproject/image/Backbtn.png")));
			lblNewLabel_2.setBounds(11, 39, 161, 130);
			contentPanel.add(lblNewLabel_2);

		JLabel moviePoster = new JLabel("");
		moviePoster.setLocation(34, 101);
		moviePoster.setSize(380, 450);
		moviePoster.setIcon(
				new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]포스터_포레스트검프.png")));

		contentPanel.add(moviePoster);
		// 이전화면 버튼
		JLabel BtnGoToPreviousPage = new JLabel("");
		BtnGoToPreviousPage
				.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn 이전화면.png")));

		BtnGoToPreviousPage.setBounds(504, 249, 200, 100);
		contentPanel.add(BtnGoToPreviousPage);
		// 배경화면
		JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
		lbl_background.setIcon(new ImageIcon(
				MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_background.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_background);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	// 구매취소
	public void OrderCancleAction() {

		JOptionPane.showMessageDialog(null, "구매취소되었습니다.");
		OrderCancledialog.setVisible(false);
		OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
		dispose();
	}

}
