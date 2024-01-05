package com.javaproject.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;

public class MovieSalesStatus extends JDialog {
	
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MovieSalesStatus dialog = new MovieSalesStatus();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MovieSalesStatus() {
		setTitle("매출 현황");
		setBounds(ShareVar.managerXlocation,ShareVar.managerYlocation,ShareVar.managerXsize,ShareVar.managerYsize);		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	}

}
