package com.javaproject.manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.data.category.DefaultCategoryDataset;

import com.javaproject.base.ShareVar;
import com.javaproject.managerfunction.DaoUserStatistics;
import com.javaproject.managerfunction.DtoWDH;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	private JComboBox cbYearDailyRevenue;
	private JComboBox cbYearTypeStatistics;
	private JComboBox cbYearAgeStatistics;
	private JButton btnMonthlyRevenue;
	private JButton btnDailyRevenue;
	private JButton btnAgeStatistics;
	private JButton btnTypeStatistics;
	private JComboBox cbMonthDailyRevenue;
	private JComboBox cbMonthAgeStatistics;
	private JComboBox cbMonthTypeStatistics;
	private JLabel lblNewLabel_3;
	private int startYear = 2020;

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				addCbItemYear();
				settingCbYearMonth();
			}
		});
		setTitle("사용자 통계");
		setBounds(ShareVar.managerXlocation + 100, ShareVar.managerYlocation, ShareVar.managerXsize,
				ShareVar.managerYsize);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel_2());
		contentPanel.add(getLblNewLabel_1_1());
		contentPanel.add(getCbMonthlyRevenue());
		contentPanel.add(getCbYearDailyRevenue());
		contentPanel.add(getCbYearTypeStatistics());
		contentPanel.add(getCbYearAgeStatistics());
		contentPanel.add(getBtnMonthlyRevenue());
		contentPanel.add(getBtnDailyRevenue());
		contentPanel.add(getBtnAgeStatistics());
		contentPanel.add(getBtnTypeStatistics());
		contentPanel.add(getCbMonthDailyRevenue());
		contentPanel.add(getCbMonthAgeStatistics());
		contentPanel.add(getCbMonthTypeStatistics());
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
			cbMonthlyRevenue.setBounds(105, 150, 170, 40);
		}
		return cbMonthlyRevenue;
	}

	private JComboBox getCbYearDailyRevenue() {
		if (cbYearDailyRevenue == null) {
			cbYearDailyRevenue = new JComboBox();
			cbYearDailyRevenue.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			cbYearDailyRevenue.setBounds(465, 150, 90, 40);
		}
		return cbYearDailyRevenue;
	}

	private JComboBox getCbYearTypeStatistics() {
		if (cbYearTypeStatistics == null) {
			cbYearTypeStatistics = new JComboBox();
			cbYearTypeStatistics.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			cbYearTypeStatistics.setBounds(480, 390, 90, 40);
		}
		return cbYearTypeStatistics;
	}

	private JComboBox getCbYearAgeStatistics() {
		if (cbYearAgeStatistics == null) {
			cbYearAgeStatistics = new JComboBox();
			cbYearAgeStatistics.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			cbYearAgeStatistics.setBounds(90, 390, 90, 40);
		}
		return cbYearAgeStatistics;
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

	private JComboBox getCbMonthDailyRevenue() {
		if (cbMonthDailyRevenue == null) {
			cbMonthDailyRevenue = new JComboBox();
			cbMonthDailyRevenue.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			cbMonthDailyRevenue.setModel(new DefaultComboBoxModel(new String[] { "01월 매출", "02월 매출", "03월 매출", "04월 매출",
					"05월 매출", "06월 매출", "07월 매출", "08월 매출", "09월 매출", "10월 매출", "11월 매출", "12월 매출" }));
			cbMonthDailyRevenue.setBounds(567, 150, 138, 40);
		}
		return cbMonthDailyRevenue;
	}

	private JComboBox getCbMonthAgeStatistics() {
		if (cbMonthAgeStatistics == null) {
			cbMonthAgeStatistics = new JComboBox();
			cbMonthAgeStatistics.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			cbMonthAgeStatistics.setModel(new DefaultComboBoxModel(new String[] { "01월 현황", "02월 현황", "03월 현황",
					"04월 현황", "05월 현황", "06월 현황", "07월 현황", "08월 현황", "09월 현황", "10월 현황", "11월 현황", "12월 현황" }));
			cbMonthAgeStatistics.setBounds(192, 390, 138, 40);
		}
		return cbMonthAgeStatistics;
	}

	private JComboBox getCbMonthTypeStatistics() {
		if (cbMonthTypeStatistics == null) {
			cbMonthTypeStatistics = new JComboBox();
			cbMonthTypeStatistics.setModel(new DefaultComboBoxModel(new String[] { "01월 현황", "02월 현황", "03월 현황",
					"04월 현황", "05월 현황", "06월 현황", "07월 현황", "08월 현황", "09월 현황", "10월 현황", "11월 현황", "12월 현황" }));
			cbMonthTypeStatistics.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			cbMonthTypeStatistics.setBounds(582, 390, 138, 40);
		}
		return cbMonthTypeStatistics;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(
					MovieUserStatistics.class.getResource("/com/javaproject/image/manager_background.png")));
			lblNewLabel_3.setBounds(0, 0, 800, 572);
		}
		return lblNewLabel_3;
	}

	// --- Field ---
	// 월별 매출 현황에서 연도를 선택 후 차트보기를 눌르면 차트를 띄움
	private void showMonthlyRevenue() {

		// 콤보박스에서 연도만 따와서 ShareVar.year에 넣어줌
		ShareVar.year = cbMonthlyRevenue.getSelectedItem().toString().substring(2, 4);

		// 월별 매출 현황 차트를 띄워줌
		MovieMonthSalesStatus movieMonthSalesStatus = new MovieMonthSalesStatus();
		movieMonthSalesStatus.setVisible(true);

	}

	// 일별 매출 현황에서 연도와 달을 선택 후 차트보기를 누르면 차트를 띄움
	private void showDailyRevenue() {

		// 콤보박스에서 연도와 달만 따와서 ShareVar.year와 ShareVar.month를 넣어줌
		ShareVar.year = cbYearDailyRevenue.getSelectedItem().toString().substring(2, 4);
		ShareVar.month = cbMonthDailyRevenue.getSelectedItem().toString().substring(0, 2);

		// 일별 매출 현황 차트를 띄워줌
		MovieDaySalesStatus movieDaySalesStatus = new MovieDaySalesStatus();
		movieDaySalesStatus.setVisible(true);

	}

	// 연령별 사용자 통계에서 연도와 달을 선택 후 차트보기를 누르면 차트를 띄움
	private void showAgeStatistics() {

		// 콤보박스에서 연도만 따와서 ShareVar.year에 넣어줌
		ShareVar.year = cbYearAgeStatistics.getSelectedItem().toString().substring(2, 4);
		ShareVar.month = cbMonthAgeStatistics.getSelectedItem().toString().substring(0, 2);

		// 연령별 사용자 통계를 띄워줌
		AgeStatisticsChart movieMonthSalesStatus = new AgeStatisticsChart();
		movieMonthSalesStatus.setVisible(true);

	}

	// 유형별 사용자 통계에서 연도와 달을 선택 후 차트보기를 누르면 차트를 띄움
	private void showTypeStatistics() {

		// 콤보박스에서 연도만 따와서 ShareVar.year에 넣어줌
		ShareVar.year = cbYearTypeStatistics.getSelectedItem().toString().substring(2, 4);
		ShareVar.month = cbMonthDailyRevenue.getSelectedItem().toString().substring(0, 2);

		// 유형별 사용자 통계를 띄워줌
		TypeStatistics movieMonthSalesStatus = new TypeStatistics();
		movieMonthSalesStatus.setVisible(true);

	}

	// 월별 매출, 일별 매출, 연령별 통계, 타입별 통계의 년도 콤보박스를 2020년부터 현재 년도까지로 설정
	private void addCbItemYear() {
		// 현재 년도를 받아온 후 int값으로 변환
		int currentYear = Integer.parseInt(Year.now().toString());
		// 2020년부터 현재 년도까지 콤보박스에 추가
		for (int i = startYear; i <= currentYear; i++) {
			cbMonthlyRevenue.addItem(i + "년 매출");
			cbYearDailyRevenue.addItem(i);
			cbYearAgeStatistics.addItem(i);
			cbYearTypeStatistics.addItem(i);
		}
	}

	// 콤보박스들의 초기값을 현재 년도와 월로 설정
	private void settingCbYearMonth() {
		// 현재 년도와 월을 받아온 후 int값으로 변환
		int currentYear = Integer.parseInt(Year.now().toString());
		int currentMonth = LocalDate.now().getMonthValue();

		// 현재 년도에서 2020을 빼서 index값을 설정 (index는 0부터 시작하므로)
		cbMonthlyRevenue.setSelectedIndex(currentYear - startYear);
		cbYearDailyRevenue.setSelectedIndex(currentYear - startYear);
		cbYearAgeStatistics.setSelectedIndex(currentYear - startYear);
		cbYearTypeStatistics.setSelectedIndex(currentYear - startYear);

		// 현재 달을 index값으로 설정
		cbMonthDailyRevenue.setSelectedIndex(currentMonth - 1);
		cbMonthAgeStatistics.setSelectedIndex(currentMonth - 1);
		cbMonthTypeStatistics.setSelectedIndex(currentMonth - 1);
	}

} // End