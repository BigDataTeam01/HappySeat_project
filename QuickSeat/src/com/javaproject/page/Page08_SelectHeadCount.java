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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import com.javaproject.page.Page05_MovieInformation.mybutton;
import javax.swing.JTextField;

public class Page08_SelectHeadCount extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 1. SelectHeadCount에서 이전화면 버튼을 터치했을시 SelectTime 화면으로 이동
	 * 				 2. SelectHeadCount에서 인원선택버튼에 -+를 터치했을시  숫자변동 
	 * 				 3. SelectHeadCount에서 인원확정을 터치했을시  SelectSeat화면으로 이동
	 * 				 4. SelectHeadCount에서 첫화면 버튼을 터치했을시  SelectMenu화면으로 이동
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환
	 * 
	 *  *  *  *  * Update 2024.01.8 by J.park:
	 * 			1. descripton 수정
	 * 			3. kiosk set bound sharevar 에서 가져와 지정
	 * 			4. diaog -> static 
	 * 			5. 배경 추가
	 * 			5. 첫화면,이전화면, 입력완료(임시) 추가
	 * 			6.버튼 UI변경
	 * 
	 *   *  *  *  * Update 2024.01.12 by J.park:
	 * 			1. +,-버튼 클리시, 텍스트 필드에 숫자 증,감구현(음수값 안되게 설정) 
	 * 			2. - 버튼 클릭시 텍스트 필드에 음수값 안되게 설정
	 * 			3. 인원확정 버튼 클릭시 sharevar.sumOfPersonNumbers에 선택한 총 인원 저장
	 * 			
	 *   *  *  *  * Update 2024.01.13 by J.park:
	 * 			1. 쉐어바에 선택한 사람분류 어레이로 들어가게 설정
	 * 
	 * 			2. share 바 변수 변경했으니 그거에 맞게 적용해서 입력하도록 변경
	 * 			
	 */

	/**
	 * Launch the application.
	 */

	private mybutton btnNewButton;
	private JTextField tfPersonCategory1;
	private JTextField tfPersonCategory2;
	private JTextField tfPersonCategory3;
	private JTextField tfPersonCategory4;
	private JTextField tfPersonCategory5;
	//인원선택 어레이에 저장
	private JTextField[] tfPersonNumArray = new JTextField[5];
	private ArrayList<Integer> personNums = new ArrayList<>(); // 어레이리스트 추가

	

	public static void main(String[] args) {
		try {
			Page08_SelectHeadCount dialog = new Page08_SelectHeadCount();
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
	public Page08_SelectHeadCount() {
		contentPanel.add(getBtnNewButton());
		// 타이틀 설정
		setTitle("인원 선택");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		{

			// 페이지 타이틀
			JLabel lbl_pageTitle = new JLabel("인원 선택");
			lbl_pageTitle.setBounds(295, 10, 250, 100);
			lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

			//인원확정 버튼 나타내기
			contentPanel.add(lbl_pageTitle);
			
			
			//사람분류 라벨(총 5개)
			JLabel lblPersonClassification1 = new JLabel("일 반");
			lblPersonClassification1.setFont(new Font("BM Dohyeon", Font.PLAIN, 25));
			lblPersonClassification1.setBounds(47, 195, 80, 50);
			contentPanel.add(lblPersonClassification1);
			
			JLabel lblPersonClassification2 = new JLabel("청소년");
			lblPersonClassification2.setFont(new Font("BM Dohyeon", Font.PLAIN, 25));
			lblPersonClassification2.setBounds(436, 195, 80, 50);
			contentPanel.add(lblPersonClassification2);
			
			JLabel lblPersonClassification3 = new JLabel("경 로");
			lblPersonClassification3.setFont(new Font("BM Dohyeon", Font.PLAIN, 25));
			lblPersonClassification3.setBounds(47, 285, 80, 50);
			contentPanel.add(lblPersonClassification3);
			
			JLabel lblPersonClassification4 = new JLabel("유공자");
			lblPersonClassification4.setFont(new Font("BM Dohyeon", Font.PLAIN, 25));
			lblPersonClassification4.setBounds(436, 285, 80, 50);
			contentPanel.add(lblPersonClassification4);
			
			JLabel lblPersonClassification5 = new JLabel("장애인");
			lblPersonClassification5.setFont(new Font("BM Dohyeon", Font.PLAIN, 25));
			lblPersonClassification5.setBounds(47, 376, 80, 50);
			contentPanel.add(lblPersonClassification5);
			
			//마이너스 라벨(총 5개)
			JLabel lblPersonMinus1 = new JLabel("-");
			lblPersonMinus1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int currentValue = Integer.parseInt(tfPersonCategory1.getText());
					if(currentValue>0) {
						currentValue--;
						tfPersonCategory1.setText(String.valueOf(currentValue));
					}
				}
			});
			lblPersonMinus1.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			lblPersonMinus1.setBounds(185, 210, 20, 20);
			contentPanel.add(lblPersonMinus1);

			JLabel lblPersonMinus2 = new JLabel("-");
			lblPersonMinus2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int currentValue = Integer.parseInt(tfPersonCategory2.getText());
					if (currentValue > 0) {
						currentValue--;
						tfPersonCategory2.setText(String.valueOf(currentValue));
					}
				}
			});
			lblPersonMinus2.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			lblPersonMinus2.setBounds(574, 210, 20, 20);
			contentPanel.add(lblPersonMinus2);

			JLabel lblPersonMinus3 = new JLabel("-");
			lblPersonMinus3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int currentValue = Integer.parseInt(tfPersonCategory3.getText());
					if (currentValue > 0) {
						currentValue--;
						tfPersonCategory3.setText(String.valueOf(currentValue));
					}
				}
			});
			lblPersonMinus3.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			lblPersonMinus3.setBounds(185, 300, 20, 20);
			contentPanel.add(lblPersonMinus3);

			JLabel lblPersonMinus4 = new JLabel("-");
			lblPersonMinus4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int currentValue = Integer.parseInt(tfPersonCategory4.getText());
					if (currentValue > 0) {
						currentValue--;
						tfPersonCategory4.setText(String.valueOf(currentValue));
					}
				}
			});
			lblPersonMinus4.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			lblPersonMinus4.setBounds(574, 300, 20, 20);
			contentPanel.add(lblPersonMinus4);

			JLabel lblPersonMinus5 = new JLabel("-");
			lblPersonMinus5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int currentValue = Integer.parseInt(tfPersonCategory5.getText());
					if (currentValue > 0) {
						currentValue--;
						tfPersonCategory5.setText(String.valueOf(currentValue));
					}
				}
			});
			lblPersonMinus5.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			lblPersonMinus5.setBounds(185, 400, 20, 20);
			contentPanel.add(lblPersonMinus5);

			// 플러스 라벨(총5개)
			JLabel lblPersonPlus1 = new JLabel("+");
			lblPersonPlus1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int currentValue = Integer.parseInt(tfPersonCategory1.getText());

					currentValue++;

					tfPersonCategory1.setText(String.valueOf(currentValue));
				}
			});
			lblPersonPlus1.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			lblPersonPlus1.setBounds(305, 210, 20, 20);
			contentPanel.add(lblPersonPlus1);
			
			JLabel lblPersonPlus2 = new JLabel("+");
			lblPersonPlus2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int currentValue = Integer.parseInt(tfPersonCategory2.getText());

					currentValue++;

					tfPersonCategory2.setText(String.valueOf(currentValue));
				}
			});
			lblPersonPlus2.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			lblPersonPlus2.setBounds(694, 210, 20, 20);
			contentPanel.add(lblPersonPlus2);
			
			JLabel lblPersonPlus3 = new JLabel("+");
			lblPersonPlus3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int currentValue = Integer.parseInt(tfPersonCategory3.getText());

					currentValue++;

					tfPersonCategory3.setText(String.valueOf(currentValue));
				}
			});
			lblPersonPlus3.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			lblPersonPlus3.setBounds(305, 300, 20, 20);
			contentPanel.add(lblPersonPlus3);
			
			JLabel lblPersonPlus4 = new JLabel("+");
			lblPersonPlus4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int currentValue = Integer.parseInt(tfPersonCategory4.getText());

					currentValue++;

					tfPersonCategory4.setText(String.valueOf(currentValue));
				}
			});
			lblPersonPlus4.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			lblPersonPlus4.setBounds(694, 300, 20, 20);
			contentPanel.add(lblPersonPlus4);
			
			JLabel lblPersonPlus5 = new JLabel("+");
			lblPersonPlus5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int currentValue = Integer.parseInt(tfPersonCategory5.getText());

					currentValue++;

					tfPersonCategory5.setText(String.valueOf(currentValue));
				}
			});
			lblPersonPlus5.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			lblPersonPlus5.setBounds(305, 400, 20, 20);
			contentPanel.add(lblPersonPlus5);
			
			//인원수 텍스트필드
			tfPersonCategory1 = new JTextField();
			tfPersonCategory1.setHorizontalAlignment(SwingConstants.CENTER);
			tfPersonCategory1.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			tfPersonCategory1.setBounds(225, 200, 60, 40);
			contentPanel.add(tfPersonCategory1);
			tfPersonCategory1.setColumns(10);
			tfPersonCategory1.setText("0");
			
			tfPersonCategory2 = new JTextField();
			tfPersonCategory2.setHorizontalAlignment(SwingConstants.CENTER);
			tfPersonCategory2.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			tfPersonCategory2.setColumns(10);
			tfPersonCategory2.setBounds(614, 200, 60, 40);
			contentPanel.add(tfPersonCategory2);
			tfPersonCategory2.setText("0");
			
			tfPersonCategory3 = new JTextField();
			tfPersonCategory3.setHorizontalAlignment(SwingConstants.CENTER);
			tfPersonCategory3.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			tfPersonCategory3.setColumns(10);
			tfPersonCategory3.setBounds(225, 290, 60, 40);
			contentPanel.add(tfPersonCategory3);
			tfPersonCategory3.setText("0");

			tfPersonCategory4 = new JTextField();
			tfPersonCategory4.setHorizontalAlignment(SwingConstants.CENTER);
			tfPersonCategory4.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			tfPersonCategory4.setColumns(10);
			tfPersonCategory4.setBounds(614, 290, 60, 40);
			contentPanel.add(tfPersonCategory4);
			tfPersonCategory4.setText("0");
			
			tfPersonCategory5 = new JTextField();
			tfPersonCategory5.setHorizontalAlignment(SwingConstants.CENTER);
			tfPersonCategory5.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, 25));
			tfPersonCategory5.setColumns(10);
			tfPersonCategory5.setBounds(225, 390, 60, 40);
			contentPanel.add(tfPersonCategory5);
			tfPersonCategory5.setText("0");
			
			//백그라운드 (총 5개)
			JLabel PersonNumBackground1 = new JLabel("   일반");
			PersonNumBackground1.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/인원선택박스.png")));
			PersonNumBackground1.setBounds(21, 181, 360, 80);
			contentPanel.add(PersonNumBackground1);
			
			JLabel PersonNumBackground2 = new JLabel("   경로");
			PersonNumBackground2.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/인원선택박스.png")));
			PersonNumBackground2.setBounds(416, 181, 360, 80);
			contentPanel.add(PersonNumBackground2);
			
			JLabel PersonNumBackground3 = new JLabel("   우대");
			PersonNumBackground3.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/인원선택박스.png")));
			PersonNumBackground3.setBounds(21, 272, 360, 80);
			contentPanel.add(PersonNumBackground3);
			
			JLabel PersonNumBackground4 = new JLabel("   청소년");
			PersonNumBackground4.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/인원선택박스.png")));
			PersonNumBackground4.setBounds(416, 272, 360, 80);
			contentPanel.add(PersonNumBackground4);
			
			JLabel PersonNumBackground5 = new JLabel("");
			PersonNumBackground5.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/인원선택박스.png")));
			PersonNumBackground5.setBounds(21, 362, 360, 80);
			contentPanel.add(PersonNumBackground5);

			// 첫화면 아이콘
			JLabel lbl_pageTitle_1 = new JLabel("첫화면");
			lbl_pageTitle_1.setBounds(623, 20, 170, 130);
			lbl_pageTitle_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectMenu();
				}
			});
			
			
			
			
			
			lbl_pageTitle_1
					.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));

			lbl_pageTitle_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
			contentPanel.add(lbl_pageTitle_1);
			// 이전화면으로 가기
			JLabel BtnBackToPrevious = new JLabel("");
			BtnBackToPrevious.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectTime();
				}
			});

			BtnBackToPrevious
					.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
			BtnBackToPrevious.setBounds(6, 21, 170, 130);
			contentPanel.add(BtnBackToPrevious);

			// 배경화면
			JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
			lbl_background.setIcon(new ImageIcon(
					Page05_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
			lbl_background.setBounds(-16, 0, 800, 600);
			contentPanel.add(lbl_background);
			

		}
	}

//--------------------Function----------------------------
	// 다음화면(영화좌석선택)로 가기
	private void goToSelectSeat() {
		Page08_SelectHeadCount SelectHeadCountdialog = new Page08_SelectHeadCount();
		Page09_SelectSeat_ver2 SelectSeatdialog = new Page09_SelectSeat_ver2();

		dispose();
		SelectHeadCountdialog.setVisible(false);
		SelectHeadCountdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectSeatdialog.setVisible(true);
	}

	// 이전화면(영화시간선택)으로 가기
	private void goToSelectTime() {
		Page08_SelectHeadCount SelectHeadCountdialog = new Page08_SelectHeadCount();
		Page07_SelectTime SelectTimedialog = new Page07_SelectTime();

		dispose();
		SelectHeadCountdialog.setVisible(false);
		SelectHeadCountdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectTimedialog.setVisible(true);
	}

	// 첫화면으로 가기
	private void goToSelectMenu() {
		Page08_SelectHeadCount SelectHeadCountdialog = new Page08_SelectHeadCount();
		Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
		dispose();
		SelectHeadCountdialog.setVisible(false);
		SelectHeadCountdialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}
	
	//인원확정 버튼
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {

			btnNewButton =new mybutton("인원확정",new Color(183,216,107) );  
			btnNewButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 68));
			btnNewButton.setBounds(150	, 455, 500, 90);
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//인원선택 합 구하기 
					calculateAndStoreSum();
					//인원선택 어레이로 쉐어바에 저장하기
					storeValuesInShareVar();
					//좌석선택으로 가기
					goToSelectSeat();
					//쉐어바에 들어갔는지 확인
					 System.out.println(ShareVar.sumOfPersonNumbers);
					 System.out.println("Stored values in ShareVar: " +
		                        ShareVar.personCategory[0] + ", " +
		                        ShareVar.personCategory[1] + ", " +
		                        ShareVar.personCategory[2] + ", " +
		                        ShareVar.personCategory[3] + ", " +
		                        ShareVar.personCategory[4]);
				}
			});
//            System.out.println(ShareVar.sumOfPersonNumbers);
	
		}
		return btnNewButton;
		
	}
	
	//선택한 숫자 더하기
	 private void calculateAndStoreSum() {
	            int sum = Integer.parseInt(tfPersonCategory1.getText()) +
	                      Integer.parseInt(tfPersonCategory2.getText()) +
	                      Integer.parseInt(tfPersonCategory3.getText()) +
	                      Integer.parseInt(tfPersonCategory4.getText()) +
	                      Integer.parseInt(tfPersonCategory5.getText());

	            // 텍스트필드에 들어간 인원수 합을 ShareVar에 저장
	            ShareVar.sumOfPersonNumbers = sum;
//	            System.out.println("---------------");
//	            System.out.println(ShareVar.sumOfPersonNumbers);
	    }
	// +버튼 눌렀을때 텍스트필드에 1더하는 액션
	 private void addAction() {
		 int currentValue = Integer.parseInt(tfPersonCategory5.getText());

			currentValue++;

			tfPersonCategory5.setText(String.valueOf(currentValue));
		 
	 }
	// 각 값들을 ShareVar에 저장
	 private void storeValuesInShareVar() {
	     ShareVar.personCategory[0] = Integer.parseInt(tfPersonCategory1.getText());
	     ShareVar.personCategory[1] = Integer.parseInt(tfPersonCategory2.getText());
	     ShareVar.personCategory[2] = Integer.parseInt(tfPersonCategory3.getText());
	     ShareVar.personCategory[3] = Integer.parseInt(tfPersonCategory4.getText());
	     ShareVar.personCategory[4] = Integer.parseInt(tfPersonCategory5.getText());
	 }
	 
}// End
