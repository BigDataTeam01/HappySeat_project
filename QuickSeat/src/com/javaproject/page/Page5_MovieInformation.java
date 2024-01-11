package com.javaproject.page;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import com.javaproject.kioskFunction.Dao_PJH;
import com.javaproject.kioskFunction.Dto_PJH;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.ArrayList;

import javax.swing.border.Border;
import javax.swing.*;

// FONT library
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	


// 그냥 스윙에 있는거 다쓰자. 

import java.awt.*;

//swing 에 있는거 다쓴다 
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class Page5_MovieInformation extends JDialog{

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
	 * Update 2024.01.06 by PJH , PJM:
	 * 			1. shareVar 에서 가져온 영화제목 으로 영화정보창에 보여주기(영화제목 , 개봉일 , 영화등급 , 상영시간 , 국가 , 줄거)
	 * 			
	 * 
	 */
	
	/**
	 * Launch the application.
	 */
	private static Page5_MovieInformation dialog = new Page5_MovieInformation();
	private static Page6_SelectCinema SelectCinemadialog = new Page6_SelectCinema();
	private static Page4_SelectMovie SelectMoviedialog = new Page4_SelectMovie();
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblGoHome;
	private JLabel lblMovieTitle;
	private JLabel lblPoster;
	private JLabel lblMovieTitle_data;
	private JLabel lblMovieRelTime_data;
	private JLabel lblMovieMade_in_data;
	private JLabel lblMovieRating_data;
	private JLabel lblMovieRunTimedata;
	private JLabel lblMovieDesc_data;
	

	
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
	
	
	
	public Page5_MovieInformation() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				showtest();
			}
		});
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

		lblMovieTitle = new JLabel("영화 :");
		lblMovieTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieTitle.setBounds(403, 165, 50, 20);
		contentPanel.add(lblMovieTitle);
		
		JLabel lblMovieRelTime = new JLabel("개봉일 :");
		lblMovieRelTime.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieRelTime.setBounds(403, 198, 60, 20);
		contentPanel.add(lblMovieRelTime);
		
		JLabel lblMovieRating = new JLabel("등급 :");
		lblMovieRating.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieRating.setBounds(403, 232, 50, 20);
		contentPanel.add(lblMovieRating);
		
		JLabel lblMovieRunTime = new JLabel("상영시간 :");
		lblMovieRunTime.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieRunTime.setBounds(403, 266, 80, 20);
		contentPanel.add(lblMovieRunTime);
		
		JLabel lblMovieMade_In = new JLabel("국가 :");
		lblMovieMade_In.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieMade_In.setBounds(403, 291, 50, 20);
		contentPanel.add(lblMovieMade_In);
		
		JLabel lblMovieDesc = new JLabel("줄거리 :");
		lblMovieDesc.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieDesc.setBounds(403, 324, 60, 20);
		contentPanel.add(lblMovieDesc);
		lblPageTitle_1.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
		lblPageTitle_1.setBounds(6, 21, 171, 133);
		contentPanel.add(lblPageTitle_1);
		contentPanel.add(getLblGoHome());


		
		//	페이지 타이틀 예시 
		JLabel lblPageTitle = new JLabel("영화정보");
		lblPageTitle.setFont(new Font("BM Dohyeon", Font.PLAIN, 75));
		 								
		lblPageTitle.setBounds(266, 
								32, 
								331,
								100);
		
		contentPanel.add(lblPageTitle);
		
		lblPoster = new JLabel("");
//		ImageIcon icon = new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]포스터_포레스트검프.png"));
//		// img 에 이미지를 담는다. 
//		Image img = icon.getImage();
//		// 이미지 사이즈 조절
//		Image changeImg = img.getScaledInstance(275, 355,  Image.SCALE_SMOOTH);
//		// 변경된 이미지를 다시 icon 에 담는다. 
//		ImageIcon changeIcon = new ImageIcon(changeImg);
//		lblPoster = new JLabel(changeIcon);
//		
//		
//		//lblPoster.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]포스터_포레스트검프.png")));
//		
		lblPoster.setBounds(54, 165, 319, 390);
		contentPanel.add(lblPoster);
		
		lblMovieTitle_data = new JLabel("영화 :");
		lblMovieTitle_data.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieTitle_data.setBounds(512, 165, 250, 20);
		contentPanel.add(lblMovieTitle_data);
		
		lblMovieRelTime_data = new JLabel("개봉일 :");
		lblMovieRelTime_data.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieRelTime_data.setBounds(512, 198, 250, 20);
		contentPanel.add(lblMovieRelTime_data);
		
		lblMovieRating_data = new JLabel("등급 :");
		lblMovieRating_data.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieRating_data.setBounds(512, 232, 250, 20);
		contentPanel.add(lblMovieRating_data);
		
		lblMovieRunTimedata = new JLabel("상영시간 :");
		lblMovieRunTimedata.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieRunTimedata.setBounds(512, 266, 250, 20);
		contentPanel.add(lblMovieRunTimedata);
		
		lblMovieMade_in_data = new JLabel("국가 :");
		lblMovieMade_in_data.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieMade_in_data.setBounds(512, 291, 250, 20);
		contentPanel.add(lblMovieMade_in_data);
		
		lblMovieDesc_data = new JLabel("");
		lblMovieDesc_data.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblMovieDesc_data.setBounds(403, 357, 350, 100);
		contentPanel.add(lblMovieDesc_data);
		
		
		
		
		
		JLabel lblPageBackground = new JLabel("",SwingConstants.CENTER);
		//lblNewLabel.
		//Font font = new ("도현체")
		lblPageBackground.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		lblPageBackground.setBounds(0, 0, 800, 600);
		contentPanel.add(lblPageBackground);
		 	    

	}
	
	// Tescode 
	

	

	
	/// Functions
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new mybutton("영화 선택",new Color(183, 216, 107));
			btnNewButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 68));
			btnNewButton.setBounds(436, 458, 292, 92);
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
		
		Page6_SelectCinema selectCinema = new Page6_SelectCinema();
		
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
			lblGoHome.setIcon(new ImageIcon(Page5_MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));
			lblGoHome.setBounds(618, 6, 171, 133);
		
		return lblGoHome;
		
	}
		
	
	private void goHomePage() {
		Page2_SelectMenu selectMenu = new Page2_SelectMenu();
		
		
		selectMenu.setVisible(true);
		
		
		
		this.dispose();
	}
	private void showtest() {
		
		String movie_title = ShareVar.selectedMovieTitle;
		Dao_PJH dao = new Dao_PJH(movie_title);
		ArrayList<Dto_PJH> dtolist = dao.movie_Info();
		lblMovieTitle_data.setText(dtolist.get(0).getMovie_title());
		lblMovieRelTime_data.setText(dtolist.get(0).getRel_date().toString());
		lblMovieRunTimedata.setText(dtolist.get(0).getMovie_run_time()+ "분");
		lblMovieRating_data.setText(dtolist.get(0).getFilm_rating());
		lblMovieMade_in_data.setText(dtolist.get(0).getMade_in());
		lblMovieDesc_data.setText(dtolist.get(0).getMovie_desc());
		imageInsert(lblPoster, ShareVar.filename);
		
		
		
		
	}
	private void imageInsert(JLabel poster, int filename) {
		
		// Image 처리 : filename이 달라야 보여주기가 가능
		String filePath = Integer.toString(filename);
		poster.setIcon(new ImageIcon(filePath));

		ImageIcon icon = new ImageIcon(filePath);
		// img 에 이미지를 담는다.
		Image img = icon.getImage();
		// 이미지 사이즈 조절
		Image changeImg = img.getScaledInstance(319, 390, Image.SCALE_SMOOTH);
		// 변경된 이미지를 다시 icon 에 담는다.
		ImageIcon changeIcon = new ImageIcon(changeImg);
		poster.setIcon(changeIcon);

		poster.setHorizontalAlignment(SwingConstants.CENTER);

		File file = new File(filePath);
		// System.out.println(ShareVar.filename);
//		file.delete();

	}
	
}// END
