package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Page01_Splash extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	/*
	 * Description: 스플래쉬 화면
	 * Date: 2024.01.14
	 * Author : D Forrest Park
	 * 
	 * Update 2024.01.14 by PDG
	 * 	o	1. 행복좌석으로 바꿈
	 * 	o	2. 전체적으로 프로그램 손봄. 
	 * 
	 * 
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Page01_Splash dialog = new Page01_Splash();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			ShareVar sharevar = new ShareVar();
			sharevar.shareVarInint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page01_Splash() {
		setBounds(ShareVar.kiosk_loc_x, ShareVar.kiosk_loc_y, ShareVar.kiosk_width,ShareVar.kiosk_hight);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			goMainAction();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Page01_Splash.class.getResource("/com/javaproject/image/HappySeatBackGround.png")));
		lblNewLabel.setBounds(0, -28, 800, 600);
		contentPanel.add(lblNewLabel);
	}
	
	/// Functions
	private void goMainAction() {
		
		Page02_SelectMenu selectMenue = new Page02_SelectMenu();
		
		selectMenue.setVisible(true);
		this.setVisible(false);
		this.dispose();
	
		
	}
	
}// END
