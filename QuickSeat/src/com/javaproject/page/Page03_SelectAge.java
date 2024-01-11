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

public class Page03_SelectAge extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 연령대 선택화면
	 * 				 1.SelectAge에서 연령대 버튼을 터치했을시 MovieSelect 화면으로 이동
	 * 				 2.SelectAge에서 이전 화면 버튼을 터치했을시  SelectMenu 화면으로 이동
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환
	 * 
	 *  *  * Update 2024.01.07 by J.park:
	 * 			1. descripton 수정
	 * 			2. kiosk set bound sharevar 에서 가져와 지정
	 * 			3. diaog -> static 
	 * 			4. 배경 추가
	 * 			5. 나이선택,이전화면,연령확인,첫화면 버튼추가
	 * 			6. 처음으로,이전으로 버튼 변경
	 */
	/**
	 * Launch the application.
	 */
	private static Page03_SelectAge selectAgedialog = new Page03_SelectAge();
	private static Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
	private static Page04_SelectMovie selectMoviedialog = new Page04_SelectMovie();

	public static void main(String[] args) {
		try {
			selectAgedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			selectAgedialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page03_SelectAge() {
		setTitle("연령 선택");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setLayout(null);

		// 첫화면 아이콘
		JLabel lbl_pageTitle_1 = new JLabel("첫화면");
		lbl_pageTitle_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMenu();
			}
		});
		lbl_pageTitle_1
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));

		lbl_pageTitle_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		lbl_pageTitle_1.setBounds(628, 17, 180, 130);
		contentPanel.add(lbl_pageTitle_1);
		// 페이지 타이틀
		JLabel lbl_pageTitle = new JLabel("연령 선택");
		lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

		lbl_pageTitle.setBounds(295, 10, 250, 100);

		contentPanel.add(lbl_pageTitle);
		// 나이 버튼
		JLabel BtnUnder10 = new JLabel("");
		BtnUnder10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMovie();
			}
		});
		BtnUnder10.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn10대 이하.png")));
		BtnUnder10.setBounds(52, 192, 140, 110);
		contentPanel.add(BtnUnder10);

		JLabel Btn20 = new JLabel("");
		Btn20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMovie();
			}
		});

		Btn20.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn20대.png")));
		Btn20.setBounds(240, 192, 140, 110);
		contentPanel.add(Btn20);

		JLabel Btn30 = new JLabel("");
		Btn30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMovie();
			}
		});
		Btn30.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn30대.png")));
		Btn30.setBounds(427, 192, 140, 110);
		contentPanel.add(Btn30);

		JLabel Btn40 = new JLabel("");
		Btn40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMovie();
			}
		});
		Btn40.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn40대.png")));
		Btn40.setBounds(609, 192, 140, 110);
		contentPanel.add(Btn40);

		JLabel Btn50 = new JLabel("");
		Btn50.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMovie();
			}
		});
		Btn50.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn50대.png")));
		Btn50.setBounds(52, 365, 140, 110);
		contentPanel.add(Btn50);

		JLabel Btn60 = new JLabel("");
		Btn60.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMovie();
			}
		});
		Btn60.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn60대.png")));
		Btn60.setBounds(240, 365, 140, 110);
		contentPanel.add(Btn60);

		JLabel Btn70 = new JLabel("");
		Btn70.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMovie();
			}
		});
		Btn70.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn70대.png")));
		Btn70.setBounds(427, 365, 140, 110);
		contentPanel.add(Btn70);

		JLabel BtnOver80 = new JLabel("");
		BtnOver80.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMovie();
			}
		});
		BtnOver80.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn80대.png")));
		BtnOver80.setBounds(615, 365, 140, 110);
		contentPanel.add(BtnOver80);
		// 이전으로버튼
		JLabel BtnBack = new JLabel("");
		BtnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToOrderCancle();
			}
		});
		BtnBack.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
		BtnBack.setBounds(11, 18, 170, 130);
		contentPanel.add(BtnBack);

		// 배경화면
		JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
		lbl_background.setIcon(new ImageIcon(
				Page05_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_background.setBounds(0, 0, 800, 600);
		contentPanel.add(lbl_background);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	// 첫화면으로 가기
	public void goToSelectMenu() {
		dispose();
		selectAgedialog.setVisible(false);
		selectAgedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}

	// 전화면으로 가기
	public void goToOrderCancle() {
		dispose();
		selectAgedialog.setVisible(false);
		selectAgedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}

	// 영화선택화면으로 가기
	public void goToSelectMovie() {
		dispose();
		selectAgedialog.setVisible(false);
		selectAgedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMoviedialog.setVisible(true);
	}
}
