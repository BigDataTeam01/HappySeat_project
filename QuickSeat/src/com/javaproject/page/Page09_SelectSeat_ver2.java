package com.javaproject.page;

import javax.swing.*;
import com.javaproject.base.ShareVar;
import com.javaproject.kioskFunction.BackSplashTimer;
import com.javaproject.kioskFunction.Dao_pdg;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Page09_SelectSeat_ver2 extends JDialog {

	/*
	 * Description: 좌석 선택 페이지 
	 * 
	 * Author : 이천영 박동근
	 * 
	 * Date : 2024.01.10
	 * 
	 * Update 2024.01.14	 * 
	 * 
	 */
	
	// Field
	private Timer timer; // 좌석코드를 불러오는 주기.
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
	private static int eorSeatCode = 0;

	int columnsOfSeats = 4; // column number
	
	public static void main(String[] args) {
		try {
			Page09_SelectSeat_ver2 dialog = new Page09_SelectSeat_ver2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Page09_SelectSeat_ver2() {
		createSeat();
		this.setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);
		this.setTitle("좌석선택");
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnSeatConfirm());
		contentPanel.add(getLbl_previousPage());
		contentPanel.add(getLbl_screen());
		contentPanel.add(getLbl_previousPage_1());
		contentPanel.add(getLbl_background());
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				timer = new Timer();
				timer.scheduleAtFixedRate(new RemindTask(), 0, 1000);
				backSplashTimeEnd();
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				timer.cancel();
			}
		});

	}
	
	// TimerTask를 쓰기 위한 class
	class RemindTask extends TimerTask {
		public void run() {
			getCurrentSeatCode();
			loadSeat();
			System.out.println("새로고침");
			System.out.println("selectSeatCode : " + selectSeatCode);
			System.out.println("seatCode : " + seatCode);
		}
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
	
	private class SeatButtonListener implements ActionListener {
		// Field
		int row;
		int col;

		public SeatButtonListener(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public void actionPerformed(ActionEvent e) { // 좌석을 눌렀을 때 그에 맞게 좌석 코드를 바꾸는 기능 
			// 좌석 상태 토글
			seatStatus[row][col] = !seatStatus[row][col];

			// 0 -> 1 , 즉 선택가능한 좌석을 선택을 하였을 때,
			if (seatStatus[row][col]) {
				seatArray[row][col].setIcon(new ImageIcon(
						Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/SelectedSeat.png")));

				selectSeatCode.setCharAt(row * columnsOfSeats + col, '1');
				
				// DB에서 불러온 코드와 사용자가 선택한 코드를 EOR, 변화 된 좌석은 1, 변화하지 않으면 0 
				eorSeatCode = Integer.parseInt(seatCode.toString(), 2) ^ Integer.parseInt(selectSeatCode.toString(), 2);
//				// changeCount : 사용자가 선택을 한 좌석 갯수 
//				int changeCount = countSelecteSeat(eorSeatCode);
//				
//				if (ShareVar.sumOfPersonNumbers > changeCount + 1 ) {
//					JOptionPane.showMessageDialog(null, ShareVar.sumOfPersonNumbers + "명을 초과할 수 없습니다.");
//				}
			}
			
			// 1 -> 0, 내가 선택 한 좌석을 선택취소 하였을때 
			else {
				selectSeatCode.setCharAt(row * columnsOfSeats + col, '0');
				seatArray[row][col].setIcon(new ImageIcon(
						Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/NotselectedSeat.png")));
			}
		}

	}

	
	
	// 페이지 구성요소
	private JLabel getLbl_background() {
		if (lbl_background == null) {
			lbl_background = new JLabel("");
			lbl_background.setIcon(new ImageIcon(Page09_SelectSeat_ver2.class
					.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
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
			lbl_previousPage.setIcon(
					new ImageIcon(Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/Btn이전으로.png")));
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
			lbl_previousPage_1.setIcon(
					new ImageIcon(Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/Btn처음으로.png")));
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
					if(checkSelecte() == true) {
						timer.cancel();
						ShareVar.selectedSeatSeq = changedSeatIndices(eorSeatCode);
						updateSeatCodeAction();
						goConfirmSeat();
						System.out.println("Db 업데이트 코드 : " + selectSeatCode);
						System.out.println("ShareVar 저장 : " + ShareVar.selectedSeatSeq);
						System.out.println("ShareVar dbSeatCode : " + ShareVar.dbSeatCode);
					}}});
		}
		return btnSeatConfirm;
	}
	
	// Functions
	private void getCurrentSeatCode() {
		ShareVar.dbSeatCode = seatCode;
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
		Page08_SelectHeadCount prev = new Page08_SelectHeadCount();
		this.setVisible(false);
		prev.setVisible(true);
		this.dispose();
	}

	private void gohomeAction() {
		Page02_SelectMenu prev = new Page02_SelectMenu();
		this.setVisible(false);
		prev.setVisible(true);
		this.dispose();
	}

	private void createSeat() { // 좌석 버튼 만드는 Method 
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

				if (seatCode.charAt(rowSeat * columnsOfSeats + colSeat) == '0') {
					seatArray[rowSeat][colSeat].setIcon(new ImageIcon(
							Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/NotSelectedSeat.png")));
				}
				else {
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

	private void loadSeat() { // DB에서 특정 상영관에 대한 좌석 현황을 불러와서 그에 맞는 Image 보여주기
		int totalSeats = seatCode.length();
		int residueSeatRow = totalSeats % columnsOfSeats;
		int rowsOfSeat = totalSeats / columnsOfSeats + residueSeatRow; // row number

		for (int rowSeat = 0; rowSeat < rowsOfSeat; rowSeat++) {
			for (int colSeat = 0; (colSeat < columnsOfSeats)
					&& (rowSeat * columnsOfSeats + colSeat < totalSeats); colSeat++) {

				if (seatCode.charAt(rowSeat * columnsOfSeats + colSeat) == '0') {
					seatArray[rowSeat][colSeat].setIcon(new ImageIcon(
							Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/NotSelectedSeat.png")));
					seatArray[rowSeat][colSeat].setEnabled(true);
					try {
						if (selectSeatCode.charAt(rowSeat * columnsOfSeats + colSeat) == '1') {
							seatArray[rowSeat][colSeat].setIcon(new ImageIcon(Page09_SelectSeat_ver2.class
									.getResource("/com/javaproject/image/SelectedSeat.png")));
							seatArray[rowSeat][colSeat].setEnabled(true);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "다시 시도해주세요. error : loadSeat");
					}
				}

				else {
					seatArray[rowSeat][colSeat].setIcon(new ImageIcon(Page09_SelectSeat_ver2.class
							.getResource("/com/javaproject/image/alreadySelectedSeat70by70.png")));
					seatArray[rowSeat][colSeat].setEnabled(false);
				}
			}
		}
	}
	
	private int countSelecteSeat(int EORseat) { // 좌석상태가 몇 개 변하였는지 세는 Method  
		int count = 0;
		while (EORseat > 0) {
			count += (EORseat & 1);
			EORseat = EORseat >> 1;
		}
		return count;
	}
	
	private boolean checkSelecte() {
		boolean result = false;
		if(seatCode.toString().equals(selectSeatCode.toString())) {
			JOptionPane.showMessageDialog(null, "좌석을 선택해주세요.");
			result = false;
		}
		else {
			result = true;
		}
		return result;
		
	}
	
	private void backSplashTimeEnd() {
		BackSplashTimer backSplashTimer = new BackSplashTimer(300, this);
	}

	private ArrayList<Integer> changedSeatIndices(int eorCode) {
		System.out.println(eorCode);
	    ArrayList<Integer> changedIndices = new ArrayList<>();

	    int index = 0;
	    while (eorCode > 0) {
	        if ((eorCode & 1) == 1) {
	            changedIndices.add(seatCode.length()-index);
	        }

	        eorCode = eorCode >> 1;
	        index++;
	    }

	    return changedIndices;
	}
	
}// End
