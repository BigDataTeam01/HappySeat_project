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
import com.javaproject.kioskFunction.BackSplashTimer;
import com.javaproject.kioskFunction.ButtonInsertIcon;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	 * 
	 * 
	 *  Update 2024.01.14 by PDG
	 *  		1. 버튼 전부다 새로 만듬. 
	 */
	
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		try {
			Page03_SelectAge selectAgedialog = new Page03_SelectAge();
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				backSplashTimeEnd();
			}
		});
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
		
		///////////////////// 버튼 새로 만듭니다. //////////////////
		
		//<<20이하 버튼생성>>
		ImageIcon iconBtnUnder20 = new ImageIcon(
				Page03_SelectAge.class.getResource("/com/javaproject/image/BtnUnder20.png"));
		

		ButtonInsertIcon BtnUnder20 = new ButtonInsertIcon(iconBtnUnder20,ShareVar.btnFillet);
		BtnUnder20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareVar.selectedCustage=10;
				goToSelectMovie();
			}
		});

		BtnUnder20.setBounds(52, 192, 134, 105);
		BtnUnder20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShareVar.selectedCustage=10;
				goToSelectMovie();
			}
		});
		contentPanel.add(BtnUnder20);
		
		//<<20대 버튼생성>>
		ImageIcon iconBtn20 = new ImageIcon(
				Page03_SelectAge.class.getResource("/com/javaproject/image/Btn20대.png"));
		

		ButtonInsertIcon Btn20 = new ButtonInsertIcon(iconBtn20,ShareVar.btnFillet);
		Btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareVar.selectedCustage=10;
				goToSelectMovie();
			}
		});

		Btn20.setBounds(240, 192, 134, 105);
		Btn20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShareVar.selectedCustage=20;
				goToSelectMovie();
			}
		});
		contentPanel.add(Btn20);
		
		//<<30대 버튼생성>>
		ImageIcon iconBtn30 = new ImageIcon(
				Page03_SelectAge.class.getResource("/com/javaproject/image/Btn30대.png"));
		

		ButtonInsertIcon Btn30 = new ButtonInsertIcon(iconBtn30,ShareVar.btnFillet);
		Btn30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareVar.selectedCustage=30;
				goToSelectMovie();
			}
		});

		Btn30.setBounds(427, 192, 134, 105);
		Btn30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShareVar.selectedCustage=30;
				goToSelectMovie();
			}
		});
		contentPanel.add(Btn30);
		
		
		//<<40대 버튼생성>>
		ImageIcon iconBtn40 = new ImageIcon(
				Page03_SelectAge.class.getResource("/com/javaproject/image/Btn40대.png"));
		

		ButtonInsertIcon Btn40 = new ButtonInsertIcon(iconBtn40,ShareVar.btnFillet);
		Btn40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareVar.selectedCustage=40;
				goToSelectMovie();
			}
		});

		Btn40.setBounds(609, 192, 134, 105);
		Btn40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShareVar.selectedCustage=40;
				goToSelectMovie();
			}
		});
		contentPanel.add(Btn40);
		
		//<<50대 버튼생성>>
		ImageIcon iconBtn50 = new ImageIcon(
				Page03_SelectAge.class.getResource("/com/javaproject/image/Btn50대.png"));
		

		ButtonInsertIcon Btn50 = new ButtonInsertIcon(iconBtn50,ShareVar.btnFillet);
		Btn50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareVar.selectedCustage=50;
				goToSelectMovie();
			}
		});

		Btn50.setBounds(52, 365, 134, 105);
		Btn50.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShareVar.selectedCustage=50;
				goToSelectMovie();
			}
		});
		contentPanel.add(Btn50);
		
		//<<60대 버튼생성>>
		ImageIcon iconBtn60 = new ImageIcon(
				Page03_SelectAge.class.getResource("/com/javaproject/image/Btn60대.png"));
		

		ButtonInsertIcon Btn60 = new ButtonInsertIcon(iconBtn60,ShareVar.btnFillet);
		Btn60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareVar.selectedCustage=60;
				goToSelectMovie();
			}
		});

		Btn60.setBounds(240, 365, 134, 105);
		Btn60.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShareVar.selectedCustage=60;
				goToSelectMovie();
			}
		});
		contentPanel.add(Btn60);
		
		//<<70대 버튼생성>>
		ImageIcon iconBtn70 = new ImageIcon(
				Page03_SelectAge.class.getResource("/com/javaproject/image/Btn70대.png"));
		

		ButtonInsertIcon Btn70 = new ButtonInsertIcon(iconBtn70,ShareVar.btnFillet);
		Btn70.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareVar.selectedCustage=70;
				goToSelectMovie();
			}
		});

		Btn70.setBounds(427, 365, 134, 105);
		Btn70.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShareVar.selectedCustage=70;
				goToSelectMovie();
			}
		});
		contentPanel.add(Btn70);
		//<<80대 버튼생성>>
		ImageIcon iconBtn80 = new ImageIcon(
				Page03_SelectAge.class.getResource("/com/javaproject/image/Btn80대.png"));
		

		ButtonInsertIcon Btn80 = new ButtonInsertIcon(iconBtn80,ShareVar.btnFillet);
		Btn80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShareVar.selectedCustage=80;
				goToSelectMovie();
			}
		});

		Btn80.setBounds(615, 365, 134, 105);
		Btn80.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShareVar.selectedCustage=80;
				goToSelectMovie();
			}
		});
		contentPanel.add(Btn80);
		







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
		Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
		dispose();
		this.setVisible(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}

	// 전화면으로 가기
	public void goToOrderCancle() {
		Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
		dispose();
		this.setVisible(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}

	// 영화선택화면으로 가기
	public void goToSelectMovie() {
		Page04_SelectMovie selectMoviedialog = new Page04_SelectMovie();
		int cust_age = ShareVar.selectedCustage;
		System.out.println(cust_age);
		dispose();
		this.setVisible(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMoviedialog.setVisible(true);
	}
	
	// splash Class로 돌아가기
	public void backSplashTimeEnd() {
		BackSplashTimer backSplashTimer = new BackSplashTimer(30, this);
	}

}
