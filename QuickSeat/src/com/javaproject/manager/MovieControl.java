package com.javaproject.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;

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


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

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
		setTitle("영화 등록 및 수정");
		setBounds(ShareVar.managerXlocation,ShareVar.managerYlocation,ShareVar.managerXsize,ShareVar.managerYsize);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	}

	// ================================================ Functions =========================================================================
	
	
	
} // End
