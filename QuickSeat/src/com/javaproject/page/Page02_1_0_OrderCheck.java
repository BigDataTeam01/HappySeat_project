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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import com.javaproject.page.Page8_SelectHeadCount.mybutton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Page2_1_0_OrderCheck extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 예매,주문내역 확인 화면
	 * 				 1.OrderCheck 에서 발권된 발권번호를 입력 후 입력완료를 터치시 Page2_1_1_OrderCancel 화면으로 이동
	 * 				 2.OrderCheck 에서 왼쪽 상단에 있는 첫화면 버튼을 터치 하면 MenuSelect 화면으로 이동
	 * Date : 2024.01.06 (토요일)
	 * Author : 박정민,박지환
	 * 
	 * 
	  *  *  * Update 2024.01.06 by J.park:
	 * 			1. descripton 수정
	 * 			3. kiosk set bound sharevar 에서 가져와 지정
	 * 			4. diaog -> static 
	 * 			5. 배경 추가
	 * 			6. 첫화면Icon 추가
	 * 			7. 숫자입력 버튼 추가
	 * 			8. 입력완료 버튼 추가******************************** 화면 크기 바뀌면서 UI다시 바꿔야함(나중에 다시 만들기)******************************************
	 * 			9.  입력완료,숫자패드,이전,처음으로 아이콘,위치 변경
	 * 
	 */
	/**
	 * Launch the application.
	 */
	private static Page2_1_0_OrderCheck OrderCheckdialog = new Page2_1_0_OrderCheck();
	private static Page2_SelectMenu selectMenudialog = new Page2_SelectMenu();
	private static Page2_1_1_OrderCancel OrderCancledialog = new Page2_1_1_OrderCancel();
	private JTextField tfTicketNum;
	private mybutton btnNewButton;

	public static void main(String[] args) {
		try {
			OrderCheckdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			OrderCheckdialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//////////////라운드 버튼박스를 만들기 위한 paintComponent 설정

	class mybutton extends JButton {
		private Color backgroundColor = new Color(183, 216, 107);

		public mybutton(String text, Color bgColor) {
			super(text);
			this.backgroundColor = bgColor;
			init();
		}

		private void init() {
			setContentAreaFilled(false);
			setOpaque(false);
		}

		@Override
		public void paintComponent(Graphics g) {
			int width = getWidth();
			int height = getHeight();
			Graphics2D graphics = (Graphics2D) g;
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			if (getModel().isArmed()) {
				graphics.setColor(backgroundColor.darker());
			} else if (getModel().isRollover()) {
				graphics.setColor(backgroundColor.brighter());
			} else {
				graphics.setColor(backgroundColor);
			}

			graphics.fillRoundRect(0, 0, width, height, 10, 10);
			FontMetrics fontMetrics = graphics.getFontMetrics();
			Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
			int textX = (width - stringBounds.width) / 2;
			int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

			graphics.setColor(getForeground());
			graphics.setFont(getFont());
			graphics.drawString(getText(), textX, textY);
			graphics.dispose();
			super.paintComponent(g);
		}
	}

////
	/**
	 * Create the dialog.
	 */
	public Page2_1_0_OrderCheck() {
		setTitle("예매 확인");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		//입력완료 버튼 넣기
		contentPanel.add(getBtnNewButton());
//		페이지 타이틀 
		JLabel lbl_pageTitle = new JLabel("예매 확인");
		lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

		lbl_pageTitle.setBounds(295, 10, 250, 100);

		contentPanel.add(lbl_pageTitle);
		// 첫화면 아이콘
		JLabel lbl_pageTitle_1 = new JLabel("첫화면");
		lbl_pageTitle_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMenu();
			}
		});
		lbl_pageTitle_1
				.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));

		lbl_pageTitle_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		lbl_pageTitle_1.setBounds(628, 17, 180, 130);
		contentPanel.add(lbl_pageTitle_1);

		// 발권번호 텍스트
		JLabel lblTicketNum = new JLabel("발권 번호 :");
		lblTicketNum.setFont(new Font("배달의민족 도현", Font.PLAIN, 50));
		lblTicketNum.setBounds(42, 196, 240, 70);
		contentPanel.add(lblTicketNum);

		// 이전으로버튼
		JLabel BtnBack = new JLabel("");
		BtnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectMenu();
			}
		});
		BtnBack.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
		BtnBack.setBounds(11, 18, 170, 130);
		contentPanel.add(BtnBack);

		// 발권번호 텍스트 필드
		tfTicketNum = new JTextField();
		tfTicketNum.setBounds(300, 210, 400, 38);
		contentPanel.add(tfTicketNum);
		tfTicketNum.setColumns(10);

		// 숫자버튼부분
		JLabel Btn1 = new JLabel("");
		Btn1.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn1.png")));
		Btn1.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		Btn1.setBounds(42, 322, 70, 70);
		contentPanel.add(Btn1);

		JLabel Btn2 = new JLabel("\"\"");
		Btn2.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn2.png")));
		Btn2.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		Btn2.setBounds(132, 322, 70, 70);
		contentPanel.add(Btn2);

		JLabel Btn3 = new JLabel("\"\"");
		Btn3.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn3.png")));
		Btn3.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		Btn3.setBounds(222, 322, 70, 70);
		contentPanel.add(Btn3);

		JLabel Btn5 = new JLabel("\"\"");
		Btn5.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn5.png")));
		Btn5.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		Btn5.setBounds(402, 322, 70, 70);
		contentPanel.add(Btn5);

		JLabel Btn6 = new JLabel("\"\"");
		Btn6.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn6.png")));
		Btn6.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		Btn6.setBounds(45, 403, 70, 70);
		contentPanel.add(Btn6);

		JLabel Btn4 = new JLabel("\"\"");
		Btn4.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn4.png")));
		Btn4.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		Btn4.setBounds(312, 322, 70, 70);
		contentPanel.add(Btn4);

		JLabel Btn8 = new JLabel("\"\"");
		Btn8.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn8.png")));
		Btn8.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		Btn8.setBounds(225, 403, 70, 70);
		contentPanel.add(Btn8);

		JLabel Btn9 = new JLabel("\"\"");
		Btn9.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn9.png")));
		Btn9.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		Btn9.setBounds(315, 403, 70, 70);
		contentPanel.add(Btn9);

		JLabel BtnClear = new JLabel("\"\"");
		BtnClear.setIcon(
				new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/BtnClear.png")));
		BtnClear.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		BtnClear.setBounds(484, 322, 70, 70);
		contentPanel.add(BtnClear);

		JLabel Btn0 = new JLabel("\"\"");
		Btn0.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn0.png")));
		Btn0.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		Btn0.setBounds(405, 403, 70, 70);
		contentPanel.add(Btn0);

		JLabel Btn1Delete = new JLabel("\"\"");
		Btn1Delete.setIcon(
				new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn1Delete.png")));
		Btn1Delete.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		Btn1Delete.setBounds(484, 403, 70, 70);
		contentPanel.add(Btn1Delete);

		JLabel Btn7 = new JLabel("\"\"");
		Btn7.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn7.png")));
		Btn7.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
		Btn7.setBounds(135, 403, 70, 70);
		contentPanel.add(Btn7);

		// 배경화면
		JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
		lbl_background.setIcon(new ImageIcon(
				Page5_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_background.setBounds(-16, 0, 800, 600);
		contentPanel.add(lbl_background);
	}

//---------------------------Function---------------------
	// 첫화면으로 가기
	public void goToSelectMenu() {
		dispose();
		OrderCheckdialog.setVisible(false);
		OrderCheckdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}

	// 티켓 취소화면으로 가기
	public void goToOrderCancle() {
		dispose();
		OrderCheckdialog.setVisible(false);
		OrderCheckdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		OrderCancledialog.setVisible(true);

	}

	// 입력완료 버튼
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {

			btnNewButton = new mybutton("입력완료", new Color(183, 216, 107));
			btnNewButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
			btnNewButton.setBounds(563, 331, 194, 133);
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToOrderCancle();
				}
			});

		}
		return btnNewButton;
	}

}// End
