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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	static MovieControl moviecontrolDialog = new MovieControl(); // MovieControl Dialog를 controlDialog란 이름으로 함.
	static MovieDaySalesStatus statusDialog = new MovieDaySalesStatus();
	static MovieUserStatistics statisticsDialog = new MovieUserStatistics();
	static ScreenControl screencontrolDialog = new ScreenControl();
	private JLabel lblManagerBackGround;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblScreenControl;
	private JLabel lblAdminID;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				lblAdminID.setText(ShareVar.managerID);
			}
		});
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
		lblNewLabel.setBounds(157, 248, 150, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("BM Dohyeon", Font.PLAIN, 23));
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("매출 현황");
		lblNewLabel_1.setBounds(157, 471, 150, 40);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 23));
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("사용자 통계");
		lblNewLabel_2.setBounds(488, 471, 150, 40);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 23));
		contentPanel.add(lblNewLabel_2);
		contentPanel.add(getLblNewLabel_3());
		contentPanel.add(getLblNewLabel_4());
		contentPanel.add(getLblScreenControl());
		contentPanel.add(getLblAdminID());
		contentPanel.add(getLblManagerBackGround());
	}
	
	private JLabel getLblMovieControl() {
		if (lblMovieControl == null) {
			lblMovieControl = new JLabel("");
			lblMovieControl.setBounds(157, 88, 150, 150);
			lblMovieControl.setIcon(new ImageIcon(ManagerMain.class.getResource("/com/javaproject/image/MovieControl.png")));
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
			lblMovieSalesStatus.setBounds(157, 323, 150, 150);
			lblMovieSalesStatus.setIcon(new ImageIcon(ManagerMain.class.getResource("/com/javaproject/image/MovieSalesStatus.png")));
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
			lblMovieUserStatistics.setBounds(488, 323, 150, 150);
			lblMovieUserStatistics.setIcon(new ImageIcon(ManagerMain.class.getResource("/com/javaproject/image/MovieUserStatistics.png")));
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
		moviecontrolDialog.setVisible(true);
	}
	
	private void goToMovieSalesStatus() {
		statusDialog.setVisible(true);
	}
	
	private void goToMovieUserStatistics() {
		statisticsDialog.setVisible(true);
	}
	private JLabel getLblManagerBackGround() {
		if (lblManagerBackGround == null) {
			lblManagerBackGround = new JLabel("");
			lblManagerBackGround.setIcon(new ImageIcon(ManagerMain.class.getResource("/com/javaproject/image/manager_background.png")));
			lblManagerBackGround.setBounds(0, 0, 800, 572);
		}
		return lblManagerBackGround;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("관리자 ID : ");
			lblNewLabel_3.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(488, 29, 105, 33);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("상영관 관리");
			lblNewLabel_4.setFont(new Font("BM Dohyeon", Font.PLAIN, 23));
			lblNewLabel_4.setBounds(500, 248, 127, 40);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblScreenControl() {
		if (lblScreenControl == null) {
			lblScreenControl = new JLabel("");
			lblScreenControl.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToScreenControl();
				}
			});
			lblScreenControl.setIcon(new ImageIcon(ManagerMain.class.getResource("/com/javaproject/image/MovieScreen.png")));
			lblScreenControl.setBounds(510, 148, 100, 90);
		}
		return lblScreenControl;
	}
	private JLabel getLblAdminID() {
		if (lblAdminID == null) {
			lblAdminID = new JLabel("");
			lblAdminID.setFont(new Font("BM Dohyeon", Font.PLAIN, 19));
			lblAdminID.setBounds(601, 25, 140, 40);
		}
		return lblAdminID;
	}
	
	private void goToScreenControl() {
		screencontrolDialog.setVisible(true);
	}
	
	
	
} // End