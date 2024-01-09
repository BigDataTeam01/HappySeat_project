package com.javaproject.manager;

import java.awt.EventQueue;

import javax.swing.JDialog;

import com.javaproject.base.ShareVar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

public class ScreenControl extends JDialog {
	
	private final DefaultTableModel outerTable = new DefaultTableModel(); // OuterTable 선언
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JRadioButton rbInsert;
	private JRadioButton rbUpdate;
	private JRadioButton rbDelete;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_1;
	private JComboBox cbScreenRoom;
	private JLabel lblNewLabel_1_1;
	private JComboBox cbMovieTitle;
	private JLabel lblNewLabel_1_1_1;
	private JComboBox cbYear;
	private JLabel lblNewLabel_1_1_2;
	private JComboBox cbMonth;
	private JLabel lblNewLabel_1_1_2_1;
	private JComboBox cbDate;
	private JLabel lblNewLabel_1_1_2_2;
	private JComboBox cbHour;
	private JLabel lblNewLabel_1_1_2_3;
	private JComboBox cbMinute;
	private JLabel lblNewLabel_1_1_2_4;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1_1_1;
	private JTextField tfStartTime;
	private JTextField tfRunTime;
	private JLabel lblNewLabel_1_1_2_4_1;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JComboBox cbScreenSelect;
	private JTable innerTable;
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cbYearAdd();
				screenTableInit();
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				cbYearClear();
			}
		});
		setTitle("상영관 관리");
		setBounds(ShareVar.managerXlocation, ShareVar.managerYlocation, ShareVar.managerXsize, ShareVar.managerYsize);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getRbInsert());
		getContentPane().add(getRbUpdate());
		getContentPane().add(getRbDelete());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getCbScreenRoom());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getCbMovieTitle());
		getContentPane().add(getLblNewLabel_1_1_1());
		getContentPane().add(getCbYear());
		getContentPane().add(getLblNewLabel_1_1_2());
		getContentPane().add(getCbMonth());
		getContentPane().add(getLblNewLabel_1_1_2_1());
		getContentPane().add(getCbDate());
		getContentPane().add(getLblNewLabel_1_1_2_2());
		getContentPane().add(getCbHour());
		getContentPane().add(getLblNewLabel_1_1_2_3());
		getContentPane().add(getCbMinute());
		getContentPane().add(getLblNewLabel_1_1_2_4());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_1_1_1_1());
		getContentPane().add(getTfStartTime());
		getContentPane().add(getTfRunTime());
		getContentPane().add(getLblNewLabel_1_1_2_4_1());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getScrollPane());
		getContentPane().add(getCbScreenSelect());
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
	private JRadioButton getRbInsert() {
		if (rbInsert == null) {
			rbInsert = new JRadioButton("등록");
			rbInsert.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			rbInsert.setSelected(true);
			buttonGroup.add(rbInsert);
			rbInsert.setBounds(32, 99, 60, 23);
		}
		return rbInsert;
	}
	private JRadioButton getRbUpdate() {
		if (rbUpdate == null) {
			rbUpdate = new JRadioButton("수정");
			rbUpdate.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			buttonGroup.add(rbUpdate);
			rbUpdate.setBounds(104, 99, 60, 23);
		}
		return rbUpdate;
	}
	private JRadioButton getRbDelete() {
		if (rbDelete == null) {
			rbDelete = new JRadioButton("삭제");
			rbDelete.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			buttonGroup.add(rbDelete);
			rbDelete.setBounds(176, 99, 60, 23);
		}
		return rbDelete;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("상영관  :");
			lblNewLabel_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1.setBounds(58, 149, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JComboBox getCbScreenRoom() {
		if (cbScreenRoom == null) {
			cbScreenRoom = new JComboBox();
			cbScreenRoom.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbScreenRoom.setBounds(131, 145, 105, 27);
		}
		return cbScreenRoom;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("영화 제목  :");
			lblNewLabel_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1.setBounds(42, 196, 77, 16);
		}
		return lblNewLabel_1_1;
	}
	private JComboBox getCbMovieTitle() {
		if (cbMovieTitle == null) {
			cbMovieTitle = new JComboBox();
			cbMovieTitle.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbMovieTitle.setBounds(131, 192, 105, 27);
		}
		return cbMovieTitle;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("영화 상영 시작 시간");
			lblNewLabel_1_1_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_1.setBounds(33, 260, 151, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JComboBox getCbYear() {
		if (cbYear == null) {
			cbYear = new JComboBox();
			cbYear.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbYear.setBounds(32, 288, 70, 27);
		}
		return cbYear;
	}
	private JLabel getLblNewLabel_1_1_2() {
		if (lblNewLabel_1_1_2 == null) {
			lblNewLabel_1_1_2 = new JLabel("년");
			lblNewLabel_1_1_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_2.setBounds(104, 292, 24, 16);
		}
		return lblNewLabel_1_1_2;
	}
	private JComboBox getCbMonth() {
		if (cbMonth == null) {
			cbMonth = new JComboBox();
			cbMonth.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
			cbMonth.setBounds(129, 288, 70, 27);
		}
		return cbMonth;
	}
	private JLabel getLblNewLabel_1_1_2_1() {
		if (lblNewLabel_1_1_2_1 == null) {
			lblNewLabel_1_1_2_1 = new JLabel("월");
			lblNewLabel_1_1_2_1.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_2_1.setBounds(200, 292, 24, 16);
		}
		return lblNewLabel_1_1_2_1;
	}
	private JComboBox getCbDate() {
		if (cbDate == null) {
			cbDate = new JComboBox();
			cbDate.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbDate.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDate.setBounds(222, 288, 70, 27);
		}
		return cbDate;
	}
	private JLabel getLblNewLabel_1_1_2_2() {
		if (lblNewLabel_1_1_2_2 == null) {
			lblNewLabel_1_1_2_2 = new JLabel("일");
			lblNewLabel_1_1_2_2.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_2_2.setBounds(292, 292, 24, 16);
		}
		return lblNewLabel_1_1_2_2;
	}
	private JComboBox getCbHour() {
		if (cbHour == null) {
			cbHour = new JComboBox();
			cbHour.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbHour.setModel(new DefaultComboBoxModel(new String[] {"06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
			cbHour.setBounds(32, 327, 70, 27);
		}
		return cbHour;
	}
	private JLabel getLblNewLabel_1_1_2_3() {
		if (lblNewLabel_1_1_2_3 == null) {
			lblNewLabel_1_1_2_3 = new JLabel("시");
			lblNewLabel_1_1_2_3.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			lblNewLabel_1_1_2_3.setBounds(103, 331, 24, 16);
		}
		return lblNewLabel_1_1_2_3;
	}
	private JComboBox getCbMinute() {
		if (cbMinute == null) {
			cbMinute = new JComboBox();
			cbMinute.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbMinute.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
			cbMinute.setBounds(128, 327, 70, 27);
		}
		return cbMinute;
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
	private JTextField getTfStartTime() {
		if (tfStartTime == null) {
			tfStartTime = new JTextField();
			tfStartTime.setFont(new Font("BM Dohyeon", Font.PLAIN, 13));
			tfStartTime.setEditable(false);
			tfStartTime.setText("2024년 01월 01일 06시 00분");
			tfStartTime.setBounds(111, 366, 192, 26);
			tfStartTime.setColumns(10);
		}
		return tfStartTime;
	}
	private JTextField getTfRunTime() {
		if (tfRunTime == null) {
			tfRunTime = new JTextField();
			tfRunTime.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			tfRunTime.setText("90");
			tfRunTime.setColumns(10);
			tfRunTime.setBounds(145, 431, 51, 26);
		}
		return tfRunTime;
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
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNewButton.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			btnNewButton.setBounds(115, 508, 121, 38);
		}
		return btnNewButton;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(340, 134, 420, 412);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}
	private JComboBox getCbScreenSelect() {
		if (cbScreenSelect == null) {
			cbScreenSelect = new JComboBox();
			cbScreenSelect.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbScreenSelect.setModel(new DefaultComboBoxModel(new String[] {"1 상영관", "2 상영관", "3 상영관"}));
			cbScreenSelect.setBounds(339, 99, 105, 27);
		}
		return cbScreenSelect;
	}
	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		scrollPane.setViewportView(innerTable);
		return innerTable;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(ScreenControl.class.getResource("/com/javaproject/image/manager_background.png")));
			lblNewLabel_3.setBounds(0, 0, 800, 575);
		}
		return lblNewLabel_3;
	}
	// --- Function ---
	
	
	private void screenTableInit() { // Table 초기화 
		outerTable.addColumn("영화제목");
		outerTable.addColumn("감독");
		outerTable.addColumn("장르");
		outerTable.addColumn("개봉일");
		outerTable.addColumn("관람등급");
		outerTable.addColumn("제작국가");
		outerTable.addColumn("개봉상태");
		outerTable.setColumnCount(7);
		
		int colNo = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(colNo);
		int width = 60;
		col.setPreferredWidth(width);
		
		colNo = 1;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 60;
		col.setPreferredWidth(width);
		
		colNo = 2;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 50;
		col.setPreferredWidth(width);
		
		colNo = 3;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 70;
		col.setPreferredWidth(width);
		
		colNo = 4;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 60;
		col.setPreferredWidth(width);
		
		colNo = 5;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 60;
		col.setPreferredWidth(width);
		
		colNo = 6;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 60;
		col.setPreferredWidth(width);
		
		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);
		
		// Table Row Delete
		int i = outerTable.getRowCount();
		for(int j=0; j<i; j++) {
			outerTable.removeRow(0);
		}
	}
	
	// cbYear에 현재년도와 다음년도 넣기
	private void cbYearAdd() {
        // 현재 날짜 가져오기
        LocalDate currentDate = LocalDate.now();
        
        // 현재 날짜의 연도와 다음년도 cbYear에 넣기
        cbYear.addItem(currentDate.getYear());
        cbYear.addItem(currentDate.getYear()+1);


	}
	
	// 창이 deactivated 되면 cbYear의 항목들을 삭제 (창이 activated 될 때 마다 cbYear의 중복 추가 방지를 위함)
	private void cbYearClear() {
		cbYear.removeAllItems();
	}

	
	
	
	
	
	
	
	
	
	
	
} // End
