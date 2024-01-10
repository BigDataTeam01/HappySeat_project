package com.javaproject.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import com.javaproject.managerfunction.DaoUserStatistics;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MovieUserStatistics extends JDialog {

	/*
	 * Descritipon : 1. DB에서 customer Table의 고객유형과 reserve Table의 seq와 screen Table의
	 * scr_start_time를 가져와 유형별 사용자 통계를 차트로 보여줌 2. DB에서 customer Table의 연령대와 reserve
	 * Table의 seq와 screen Table의 scr_start_time를 가져와 연령별 사용자 통계를 차트로 보여줌
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
	private JLabel lblNewLabel_1_1;
	private JComboBox cbMonthlyRevenue;
	private JComboBox cbDailyRevenue;
	private JComboBox cbTypeStatistics;
	private JComboBox cbAgeStatistics;
	private JButton btnMonthlyRevenue;
	private JButton btnDailyRevenue;
	private JButton btnAgeStatistics;
	private JButton btnTypeStatistics;
	private JLabel lblNewLabel_3;

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
		setBounds(ShareVar.managerXlocation, ShareVar.managerYlocation, ShareVar.managerXsize, ShareVar.managerYsize);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLblNewLabel_1_1());
		contentPanel.add(getCbMonthlyRevenue());
		contentPanel.add(getCbDailyRevenue());
		contentPanel.add(getCbTypeStatistics());
		contentPanel.add(getCbAgeStatistics());
		contentPanel.add(getBtnMonthlyRevenue());
		contentPanel.add(getBtnDailyRevenue());
		contentPanel.add(getBtnAgeStatistics());
		contentPanel.add(getBtnTypeStatistics());
		contentPanel.add(getLblNewLabel_3());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("월별 매출 현황");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("BM Dohyeon", Font.PLAIN, 35));
			lblNewLabel.setBounds(65, 60, 250, 80);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("일별 매출 현황");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 35));
			lblNewLabel_1.setBounds(455, 60, 250, 80);
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("연령별 사용자 통계");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 35));
			lblNewLabel_2.setBounds(30, 300, 330, 80);
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("유형별 사용자 통계");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 35));
			lblNewLabel_1_1.setBounds(420, 300, 330, 80);
		}
		return lblNewLabel_1_1;
	}

	private JComboBox getCbMonthlyRevenue() {
		if (cbMonthlyRevenue == null) {
			cbMonthlyRevenue = new JComboBox();
			cbMonthlyRevenue.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			cbMonthlyRevenue.setModel(new DefaultComboBoxModel(new String[] { "2024년 매출" }));
			cbMonthlyRevenue.setBounds(105, 150, 170, 40);
		}
		return cbMonthlyRevenue;
	}

	private JComboBox getCbDailyRevenue() {
		if (cbDailyRevenue == null) {
			cbDailyRevenue = new JComboBox();
			cbDailyRevenue.setModel(new DefaultComboBoxModel(new String[] {"2024년 06월 매출", "2024년 07월 매출"}));
			cbDailyRevenue.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			cbDailyRevenue.setBounds(480, 150, 210, 40);
		}
		return cbDailyRevenue;
	}

	private JComboBox getCbTypeStatistics() {
		if (cbTypeStatistics == null) {
			cbTypeStatistics = new JComboBox();
			cbTypeStatistics.setModel(new DefaultComboBoxModel(new String[] { "2024년 7월 통계" }));
			cbTypeStatistics.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			cbTypeStatistics.setBounds(480, 390, 210, 40);
		}
		return cbTypeStatistics;
	}

	private JComboBox getCbAgeStatistics() {
		if (cbAgeStatistics == null) {
			cbAgeStatistics = new JComboBox();
			cbAgeStatistics.setModel(new DefaultComboBoxModel(new String[] {"2024년 07월 통계"}));
			cbAgeStatistics.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			cbAgeStatistics.setBounds(90, 390, 210, 40);
		}
		return cbAgeStatistics;
	}

	private JButton getBtnMonthlyRevenue() {
		if (btnMonthlyRevenue == null) {
			btnMonthlyRevenue = new JButton("차트 보기");
			btnMonthlyRevenue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showMonthlyRevenue();
				}
			});
			btnMonthlyRevenue.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			btnMonthlyRevenue.setBounds(125, 220, 136, 40);
		}
		return btnMonthlyRevenue;
	}

	private JButton getBtnDailyRevenue() {
		if (btnDailyRevenue == null) {
			btnDailyRevenue = new JButton("차트 보기");
			btnDailyRevenue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showDailyRevenue();
				}
			});
			btnDailyRevenue.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			btnDailyRevenue.setBounds(509, 220, 136, 40);
		}
		return btnDailyRevenue;
	}

	private JButton getBtnAgeStatistics() {
		if (btnAgeStatistics == null) {
			btnAgeStatistics = new JButton("차트 보기");
			btnAgeStatistics.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showAgeStatistics();
				}
			});
			btnAgeStatistics.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			btnAgeStatistics.setBounds(125, 460, 136, 40);
		}
		return btnAgeStatistics;
	}

	private JButton getBtnTypeStatistics() {
		if (btnTypeStatistics == null) {
			btnTypeStatistics = new JButton("차트 보기");
			btnTypeStatistics.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showTypeStatistics();
				}
			});
			btnTypeStatistics.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			btnTypeStatistics.setBounds(509, 460, 136, 40);
		}
		return btnTypeStatistics;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setIcon(new ImageIcon(
					MovieUserStatistics.class.getResource("/com/javaproject/image/manager_background.png")));
			lblNewLabel_3.setBounds(0, 0, 800, 572);
		}
		return lblNewLabel_3;
	}

	// --- Field ---
	private void showMonthlyRevenue() {
		
		ShareVar.year = cbMonthlyRevenue.getSelectedItem().toString().substring(2, 4);
		
		MovieMonthSalesStatus movieMonthSalesStatus = new MovieMonthSalesStatus();
		movieMonthSalesStatus.setVisible(true);

	}

	private void showDailyRevenue() {
		
		ShareVar.year = cbDailyRevenue.getSelectedItem().toString().substring(2, 4);
		ShareVar.month = cbDailyRevenue.getSelectedItem().toString().substring(6, 8);
		
		MovieDaySalesStatus movieDaySalesStatus = new MovieDaySalesStatus();
		movieDaySalesStatus.setVisible(true);
		
	}
	
	private void showAgeStatistics() {
		
		ShareVar.year = cbAgeStatistics.getSelectedItem().toString().substring(2, 4);
		
		AgeStatisticsChart movieMonthSalesStatus = new AgeStatisticsChart();
		movieMonthSalesStatus.setVisible(true);

	}
	
	private void showTypeStatistics() {
		
		ShareVar.year = cbTypeStatistics.getSelectedItem().toString().substring(2, 4);
		
		TypeStatistics movieMonthSalesStatus = new TypeStatistics();
		movieMonthSalesStatus.setVisible(true);

		
	}

} // End