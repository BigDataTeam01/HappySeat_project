package com.javaproject.page;

import javax.swing.*;

import com.javaproject.base.ShareVar;
import com.javaproject.kioskFunction.Dao_pdg;
import com.javaproject.page.Page5_MovieInformation.mybutton;
import com.mysql.cj.result.Row;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.TimerTask;

public class Page09_SelectSeat_ver2 extends JDialog {

	/*
	 * Description:
	 * 
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JButton[][] seatArray; // 생성되는 좌석들의 배열
	private boolean[][] seatStatus;

	private JPanel contentPanel = new JPanel();
	private JLabel lbl_background;
	private JLabel lbl_previousPage;
	private JLabel lbl_previousPage_1;
	private JLabel lbl_screen;
	private JButton btnSeatConfirm;
	private static StringBuilder seatCode = new StringBuilder("");
	private static StringBuilder selectSeatCode = new StringBuilder("");
//    private Page09_SelectSeat_ver2 dialog = new Page09_SelectSeat_ver2();

	int columnsOfSeats = 4; // column number

	public Page09_SelectSeat_ver2() {
		createSeat();
		// setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 예시로 10개의 좌석을 만듭니다.

		this.setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);
		this.setTitle("좌석선택");
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnSeatConfirm());

//       int residueSeatRow = totalSeats%columnsOfSeats;
//       int rowsOfSeat = totalSeats/columnsOfSeats + residueSeatRow; // row number
//       int a = columnsOfSeats * rowsOfSeat - totalSeats; // 빼야할 좌석의 개수 

		// 좌석 버튼을 다이얼로그에 추가 (여기로 이동했습니다.)
		contentPanel.add(getLbl_previousPage());
		contentPanel.add(getLbl_screen());
		contentPanel.add(getLbl_previousPage_1());
		contentPanel.add(getLbl_background());
	}

	///////////// 라운드 버튼박스를 만들기 위한 paintComponent 설정
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

			graphics.fillRoundRect(0, 0, width, height, 20, 20);

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

	public static void main(String[] args) {
		Page09_SelectSeat_ver2 dialog = new Page09_SelectSeat_ver2();

		Thread seatSelectionThread = new Thread();
		seatSelectionThread.start();

		SwingUtilities.invokeLater(() -> {
			dialog.setVisible(true);
		});

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// getCurrentSeatCode 메소드를 백그라운드에서 실행
				Thread backgroundThread = new Thread(new SeatUpdateRunnable(dialog));
				backgroundThread.start();
			}
		};

		java.util.Timer timer = new java.util.Timer(true);
		timer.scheduleAtFixedRate(task, 0, 1000); // 2초마다 실행 (예시)

	}

	// 페이지 구성요소
	private JLabel getLbl_background() {
		if (lbl_background == null) {
			lbl_background = new JLabel("");
			lbl_background.setIcon(new ImageIcon(
					Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
			lbl_background.setBounds(0, 0, 800, 600);
		}
		return lbl_background;
	}

	private JLabel getLbl_previousPage() {
		if (lbl_previousPage == null) {
			lbl_previousPage = new JLabel("");
			lbl_previousPage.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goPreviousPage();
				}
			});
			lbl_previousPage
					.setIcon(new ImageIcon(Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/Btn이전으로.png")));
			lbl_previousPage.setBounds(15, 20, 170, 130);
		}
		return lbl_previousPage;
	}

	private JLabel getLbl_previousPage_1() {
		if (lbl_previousPage_1 == null) {
			lbl_previousPage_1 = new JLabel("");
			lbl_previousPage_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					gohomeAction();
				}
			});
			lbl_previousPage_1.setBounds(623, 20, 170, 130);
			lbl_previousPage_1
					.setIcon(new ImageIcon(Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/Btn처음으로.png")));
		}
		return lbl_previousPage_1;
	}

	private JLabel getLbl_screen() {
		if (lbl_screen == null) {
			lbl_screen = new JLabel("스크린");
			lbl_screen.setFont(new Font("BM Dohyeon", Font.PLAIN, 38));
			lbl_screen.setBounds(119, 165, 126, 87);
		}
		return lbl_screen;
	}

	private JButton getBtnSeatConfirm() {
		if (btnSeatConfirm == null) {
			btnSeatConfirm = new mybutton("좌석 확정 ", new Color(183, 216, 107));
			btnSeatConfirm.setFont(new Font("BM Dohyeon", Font.PLAIN, 38));
			btnSeatConfirm.setBounds(436, 458, 240, 80);
			btnSeatConfirm.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println("Db 업데이트 코드 : " + selectSeatCode);
					updateSeatCodeAction();
					goConfirmSeat();
				}
			});

		}
		return btnSeatConfirm;
	}

	static class SeatUpdateRunnable implements Runnable {
		private Page09_SelectSeat_ver2 outerInstance;

		public SeatUpdateRunnable(Page09_SelectSeat_ver2 outerInstance) {
			this.outerInstance = outerInstance;
		}

		@Override
		public void run() {
			// 백그라운드에서 수행되어야 할 작업
			System.out.println("새로고침 시작");
			outerInstance.getCurrentSeatCode();
			outerInstance.loadSeat();
			
			// outerInstance.autoCreateSeat();
		}
	}

	// Functions

	private void getCurrentSeatCode() {
		Dao_pdg currentSeatCode = new Dao_pdg(ShareVar.scr_code);
		StringBuilder fetchedSeatCode = new StringBuilder();

		seatCode = fetchedSeatCode.append(currentSeatCode.currentSeatCode());
	}

	private void updateSeatCodeAction() {
		Dao_pdg updateSeatCode = new Dao_pdg(selectSeatCode.toString());
		updateSeatCode.updateSeatCode();
	}

	private void goConfirmSeat() {
		Page10_ConfirmSeat confirmSeat = new Page10_ConfirmSeat();
		this.setVisible(false);
		confirmSeat.setVisible(true);
		this.dispose();
	}

	private void goPreviousPage() {
		Page8_SelectHeadCount prev = new Page8_SelectHeadCount();
		this.setVisible(false);
		prev.setVisible(true);
		this.dispose();
	}

	private void gohomeAction() {
		Page2_SelectMenu prev = new Page2_SelectMenu();
		this.setVisible(false);
		prev.setVisible(true);
		this.dispose();
	}

	private class SeatButtonListener implements ActionListener {
		// Field
		int row;
		int col;

		public SeatButtonListener(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// 좌석 상태 토글
			seatStatus[row][col] = !seatStatus[row][col];

			// ContentArea에 배경색 설정
			if (seatStatus[row][col]) {
//            	seatArray[row][col].setContentAreaFilled(true);
//            	seatArray[row][col].setBackground(Color.red);
				seatArray[row][col].setIcon(
						new ImageIcon(Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/SelectedSeat.png")));

				selectSeatCode.setCharAt(row * columnsOfSeats + col, '1');
//				selectSeatCode = seatCode;
				System.out.println(seatCode);
				System.out.println(selectSeatCode);

			} else {
//            	seatArray[row][col].setContentAreaFilled(false);
//            	seatArray[row][col].setBackground(null);
				selectSeatCode.setCharAt(row * columnsOfSeats + col, '0');
				seatArray[row][col].setIcon(new ImageIcon(
						Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/NotselectedSeat.png")));
			}
		}
	}

	private void createSeat() {
		if (seatArray != null) {
			for (int i = 0; i < seatArray.length; i++) {
				for (int j = 0; j < seatArray[i].length; j++) {
					contentPanel.remove(seatArray[i][j]);
				}
			}
		}

		getCurrentSeatCode();
		selectSeatCode = seatCode;
		int totalSeats = seatCode.length();
		int residueSeatRow = totalSeats % columnsOfSeats;
		int rowsOfSeat = totalSeats / columnsOfSeats + residueSeatRow; // row number

		int startLine = 30;
		int seatWidth = 80;
		int seatHeight = 80;
		int rowGap = 83;
		int colGap = 83;

		seatArray = new JButton[rowsOfSeat][columnsOfSeats]; //
		seatStatus = new boolean[rowsOfSeat][columnsOfSeats];

		// 좌석 버튼생성
		for (int rowSeat = 0; rowSeat < rowsOfSeat; rowSeat++) {
			for (int colSeat = 0; (colSeat < columnsOfSeats)
					&& (rowSeat * columnsOfSeats + colSeat < totalSeats); colSeat++) { // front seat colum is three

				seatArray[rowSeat][colSeat] = new JButton();
				seatArray[rowSeat][colSeat].addActionListener(new SeatButtonListener(rowSeat, colSeat));

//               loadSeat(rowSeat, colSeat, rowsOfSeat, totalSeats);

				if (seatCode.charAt(rowSeat * columnsOfSeats + colSeat) == '0') {
					seatArray[rowSeat][colSeat].setIcon(new ImageIcon(
							Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/NotSelectedSeat.png")));

				} else {
					seatArray[rowSeat][colSeat].setIcon(new ImageIcon(Page09_SelectSeat_ver2.class
							.getResource("/com/javaproject/image/alreadySelectedSeat70by70.png")));
					seatArray[rowSeat][colSeat].setEnabled(false);
				}

				seatArray[rowSeat][colSeat].setBounds(startLine + colSeat * colGap, 250 + rowSeat * rowGap, seatWidth,
						seatHeight);

				contentPanel.add(seatArray[rowSeat][colSeat]);

			}
		}
	}

	private void loadSeat() {
		int totalSeats = seatCode.length();
    	int residueSeatRow = totalSeats%columnsOfSeats;
    	int rowsOfSeat = totalSeats/columnsOfSeats + residueSeatRow; // row number
    	
		for(int rowSeat = 0 ; rowSeat < rowsOfSeat; rowSeat++) {
         	for (int colSeat = 0; (colSeat < columnsOfSeats) && (rowSeat*columnsOfSeats+colSeat < totalSeats); colSeat++) {
         		
         		if(seatCode.charAt(rowSeat*columnsOfSeats + colSeat) == '0') {
         			seatArray[rowSeat][colSeat].setIcon(new ImageIcon(
         					Page09_SelectSeat_ver2.class.getResource(
         							"/com/javaproject/image/NotSelectedSeat.png")));
         			seatArray[rowSeat][colSeat].setEnabled(true);
         			try {
         				if(selectSeatCode.charAt(rowSeat*columnsOfSeats + colSeat) == '1') {
         					seatArray[rowSeat][colSeat].setIcon(new ImageIcon(
         							Page09_SelectSeat_ver2.class.getResource(
         									"/com/javaproject/image/SelectedSeat.png")));
         					seatArray[rowSeat][colSeat].setEnabled(true);
         				}
         			}catch(Exception e) {
         				System.out.println("에러");
         			}
         		}
         			
         		else {
         			seatArray[rowSeat][colSeat].setIcon(new ImageIcon(
         					Page09_SelectSeat_ver2.class.getResource(
         							"/com/javaproject/image/alreadySelectedSeat70by70.png")));
         			seatArray[rowSeat][colSeat].setEnabled(false);
         		}
         	}
		
			}
		}

}// End