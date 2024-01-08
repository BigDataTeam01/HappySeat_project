package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font; // FONT library
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;


import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	


// 그냥 스윙에 있는거 다쓰자. 

import java.awt.*;

//swing 에 있는거 다쓴다 
import javax.swing.*;




public class MovieInformation extends JDialog{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static final String VIDEO_URL = "https://youtu.be/bLvqoHBptjg?si=nwLN3uBeu65fFt-q"; // 동영상 URL
	
	/*
	 * Description : 현재 상영중인 영화 목록을 보여주고 고객이 영화를 선택할수 있도록 하는 페이지
	 * 
	 * 				 0.이 페이지는 SelectCinema 으로 부터 이동됨.
	 * 				 1.MovieInformation에서 영화선택 btn -> SelectCinema 화면
	 * 
	 * 				 2.SelectInformation에서 이전화면 버튼을 터치했을시  SelectMovie 화면으로 이동?
	 * 				 3.SelectInformation에서 첫화면 버튼을 터치했을시  SelectMenu 화면으로 이동?
	 * 
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환, 박동근
	 * 
	 * Update 2024.01.06 by PDG:
	 * 			1. descripton 수정
	 * 			2. Test code 작성
	 * 			3. kiosk set bound sharevar 에서 가져와 지정
	 * 			4. diaog -> static 
	 * 			5. 배경 만듬
	 * 			6. 배민 도현 추가하여 페이지 타이틀 생성
	 * 			7.이전화면 영화선택 버튼 추가(임시)
	 */
	
	/**
	 * Launch the application.
	 */
	private static MovieInformation dialog = new MovieInformation();
	private static SelectCinema SelectCinemadialog = new SelectCinema();
	private static SelectMovie SelectMoviedialog = new SelectMovie();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblGoHome;
	

	
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
	
	
	public static void main(String[] args) {
		
		
		
		
		try {
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	
	public MovieInformation() {
		setTitle("영화정보");
		setBounds(ShareVar.kiosk_loc_x, 
				  ShareVar.kiosk_loc_y, 
				  ShareVar.kiosk_width, 
				  ShareVar.kiosk_hight);
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//이전화면 버튼
		JLabel lblPageTitle_1 = new JLabel("");
		lblPageTitle_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			goToSelectMovie();
			}
		});
		contentPanel.add(getBtnNewButton());
		lblPageTitle_1.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
		lblPageTitle_1.setBounds(6, 21, 171, 133);
		contentPanel.add(lblPageTitle_1);
		contentPanel.add(getLblGoHome());


		
		//	페이지 타이틀 예시 
		JLabel lblPageTitle = new JLabel("영화정보");
		lblPageTitle.setFont(new Font("BM Dohyeon", Font.PLAIN, 75));
		 								
		lblPageTitle.setBounds(275, 
								17, 
								331,
								100);
		
		contentPanel.add(lblPageTitle);
		
		JLabel lblPoster = new JLabel("");
		ImageIcon icon = new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]포스터_포레스트검프.png"));
		// img 에 이미지를 담는다. 
		Image img = icon.getImage();
		// 이미지 사이즈 조절
		Image changeImg = img.getScaledInstance(275, 355,  Image.SCALE_SMOOTH);
		// 변경된 이미지를 다시 icon 에 담는다. 
		ImageIcon changeIcon = new ImageIcon(changeImg);
		lblPoster = new JLabel(changeIcon);
		
		
		//lblPoster.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]포스터_포레스트검프.png")));
		
		lblPoster.setBounds(99, 151, 275, 355);
		contentPanel.add(lblPoster);
		
		
		
		
		
		JLabel lblPageBackground = new JLabel("",SwingConstants.CENTER);
		//lblNewLabel.
		//Font font = new ("도현체")
		lblPageBackground.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lblPageBackground.setBounds(0, 0, 800, 600);
		contentPanel.add(lblPageBackground);
	}
	
	// Tescode 
	

	

	
	/// Functions
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new mybutton("영화 선택",new Color(183, 216, 107));
			btnNewButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 68));
			btnNewButton.setBounds(436	, 458, 292, 110);
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goSelectCinema();
				}
			});
			
		}
		return btnNewButton;
	}
	// Go selectCinema
	public void goSelectCinema() {
		
		SelectCinema selectCinema = new SelectCinema();
		
		selectCinema.setVisible(true);
		
		this.dispose();
	}
	// Page back
	public void goToSelectMovie() {
		dialog.setVisible(false);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectMoviedialog.setVisible(true);
	}
	
	
	private JLabel getLblGoHome() {
		
			lblGoHome = new JLabel("");
			lblGoHome.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					goHomePage();
				
				}});
			lblGoHome.setIcon(new ImageIcon(MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));
			lblGoHome.setBounds(618, 6, 171, 133);
		
		return lblGoHome;
		
	}
		
	
	private void goHomePage() {
		SelectMenu selectMenu = new SelectMenu();
		
		
		selectMenu.setVisible(true);
		
		
		
		this.dispose();
	}
	
		
		
	
		
		
		
		
		
		
}// END
