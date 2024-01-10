		package com.javaproject.manager;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javaproject.base.ShareVar;
import com.javaproject.managerfunction.DaoMovieControl;
import com.javaproject.managerfunction.DtoLCY;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovieControl extends JDialog {
	
	/*
	 * Descritipon : 1. DB의 Movie Table로 Insert함
	 * 				 2. DB의 Movie Table에서 select하여 scroll pane의 innerTable에 불러온다.
	 *               3. DB의 Movie Table을 Update함
	 * 
	 * Author : Lcy, Wdh
	 * 
	 * Date : 2024-01-05 , 16:07
	 */

	private final DefaultTableModel outerTable = new DefaultTableModel();
	private static final long serialVersionUID = 1L;
	private JTable innerTable;
	private JTextField tfMovieTitle;
	private JTextField tfDistCompany;
	private JTextField tfGenre;
	private JTextField tfOverDate;
	private JTextField tfRelDate;
	private JTextField tfMadeIn;
	private JTextField tfPosterPath;
	private JTextField tfDirector;
	private JTextField tfActor;
	private JComboBox cbRelState;
	private JComboBox cbFilmRating;
	private JLabel lblPosterImage;
	private JScrollPane scrollPane;
	private JEditorPane epMovieDesc;
	private JButton btnInit;
	private JButton btnFilePath;
	private JScrollPane scrollPane_1;
//	private JEditorPane editorPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MovieControl dialog = new MovieControl();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MovieControl() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				movieTableInit();
				movieSearchAction();
			}
		});
		setTitle("영화 등록 및 수정");
		setBounds(ShareVar.managerXlocation,ShareVar.managerYlocation,ShareVar.managerXsize,ShareVar.managerYsize);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("영화 등록 및 수정");
		lblNewLabel.setFont(new Font("BM Dohyeon", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 25, 760, 50);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("영화 제목  : ");
		lblNewLabel_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(29, 80, 76, 22);
		getContentPane().add(lblNewLabel_1);
		
		tfMovieTitle = new JTextField();
		tfMovieTitle.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		tfMovieTitle.setHorizontalAlignment(SwingConstants.CENTER);
		tfMovieTitle.setBounds(106, 80, 159, 21);
		getContentPane().add(tfMovieTitle);
		tfMovieTitle.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("배급사  : ");
		lblNewLabel_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(29, 155, 76, 22);
		getContentPane().add(lblNewLabel_1_1);
		
		tfDistCompany = new JTextField();
		tfDistCompany.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		tfDistCompany.setHorizontalAlignment(SwingConstants.CENTER);
		tfDistCompany.setColumns(10);
		tfDistCompany.setBounds(106, 155, 93, 21);
		getContentPane().add(tfDistCompany);
		
		JLabel lblNewLabel_1_2 = new JLabel("장르  : ");
		lblNewLabel_1_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(29, 180, 76, 22);
		getContentPane().add(lblNewLabel_1_2);
		
		tfGenre = new JTextField();
		tfGenre.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		tfGenre.setHorizontalAlignment(SwingConstants.CENTER);
		tfGenre.setColumns(10);
		tfGenre.setBounds(106, 180, 159, 21);
		getContentPane().add(tfGenre);
		
		JLabel lblNewLabel_1_3 = new JLabel("관람 등급  : ");
		lblNewLabel_1_3.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(29, 205, 76, 22);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("상영 종료일  : ");
		lblNewLabel_1_4.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(29, 280, 86, 22);
		getContentPane().add(lblNewLabel_1_4);
		
		tfOverDate = new JTextField();
		tfOverDate.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		tfOverDate.setHorizontalAlignment(SwingConstants.CENTER);
		tfOverDate.setColumns(10);
		tfOverDate.setBounds(106, 280, 93, 21);
		getContentPane().add(tfOverDate);
		
		JLabel lblNewLabel_1_5 = new JLabel("개봉일 : ");
		lblNewLabel_1_5.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(29, 255, 76, 22);
		getContentPane().add(lblNewLabel_1_5);
		
		tfRelDate = new JTextField();
		tfRelDate.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		tfRelDate.setHorizontalAlignment(SwingConstants.CENTER);
		tfRelDate.setColumns(10);
		tfRelDate.setBounds(106, 255, 93, 21);
		getContentPane().add(tfRelDate);
		
		JLabel lblNewLabel_1_6 = new JLabel("제작 국가 : ");
		lblNewLabel_1_6.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1_6.setBounds(29, 230, 76, 22);
		getContentPane().add(lblNewLabel_1_6);
		
		tfMadeIn = new JTextField();
		tfMadeIn.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		tfMadeIn.setHorizontalAlignment(SwingConstants.CENTER);
		tfMadeIn.setColumns(10);
		tfMadeIn.setBounds(106, 230, 93, 21);
		getContentPane().add(tfMadeIn);
		
		JLabel lblNewLabel_1_7 = new JLabel("영화 설명");
		lblNewLabel_1_7.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1_7.setBounds(29, 363, 86, 22);
		getContentPane().add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("영화 포스터 : ");
		lblNewLabel_1_6_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1_6_1.setBounds(160, 363, 86, 22);
		getContentPane().add(lblNewLabel_1_6_1);
		
		tfPosterPath = new JTextField();
		tfPosterPath.setFont(new Font("배달의민족 도현", Font.PLAIN, 14));
		tfPosterPath.setHorizontalAlignment(SwingConstants.CENTER);
		tfPosterPath.setColumns(10);
		tfPosterPath.setBounds(245, 363, 105, 21);
		getContentPane().add(tfPosterPath);
		
		JLabel lblNewLabel_1_6_1_1 = new JLabel("개봉 상태 : ");
		lblNewLabel_1_6_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1_6_1_1.setBounds(29, 305, 76, 22);
		getContentPane().add(lblNewLabel_1_6_1_1);
		
		getContentPane().add(getScrollPane());
		getContentPane().add(getCbRelState());
		getContentPane().add(getCbFilmRating());
		getContentPane().add(getLblPosterImage());
		
		JButton btnSelect = new JButton("완료");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					checkMovie_Title();
					clearMovieColumn();
				}catch(Exception q) {
					JOptionPane.showMessageDialog(null, "영화 정보 입력이 실패하였습니다.");
				}
			}
		});
		btnSelect.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		btnSelect.setBounds(373, 532, 65, 23);
		getContentPane().add(btnSelect);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("감독  : ");
		lblNewLabel_1_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(29, 105, 76, 22);
		getContentPane().add(lblNewLabel_1_1_1);
		
		tfDirector = new JTextField();
		tfDirector.setHorizontalAlignment(SwingConstants.CENTER);
		tfDirector.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		tfDirector.setColumns(10);
		tfDirector.setBounds(106, 105, 159, 21);
		getContentPane().add(tfDirector);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("배우  : ");
		lblNewLabel_1_1_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		lblNewLabel_1_1_1_1.setBounds(29, 130, 76, 22);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		tfActor = new JTextField();
		tfActor.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
		tfActor.setColumns(10);
		tfActor.setBounds(106, 130, 159, 21);
		getContentPane().add(tfActor);
		getContentPane().add(getBtnInit());
		getContentPane().add(getBtnFilePath());
		getContentPane().add(getScrollPane_1());
		
		JLabel lblBackGround = new JLabel("");
		lblBackGround.setIcon(new ImageIcon(MovieControl.class.getResource("/com/javaproject/image/manager_background.png")));
		lblBackGround.setBounds(0, 0, 800, 572);
		getContentPane().add(lblBackGround);
	}
	
	private JScrollPane getScrollPane() {
		if(scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(450, 80, 330, 450);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	
	private JComboBox getCbRelState() {
		if(cbRelState == null) {
			cbRelState = new JComboBox();
			cbRelState.setModel(new DefaultComboBoxModel(new String[] {"", "상영중", "상영종료"}));
			cbRelState.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			cbRelState.setBounds(106, 305, 116, 23);
		}
		return cbRelState;
	}
	
	private JComboBox getCbFilmRating() {
		if(cbFilmRating == null) {
			cbFilmRating = new JComboBox();
			cbFilmRating.setModel(new DefaultComboBoxModel(new String[] {"", "전체 이용가", "12세 이용가", "15세 이용가", "19세 이용가"}));
			cbFilmRating.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			cbFilmRating.setBounds(106, 205, 123, 23);
			getContentPane().add(cbFilmRating);
		}
		return cbFilmRating;
	}
	
	private JLabel getLblPosterImage() {
		if(lblPosterImage == null) {
			lblPosterImage = new JLabel("이미지를 추가 해주세요.");
			lblPosterImage.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
			lblPosterImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblPosterImage.setBounds(274, 80, 164, 278);
			
		}
		return lblPosterImage;
	}
	
	private JTable getInnerTable() {
		if(innerTable == null) {
			innerTable = new JTable();
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getButton()==1){
						tableClick();
					}
				}
			});
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
			scrollPane.setViewportView(innerTable);
		return innerTable;
	}
	
	private JButton getBtnInit() {
		if (btnInit == null) {
			btnInit = new JButton("초기화");
			btnInit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearMovieColumn();
					movieTableInit();
					movieSearchAction();
				}
			});
			btnInit.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			btnInit.setBounds(19, 52, 65, 23);
		}
		return btnInit;
	}
	
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("파일경로");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					filePath();
				}
			});
			btnFilePath.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			btnFilePath.setBounds(352, 364, 86, 23);
		}
		return btnFilePath;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(29, 390, 402, 135);
			scrollPane_1.setViewportView(getEditorPane());
		}
		return scrollPane_1;
	}
	private JEditorPane getEditorPane() {
		if (epMovieDesc == null) {
			epMovieDesc = new JEditorPane();
			epMovieDesc.setFont(new Font("BM Dohyeon",Font.PLAIN,15));
		}
		return epMovieDesc;
	}
// ====================== Functions =====================================
	
	private void movieTableInit() { // Table 초기화 
		outerTable.addColumn("영화제목");
		outerTable.addColumn("감독");
		outerTable.addColumn("장르");
		outerTable.addColumn("개봉일");
		outerTable.addColumn("관람등급");
		outerTable.addColumn("제작국가");
		outerTable.addColumn("개봉상태");
		outerTable.setColumnCount(7);
		
		int colNo = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(colNo);
		int width = 60;
		col.setPreferredWidth(width);
		
		colNo = 1;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 60;
		col.setPreferredWidth(width);
		
		colNo = 2;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 40;
		col.setPreferredWidth(width);
		
		colNo = 3;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 70;
		col.setPreferredWidth(width);
		
		colNo = 4;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);
		
		colNo = 5;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 55;
		col.setPreferredWidth(width);
		
		colNo = 6;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 60;
		col.setPreferredWidth(width);
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		// Table Row Delete
		int i = outerTable.getRowCount();
		for(int j=0; j<i; j++) {
			outerTable.removeRow(0);
		}
		
	}

	private void movieSearchAction() { // movie Table에서 목록 불러오기 
		DaoMovieControl dao = new DaoMovieControl();
		ArrayList<DtoLCY> dtoList = dao.selectList();
		int listCount = dtoList.size();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		for(int i=0; i<listCount; i++) {
			String[] qTxt = { dtoList.get(i).getMovie_title(), 
							  dtoList.get(i).getDirector(),
							  dtoList.get(i).getGenre(),
							  dateFormat.format(dtoList.get(i).getRel_date()),
							  dtoList.get(i).getFilm_rating(),
							  dtoList.get(i).getMade_in(),
							  dtoList.get(i).getRel_state() 
			};
			outerTable.addRow(qTxt);
		}
	}
	
	private void tableClick() { // Table에서 Row를 Click했을 경우 
		int i = innerTable.getSelectedRow();
		String wkMovie_Title = (String) innerTable.getValueAt(i, 0);
		
		DaoMovieControl dao = new DaoMovieControl(wkMovie_Title);
		DtoLCY dto = dao.movieTableClick();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		tfMovieTitle.setText(dto.getMovie_title());
		tfDirector.setText(dto.getDirector());
		tfActor.setText(dto.getActor());
		tfDistCompany.setText(dto.getDist_company());
		tfGenre.setText(dto.getGenre());
		cbFilmRating.setSelectedItem(dto.getFilm_rating());
		tfMadeIn.setText(dto.getMade_in());
		tfRelDate.setText(dateFormat.format(dto.getRel_date()));
		tfOverDate.setText(dateFormat.format(dto.getOver_date()));
		cbRelState.setSelectedItem(dto.getRel_state()); 
		epMovieDesc.setText(dto.getMovie_desc());

		
		// Image 처리 : filename이 달라야 보여주기가 가능
		String filePath = Integer.toString(ShareVar.filename);
		tfPosterPath.setText(filePath);
		
		// DB에서 가져온 Poster 크기 재조정 
		ImageIcon icon = new ImageIcon(filePath);
		Image changeImg = icon.getImage().getScaledInstance(164, 278, Image.SCALE_SMOOTH);
		
		lblPosterImage.setIcon(new ImageIcon(changeImg));
		lblPosterImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		File file = new File(filePath);
//		file.delete();
		
		cbFilmRating.removeItem("");
		cbRelState.removeItem("");
	}
	
	private void clearMovieColumn() { // tf,cb 전부 초기화 
		tfMovieTitle.setText("");
		tfDirector.setText("");
		tfActor.setText("");
		tfDistCompany.setText("");
		tfGenre.setText("");
		cbFilmRating.addItem("");
		cbFilmRating.setSelectedItem("");
		tfMadeIn.setText("");
		tfRelDate.setText("");
		tfOverDate.setText("");
		cbRelState.addItem("");
		cbRelState.setSelectedItem(""); 
		epMovieDesc.setText("");
		lblPosterImage.setIcon(null);
		tfPosterPath.setText("");
	}
	
	private void movieInsertAction() { // movie Table DB에 새로 입력. 
		String movie_title = tfMovieTitle.getText().trim();
		String director = tfDirector.getText().trim();
		String actor = tfActor.getText().trim();
		String dist_company = tfDistCompany.getText().trim();
		String genre = tfGenre.getText().trim();
		String film_rating = cbFilmRating.getSelectedItem().toString().trim();
		String made_in = tfMadeIn.getText().trim();
		String rel_date  = tfRelDate.getText().trim();
		String over_date = tfOverDate.getText().trim();
		String rel_state = cbRelState.getSelectedItem().toString().trim();
		String movie_desc = epMovieDesc.getText().trim();
		
		// Image
		FileInputStream input = null;
		File file = new File(tfPosterPath.getText().trim());
		try {
			input = new FileInputStream(file);
			
		}catch(FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "이미지 저장을 실패하였습니다.");
			return;
		}
		
		DaoMovieControl dao = new DaoMovieControl(movie_title, director, actor, dist_company, genre, film_rating, made_in, input ,movie_desc, rel_date, over_date, rel_state);
		
		try {
			dao.movieInsertAction();
			JOptionPane.showMessageDialog(null, "영화 '"+ tfMovieTitle.getText().trim() + "'가 정상적으로 등록되었습니다.");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "InsertAction Error");
		}
	}
	
	private void movieUpdateAction() { // Movie Table DB 수정. 
		String movie_title = tfMovieTitle.getText().trim();
		String director = tfDirector.getText().trim();
		String actor = tfActor.getText().trim();
		String dist_company = tfDistCompany.getText().trim();
		String genre = tfGenre.getText().trim();
		String film_rating = cbFilmRating.getSelectedItem().toString().trim();
		String made_in = tfMadeIn.getText().trim();
		String rel_date = tfRelDate.getText().trim();
		String over_date = tfOverDate.getText().trim();	
		String rel_state = cbRelState.getSelectedItem().toString().trim();
		String movie_desc = epMovieDesc.getText().trim();
		
		// Image 처리
		FileInputStream input = null;
		File file = new File(tfPosterPath.getText().trim());
		try {
			input = new FileInputStream(file);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		DaoMovieControl dao = new DaoMovieControl(movie_title, director, actor, dist_company, genre, film_rating, made_in, input, movie_desc, rel_date, over_date, rel_state);
		boolean result = dao.movieUpdateAction();
		
		if(result == true) {
			JOptionPane.showMessageDialog(null, "영화 '"+ tfMovieTitle.getText().trim() + "'가 정상적으로 수정되었습니다.");
		}
		else {
			JOptionPane.showMessageDialog(null, "입력 중 문제가 발생하였습니다.");
		}
	}
	
	private void checkMovie_Title() { // 완료 btn을 눌렀을 때,
		DaoMovieControl dao = new DaoMovieControl(tfMovieTitle.getText().trim());
		int movieCount = 0;
		// checkMovieTitle Method를 호출하여 where = 영화 제목으로 DB에서 검색, 있으면 1 없으면 0.
		movieCount = dao.checkMovieTitle();
		
		if(movieCount == 0) {
			// movieCount가 0이면 DB에 중복되는 영화제목이 없음.
			movieInsertAction();
		}
		if(movieCount == 1) {
			movieUpdateAction();
		}
	}
	
	
	private void filePath() { // lblPosterImage에 파일첨부 btn을 눌렀을 때, 실행되는 Method 
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG","PNG","BMP","jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.");
			return;
		}
		
		String filePath = chooser.getSelectedFile().getPath();
		tfPosterPath.setText(filePath);
		lblPosterImage.setIcon(new ImageIcon(filePath));
		lblPosterImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
} // End