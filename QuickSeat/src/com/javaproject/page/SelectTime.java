package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SelectTime extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 1. SelectTime에서 이전화면 버튼을 터치했을시 SelectCinema 화면으로 이동
	 * 				 2. SelectTime에서 영화시간 버튼 터치시  SelectHeadCount 화면으로 이동
	 * 				 3. SelectTime에서 첫화면 버튼을 터치했을시  SelectMenu화면으로 이동
	 * 				 4. SelectTime에서 이전시간,다음시간 버튼을 터치했을시 settext로 다음,이전 데이터를 보여줌
	 * 	
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환
	 * 
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SelectTime dialog = new SelectTime();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectTime() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
