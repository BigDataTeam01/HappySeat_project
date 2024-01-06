package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SelectPayment extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/*
	 * Description : 1. SelectPayment에서 첫화면 버튼을 터치했을시  SelectMenu화면으로 이동
	 * 				 2. SelectPayment에서 이전화면 버튼을 터치했을시 ConfirmSeat화면으로 이동
	 * 				 3. SelectPayment에서 현금결제 버튼을 터치했을시  Cash화면으로 이동
	 * 				 4. SelectPayment에서 문화누리카드 버튼을 터치했을시  Card화면으로 이동
	 * 				 5. SelectPayment에서 신용카드 버튼을 터치했을시  Card화면으로 이동
	 * Date : 2024.01.06 (토요일)
	 * Author : 박정민,박지환
	 * 
	 * Update 2024.01.06 by J.Park:
	 * 			1. 클라스 이름 SelectPayment로 변경
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SelectPayment dialog = new SelectPayment();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectPayment() {
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
