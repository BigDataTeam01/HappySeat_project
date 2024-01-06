package com.javaproject.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ManagerMain extends JDialog {

	/*
	 * Descritipon : ManagerLogin Class에서 ManagerMain Class로 이동
	 * 				 영화 관리 아이콘을 클릭할 경우 MovieControl Class로 이동 
	 *				 매출현황 아이콘을 클릭할 경우 MovieSalesStatus Class로 이동
	 *				 사용자통계 아이콘을 클릭할 경우 MovieUserStatistics Class로 이동
	 * 
	 * Author : Lcy, Wdh
	 * 
	 * Date : 2024-01-05 , 16:07
	 */

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblMovieControl;
	private JLabel lblMovieSalesStatus;
	private JLabel lblMovieUserStatistics;
	
	// static인 이유? : 모든 method에서 내가 원하는 특정한 dialog를 .setVisible(false)로 하기 위함.
	static ManagerMain mainDialog = new ManagerMain();
	static MovieControl controlDialog = new MovieControl(); // MovieControl Dialog를 controlDialog란 이름으로 함.
	static MovieSalesStatus statusDialog = new MovieSalesStatus();
	static MovieUserStatistics statisticsDialog = new MovieUserStatistics();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			mainDialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManagerMain() {
		setTitle("관리자 통합화면");
		setBounds(ShareVar.managerXlocation,ShareVar.managerYlocation,ShareVar.managerXsize,ShareVar.managerYsize);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblMovieControl());
		contentPanel.add(getLblMovieSalesStatus());
		contentPanel.add(getLblMovieUserStatistics());
		
		JLabel lblNewLabel = new JLabel("영화 관리");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("배달의민족 도현", Font.PLAIN, 21));
		lblNewLabel.setBounds(100, 340, 150, 40);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("매출 현황");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("배달의민족 도현", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(325, 340, 150, 40);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("사용자 통계");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("배달의민족 도현", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(550, 340, 150, 40);
		contentPanel.add(lblNewLabel_2);
	}
	private JLabel getLblMovieControl() {
		if (lblMovieControl == null) {
			lblMovieControl = new JLabel("");
			lblMovieControl.setIcon(new ImageIcon(ManagerMain.class.getResource("/com/javaproject/image/MovieControl.png")));
			lblMovieControl.setBounds(100, 180, 150, 150);
			lblMovieControl.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToMovieControl();
				}
			});
		}
		return lblMovieControl;
	}
	private JLabel getLblMovieSalesStatus() {
		if (lblMovieSalesStatus == null) {
			lblMovieSalesStatus = new JLabel("");
			lblMovieSalesStatus.setIcon(new ImageIcon(ManagerMain.class.getResource("/com/javaproject/image/MovieSalesStatus.png")));
			lblMovieSalesStatus.setBounds(325, 180, 150, 150);
			lblMovieSalesStatus.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToMovieSalesStatus();
				}
			});
		}
		return lblMovieSalesStatus;
	}
	private JLabel getLblMovieUserStatistics() {
		if (lblMovieUserStatistics == null) {
			lblMovieUserStatistics = new JLabel("");
			lblMovieUserStatistics.setIcon(new ImageIcon(ManagerMain.class.getResource("/com/javaproject/image/MovieUserStatistics.png")));
			lblMovieUserStatistics.setBounds(550, 180, 150, 150);
			lblMovieUserStatistics.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToMovieUserStatistics();
				}
			});
		}
		return lblMovieUserStatistics;
	}
	
	
	// ================================================ Functions =========================================================================
	
	private void goToMovieControl() {
		controlDialog.setVisible(true);
	}
	
	private void goToMovieSalesStatus() {
		statusDialog.setVisible(true);
	}
	
	private void goToMovieUserStatistics() {
		statisticsDialog.setVisible(true);
	}
} // End
