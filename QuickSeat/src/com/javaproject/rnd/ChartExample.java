package com.javaproject.rnd;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;


	// 차트에 대한 rnd, 일단은 선그래프만 나오지만 bar그래프로 바꿀 수도 있게 해볼 예정
public class ChartExample extends JFrame {
    private static final long serialVersionUID = 1L;

	public ChartExample(String title) {
        super(title);

        // 그래프 생성
        JFreeChart chart = createChart(createDataset());

        // 그래프를 패널에 추가
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); // DefaultCategoryDataset이 아닌 다른 Class를 고르면 dataset표현방법을 바꿀 수 있음.

        // 데이터 추가
        dataset.addValue(1.0, "Series1", "Category1");
        dataset.addValue(4.0, "Series1", "Category2");
        dataset.addValue(3.0, "Series1", "Category3");
        dataset.addValue(5.0, "Series1", "Category4");

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        return ChartFactory.createLineChart(
                "Line Chart Example",     // 차트 제목
                "Category",               // X 축 레이블
                "Value",                  // Y 축 레이블
                dataset                   // 데이터셋
        );
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        ChartExample frame = new ChartExample("JFreeChart Example");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
