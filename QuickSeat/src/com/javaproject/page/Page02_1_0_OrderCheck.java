package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import com.javaproject.kioskFunction.BackSplashTimer;
import com.javaproject.kioskFunction.ButtonDesign_ver1;
import com.javaproject.kioskFunction.Dao_PJH;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.*;



public class Page02_1_0_OrderCheck extends JDialog {
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
	 * 			2. kiosk set bound sharevar 에서 가져와 지정
	 * 			3. diaog -> static 
	 * 			4. 배경 추가
	 * 			5. 첫화면Icon 추가
	 * 			6. 숫자입력 버튼 추가
	 * 			7. 입력완료 버튼 추가******************************** 화면 크기 바뀌면서 UI다시 바꿔야함(나중에 다시 만들기)******************************************
	 * 			8.  입력완료,숫자패드,이전,처음으로 아이콘,위치 변경
	 * 
	 *  *  *  * Update 2024.01.13 by J.park:
	 * 			1. 버튼숫자입력 기능 구현
	 * 			2.입력된 숫자 쉐어바에 저장
	 * 			
	 * 	 *  *  *  * Update 2024.01.14 by J.park:
	 * 			1. 입력된 발권번호와 db의 발권번호를 비교해 번호가 같으면 쉐어바에 insertedOrderNum에 발권번호 저장
	 * 
	 *  Update 2024.1.14 by PDG
	 *  
	 *  		1. button 을 클래스페이지에서 받아서 생성하도록 바꿧어요.
	 *  		2. 페이지 종료후 타이머 돌지 않게 함. 
	 * 			
	/**
	 * Launch the application.
	 */
	private JTextField tfTicketNum; //?

	BackSplashTimer backSplashTimer ;

	public static void main(String[] args) {
		try {
			Page02_1_0_OrderCheck OrderCheckdialog = new Page02_1_0_OrderCheck();
			OrderCheckdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			OrderCheckdialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page02_1_0_OrderCheck() {
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
		setTitle("예매 확인");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// 입력완료 버튼 넣기
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
		lbl_pageTitle_1.setIcon(
				new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));

		lbl_pageTitle_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		lbl_pageTitle_1.setBounds(628, 17, 180, 130);
		contentPanel.add(lbl_pageTitle_1);

		// 발권번호 텍스트
		JLabel lblTicketNum = new JLabel("발권 번호 :");
		lblTicketNum.setFont(new Font("BM Dohyeon", Font.PLAIN, 50));
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
		BtnBack.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
		BtnBack.setBounds(11, 18, 170, 130);
		contentPanel.add(BtnBack);

		// 발권번호 텍스트 필드
		tfTicketNum = new JTextField();
		tfTicketNum.setBounds(300, 210, 400, 38);
		contentPanel.add(tfTicketNum);
		tfTicketNum.setColumns(10);

		// 숫자버튼부분
		JLabel Btn1 = new JLabel("");
		Btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTicketNum.setText(tfTicketNum.getText() + "1");// 1번 버튼 눌렀을때 1번 입력
			}
		});
		Btn1.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn1.png")));
		Btn1.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		Btn1.setBounds(42, 322, 70, 70);
		contentPanel.add(Btn1);

		JLabel Btn2 = new JLabel("\"\"");
		Btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTicketNum.setText(tfTicketNum.getText() + "2");
			}
		});
		Btn2.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn2.png")));
		Btn2.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		Btn2.setBounds(132, 322, 70, 70);
		contentPanel.add(Btn2);

		JLabel Btn3 = new JLabel("\"\"");
		Btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTicketNum.setText(tfTicketNum.getText() + "3");
			}
		});
		Btn3.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn3.png")));
		Btn3.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		Btn3.setBounds(222, 322, 70, 70);
		contentPanel.add(Btn3);

		JLabel Btn4 = new JLabel("\"\"");
		Btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTicketNum.setText(tfTicketNum.getText() + "4");
			}
		});
		Btn4.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn4.png")));
		Btn4.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		Btn4.setBounds(312, 322, 70, 70);
		contentPanel.add(Btn4);

		JLabel Btn5 = new JLabel("\"\"");
		Btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTicketNum.setText(tfTicketNum.getText() + "5");
			}
		});
		Btn5.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn5.png")));
		Btn5.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		Btn5.setBounds(402, 322, 70, 70);
		contentPanel.add(Btn5);

		JLabel Btn6 = new JLabel("\"\"");
		Btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTicketNum.setText(tfTicketNum.getText() + "6");
			}
		});
		Btn6.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn6.png")));
		Btn6.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		Btn6.setBounds(45, 403, 70, 70);
		contentPanel.add(Btn6);

		JLabel Btn7 = new JLabel("\"\"");
		Btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTicketNum.setText(tfTicketNum.getText() + "7");
			}
		});
		Btn7.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn7.png")));
		Btn7.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		Btn7.setBounds(135, 403, 70, 70);
		contentPanel.add(Btn7);

		JLabel Btn8 = new JLabel("\"\"");
		Btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTicketNum.setText(tfTicketNum.getText() + "8");
			}
		});
		Btn8.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn8.png")));
		Btn8.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		Btn8.setBounds(225, 403, 70, 70);
		contentPanel.add(Btn8);

		JLabel Btn9 = new JLabel("\"\"");
		Btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTicketNum.setText(tfTicketNum.getText() + "9");
			}
		});
		Btn9.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn9.png")));
		Btn9.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		Btn9.setBounds(315, 403, 70, 70);
		contentPanel.add(Btn9);

		JLabel Btn0 = new JLabel("\"\"");
		Btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTicketNum.setText(tfTicketNum.getText() + "0");
			}
		});
		Btn0.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn0.png")));
		Btn0.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		Btn0.setBounds(405, 403, 70, 70);
		contentPanel.add(Btn0);

		JLabel BtnClear = new JLabel("\"\"");
		BtnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfTicketNum.setText(""); // 발권번호 모두 지우기
			}
		});
		BtnClear.setIcon(
				new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/BtnClear.png")));
		BtnClear.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		BtnClear.setBounds(484, 322, 70, 70);
		contentPanel.add(BtnClear);

		JLabel BtnDelete = new JLabel("\"\"");
		BtnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String currentText = tfTicketNum.getText();
				if (!currentText.isEmpty()) {
					// 현재 텍스트가 비어있지 않으면 마지막 문자를 제거
					tfTicketNum.setText(currentText.substring(0, currentText.length() - 1));
				}
			}
		});
		BtnDelete.setIcon(
				new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn1Delete.png")));
		BtnDelete.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		BtnDelete.setBounds(484, 403, 70, 70);
		contentPanel.add(BtnDelete);

		// 배경화면
		JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
		lbl_background.setIcon(new ImageIcon(
				Page05_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lbl_background.setBounds(-16, 0, 800, 600);
		contentPanel.add(lbl_background);
	}

//---------------------------Function---------------------
	// 첫화면으로 가기
	public void goToSelectMenu() {
		Page02_1_0_OrderCheck OrderCheckdialog = new Page02_1_0_OrderCheck();
		Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
		dispose();
		OrderCheckdialog.setVisible(false);
		OrderCheckdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}

	// 티켓 취소화면으로 가기
	public void goToOrderCancle() {
		Page02_1_0_OrderCheck OrderCheckdialog = new Page02_1_0_OrderCheck();
		Page02_1_1_OrderCancel OrderCancledialog = new Page02_1_1_OrderCancel();
		dispose();
		OrderCheckdialog.setVisible(false);
		OrderCheckdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		OrderCancledialog.setVisible(true);

	}

	// 입력완료 버튼
	private JButton getBtnNewButton() {
		ButtonDesign_ver1 customButton = new ButtonDesign_ver1("입력완료", ShareVar.btnFillColor);
		customButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 40));
		customButton.setForeground(ShareVar.btnTextColor);
		customButton.setBounds(563, 331, 194, 133);
		customButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(ShareVar.insertedOrderNum);
				checkTicketNumberAndProceed();
			}
		});
		return customButton;
	}

	// 티켓 번호 일치 불일치 확인, 빈값으로 넣었는지 확인 
	private void checkTicketNumberAndProceed() {
	    String inputTicketNum = tfTicketNum.getText();
	    if (inputTicketNum != null && !inputTicketNum.isEmpty()) {
	        // 데이터베이스에서  고객이 작성한 ticket_number와 db에 있는 발권번호와 일치하는지 조회(밑에checkTicketNumberInDatabase애서 확인필요)
	    	// 입력된 데이터가 있을 경우에 밑의  if (ticketNumberExists) 이 구문으로 넘어가고 입력된 데이터가 없다면 제일 밑의 else구문으로 넘어감
	        boolean ticketNumberExists = checkTicketNumberInDatabase(inputTicketNum);

	        if (ticketNumberExists) {
	            // 일치하는 경우 ShareVar에 저장하고 다음 화면으로 이동
	            ShareVar.insertedOrderNum = inputTicketNum;
	            System.out.println(ShareVar.insertedOrderNum);
	            System.out.println("티켓 번호 확인 및 저장: " + ShareVar.insertedOrderNum);
	            goToOrderCancle();
	        } else {
	            // 일치하지 않는 경우 다이얼로그
	        	 JOptionPane.showMessageDialog(null, "일치하지 않는 티켓 번호입니다.");
	        }
	    } else {
	        // 입력된 티켓 번호가 없을 경우 다이얼로그
	    	JOptionPane.showMessageDialog(null, "티켓 번호를 입력하세요.");
	    }
	}

	// 데이터베이스에서 ticket_number 확인(불린값으로 고객이 작성한 발권번호와 디비에 있는 발권번호 비교하하는 메소드)
	private boolean checkTicketNumberInDatabase(String ticketNumber) {
	    boolean result = false;

	    try {
	        // ReserveDAO 객체 생성
	        Dao_PJH dao_PJH = new Dao_PJH();
	        // 데이터베이스에서 가져온 티켓 번호
	        String dbTicketNumber = dao_PJH.confirmReservedTicket();

	        // 티켓 번호가 일치하는지 확인
	        result = ticketNumber.equals(dbTicketNumber);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return result;
	}
	
	
	
	// splash Class로 돌아가기
	public void backSplashTimeEnd() {
		backSplashTimer = new BackSplashTimer(100, this);
	}
	// 만약에 내가 타이머가 다 돌아가기 전에 페이지를 종료한다면 이것이 실행 되지 말아야한다. 
	public void stopTimer() {
		 
		backSplashTimer.stop();
	}
		
}// End
