package com.javaproject.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MovieUserStatistics extends JDialog {
	
	/*
	 * Descritipon : 1. DB에서 customer Table의 고객유형과 reserve Table의 seq와 screen Table의 scr_start_time를 가져와 유형별 사용자 통계를 차트로 보여줌
	 * 				 2. DB에서 customer Table의 연령대와 reserve Table의 seq와 screen Table의 scr_start_time를 가져와 연령별 사용자 통계를 차트로 보여줌
	 * 
	 * Author : Lcy, Wdh
	 * 
	 * Date : 2024-01-05 , 16:07
	 */

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MovieUserStatistics dialog = new MovieUserStatistics();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MovieUserStatistics() {
		setTitle("사용자 통계");
		setBounds(ShareVar.managerXlocation,ShareVar.managerYlocation,ShareVar.managerXsize,ShareVar.managerYsize);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblManagerBackGround = new JLabel("");
		lblManagerBackGround.setIcon(new ImageIcon(MovieUserStatistics.class.getResource("/com/javaproject/image/manager_background.png")));
		lblManagerBackGround.setBounds(0, 0, 800, 572);
		contentPanel.add(lblManagerBackGround);
	}

}