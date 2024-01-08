package com.javaproject.manager;

import java.awt.EventQueue;

import javax.swing.JDialog;

import com.javaproject.base.ShareVar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MovieMonthSalesStatus extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieMonthSalesStatus dialog = new MovieMonthSalesStatus();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public MovieMonthSalesStatus() {
		setTitle("월별 매출 현황");
		setBounds(ShareVar.managerXlocation, ShareVar.managerYlocation, ShareVar.managerXsize, ShareVar.managerYsize);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel());

	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("월별 매출 현황");
			lblNewLabel_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 30));
			lblNewLabel_1.setBounds(298, 27, 257, 50);
		}
		return lblNewLabel_1;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(MovieMonthSalesStatus.class.getResource("/com/javaproject/image/manager_background.png")));
			lblNewLabel.setBounds(0, 0, 800, 575);
		}
		return lblNewLabel;
	}
}
