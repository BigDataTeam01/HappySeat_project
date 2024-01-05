package com.javaproject.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerLogin extends JDialog {
	
	/*
	 * Descritipon : 관리자가 관리페이지로 접속하기 위해 아이디와 패스워드를 입력해 관리자 Table과 비교하여 메인페이지로 이동
	 * 
	 * Author : Lcy, Wdh
	 * 
	 * Date : 2024-01-05 , 16:07
	 */

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	
	static ManagerLogin loginDialog = new ManagerLogin();
	static ManagerMain mainDialog = new ManagerMain();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			loginDialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManagerLogin() {
		setTitle("관리자 로그인");
		setBounds(ShareVar.managerXlocation,ShareVar.managerYlocation,ShareVar.managerXsize,ShareVar.managerYsize);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getBtnNewButton());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("관리자번호  :");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 17));
			lblNewLabel.setBounds(72, 140, 153, 57);
		}
		return lblNewLabel;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("접속");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					goToMain();
				}
			});
			btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
			btnNewButton.setBounds(313, 455, 174, 71);
		}
		return btnNewButton;
	}
	
	
	// ================================================ Functions =========================================================================
	
	private void goToMain() {
		loginDialog.setVisible(false);
		loginDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		mainDialog.setVisible(true);
	}
	
	
	
} // End
