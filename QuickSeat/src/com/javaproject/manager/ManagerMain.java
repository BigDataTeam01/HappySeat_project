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
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
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
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_2());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("영화 관리");
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToMovieControl();
				}
			});
			lblNewLabel.setBounds(97, 188, 157, 131);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("매출 현황");
			lblNewLabel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToMovieSalesStatus();
				}
			});
			lblNewLabel_1.setBounds(313, 188, 157, 131);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("사용자 통계");
			lblNewLabel_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					goToMovieUserStatistics();
				}
			});
			lblNewLabel_2.setBounds(555, 188, 157, 131);
		}
		return lblNewLabel_2;
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
