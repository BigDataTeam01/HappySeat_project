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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;

public class Page8_SelectHeadCount extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 1. SelectHeadCount에서 이전화면 버튼을 터치했을시 SelectTime 화면으로 이동
	 * 				 2. SelectHeadCount에서 인원선택버튼에 -+를 터치했을시  숫자변동 
	 * 				 3. SelectHeadCount에서 인원확정을 터치했을시  SelectSeat화면으로 이동
	 * 				 4. SelectHeadCount에서 첫화면 버튼을 터치했을시  SelectMenu화면으로 이동
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환
	 * 
	 *  *  *  *  * Update 2024.01.8 by J.park:
	 * 			1. descripton 수정
	 * 			3. kiosk set bound sharevar 에서 가져와 지정
	 * 			4. diaog -> static 
	 * 			5. 배경 추가
	 * 			5. 첫화면,이전화면, 입력완료(임시) 추가
	 * 
	 */

	/**
	 * Launch the application.
	 */
	private static Page8_SelectHeadCount SelectHeadCountdialog = new Page8_SelectHeadCount();
	private static Page2_SelectMenu selectMenudialog = new Page2_SelectMenu();
	private static Page7_SelectTime SelectTimedialog = new Page7_SelectTime();
	private static Page9_SelectSeat SelectSeatdialog = new Page9_SelectSeat();

	public static void main(String[] args) {
		try {
			Page8_SelectHeadCount dialog = new Page8_SelectHeadCount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page8_SelectHeadCount() {
		// 타이틀 설정
		setTitle("인원 선택");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			// 페이지 타이틀
			JLabel lbl_pageTitle = new JLabel("인원 선택");
			lbl_pageTitle.setBounds(295, 10, 250, 100);
			lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

			contentPanel.add(lbl_pageTitle);
			// 첫화면 아이콘
			JLabel lbl_pageTitle_1 = new JLabel("첫화면");
			lbl_pageTitle_1.setBounds(12, 30, 46, 68);
			lbl_pageTitle_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectMenu();
				}
			});
			lbl_pageTitle_1
					.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/첫화면Icon.png")));

			lbl_pageTitle_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			contentPanel.add(lbl_pageTitle_1);
			// 이전화면으로 가기
			JLabel BtnBackToPrevious = new JLabel("");
			BtnBackToPrevious.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectTime();
				}
			});

			BtnBackToPrevious
					.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn 이전화면.png")));
			BtnBackToPrevious.setBounds(295, 441, 200, 100);
			contentPanel.add(BtnBackToPrevious);
			// 영화좌석선택으로 가기
			JLabel BtnConfirmHeadCount = new JLabel("");
			BtnConfirmHeadCount.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectSeat();
				}
			});
			BtnConfirmHeadCount
					.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn입력완료.png")));

			BtnConfirmHeadCount.setBounds(295, 318, 227, 100);
			contentPanel.add(BtnConfirmHeadCount);
			// 배경화면
			JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
			lbl_background.setIcon(new ImageIcon(
					Page5_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
			lbl_background.setBounds(-16, 0, 800, 600);
			contentPanel.add(lbl_background);

		}
	}

//--------------------Function----------------------------
	// 다음화면(영화좌석선택)로 가기
	private void goToSelectSeat() {
		dispose();
		SelectHeadCountdialog.setVisible(false);
		SelectHeadCountdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectSeatdialog.setVisible(true);
	}

	// 이전화면(영화시간선택)으로 가기
	private void goToSelectTime() {
		dispose();
		SelectHeadCountdialog.setVisible(false);
		SelectHeadCountdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectTimedialog.setVisible(true);
	}

	// 첫화면으로 가기
	private void goToSelectMenu() {
		dispose();
		SelectHeadCountdialog.setVisible(false);
		SelectHeadCountdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}

}// End
