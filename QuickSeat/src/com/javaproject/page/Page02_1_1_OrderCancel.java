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
import com.javaproject.page.Page02_1_0_OrderCheck.mybutton;

public class Page02_1_1_OrderCancel extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
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
	 */
	/**
	 * Launch the application.
	 */
	private static Page02_1_1_OrderCancel OrderCancledialog = new Page02_1_1_OrderCancel();
//	private static Page02_1_1_OrderCancel_Dialog OrderCancledialogdialog = new Page02_1_1_OrderCancel_Dialog();
	private static Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
	private static Page02_1_0_OrderCheck OrderCheckdialog = new Page02_1_0_OrderCheck();
	private mybutton btnNewButton;
	
	public static void main(String[] args) {
		try {
			OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			OrderCancledialog.setVisible(true);
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
		/**
		 * Create the dialog.
	 */
	public Page02_1_1_OrderCancel() {
		setTitle("예매 확인");
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
		dispose();
		OrderCancledialog.setVisible(false);
		OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}
	
	// 이전화면(예매확인)으로 가기
		public void goToOredrCheck() {
			dispose();
			OrderCancledialog.setVisible(false);
			OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			OrderCheckdialog.setVisible(true);
		}

	// 구매취소0
	public void OrderCancleAction() {
		//JOptionPane에 배경화면 지정 불가... 따라서 새로운 클래스 생성하고 그 클래스의 매소드르
		JOptionPane.showMessageDialog(null, "구매취소되었습니다.");
		
		
		
		
		OrderCancledialog.setVisible(false);
		OrderCancledialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
//		Page02_1_1_OrderCancel_Dialog OrderCancledialogdialog= new Page02_1_1_OrderCancel_Dialog();
//		OrderCancledialogdialog.setVisible(true);
		selectMenudialog.setVisible(true);
		
	}
	// 구매 버튼
		private JButton getBtnNewButton() {
			if (btnNewButton == null) {

				btnNewButton = new mybutton("구매취소", new Color(183, 216, 107));
				btnNewButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 60));
				btnNewButton.setBounds(146, 450, 500, 100);
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						OrderCancleAction();
					}
				});

			}
			return btnNewButton;
		}
		
}
