package com.javaproject.rnd;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;

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

// 차트에 대한 rnd, 일단은 선그래프만 나오지만 bar그래프로 바꿀 수도 있게 해볼 예정
public class ChartExample extends JFrame {
	private static final long serialVersionUID = 1L;

	public ChartExample(String title) {
		super(title);

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

		// 차트 렌더러(Renderer)를 가져와서 값 표시 설정
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
		DefaultCategoryDataset dataset = new DefaultCategoryDataset(); // DefaultCategoryDataset이 아닌 다른 Class를 고르면
																		// dataset 표현방법을 바꿀 수 있음.

		// 데이터 추가
		
//		dataset.addValue(3.0, "전년도", "1월");
//		dataset.addValue(13.0, "이번년도", "1월");
//		dataset.addValue(33.0, "전년도", "2월");
//		dataset.addValue(23.0, "이번년도", "2월");
//		dataset.addValue(13.0, "전년도", "3월");
//		dataset.addValue(43.0, "이번년도", "3월");
//		dataset.addValue(33.0, "전년도", "4월");
//		dataset.addValue(53.0, "이번년도", "4월");
//		dataset.addValue(73.0, "전년도", "5월");
//		dataset.addValue(63.0, "이번년도", "5월");
//		dataset.addValue(93.0, "전년도", "6월");
//		dataset.addValue(83.0, "이번년도", "6월");
//		dataset.addValue(23.0, "전년도", "7월");
//		dataset.addValue(43.0, "이번년도", "7월");
//		dataset.addValue(13.0, "전년도", "8월");
//		dataset.addValue(53.0, "이번년도", "8월");
//		dataset.addValue(3.0, "전년도", "9월");
//		dataset.addValue(63.0, "이번년도", "9월");
//		dataset.addValue(43.0, "전년도", "10월");
//		dataset.addValue(33.0, "이번년도", "10월");
//		dataset.addValue(23.0, "전년도", "11월");
//		dataset.addValue(33.0, "이번년도", "11월");
//		dataset.addValue(53.0, "전년도", "12월");
//		dataset.addValue(23.0, "이번년도", "12월");
		DaoChartExample dao = new DaoChartExample();
		ArrayList<DtoChartExample> dto = dao.pricePerDay();
		// 1주일 단위로 표 만들기
		for(int i = 6; i >= 0; i--) {
			int date = 17-i;
			String day = "07" + "-" + Integer.toString(date);
			int sumPrice = 0;
			
			// 가져온 day와 현재 day가 일치할 경우 sumPrice에 가격 추가
			for(int j = 0; j < dto.size(); j++) {
				String day1 = dto.get(j).getResv_date().substring(3,8);
				if(day1.equals(day)) {
					sumPrice += dto.get(j).getTicket_price();
				}
			}
			dataset.addValue(sumPrice, "이번년도", day);
		}

		return dataset;
	}

	private JFreeChart createChart(CategoryDataset dataset) {
		return ChartFactory.createBarChart("일별 매출 현황", // 차트 제목
				"", // X 축 레이블
				"만원", // Y 축 레이블
				dataset // 데이터셋
		);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			createAndShowGUI();
		});
	}

	private static void createAndShowGUI() {
		ChartExample frame = new ChartExample("일별 매출 현황");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
