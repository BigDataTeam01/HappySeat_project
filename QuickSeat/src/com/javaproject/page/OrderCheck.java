package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class OrderCheck extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 예매,주문내역 확인 화면
	 * 				 1.OrderCheck 에서 발권된 발권번호를 입력 후 입력완료를 터치시 OrderCancle 화면으로 이동
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
	 * 			5. 첫화면Icon 추가
	 * 			5. 숫자입력 버튼 추가
	 * 			5. 입력완료 버튼 추가******************************** 화면 크기 바뀌면서 UI다시 바꿔야함(나중에 다시 만들기)******************************************
	 * 
	 */
	
	
	
	/**
	 * Launch the application.
	 */
	private static OrderCheck OrderCheckdialog = new OrderCheck();
	private static SelectMenu selectMenudialog = new SelectMenu();
	private static OrderCancle OrderCancledialog = new OrderCancle();
	private JTextField textField;

	public static void main(String[] args) {
		try {
			OrderCheckdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			OrderCheckdialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrderCheck() {
		setTitle("예매 확인");
		setBounds(ShareVar.kiosk_loc_x, 
				  ShareVar.kiosk_loc_y, 
				  ShareVar.kiosk_width, 
				  ShareVar.kiosk_hight);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
			contentPanel.setLayout(null);

//		페이지 타이틀 
			JLabel lbl_pageTitle = new JLabel("예매 확인");
			lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font,
			 								Font.PLAIN, 
			 								ShareVar.kiosk_title_font_size));
			 								
			lbl_pageTitle.setBounds(295, 
									10, 
									250,
									100);
			
			contentPanel.add(lbl_pageTitle);
			//첫화면 아이콘
			JLabel lbl_pageTitle_1 = new JLabel("첫화면");
			lbl_pageTitle_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectMenu();
				}
			});
			lbl_pageTitle_1.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/첫화면Icon.png")));

			lbl_pageTitle_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			lbl_pageTitle_1.setBounds(12, 30, 46, 68);
			contentPanel.add(lbl_pageTitle_1);
			
			//발권번호 텍스트
			JLabel lbl_pageTitle_2 = new JLabel("발권번호 :");
			lbl_pageTitle_2.setFont(new Font("배달의민족 도현", Font.PLAIN, 30));
			lbl_pageTitle_2.setBounds(49, 142, 134, 51);
			contentPanel.add(lbl_pageTitle_2);
			
			//입력완료버튼
			JLabel BTNInsertComplete = new JLabel("");
			BTNInsertComplete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToOrderCancle();
					
				}
			});
			BTNInsertComplete.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn입력완료.png")));
			BTNInsertComplete.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			BTNInsertComplete.setBounds(399, 254, 210, 58);
			contentPanel.add(BTNInsertComplete);
			
			textField = new JTextField();
			textField.setBounds(202, 146, 528, 38);
			contentPanel.add(textField);
			textField.setColumns(10);
			
			//숫자버튼부분
			JLabel Btn1 = new JLabel("");
			Btn1.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn1.png")));
			Btn1.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			Btn1.setBounds(49, 200, 70, 70);
			contentPanel.add(Btn1);
			
			JLabel Btn2 = new JLabel("\"\"");
			Btn2.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn2.png")));
			Btn2.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			Btn2.setBounds(129, 200, 70, 70);
			contentPanel.add(Btn2);
			
			JLabel Btn3 = new JLabel("\"\"");
			Btn3.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn3.png")));
			Btn3.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			Btn3.setBounds(209, 200, 70, 70);
			contentPanel.add(Btn3);
			
			JLabel Btn5 = new JLabel("\"\"");
			Btn5.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn5.png")));
			Btn5.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			Btn5.setBounds(129, 280,70, 70);
			contentPanel.add(Btn5);
			
			JLabel Btn6 = new JLabel("\"\"");
			Btn6.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn6.png")));
			Btn6.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			Btn6.setBounds(209, 280, 70, 70);
			contentPanel.add(Btn6);
			
			JLabel Btn4 = new JLabel("\"\"");
			Btn4.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn4.png")));
			Btn4.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			Btn4.setBounds(49, 280, 70, 70);
			contentPanel.add(Btn4);
			
			JLabel Btn8 = new JLabel("\"\"");
			Btn8.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn8.png")));
			Btn8.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			Btn8.setBounds(129, 360, 70, 70);
			contentPanel.add(Btn8);
			
			JLabel Btn9 = new JLabel("\"\"");
			Btn9.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn9.png")));
			Btn9.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			Btn9.setBounds(209, 360, 70, 70);
			contentPanel.add(Btn9);
			
			JLabel BtnClear = new JLabel("\"\"");
			BtnClear.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/BtnClear.png")));
			BtnClear.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			BtnClear.setBounds(49, 440, 70, 70);
			contentPanel.add(BtnClear);
			
			JLabel Btn0 = new JLabel("\"\"");
			Btn0.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn0.png")));
			Btn0.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			Btn0.setBounds(129, 440, 70, 70);
			contentPanel.add(Btn0);
			
			JLabel Btn1Delete = new JLabel("\"\"");
			Btn1Delete.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn1Delete.png")));
			Btn1Delete.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			Btn1Delete.setBounds(209, 440, 70, 70);
			contentPanel.add(Btn1Delete);
			
			JLabel Btn7 = new JLabel("\"\"");
			Btn7.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn7.png")));
			Btn7.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			Btn7.setBounds(49, 360, 70, 70);
			contentPanel.add(Btn7);
			
			//배경화면
			JLabel lbl_background = new JLabel("",SwingConstants.CENTER);
			lbl_background.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
			lbl_background.setBounds(-16, 0, 800, 600);
			contentPanel.add(lbl_background);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
//---------------------------Function---------------------
	//첫화면으로 가기
	public void goToSelectMenu() {
		OrderCheckdialog.setVisible(false);
		OrderCheckdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}
	//티켓 취소화면으로 가기
	public void goToOrderCancle() {
		OrderCheckdialog.setVisible(false);
		OrderCheckdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		OrderCancledialog.setVisible(true);
		
	}
}//End
