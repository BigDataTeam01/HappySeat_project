package com.javaproject.manager;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.javaproject.base.ShareVar;
import com.javaproject.managerfunction.DaoUserStatistics;
import com.javaproject.managerfunction.DtoWDH;

public class AgeStatisticsChart extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgeStatisticsChart frame = new AgeStatisticsChart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgeStatisticsChart() {
		
		setBounds(ShareVar.managerXlocation, ShareVar.managerYlocation, ShareVar.managerXsize, ShareVar.managerYsize);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		// 그래프 생성
		JFreeChart chart = createChart(createDataset());

		// 그래프를 패널에 추가
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
		setContentPane(chartPanel);

		Font font = new Font("BM Dohyeon", Font.PLAIN, 12); // 원하는 폰트 및 스타일 설정
		TextTitle chartTitle = chart.getTitle(); // 차트 제목 폰트 설정
		Font titleFont = new Font("BM Dohyeon", Font.PLAIN, 20); // 원하는 폰트 및 스타일 설정
		chartTitle.setFont(titleFont);

		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		// 차트 렌더러(Renderer)를 가져와서 값 표시 설정, 바 위에 숫자를 추가해주기 위해 필요
		BarRenderer renderer = (BarRenderer) plot.getRenderer();

		renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setDefaultItemLabelsVisible(true);

		// 값 표시 위치 설정
		renderer.setDefaultPositiveItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
		renderer.setDefaultNegativeItemLabelPosition(
				new ItemLabelPosition(ItemLabelAnchor.OUTSIDE6, TextAnchor.TOP_CENTER));

		// 값 표시 폰트 설정
		renderer.setDefaultItemLabelFont(font);

		NumberAxis yAxis = (NumberAxis) plot.getRangeAxis(); // Y축 폰트 설정
		yAxis.setTickLabelFont(font); // Y축 폰트 설정
		yAxis.setLabelFont(font);

		CategoryAxis xAxis = plot.getDomainAxis(); // X축 폰트 설정
		xAxis.setLabelFont(font);
		xAxis.setTickLabelFont(font);

		// 범례 폰트 설정
		LegendTitle legend = chart.getLegend();
		legend.setItemFont(font);

	}

	private CategoryDataset createDataset() {
		
		// DefaultCategoryDataset이 아닌 다른 Class를 고르면 dataset 표현방법을 바꿀 수 있음.
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// 데이터 추가
		DaoUserStatistics dao = new DaoUserStatistics();
		ArrayList<DtoWDH> dto = dao.ageUserStatistics();
		
		// 00부터 80까지
		for (int i = 0; i <= 80; i+=10) {
			String age = String.format("%02d", i);
			int sumPeople = 0;

			// 가져온 month와 현재 month가 일치할 경우 sumPeople에 인원 추가
			for (int j = 0; j < dto.size(); j++) {
				String ageDB = String.format("%02d", dto.get(j).getCust_age());
				if (ageDB.equals(age)) {
					sumPeople += dto.get(j).getAge_count();
				}
			}
			dataset.addValue(sumPeople, ShareVar.year + "년 " + ShareVar.month + "월", age);
		}

		return dataset;
	}

	private JFreeChart createChart(CategoryDataset dataset) {
		return ChartFactory.createBarChart("연령별 사용자 통계", // 차트 제목
				"", // X 축 레이블
				"명", // Y 축 레이블
				dataset // 데이터셋
		);
	}

}
