package com.javaproject.manager;

import java.awt.EventQueue;

import javax.swing.JDialog;

import com.javaproject.base.ShareVar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class ScreenControl extends JDialog {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_1;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1_1;
	private JComboBox comboBox_1;
	private JLabel lblNewLabel_1_1_1;
	private JComboBox comboBox_1_1;
	private JLabel lblNewLabel_1_1_2;
	private JComboBox comboBox_1_1_1;
	private JLabel lblNewLabel_1_1_2_1;
	private JComboBox comboBox_1_1_2;
	private JLabel lblNewLabel_1_1_2_2;
	private JComboBox comboBox_1_1_3;
	private JLabel lblNewLabel_1_1_2_3;
	private JComboBox comboBox_1_1_4;
	private JLabel lblNewLabel_1_1_2_4;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1_1_1;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1_1_2_4_1;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JComboBox comboBox_2;
	private JTable table;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenControl dialog = new ScreenControl();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ScreenControl() {
		setTitle("상영관 관리");
		setBounds(ShareVar.managerXlocation, ShareVar.managerYlocation, ShareVar.managerXsize, ShareVar.managerYsize);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getRdbtnNewRadioButton());
		getContentPane().add(getRdbtnNewRadioButton_1());
		getContentPane().add(getRdbtnNewRadioButton_2());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getComboBox());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getComboBox_1());
		getContentPane().add(getLblNewLabel_1_1_1());
		getContentPane().add(getComboBox_1_1());
		getContentPane().add(getLblNewLabel_1_1_2());
		getContentPane().add(getComboBox_1_1_1());
		getContentPane().add(getLblNewLabel_1_1_2_1());
		getContentPane().add(getComboBox_1_1_2());
		getContentPane().add(getLblNewLabel_1_1_2_2());
		getContentPane().add(getComboBox_1_1_3());
		getContentPane().add(getLblNewLabel_1_1_2_3());
		getContentPane().add(getComboBox_1_1_4());
		getContentPane().add(getLblNewLabel_1_1_2_4());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_1_1_1_1());
		getContentPane().add(getTextField());
		getContentPane().add(getTextField_1());
		getContentPane().add(getLblNewLabel_1_1_2_4_1());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getScrollPane());
		getContentPane().add(getComboBox_2());
		getContentPane().add(getLblNewLabel_3());

	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("상영관 관리");
			lblNewLabel.setFont(new Font("BM Dohyeon", Font.PLAIN, 30));
			lblNewLabel.setBounds(311, 20, 216, 53);
		}
		return lblNewLabel;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("등록");
			rdbtnNewRadioButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			rdbtnNewRadioButton.setSelected(true);
			buttonGroup.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setBounds(32, 99, 60, 23);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("수정");
			rdbtnNewRadioButton_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			buttonGroup.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.setBounds(104, 99, 60, 23);
		}
		return rdbtnNewRadioButton_1;
	}
	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("삭제");
			rdbtnNewRadioButton_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			buttonGroup.add(rdbtnNewRadioButton_2);
			rdbtnNewRadioButton_2.setBounds(176, 99, 60, 23);
		}
		return rdbtnNewRadioButton_2;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("상영관  :");
			lblNewLabel_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(42, 149, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			comboBox.setBounds(115, 145, 105, 27);
		}
		return comboBox;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("영화 제목  :");
			lblNewLabel_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1.setBounds(42, 196, 65, 16);
		}
		return lblNewLabel_1_1;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			comboBox_1.setBounds(115, 192, 105, 27);
		}
		return comboBox_1;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("영화 상영 시작 시간");
			lblNewLabel_1_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_1.setBounds(33, 260, 151, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JComboBox getComboBox_1_1() {
		if (comboBox_1_1 == null) {
			comboBox_1_1 = new JComboBox();
			comboBox_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"2024"}));
			comboBox_1_1.setBounds(32, 288, 85, 27);
		}
		return comboBox_1_1;
	}
	private JLabel getLblNewLabel_1_1_2() {
		if (lblNewLabel_1_1_2 == null) {
			lblNewLabel_1_1_2 = new JLabel("년");
			lblNewLabel_1_1_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_2.setBounds(115, 292, 24, 16);
		}
		return lblNewLabel_1_1_2;
	}
	private JComboBox getComboBox_1_1_1() {
		if (comboBox_1_1_1 == null) {
			comboBox_1_1_1 = new JComboBox();
			comboBox_1_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
			comboBox_1_1_1.setBounds(129, 288, 70, 27);
		}
		return comboBox_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_2_1() {
		if (lblNewLabel_1_1_2_1 == null) {
			lblNewLabel_1_1_2_1 = new JLabel("월");
			lblNewLabel_1_1_2_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_2_1.setBounds(200, 292, 24, 16);
		}
		return lblNewLabel_1_1_2_1;
	}
	private JComboBox getComboBox_1_1_2() {
		if (comboBox_1_1_2 == null) {
			comboBox_1_1_2 = new JComboBox();
			comboBox_1_1_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			comboBox_1_1_2.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			comboBox_1_1_2.setBounds(222, 288, 70, 27);
		}
		return comboBox_1_1_2;
	}
	private JLabel getLblNewLabel_1_1_2_2() {
		if (lblNewLabel_1_1_2_2 == null) {
			lblNewLabel_1_1_2_2 = new JLabel("일");
			lblNewLabel_1_1_2_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_2_2.setBounds(292, 292, 24, 16);
		}
		return lblNewLabel_1_1_2_2;
	}
	private JComboBox getComboBox_1_1_3() {
		if (comboBox_1_1_3 == null) {
			comboBox_1_1_3 = new JComboBox();
			comboBox_1_1_3.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			comboBox_1_1_3.setModel(new DefaultComboBoxModel(new String[] {"06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
			comboBox_1_1_3.setBounds(32, 327, 70, 27);
		}
		return comboBox_1_1_3;
	}
	private JLabel getLblNewLabel_1_1_2_3() {
		if (lblNewLabel_1_1_2_3 == null) {
			lblNewLabel_1_1_2_3 = new JLabel("시");
			lblNewLabel_1_1_2_3.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_2_3.setBounds(103, 331, 24, 16);
		}
		return lblNewLabel_1_1_2_3;
	}
	private JComboBox getComboBox_1_1_4() {
		if (comboBox_1_1_4 == null) {
			comboBox_1_1_4 = new JComboBox();
			comboBox_1_1_4.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			comboBox_1_1_4.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
			comboBox_1_1_4.setBounds(128, 327, 70, 27);
		}
		return comboBox_1_1_4;
	}
	private JLabel getLblNewLabel_1_1_2_4() {
		if (lblNewLabel_1_1_2_4 == null) {
			lblNewLabel_1_1_2_4 = new JLabel("분");
			lblNewLabel_1_1_2_4.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_2_4.setBounds(199, 331, 24, 16);
		}
		return lblNewLabel_1_1_2_4;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("설정 시각 : ");
			lblNewLabel_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(32, 371, 74, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("영화 상영 시간  :");
			lblNewLabel_1_1_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_1_1.setBounds(32, 438, 107, 16);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			textField.setEditable(false);
			textField.setText("2024년 01월 01일 06시 00분");
			textField.setBounds(111, 366, 192, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			textField_1.setText("90");
			textField_1.setColumns(10);
			textField_1.setBounds(145, 431, 51, 26);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel_1_1_2_4_1() {
		if (lblNewLabel_1_1_2_4_1 == null) {
			lblNewLabel_1_1_2_4_1 = new JLabel("분");
			lblNewLabel_1_1_2_4_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 14));
			lblNewLabel_1_1_2_4_1.setBounds(200, 438, 24, 16);
		}
		return lblNewLabel_1_1_2_4_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("완료");
			btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			btnNewButton.setBounds(115, 508, 121, 38);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(339, 134, 424, 412);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JComboBox getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox();
			comboBox_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1 상영관", "2 상영관", "3 상영관"}));
			comboBox_2.setBounds(339, 99, 105, 27);
		}
		return comboBox_2;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(ScreenControl.class.getResource("/com/javaproject/image/manager_background.png")));
			lblNewLabel_3.setBounds(0, 0, 800, 575);
		}
		return lblNewLabel_3;
	}
}
