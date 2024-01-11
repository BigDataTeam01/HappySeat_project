package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
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
import com.javaproject.kioskFunction.Dao_PJH;
import com.javaproject.kioskFunction.Dao_pjm;
import com.javaproject.kioskFunction.Dto_PJH;
import com.javaproject.kioskFunction.Dto_pjm;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

public class Page06_SelectCinema extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 영화선택 화면
	 * 				 1. SelectCinema에서 이전화면 버튼을 터치했을시 Page5_MovieInformation 화면으로 이동
	 * 				 2. SelectCinema에서 극장 버튼을 터치했을시  SelectTime 화면으로 이동
	 * 				 3. SelectCinema에서 첫화면 버튼을 터치했을시  SelectMenu화면으로 이동
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환
	 * 
	 *   *  *  * Update 2024.01.07 by J.park:
	 * 			1. descripton 수정
	 * 			3. kiosk set bound sharevar 에서 가져와 지정
	 * 			4. diaog -> static 
	 * 			5. 배경 추가
	 * 			6. 첫화면, 이전화면, 극장선택버튼 추가
	 * 			7. 
	 * 
	 */
	/**
	 * Launch the application.
	 */
	private static Page06_SelectCinema selectCinemadialog = new Page06_SelectCinema();
	private static Page02_SelectMenu selectMenudialog = new Page02_SelectMenu();
	private static Page05_MovieInformation movieInformationdialog = new Page05_MovieInformation();
	private static Page07_SelectTime selectTimedialog = new Page07_SelectTime();
	
	private static int moviePageCount = 1;
	private static int nextPageBtnCount = 1;

	// 상영관 사진, 위치,이름 선언
	private JLabel lbllocation_map1;
	private JLabel lbllocation_map2;
	private JLabel lbllocation_map3;
	private JLabel lbllocation_map4;
	private JLabel lblcinema_branch1;
	private JLabel lblcinema_branch2;
	private JLabel lblcinema_branch3;
	private JLabel lblcinema_branch4;
	private JLabel lblget_here1;
	private JLabel lblget_here2;
	private JLabel lblget_here3;
	private JLabel lblget_here4;
	private JLabel BtnNextCinema;
	
	public static void main(String[] args) {
		try {
			selectCinemadialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			selectCinemadialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page06_SelectCinema() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				getCinemaInfo();
			}
		});
		// 타이틀 설정
		setTitle("극장 선택");
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width, ShareVar.kiosk_hight);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			
			
			//극장 이름, 위치, 사진
			JLabel lblget_here1 = new JLabel("");
			lblget_here1.setFont(new Font("굴림", Font.PLAIN, 18));
			lblget_here1.setBounds(249, 207, 100, 21);
			contentPanel.add(lblget_here1);
			
			JLabel lbllocation_map1 = new JLabel("");
			lbllocation_map1.setBounds(134, 176, 102, 115);
			contentPanel.add(lbllocation_map1);
			
			JLabel lblcinema_branch1 = new JLabel("");
			lblcinema_branch1.setFont(new Font("굴림", Font.PLAIN, 18));
			lblcinema_branch1.setBounds(249, 173, 100, 21);
			contentPanel.add(lblcinema_branch1);
			
			JLabel lblget_here2 = new JLabel("");
			lblget_here2.setFont(new Font("굴림", Font.PLAIN, 18));
			lblget_here2.setBounds(561, 184, 100, 21);
			contentPanel.add(lblget_here2);
			
			JLabel lbllocation_map2 = new JLabel("");
			lbllocation_map2.setBounds(437, 178, 102, 115);
			contentPanel.add(lbllocation_map2);
			
			JLabel lblcinema_branch2 = new JLabel("");
			lblcinema_branch2.setFont(new Font("굴림", Font.PLAIN, 18));
			lblcinema_branch2.setBounds(561, 215, 100, 21);
			contentPanel.add(lblcinema_branch2);
			
			JLabel lblget_here3 = new JLabel("");
			lblget_here3.setFont(new Font("굴림", Font.PLAIN, 18));
			lblget_here3.setBounds(263, 375, 100, 21);
			contentPanel.add(lblget_here3);
			
			JLabel lblcinema_branch3 = new JLabel("");
			lblcinema_branch3.setFont(new Font("굴림", Font.PLAIN, 18));
			lblcinema_branch3.setBounds(263, 341, 100, 21);
			contentPanel.add(lblcinema_branch3);
			
			JLabel lbllocation_map3 = new JLabel("");
			lbllocation_map3.setBounds(148, 344, 102, 115);
			contentPanel.add(lbllocation_map3);
			
			JLabel lblcinema_branch4 = new JLabel("");
			lblcinema_branch4.setFont(new Font("굴림", Font.PLAIN, 18));
			lblcinema_branch4.setBounds(559, 341, 100, 21);
			contentPanel.add(lblcinema_branch4);
			
			JLabel lblget_here4 = new JLabel("");
			lblget_here4.setFont(new Font("굴림", Font.PLAIN, 18));
			lblget_here4.setBounds(559, 375, 100, 21);
			contentPanel.add(lblget_here4);
			
			JLabel lbllocation_map4 = new JLabel("");
			lbllocation_map4.setBounds(444, 344, 102, 115);
			contentPanel.add(lbllocation_map4);

//			페이지 타이틀 
			JLabel lbl_pagecinemaName = new JLabel("극장 선택");
			lbl_pagecinemaName.setFont(new Font(ShareVar.kiosk_title_font, Font.PLAIN, ShareVar.kiosk_title_font_size));

			lbl_pagecinemaName.setBounds(295, 10, 250, 100);

			contentPanel.add(lbl_pagecinemaName);

			// 첫화면 아이콘
			JLabel lbl_pagecinemaName_1 = new JLabel("첫화면");
			lbl_pagecinemaName_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectMenu();
				}
			});
			lbl_pagecinemaName_1
					.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn처음으로.png")));

			lbl_pagecinemaName_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 15));
			lbl_pagecinemaName_1.setBounds(623, 20, 170, 130);
			contentPanel.add(lbl_pagecinemaName_1);

			JLabel BtnPreviousCinema = new JLabel("");
			BtnPreviousCinema
					.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn이전버튼.png")));
			BtnPreviousCinema.setBounds(103, 503, 260, 50);
			contentPanel.add(BtnPreviousCinema);

			JLabel BtnNextCinema = new JLabel("");
			BtnNextCinema
					.setIcon(new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/Btn다음버튼.png")));
			BtnNextCinema.setBounds(561, 503, 198, 57);
			contentPanel.add(BtnNextCinema);

			// 극장선택 배경(총 4개)
			JLabel lbl_CinemaBackGround1 = new JLabel("");
			lbl_CinemaBackGround1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectTime();
				}
			});
			lbl_CinemaBackGround1.setIcon(
					new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
			lbl_CinemaBackGround1.setBounds(122, 167, 254, 132);
			contentPanel.add(lbl_CinemaBackGround1);

			JLabel lbl_CinemaBackGround2 = new JLabel("");
			lbl_CinemaBackGround2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectTime();
				}
			});
			lbl_CinemaBackGround2.setIcon(
					new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
			lbl_CinemaBackGround2.setBounds(425, 167, 254, 132);
			contentPanel.add(lbl_CinemaBackGround2);

			JLabel lbl_CinemaBackGround3 = new JLabel("");
			lbl_CinemaBackGround3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectTime();
				}
			});
			lbl_CinemaBackGround3.setIcon(
					new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
			lbl_CinemaBackGround3.setBounds(122, 341, 254, 132);
			contentPanel.add(lbl_CinemaBackGround3);

			JLabel lbl_CinemaBackGround4 = new JLabel("");
			lbl_CinemaBackGround4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToSelectTime();
				}
			});
			lbl_CinemaBackGround4.setIcon(
					new ImageIcon(Page05_MovieInformation.class.getResource("/com/javaproject/image/영화배경(영화선택).png")));
			lbl_CinemaBackGround4.setBounds(425, 341, 254, 132);
			contentPanel.add(lbl_CinemaBackGround4);

			// 이전으로 버튼
			JLabel BtnBackToPrevious = new JLabel("");
			BtnBackToPrevious.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToMovieInformation();
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
			lbl_background.setBounds(-16, -19, 800, 600);
			contentPanel.add(lbl_background);
		}
	}


	// 다음화면(시간선택)로 가기
	private void goToSelectTime() {
		dispose();
		selectCinemadialog.setVisible(false);
		selectCinemadialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectTimedialog.setVisible(true);
	}

	// 이전화면(영화정보)으로 가기
	private void goToMovieInformation() {
		dispose();
		selectCinemadialog.setVisible(false);
		selectCinemadialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		movieInformationdialog.setVisible(true);
	}

	// 첫화면으로 가기
	private void goToSelectMenu() {
		dispose();
		selectCinemadialog.setVisible(false);
		selectCinemadialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		selectMenudialog.setVisible(true);
	}
//--------------------Function--------------------------
	// 데이터베이스에서 정보를 가져와 보여주기
		private void getCinemaInfo() {

			Dao_PJH cinema = new Dao_PJH();
			
			ArrayList<JLabel> locationMap = new ArrayList<JLabel>();
			locationMap.add(lbllocation_map1);
			locationMap.add(lbllocation_map2);
			locationMap.add(lbllocation_map3);
			locationMap.add(lbllocation_map4);
			ArrayList<JLabel> cinemaName = new ArrayList<JLabel>();
			cinemaName.add(lblcinema_branch1);
			cinemaName.add(lblcinema_branch2);
			cinemaName.add(lblcinema_branch3);
			cinemaName.add(lblcinema_branch4);
		
			ArrayList<JLabel> cinemaGetHere = new ArrayList<JLabel>();
			cinemaGetHere.add(lblget_here1);
			cinemaGetHere.add(lblget_here2);
			cinemaGetHere.add(lblget_here3);
			cinemaGetHere.add(lblget_here4);
			
			ArrayList<Dto_PJH> dtolist = cinema.cinema_Info();
		    

			int n = dtolist.size();

			int r = n % 4;

			int m = n / 4 + ((n % 4) / 4 + 1); // 맨 마지막 페이지

			if (moviePageCount != m && moviePageCount < m) {

				for (int i = nextPageBtnCount; i <= nextPageBtnCount + 3 /* dtolist.size() */ ; i++) {

					imageInsert(locationMap.get(i - nextPageBtnCount), i);
					locationMap.get(i - nextPageBtnCount).setVisible(true);

					cinemaInfoInsert(cinemaName.get(i - nextPageBtnCount), cinemaGetHere.get(i - nextPageBtnCount),
							 i, dtolist);

				}
				BtnNextCinema.setVisible(true);

			} else {
				System.out.println(nextPageBtnCount);

				//// 마지막 페이지에서의 활동!
				for (int i = nextPageBtnCount; i < nextPageBtnCount + r /* dtolist.size() */ ; i++) {
					imageInsert(locationMap.get(i - nextPageBtnCount), i);
					locationMap.get(i - nextPageBtnCount).setVisible(true);

					cinemaInfoInsert(cinemaName.get(i - nextPageBtnCount), cinemaGetHere.get(i - nextPageBtnCount),
							 i, dtolist);
				}
				// 마지막 페이지에 없는 영화는 안보여주기
				for (int i = 3; i > r - 1; i--) {
					locationMap.get(i).setVisible(false);
					cinemaName.get(i).setVisible(false);
					cinemaGetHere.get(i).setVisible(false);
				}
				
				
				

				BtnNextCinema.setVisible(false);

			}

		}
	
		private void imageInsert(JLabel location_map, int filename) {
			  if (location_map != null) {
			// Image 처리 : filename이 달라야 보여주기가 가능
			String filePath = Integer.toString(filename);
			location_map.setIcon(new ImageIcon(filePath));

			ImageIcon icon = new ImageIcon(filePath);
			// img 에 이미지를 담는다.
			Image img = icon.getImage();
			// 이미지 사이즈 조절
			Image changeImg = img.getScaledInstance(80, 110, Image.SCALE_SMOOTH);
			// 변경된 이미지를 다시 icon 에 담는다.
			ImageIcon changeIcon = new ImageIcon(changeImg);
			location_map.setIcon(changeIcon);

			location_map.setHorizontalAlignment(SwingConstants.CENTER);

			File file = new File(filePath);
			// System.out.println(ShareVar.filename);
//			file.delete();
			  } else {
			        System.out.println("location_map is null");
			    }
		}
		//영화정보 가져오기
		private void cinemaInfoInsert(JLabel cinema_branch, JLabel cinemaGetHere, int i, ArrayList<Dto_PJH> dtolist) {

			cinema_branch.setText(dtolist.get(i - 1).getCinema_branch());
			cinemaGetHere.setText(dtolist.get(i - 1).getGet_here());
			cinema_branch.setVisible(true);
			cinemaGetHere.setVisible(true);
//			System.out.println("가나다"+cinemaName);
		}
	
	
	
}// End
