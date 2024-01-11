package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

import com.javaproject.base.ShareVar;
import com.javaproject.kioskFunction.Dao_pjm;
import com.javaproject.kioskFunction.Dto_pjm;
import com.javaproject.kioskFunction.dao;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JTextField;

public class Page04_SelectMovie extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/*
	 * Description : 영화 선택화면 1.SelectMovie에서 영화 버튼을 터치했을시 Movieinformation 화면으로 이동
	 * 						    2.SelectMovie에서 이전 화면 버튼을 터치했을시 SelectAge 화면으로 이동
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환,박동근
	 * 
	 * * * * Update 2024.01.07(일요일 )  
	 * by J.park: 1. descripton 수정 
	 * 			  2. kiosk set bound sharevar 에서 가져와 지정 
	 * 			  3. diaog -> static 
	 * 			  4. 배경 추가 
	 * 			  5. 첫화면,이전화면, 영화선택 추가
	 * * * * Update 2024.01.09 (화) by 박정민,박동근
	 * 			  1. MovieSelect ArrayList<movie_info>  만들기 
	 * 			  2. dao 로 현재 상영중 상태인 영화들 CurrentScreenMovies ArrayList <>로 가져오기
	 * 			  3. for 문을 사용해서   MovieSelect 에  CurrentScreenMovies 에 넣기
	 * 			  4. 영화 포스터 이미지 삽입
	 * 			  5. 이전버튼 다음버튼 실행에 따른 영화 정보 (영화포스터, 제목 , 영화등급, 장르) 변동 기능 구현
	 * 
	 *  
	 */			  

	/**
	 * Launch the application.
	 */
	private static JLabel lbl_Movie1;
	private static Page04_SelectMovie SelectMoviedialog = new Page04_SelectMovie();
	private static Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
	private static Page05_MovieInformation MovieInformationdialog = new Page05_MovieInformation();
	private static Page03_SelectAge SelectAgedialog = new Page03_SelectAge();
//	private JLabel lbl_moviePoster1_bg;

	private JLabel lbl_moviePoster1;
	private JLabel lbl_moviePoster2;
	private JLabel lbl_moviePoster3;
	private JLabel lbl_moviePoster4;
	private static int nextPageBtnCount = 1;
	private static JLabel lbl_PreviousMovie;
	private static JLabel lbl_NextMovie;

	private static int moviePageCount = 1;
	private JLabel lbl_MovieTitle1;
	private JLabel lbl_MovieRating1;
	private JLabel lbl_MovieGenre1;
	private JLabel lbl_MovieTitle2;
	private JLabel lbl_MovieTitle3;
	private JLabel lbl_MovieTitle4;
	private JLabel lbl_MovieRating2;
	private JLabel lbl_MovieGenre2;
	private JLabel lbl_MovieRating3;
	private JLabel lbl_MovieGenre3;
	private JLabel lbl_MovieRating4;
	private JLabel lbl_MovieGenre4;

	public static void main(String[] args) {
		try {
			Page04_SelectMovie dialog = new Page04_SelectMovie();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page04_SelectMovie() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

				lbl_PreviousMovie.setVisible(false);
				System.out.println("없어져볼께");
				getCurrentScreenMovies();
			}
		});
		setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		setTitle("영화 선택");
		setBounds(100, 100, 800, 600);
		// 타이틀 설정
		setTitle("영화 선택");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		// 이전화면
		lbl_PreviousMovie = new JLabel("");
		lbl_PreviousMovie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				moviePageCount = moviePageCount - 1;
				nextPageBtnCount -= 4;

				if (moviePageCount == 1) {

					getCurrentScreenMovies();
					lbl_PreviousMovie.setVisible(false);

				} else {
					moviePageCount = moviePageCount - 1;
					getCurrentScreenMovies();
				}

			}
		});
		lbl_PreviousMovie.setBounds(103, 503, 260, 50);
		lbl_PreviousMovie
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn이전버튼.png")));
		contentPanel.add(lbl_PreviousMovie);

		////////////// 다음 영화로 버튼
		lbl_NextMovie = new JLabel("");
		lbl_NextMovie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nextPageBtnCount += 4;
				moviePageCount += 1;
				lbl_PreviousMovie.setVisible(true);
				getCurrentScreenMovies();

			}
		});
		lbl_NextMovie.setBounds(561, 503, 198, 57);

		lbl_NextMovie
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn다음버튼.png")));
		contentPanel.add(lbl_NextMovie);

		////////////////////////////// ---------------------poster-----------------------------/////////////////

//		페이지 타이틀 
		JLabel lbl_pageTitle = new JLabel("영화 선택");
		lbl_pageTitle.setBounds(295, 10, 250, 100);
		lbl_pageTitle.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

		contentPanel.add(lbl_pageTitle);

		// 처음으로 버튼
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

		// 영화 포스터1 위치및 폭,높이 설정.
		lbl_moviePoster1 = new JLabel();
		lbl_moviePoster1.setBounds(134, 180, 80, 110);
		lbl_moviePoster1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToMovieInformation1();
			}
		});
		contentPanel.add(lbl_moviePoster1);
		// 영화포스터1 배경
		lbl_Movie1 = new JLabel("");
		lbl_Movie1.setBounds(122, 167, 254, 132);
		lbl_Movie1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToMovieInformation1();
				
			}
		});

		lbl_MovieGenre1 = new JLabel("영화 장르");
		lbl_MovieGenre1.setBounds(232, 248, 130, 20);
		contentPanel.add(lbl_MovieGenre1);

		lbl_MovieTitle1 = new JLabel("영화제목");
		lbl_MovieTitle1.setBounds(232, 180, 130, 20);
		contentPanel.add(lbl_MovieTitle1);

		lbl_MovieRating1 = new JLabel("영화등급");
		lbl_MovieRating1.setBounds(232, 204, 80, 30);
		contentPanel.add(lbl_MovieRating1);

		lbl_Movie1.setIcon(
				new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_Movie1);

		// 영화 포스터2 위치및 폭,높이 설정.
		lbl_moviePoster2 = new JLabel();
		lbl_moviePoster2.setBounds(434, 180, 80, 110);
		lbl_moviePoster2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToMovieInformation2();
			}
		});

		lbl_MovieTitle2 = new JLabel("영화제목");
		lbl_MovieTitle2.setBounds(532, 180, 130, 20);
		contentPanel.add(lbl_MovieTitle2);

		lbl_MovieRating2 = new JLabel("영화등급");
		lbl_MovieRating2.setBounds(532, 204, 80, 30);
		contentPanel.add(lbl_MovieRating2);

		lbl_MovieGenre2 = new JLabel("영화 장르");
		lbl_MovieGenre2.setBounds(532, 248, 130, 20);
		contentPanel.add(lbl_MovieGenre2);
		contentPanel.add(lbl_moviePoster2);
		JLabel lbl_Movie2 = new JLabel("");
		lbl_Movie2.setBounds(425, 167, 254, 132);
		lbl_Movie2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToMovieInformation2();
			}
		});

		lbl_Movie2.setIcon(
				new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_Movie2);

		// 영화 포스터3 위치및 폭,높이 설정.
		lbl_moviePoster3 = new JLabel();
		lbl_moviePoster3.setBounds(134, 353, 80, 110);
		lbl_moviePoster3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToMovieInformation3();
			}
		});

		lbl_MovieTitle3 = new JLabel("영화제목");
		lbl_MovieTitle3.setBounds(232, 353, 130, 20);
		contentPanel.add(lbl_MovieTitle3);

		lbl_MovieRating3 = new JLabel("영화등급");
		lbl_MovieRating3.setBounds(233, 385, 80, 30);
		contentPanel.add(lbl_MovieRating3);

		lbl_MovieGenre3 = new JLabel("영화 장르");
		lbl_MovieGenre3.setBounds(233, 429, 130, 20);
		contentPanel.add(lbl_MovieGenre3);
		contentPanel.add(lbl_moviePoster3);

		JLabel lbl_Movie3 = new JLabel("");
		lbl_Movie3.setBounds(122, 341, 254, 132);
		lbl_Movie3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToMovieInformation3();
			}
		});
		lbl_Movie3.setIcon(
				new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_Movie3);

		// 영화 포스터4 위치및 폭,높이 설정.
		lbl_moviePoster4 = new JLabel();
		lbl_moviePoster4.setBounds(434, 353, 80, 110);
		lbl_moviePoster4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToMovieInformation4();
			}
		});

		lbl_MovieTitle4 = new JLabel("영화제목");
		lbl_MovieTitle4.setBounds(532, 353, 130, 20);
		contentPanel.add(lbl_MovieTitle4);

		lbl_MovieRating4 = new JLabel("영화등급");
		lbl_MovieRating4.setBounds(532, 385, 80, 30);
		contentPanel.add(lbl_MovieRating4);

		lbl_MovieGenre4 = new JLabel("영화 장르");
		lbl_MovieGenre4.setBounds(532, 429, 130, 20);
		contentPanel.add(lbl_MovieGenre4);
		contentPanel.add(lbl_moviePoster4);
		JLabel lbl_Movie4 = new JLabel("");
		lbl_Movie4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToMovieInformation4();
			}
		});
		lbl_Movie4.setBounds(425, 341, 254, 132);
		lbl_Movie4.setIcon(
				new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
		contentPanel.add(lbl_Movie4);

		//
		// 이전화면으로 가기 버튼
		JLabel BtnBackToPrevious = new JLabel("");
		BtnBackToPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goToSelectAge();
			}
		});
		BtnBackToPrevious
				.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn이전으로.png")));
		BtnBackToPrevious.setBounds(6, 21, 170, 130);
		contentPanel.add(BtnBackToPrevious);

		// 배경화면
		JLabel lbl_background = new JLabel("", SwingConstants.CENTER);
		lbl_background.setBounds(0, 0, 800, 600);
		lbl_background.setIcon(new ImageIcon(
				Page05_MovieInformation.class.getResource("/com/javaproject/image/[QuickSeat]kiosk_background.png")));
		contentPanel.add(lbl_background);

	}

//-----------------------------Function------------
	// 다음화면(정화정보)로 가기
	private void goToMovieInformation1() {
		dispose();
		SelectMoviedialog.setVisible(false);
		SelectMoviedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		MovieInformationdialog.setVisible(true);
		String movie1 = lbl_MovieTitle1.getText();
			ShareVar.selectedMovieTitle = movie1;
			
	}
	private void goToMovieInformation2() {
		dispose();
		SelectMoviedialog.setVisible(false);
		SelectMoviedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		MovieInformationdialog.setVisible(true);
		String movie2 = lbl_MovieTitle2.getText();
		ShareVar.selectedMovieTitle = movie2;
		
	}
	private void goToMovieInformation3() {
		dispose();
		SelectMoviedialog.setVisible(false);
		SelectMoviedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		MovieInformationdialog.setVisible(true);
		String movie3 = lbl_MovieTitle3.getText();
		ShareVar.selectedMovieTitle = movie3;
	}
	private void goToMovieInformation4() {
		dispose();
		SelectMoviedialog.setVisible(false);
		SelectMoviedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		MovieInformationdialog.setVisible(true);
		String movie4 = lbl_MovieTitle4.getText();
		ShareVar.selectedMovieTitle = movie4;
		
	}

	// 이전화면(연령선택)으로 가기
	private void goToSelectAge() {
		dispose();
		SelectMoviedialog.setVisible(false);
		SelectMoviedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		SelectAgedialog.setVisible(true);
	}

	// 첫화면으로 가기
	private void goToSelectMenu() {
		dispose();
		SelectMoviedialog.setVisible(false);
		SelectMoviedialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}

	// 데이터베이스에서 정보를 가져와 보여주기
	private void getCurrentScreenMovies() {

		Dao_pjm currentMovie = new Dao_pjm();

		ArrayList<JLabel> posters = new ArrayList<JLabel>();
		posters.add(lbl_moviePoster1);
		posters.add(lbl_moviePoster2);
		posters.add(lbl_moviePoster3);
		posters.add(lbl_moviePoster4);
		ArrayList<JLabel> title = new ArrayList<JLabel>();
		title.add(lbl_MovieTitle1);
		title.add(lbl_MovieTitle2);
		title.add(lbl_MovieTitle3);
		title.add(lbl_MovieTitle4);
		ArrayList<JLabel> genre = new ArrayList<JLabel>();
		genre.add(lbl_MovieGenre1);
		genre.add(lbl_MovieGenre2);
		genre.add(lbl_MovieGenre3);
		genre.add(lbl_MovieGenre4);
		ArrayList<JLabel> rating = new ArrayList<JLabel>();
		rating.add(lbl_MovieRating1);
		rating.add(lbl_MovieRating2);
		rating.add(lbl_MovieRating3);
		rating.add(lbl_MovieRating4);
		
		ArrayList<Dto_pjm> dtolist = currentMovie.currentScreenMovie();
	    

		int n = dtolist.size();

		int r = n % 4;

		int m = n / 4 + ((n % 4) / 4 + 1); // 맨 마지막 페이지
		
		
		
		if (moviePageCount != m && moviePageCount < m) {

			for (int i = nextPageBtnCount; i <= nextPageBtnCount + 3 /* dtolist.size() */ ; i++) {
				
				imageInsert(posters.get(i - nextPageBtnCount), i);
				posters.get(i - nextPageBtnCount).setVisible(true);
				
				movieInfoInsert(title.get(i - nextPageBtnCount), genre.get(i - nextPageBtnCount),
						rating.get(i - nextPageBtnCount), i, dtolist);
						
			}
			lbl_NextMovie.setVisible(true);
			
			
		} else {

			//// 마지막 페이지에서의 활동!
			for (int i = nextPageBtnCount; i < nextPageBtnCount + r /* dtolist.size() */ ; i++) {
				imageInsert(posters.get(i - nextPageBtnCount), i);
				posters.get(i - nextPageBtnCount).setVisible(true);

				movieInfoInsert(title.get(i - nextPageBtnCount), genre.get(i - nextPageBtnCount),
						rating.get(i - nextPageBtnCount), i, dtolist);

			}
			 //마지막 페이지에 없는 영화는 안보여주기
			for (int i = 3; i > r - 1; i--) {
				posters.get(i).setVisible(false);
				title.get(i).setVisible(false);
				genre.get(i).setVisible(false);
				rating.get(i).setVisible(false);
			}
			
			
			
			
			lbl_NextMovie.setVisible(false);

		}

	}

	// 영화 정보( 제목, 장르, 레이팅 ) 삽입 메소드
	private void movieInfoInsert(JLabel title, JLabel genre, JLabel rating, int i, ArrayList<Dto_pjm> dtolist) {

		title.setText(dtolist.get(i - 1).getMovie_title());
		genre.setText(dtolist.get(i - 1).getGenre());
		rating.setText(dtolist.get(i - 1).getFilm_rating());
		title.setVisible(true);
		genre.setVisible(true);
		rating.setVisible(true);
	}
	
	private void imageInsert(JLabel poster, int filename) {
		
		// Image 처리 : filename이 달라야 보여주기가 가능
		String filePath = Integer.toString(filename);
		poster.setIcon(new ImageIcon(filePath));

		ImageIcon icon = new ImageIcon(filePath);
		// img 에 이미지를 담는다.
		Image img = icon.getImage();
		// 이미지 사이즈 조절
		Image changeImg = img.getScaledInstance(80, 110, Image.SCALE_SMOOTH);
		// 변경된 이미지를 다시 icon 에 담는다.
		ImageIcon changeIcon = new ImageIcon(changeImg);
		poster.setIcon(changeIcon);

		poster.setHorizontalAlignment(SwingConstants.CENTER);

		File file = new File(filePath);
		// System.out.println(ShareVar.filename);
//		file.delete();

	}
		
	
	
}// End
