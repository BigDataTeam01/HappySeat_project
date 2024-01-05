package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SelectSeat extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	/*
	 * Description : 1. SelecSeat에서 이전화면 버튼을 터치했을시 SelectHeadCount 화면으로 이동
	 * 				 2. SelecSeat에서 좌석확정 버튼을 터치했을시 예매된 좌석이면 "이미 예매된 좌석입니다." ShowMessageDialog 화면을 띄운다(추후의 변경예정)
	 * 				 3. SelecSeat에서 좌석확정 버튼을 터치했을시 예매가능한 좌석이면 ConfirmSeat화면으로 이동
	 * 				 4. SelecSeat에서 첫화면 버튼을 터치했을시  SelectMenu화면으로 이동
	 * 				 5. SelecSeat에서 선택 가능좌석 버튼 클릭시  버튼색이 바뀜 
	 * Date : 2024.01.05 (금요일)
	 * Author : 박정민,박지환
	 * 
	 */
	/**
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SelectSeat dialog = new SelectSeat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelectSeat() {
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
