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
	 * Description: 좌석 선택 페이지.
	 * 				for문을 통해 좌석 버튼을 만들고, 버튼을 만들면서 그 버튼을 눌렀을때의 기능을 추가. 
	 * 
	 * Author : 이천영 박동근
	 * 
	 * Date : 2024.01.10
	 * 
	 * Update 2024.01.15 16:36	 * 
	 * 
	 */
	
	// Field
	private Timer timer; // 좌석코드를 불러오는 주기.
	private static final long serialVersionUID = 1L;
	private JButton[][] seatArray; // 생성되는 좌석들의 배열 
	private static boolean[][] seatStatus; // 생성되는 좌석들의 배열 선택현황, 참 = '1' -> 선택됨

	private JPanel contentPanel = new JPanel();
	private JLabel lbl_background;
	private JLabel lbl_previousPage;
	private JLabel lbl_previousPage_1;
	private JLabel lbl_screen;
	private JButton btnSeatConfirm;
	// seatCode -> DB에 저장되어있는 좌석 현황 
	private static StringBuilder seatCode = new StringBuilder("");
	// selectSeatCode -> 사용자가 선택한 좌석 현황 
	private static StringBuilder selectSeatCode = new StringBuilder("");
	// XORSeatCode -> seatCode ^ selectSeatCode (익스클루시브오어)
	private static int xorSeatCode = 0;

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
//			System.out.println("새로고침");
//			System.out.println("selectSeatCode : " + selectSeatCode);
//			System.out.println("seatCode : " + seatCode);
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
		// 좌석 선택할때의 기능
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
				// 좌석 이미지를 변경 
				seatArray[row][col].setIcon(new ImageIcon(
						Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/SelectedSeat.png")));
				
				// 해당하는 좌석의 코드값을 '1'로 변경
				selectSeatCode.setCharAt(row * columnsOfSeats + col, '1');
				
				// DB에서 불러온 코드와 사용자가 선택한 코드를 XOR, 변화 된 좌석은 1, 변화하지 않으면 0 
				xorSeatCode = Integer.parseInt(seatCode.toString(), 2) ^ Integer.parseInt(selectSeatCode.toString(), 2);
				// 좌석을 누르게 되면 ClickCount++
				ShareVar.clickCount++;
				// 좌석이 선택되었다면 seatStatus = true
				seatStatus[row][col] = true;
				
				// 사용자의 인원 수 보다 더 많은 좌석을 선택했을때,
				if(ShareVar.sumOfPersonNumbers < ShareVar.clickCount) {
					JOptionPane.showMessageDialog(null, ShareVar.sumOfPersonNumbers + "명을 초과할 수 없습니다.");
					
					seatArray[row][col].setIcon(new ImageIcon(
							Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/NotselectedSeat.png")));
					
					// if절 위에서 selectCode를 '1'로 변경해주었으니, 다시 '0'으로 변경 
					selectSeatCode.setCharAt(row * columnsOfSeats + col, '0');
					xorSeatCode = Integer.parseInt(seatCode.toString(), 2) ^ Integer.parseInt(selectSeatCode.toString(), 2);
					
					// ClickCount가 곧 좌석을 선택한 수이기에 이것 또한 if절 위에서 더해주었으니 -- 해주어야 함.
					ShareVar.clickCount--;
					// 이것 또한 if절 위에서 true 값으로 변경되었으니 false로 다시 변경 
					seatStatus[row][col] = false;
				}
			}
			
			// 1 -> 0, 내가 선택 한 좌석을 선택취소 하였을때 
			else {
				// selectSeatCode를 '0' 으로 변경
				selectSeatCode.setCharAt(row * columnsOfSeats + col, '0');
				seatArray[row][col].setIcon(new ImageIcon(
						Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/NotselectedSeat.png")));
				
				// clickCount는 좌석을 선택한 갯수 
				ShareVar.clickCount--;
				// 선택취소 시 seatStatus의 값을 false 
				seatStatus[row][col] = false;
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
					ShareVar.clickCount = 0;
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
						updateSeatCodeAction();
						goConfirmSeat();
						ShareVar.selectedSeatSeq = changedSeatIndices(xorSeatCode);
					}}});
		}
		return btnSeatConfirm;
	}
	
	// ================= Functions ===================
	
	private void getCurrentSeatCode() { // DB에 저장되어 있는 seatCode 불러오는 Method. 
		ShareVar.dbSeatCode = seatCode;
		// ShareVar.scr_code에 따른 seatCode를 Dao를 통해 불러옴. 
		Dao_pdg currentSeatCode = new Dao_pdg(ShareVar.scr_code);
		StringBuilder fetchedSeatCode = new StringBuilder();
		// StringBulider로 변환
		seatCode = fetchedSeatCode.append(currentSeatCode.currentSeatCode());
	}

	private void updateSeatCodeAction() { // 선택확정 버튼을 눌렀을 때, 누른 코드(selecteSeatCode)에 따라 DB에 Update. 
		Dao_pdg updateSeatCode = new Dao_pdg(selectSeatCode.toString());
		// Update Query
		updateSeatCode.updateSeatCode();
	}

	private void goConfirmSeat() { // 선택확정 버튼을 눌렀을 때 다음 페이지(Page10)으로 이동.  
		Page10_ConfirmSeat confirmSeat = new Page10_ConfirmSeat();
		this.setVisible(false);
		confirmSeat.setVisible(true);
		this.dispose();
	}

	private void goPreviousPage() { // 이전 버튼을 눌렀을 때 이전 페이지(Page08)로 이동.  
		Page08_SelectHeadCount prev = new Page08_SelectHeadCount();
		this.setVisible(false);
		prev.setVisible(true);
		this.dispose();
	}

	private void gohomeAction() { // 홈화면 버튼을 눌렀을 때 첫 화면(Page02)로 이동. 
		Page02_SelectMenu prev = new Page02_SelectMenu();
		this.setVisible(false);
		prev.setVisible(true);
		this.dispose();
	}

	private void createSeat() { // 좌석 버튼을 만드는 Method. 
		// seatArray 초기화.
		if (seatArray != null) {
			for (int i = 0; i < seatArray.length; i++) {
				for (int j = 0; j < seatArray[i].length; j++) {
					contentPanel.remove(seatArray[i][j]);
				}
			}
		}
		// DB에서 현재상태의 seatCode를 불러옴. 
		getCurrentSeatCode();
		// 맨 처음에는 아무 좌석도 선택하지 않았으니, 사용자가 선택한 좌석 = DB에 있는 좌석현황. 
		selectSeatCode = seatCode;
		// 전체 좌석 수, 좌석코드(seatCode의 총 길이).
		int totalSeats = seatCode.length();
		// 좌석의 나머지 값, 전체좌석을 열로 나눈 나머지값. 
		// 만약, 전체 좌석 수 12, 열 좌석 수 4 이면, 나머지는 없음.
		// 하지만 전체 좌석 수 13, 열 좌석 수 4 이면, 나머지는 1이 됨.
		// 14, 열좌석수 4이면, 나머지 2. 
		int residueSeatRow = totalSeats % columnsOfSeats;
		// 행, 전체 좌석수를 열로 나눈 후 나머지가 있다면 추가.
		// 위의 예시로 한다면, 나머지가 0일때는 행을 3행으로 끝남. 따라서 4열 * 3행 = 총 12 좌석 수.
		// 만약 나머지가 1이라면, 4열 * 3행 + 나머지 좌석수 = 총 13 좌석 수.
		int rowsOfSeat = totalSeats / columnsOfSeats + residueSeatRow; // row number
		
		// 좌석 버튼에 대한 시작 location x 위치. 
		int startLine = 30;
		// 좌석 버튼 크기 조절.
		int seatWidth = 80;
		int seatHeight = 80;
		// 행과 열 사이의 간격. 
		int rowGap = 83;
		int colGap = 83;

		seatArray = new JButton[rowsOfSeat][columnsOfSeats]; //
		seatStatus = new boolean[rowsOfSeat][columnsOfSeats];

		// 좌석 버튼생성, 2차원 배열이기에 이중 for문. 
		// 외부 for문은 행을 변경.   
		for (int rowSeat = 0; rowSeat < rowsOfSeat; rowSeat++) {
			// 내부 for문 열을 변경.
			// 조건 : (생성되는 열 번호 < 전체 열) and (생성되는 행 번호 * 전체 열 + 생성되는 열 번호 < 전체 좌석 수)
			// and 뒤에 있는 조건에 대한 설명 : 전체 열을 4로 했고, 전체 좌석 수를 13으로 했다면, 만들어지는 좌석이 13좌석 이하여야 한다는 뜻. 
			for (int colSeat = 0; (colSeat < columnsOfSeats)
					&& (rowSeat * columnsOfSeats + colSeat < totalSeats); colSeat++) { // front seat colum is three
			
				seatArray[rowSeat][colSeat] = new JButton();
				seatArray[rowSeat][colSeat].addActionListener(new SeatButtonListener(rowSeat, colSeat));
				
				// 해당 좌석에 해당하는 코드의 값이 '0', 즉 선택이 안되어있는 상황. 
				if (seatCode.charAt(rowSeat * columnsOfSeats + colSeat) == '0') {
					seatArray[rowSeat][colSeat].setIcon(new ImageIcon(
							Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/NotSelectedSeat.png")));
				}
				// 해당 좌석에 해당하는 코드의 값이 '1', 선택되어 있는 상황.
				else {
					seatArray[rowSeat][colSeat].setIcon(new ImageIcon(Page09_SelectSeat_ver2.class
							.getResource("/com/javaproject/image/alreadySelectedSeat70by70.png")));
					// 이미 선택되어있는 좌석이므로 Enabled(false).
					seatArray[rowSeat][colSeat].setEnabled(false);
				}
				// 좌석위치 설정. 
				seatArray[rowSeat][colSeat].setBounds(startLine + colSeat * colGap, 250 + rowSeat * rowGap, seatWidth,
						seatHeight);
				
				contentPanel.add(seatArray[rowSeat][colSeat]);
			}
		}
	}

	private void loadSeat() { // DB에서 특정 상영관에 대한 좌석 현황(seatCode)을 불러와서 그에 맞는 Image 보여주기
		int totalSeats = seatCode.length();
		int residueSeatRow = totalSeats % columnsOfSeats;
		int rowsOfSeat = totalSeats / columnsOfSeats + residueSeatRow; // row number

		for (int rowSeat = 0; rowSeat < rowsOfSeat; rowSeat++) {
			for (int colSeat = 0; (colSeat < columnsOfSeats)
					&& (rowSeat * columnsOfSeats + colSeat < totalSeats); colSeat++) {
				// DB에서 불러올 때, 그 좌석에 해당하는 코드가 '0'일때 처리. 
				if (seatCode.charAt(rowSeat * columnsOfSeats + colSeat) == '0') {
					seatArray[rowSeat][colSeat].setIcon(new ImageIcon(
							Page09_SelectSeat_ver2.class.getResource("/com/javaproject/image/NotSelectedSeat.png")));
					seatArray[rowSeat][colSeat].setEnabled(true);
					// 그 좌석에 해당하는 코드가 '0'이라면, 선택되지 않았으므로 seatStatus = false. 
					seatStatus[rowSeat][colSeat] = false;
					try {
						// 사용자가 해당되는 좌석을 선택했을 때는 그 좌석은 DB에서 불러오는 seatCode에 따라 변경하면 안됨.  
						if (selectSeatCode.charAt(rowSeat * columnsOfSeats + colSeat) == '1') {
							seatArray[rowSeat][colSeat].setIcon(new ImageIcon(Page09_SelectSeat_ver2.class
									.getResource("/com/javaproject/image/SelectedSeat.png")));
							seatArray[rowSeat][colSeat].setEnabled(true);
							// 그 좌석에 해당하는 코드가 '1'이라면, 선택되었으므로 seatStatus = true. 
							seatStatus[rowSeat][colSeat] = true;
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "다시 시도해주세요. error : loadSeat");
					}
				}

				else {
					// DB에서 불러올 때, 그 좌석에 해당하는 코드가 '1'일때 처리. 
					seatArray[rowSeat][colSeat].setIcon(new ImageIcon(Page09_SelectSeat_ver2.class
							.getResource("/com/javaproject/image/alreadySelectedSeat70by70.png")));
					seatArray[rowSeat][colSeat].setEnabled(false);
					// 그 좌석에 해당하는 코드가 '1'이라면, 선택되었으므로 seatStatus = true.  
					seatStatus[rowSeat][colSeat] = true;
				}
			}
		}
	}
	
	private int countSelecteSeat(int XORseat) { // 좌석상태가 몇 개 변하였는지 세는 Method  
		int count = 0;
		while (XORseat > 0) {
			count += (XORseat & 1);
			XORseat = XORseat >> 1;
		}
		return count;
	}
	
	private boolean checkSelecte() { // 좌석을 인원 수대로 선택했는지 확인하는 Method.
		int count = countSelecteSeat(xorSeatCode);
		boolean result = false;
		// 선택한 좌석이 전체 인원보다 적을때. 
		if(count < ShareVar.sumOfPersonNumbers) {
			JOptionPane.showMessageDialog(null, "좌석을 선택해주세요.");
			result = false;
		}
		else {
			result = true;
		}
		return result;
		
	}
	
	private void backSplashTimeEnd() { // BackSplashTimer Class를 사용. 
		BackSplashTimer backSplashTimer = new BackSplashTimer(300, this);
	}

	private ArrayList<Integer> changedSeatIndices(int XORCode) { // XORCode를 통해 어떤 좌석을 선택했는지를 ArrayList로 저장. 
	    ArrayList<Integer> changedIndices = new ArrayList<>();

	    int index = 0;
	    while (XORCode > 0) {
	        if ((XORCode & 1) == 1) {
	            changedIndices.add(seatCode.length()-index);
	        }

	        XORCode = XORCode >> 1;
	        index++;
	    }

	    return changedIndices;
	}
	
}// End
