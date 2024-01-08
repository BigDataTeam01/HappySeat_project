package com.javaproject.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MovieDaySalesStatus extends JDialog {
	
	/*
	 * Descritipon : 1. DB에서 reserve Table의 seq와 screen Table의 scr_start_time를 가져와 일별매출현황을 Jfreechart를 활용해 chart모양으로 보여줌 (검색일부터 일주일전까지) 전년도와 비교 가능
	 * 				 2. DB에서 reserve Table의 seq와 screen Table의 scr_start_time를 가져와 월별매출현황을 Jfreechart를 활용해 chart모양으로 보여줌 (1월부터 12월까지) 전년도와 비교 가능
	 * 
	 * Author : Lcy, Wdh
	 * 
	 * Date : 2024-01-05 , 16:07
	 */


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MovieDaySalesStatus dialog = new MovieDaySalesStatus();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MovieDaySalesStatus() {
		setTitle("일별 매출 현황");
		setBounds(ShareVar.managerXlocation,ShareVar.managerYlocation,ShareVar.managerXsize,ShareVar.managerYsize);		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		
		JLabel lblManagerBackGround = new JLabel("");
		lblManagerBackGround.setIcon(new ImageIcon(MovieDaySalesStatus.class.getResource("/com/javaproject/image/manager_background.png")));
		lblManagerBackGround.setBounds(0, 0, 800, 572);
		contentPanel.add(lblManagerBackGround);
		
	}
	
	
	private JLabel getLblNewLabel() {
		if(lblNewLabel == null) {
			lblNewLabel = new JLabel("일별 매출 현황");
			lblNewLabel.setFont(new Font("BM Dohyeon", Font.PLAIN, 30));
			lblNewLabel.setBounds(298, 27, 215, 63);
			contentPanel.add(lblNewLabel);
		}
		return lblNewLabel;
	}
		
}