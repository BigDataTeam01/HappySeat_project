package com.javaproject.page;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.javaproject.base.ShareVar;
import com.javaproject.kioskFunction.ButtonDesign_ver1;
import com.javaproject.kioskFunction.Dao_PJH;
import com.javaproject.kioskFunction.Dto_PJH;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Page05_1_Movie_Plot extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JEditorPane editor_plot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Page05_1_Movie_Plot dialog = new Page05_1_Movie_Plot();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Page05_1_Movie_Plot() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				show_Plot();
			}
		});
		setBounds(ShareVar.kiosk_loc_x + 160, ShareVar.kiosk_loc_y + 100, 500, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getScrollPane());
		contentPanel.add(getBtnNewButton());
		contentPanel.add(getLblNewLabel_1());
		contentPanel.add(getLblNewLabel());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Page05_1_Movie_Plot.class.getResource("/com/javaproject/image/plotBackground.png")));
			lblNewLabel.setBounds(0, 0, 500, 400);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("영화 줄거리");
			lblNewLabel_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 25));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(0, 10, 500, 40);
		}
		return lblNewLabel_1;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 59, 480, 256);
			scrollPane.setViewportView(getEditor_plot());
		}
		return scrollPane;
	}
	private JEditorPane getEditor_plot() {
		if (editor_plot == null) {
			editor_plot = new JEditorPane();
			editor_plot.setEditable(false);
			editor_plot.setFont(new Font("BM Dohyeon", Font.PLAIN, 15));
		}
		return editor_plot;
	}
	private JButton getBtnNewButton() {
		ButtonDesign_ver1 customButton = new ButtonDesign_ver1("닫 기", ShareVar.btnFillColor);
		customButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 18));
		customButton.setForeground(ShareVar.btnTextColor);
		customButton.setBounds(200,320 , 100, 40);
		customButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				plot_Closed();
				
			}
		});
		return customButton;
	}
	private void show_Plot() {
		
		String movie_title = ShareVar.selectedMovieTitle;
		Dao_PJH dao = new Dao_PJH(movie_title);
		ArrayList<Dto_PJH> dtolist = dao.movie_Info();
		editor_plot.setText(dtolist.get(0).getMovie_desc());
	}
	
	private void plot_Closed() {
		this.setVisible(false);
		this.dispose();
		
	}
	
}
