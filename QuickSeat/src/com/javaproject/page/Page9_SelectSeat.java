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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import com.javaproject.page.Page8_SelectHeadCount.mybutton;

public class Page9_SelectSeat extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 영화 좌석선택 화면 
	 * 				 1. SelecSeat에서 이전화면 버튼을 터치했을시 SelectHeadCount 화면으로 이동
	 * 				 2. SelecSeat에서 좌석확정 버튼을 터치했을시 예매된 좌석이면 "이미 예매된 좌석입니다." ShowMessageDialog 화면을 띄운다(추후의 변경예정)
	 * 				 3. SelecSeat에서 좌석확정 버튼을 터치했을시 예매가능한 좌석이면 ConfirmSeat화면으로 이동
	 * 				 4. SelecSeat에서 첫화면 버튼을 터치했을시  SelectMenu화면으로 이동
	 * 				 5. SelecSeat에서 선택 가능좌석 버튼 클릭시  버튼색이 바뀜 
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환
	 * 
	 * *   *  *  * Update 2024.01.07 by J.park:
	 * 			1. descripton 수정
	 * 			3. kiosk set bound sharevar 에서 가져와 지정
	 * 			4. diaog -> static 
	 * 			5. 배경 추가
	 * 			6. 첫화면, 이전화면, 극장선택버튼 추가
	 * 			7. 
	 */
	/**
	/**
	 * Launch the application.
	 */
	private static Page9_SelectSeat SelectSeatadialog = new Page9_SelectSeat();
	private static Page2_SelectMenu selectMenudialog = new Page2_SelectMenu();
	private static Page10_ConfirmSeat ConfirmSeatdialog = new Page10_ConfirmSeat();
	private static Page8_SelectHeadCount SelectHeadCountdialog = new Page8_SelectHeadCount();
	private mybutton btnNewButton;
	public static void main(String[] args) {
		try {
			Page9_SelectSeat dialog = new Page9_SelectSeat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//////////////라운드 버튼박스를 만들기 위한 paintComponent 설정

class mybutton extends JButton{
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
  graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
  						  RenderingHints.VALUE_ANTIALIAS_ON);
  if (getModel().isArmed()) {
      graphics.setColor(backgroundColor.darker());
  } 
  else if (getModel().isRollover()) {
      graphics.setColor(backgroundColor.brighter());
  } 
  else {
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
	public Page9_SelectSeat() {
		// 타이틀 설정
		setTitle("좌석 선택");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

//			페이지 타이틀 
			JLabel lbl_pageTitle = new JLabel("극장 선택");
			lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

			lbl_pageTitle.setBounds(295, 10, 250, 100);
			//인원확정 버튼 나타내기
			contentPanel.add(getBtnNewButton());

			
			
			// 첫화면 아이콘
			JLabel lbl_pageTitle_1 = new JLabel("첫화면");
			lbl_pageTitle_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectMenu();
				}
			});
			// 처음으로 버튼
			lbl_pageTitle_1
					.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));

			lbl_pageTitle_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			lbl_pageTitle_1.setBounds(623, 20, 170, 130);
			contentPanel.add(lbl_pageTitle_1);
			// 이전으로 버튼
			JLabel BtnBackToPrevious = new JLabel("");
			BtnBackToPrevious.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectHeadCount();
				}
			});
			BtnBackToPrevious
					.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
			BtnBackToPrevious.setBounds(6, 21, 170, 130);
			contentPanel.add(BtnBackToPrevious);

			// 배경화면
			JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
			lbl_background.setIcon(new ImageIcon(
					Page5_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
			lbl_background.setBounds(-16, 0, 800, 600);
			contentPanel.add(lbl_background);
		}
	}
//----------------------Function--------------------------

		//다음화면(좌석확정)로 가기
		private void goToConfirmSeat() {
			dispose();
			SelectSeatadialog.setVisible(false);
			SelectSeatadialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			ConfirmSeatdialog.setVisible(true);
		}

	// 이전화면(영화정보)으로 가기
	private void goToSelectHeadCount() {
		dispose();
		SelectSeatadialog.setVisible(false);
		SelectSeatadialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectHeadCountdialog.setVisible(true);
	}

	// 첫화면으로 가기
	private void goToSelectMenu() {
		dispose();
		SelectSeatadialog.setVisible(false);
		SelectSeatadialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}
	//인원확정 버튼
		private JButton getBtnNewButton() {
			if (btnNewButton == null) {
				btnNewButton =new mybutton("인원확정",new Color(183,216,107) );  
				btnNewButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 75));
				btnNewButton.setBounds(462, 334, 310, 150);
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						goToConfirmSeat();
					}
				});
				
			}
			return btnNewButton;
		}
}// End
