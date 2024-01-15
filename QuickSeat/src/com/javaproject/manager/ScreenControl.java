package com.javaproject.manager;

import java.awt.EventQueue;

import javax.swing.JDialog;

import com.javaproject.base.ShareVar;
import com.javaproject.managerfunction.DaoScreenControl;
import com.javaproject.managerfunction.DtoWDH;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ScreenControl extends JDialog {

	private final DefaultTableModel outerTable = new DefaultTableModel(); // OuterTable 선언
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JRadioButton rbInsert;
	private JRadioButton rbUpdate;
	private JRadioButton rbDelete;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_1;
	private JComboBox cbScroom;
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
	private JButton btnComplete;
	private JScrollPane scrollPane;
	private JComboBox cbScroomSelect;
	private JTable innerTable;
	private JLabel lblNewLabel_3;
	private JTable table;

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
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowOpened(WindowEvent e) {
				cbYearAdd();
				cbDateSetting();
				cbItemAdd();
				screenTableInit();
				screenSearchAction();
//				seatResvCodeSetting();

			}

			@Override
			public void windowClosed(WindowEvent e) {
				cbClear();
			}
		});
		setTitle("상영관 관리");
		setBounds(ShareVar.managerXlocation-100, ShareVar.managerYlocation+100, ShareVar.managerXsize, ShareVar.managerYsize);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getRbInsert());
		getContentPane().add(getRbUpdate());
		getContentPane().add(getRbDelete());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getCbScroom());
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
		getContentPane().add(getBtnComplete());
		getContentPane().add(getScrollPane());
		getContentPane().add(getCbScroomSelect());
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
			rbInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					screenTableInit();
					screenSearchAction();
					cbClear();
					cbYearAdd();
					cbItemAdd();
					cbRunTimeInit();
				}
			});
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

	private JComboBox getCbScroom() {
		if (cbScroom == null) {
			cbScroom = new JComboBox();
			cbScroom.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbScroom.setBounds(131, 145, 161, 27);
		}
		return cbScroom;
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
			cbMovieTitle.setBounds(131, 192, 197, 27);
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
			cbYear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfStartTimeSetting();
				}
			});
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
			cbMonth.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cbDate.removeAllItems();
					cbDateSetting();
					tfStartTimeSetting();
				}
			});
			cbMonth.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbMonth.setModel(new DefaultComboBoxModel(
					new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
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
			cbDate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfStartTimeSetting();
				}
			});
			cbDate.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
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
			cbHour.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfStartTimeSetting();
				}
			});
			cbHour.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbHour.setModel(new DefaultComboBoxModel(new String[] { "06", "07", "08", "09", "10", "11", "12", "13",
					"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));
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
			cbMinute.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					tfStartTimeSetting();
				}
			});
			cbMinute.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbMinute.setModel(new DefaultComboBoxModel(
					new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
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
			tfStartTime.setText("");
			tfStartTime.setBounds(111, 366, 192, 26);
			tfStartTime.setColumns(10);
		}
		return tfStartTime;
	}

	private JTextField getTfRunTime() {
		if (tfRunTime == null) {
			tfRunTime = new JTextField();
			tfRunTime.addKeyListener(new KeyAdapter() {
				// tfRunTime에 숫자가 아닌 다른 문자열이 입력되면 없애기
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();  // 'e'는 키 이벤트를 나타내며, 'getKeyChar()' 메소드를 사용하여 입력된 문자를 가져옴

					if (!Character.isDigit(c)) {  // 'isDigit' 메소드를 사용하여 입력된 문자가 숫자인지 확인
					    e.consume();  // 'consume()' 메소드는 이벤트를 'not processed'하여 처리되지 않게 함(입력된 문자를 무시)
					}
				}
			});
			tfRunTime.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
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

	private JButton getBtnComplete() {
		if (btnComplete == null) {
			btnComplete = new JButton("완료");
			btnComplete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rbSelect();
					rbInsert.setSelected(true);
					cbClear();
					cbYearAdd();
					cbItemAdd();
					cbRunTimeInit();
				}
			});
			btnComplete.setFont(new Font("BM Dohyeon", Font.PLAIN, 20));
			btnComplete.setBounds(115, 508, 121, 38);
		}
		return btnComplete;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(340, 134, 420, 412);
			scrollPane.setViewportView(getInnerTable());
		}
		return scrollPane;
	}

	private JComboBox getCbScroomSelect() {
		if (cbScroomSelect == null) {
			cbScroomSelect = new JComboBox();
			cbScroomSelect.addPopupMenuListener(new PopupMenuListener() {
				public void popupMenuCanceled(PopupMenuEvent e) {
				}

				public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
					screenTableInit();
					cbScroomSelectSetting();
					cbScroomSelectAll();
				}

				public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				}
			});
			cbScroomSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			cbScroomSelect.setFont(new Font("BM Dohyeon", Font.PLAIN, 12));
			cbScroomSelect.setBounds(339, 99, 161, 27);
		}
		return cbScroomSelect;
	}

	private JTable getInnerTable() {
		if (innerTable == null) {
			innerTable = new JTable();
			innerTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getButton() == 1) {
						innerTableClick();
					}
				}
			});
			innerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			innerTable.setModel(outerTable);
		}
		scrollPane.setViewportView(innerTable);
		return innerTable;
	}

	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(
					new ImageIcon(ScreenControl.class.getResource("/com/javaproject/image/manager_background.png")));
			lblNewLabel_3.setBounds(0, 0, 800, 575);
		}
		return lblNewLabel_3;
	}

	// --- Function ---
	private void screenTableInit() { // Table 초기화
		outerTable.addColumn("영화제목");
		outerTable.addColumn("상영관");
		outerTable.addColumn("상영시작시간");
		outerTable.addColumn("상영시간");
		outerTable.addColumn("개봉일");
		outerTable.addColumn("상영종료일");
		outerTable.addColumn("개봉상태");
		outerTable.setColumnCount(7);

		int colNo = 0;
		TableColumn col = innerTable.getColumnModel().getColumn(colNo);
		int width = 100;
		col.setPreferredWidth(width);

		colNo = 1;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 120;
		col.setPreferredWidth(width);

		colNo = 2;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 120;
		col.setPreferredWidth(width);

		colNo = 3;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 55;
		col.setPreferredWidth(width);

		colNo = 4;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 65;
		col.setPreferredWidth(width);

		colNo = 5;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 65;
		col.setPreferredWidth(width);

		colNo = 6;
		col = innerTable.getColumnModel().getColumn(colNo);
		width = 55;
		col.setPreferredWidth(width);

		innerTable.setAutoResizeMode(innerTable.AUTO_RESIZE_OFF);

		// Table Row Delete
		int i = outerTable.getRowCount();
		for (int j = 0; j < i; j++) {
			outerTable.removeRow(0);
		}
	}

	// cbYear에 현재년도와 다음년도 넣기
	private void cbYearAdd() {
		// 현재 날짜 가져오기
		LocalDate currentDate = LocalDate.now();

		// 현재 날짜의 연도와 다음년도 cbYear에 넣기
		cbYear.addItem(currentDate.getYear());
		cbYear.addItem(currentDate.getYear() + 1);

	}

	// cbDate에 cbMonth에 맞는 숫자를 넣기 (6월은 30, 7월은 31)
	private void cbDateSetting() {
        LocalDate localDate = LocalDate.of(Integer.parseInt(cbYear.getSelectedItem().toString()), Integer.parseInt(cbMonth.getSelectedItem().toString()), 1);
        int daysInMonth = localDate.lengthOfMonth();
        for(int i = 1; i <= daysInMonth; i++) {
        	cbDate.addItem(String.format("%02d", i));
        }

	}
	
	// 상영관 콤보박스(cbScroom, cbScroomSelect, cbMovieTitle)에 상영관 이름 넣기
	private void cbItemAdd() {

		DaoScreenControl daoScreenControl = new DaoScreenControl();

		for (int i = 0; i < daoScreenControl.scroomItem().size(); i++) {
			cbScroom.addItem(daoScreenControl.scroomItem().get(i));
		}

		cbScroomSelect.addItem("전체");
		for (int i = 0; i < daoScreenControl.scroomItem().size(); i++) {
			cbScroomSelect.addItem(daoScreenControl.scroomItem().get(i));
		}

		for (int i = 0; i < daoScreenControl.moiveTitleItem().size(); i++) {
			cbMovieTitle.addItem(daoScreenControl.moiveTitleItem().get(i));
		}

	}

	/*
	 * 창이 deactivated 되면 콤보박스들의 항목들을 삭제 (창이 activated 될 때 마다 콤보박스의 아이템 중복 추가 방지를 위함)
	 */
	private void cbClear() {
		cbYear.removeAllItems();
		cbScroom.removeAllItems();
		cbScroomSelect.removeAllItems();
		cbMovieTitle.removeAllItems();
	}

	// DB의 screening_room에서 total_seat을 가져 온 후 0을 total_seat의 개수만큼 적어줌
	private String seatResvCodeSetting() {

		String scroom_name = cbScroom.getSelectedItem().toString();
		DaoScreenControl daoScreenControl = new DaoScreenControl(scroom_name);

		String totalSeat = "";
		for (int i = 0; i < daoScreenControl.totalSeatCount(); i++) {
			totalSeat += "0";
		}
		return totalSeat;

	}

	// 설정 시각 (tfStartTime)을 콤보박스의 시간내용에 따라 바뀌게 만듬
	private void tfStartTimeSetting() {
		cbYear.getSelectedItem(); // 년
		cbMonth.getSelectedItem(); // 월
		cbDate.getSelectedItem(); // 일
		cbHour.getSelectedItem(); // 시간
		cbMinute.getSelectedItem(); // 분 가져오기

//		tfStartTime.setText(cbYear.getSelectedItem() + "년 " + 
//							cbMonth.getSelectedItem() + "월 " + 
//							cbDate.getSelectedItem() + "일 " + 
//							cbHour.getSelectedItem() + "시 " + 
//							cbMinute.getSelectedItem() + "분" );
		tfStartTime.setText(cbYear.getSelectedItem() + "-" + cbMonth.getSelectedItem() + "-" + cbDate.getSelectedItem()
				+ " " + cbHour.getSelectedItem() + ":" + cbMinute.getSelectedItem() + ":00");
	}

	// DaoScreenControl에서 가져온 DB의 값 들을 innerTable에 넣어주기
	private void screenSearchAction() {
		DaoScreenControl dao = new DaoScreenControl();
		ArrayList<DtoWDH> dtoList = dao.innerTable();

		for (int i = 0; i < dtoList.size(); i++) {
			String[] qTxt = { dtoList.get(i).getScr_movie_title(), dtoList.get(i).getScr_scroom_name(),
					dtoList.get(i).getScr_start_time(), Integer.toString(dtoList.get(i).getRun_time()) + "분",
					dtoList.get(i).getRel_date(), dtoList.get(i).getOver_date(), dtoList.get(i).getRel_state() };
			outerTable.addRow(qTxt);
		}
	}

	// cbScroomSelect에서 전체 눌렀을 때
	private void cbScroomSelectAll() {
		if (cbScroomSelect.getSelectedItem().toString().equals("전체")) {
			screenTableInit();
			screenSearchAction();
		}
	}

	// innerTable의 Row를 click 했을 경우
	private void innerTableClick() {
		rbUpdate.setSelected(true);

		int i = innerTable.getSelectedRow();

		DaoScreenControl dao = new DaoScreenControl();

		ArrayList<DtoWDH> dto = dao.innerTable();

		if (!cbScroomSelect.getSelectedItem().toString().equals("전체")) {

			String scroom_name = cbScroomSelect.getSelectedItem().toString();

			dao = new DaoScreenControl(scroom_name);

			dto = dao.cbInnerTable();

		}

		cbScroom.setSelectedItem(dto.get(i).getScr_scroom_name());
		cbMovieTitle.setSelectedItem(dto.get(i).getScr_movie_title());
		tfStartTime.setText(dto.get(i).getScr_start_time());
		tfRunTime.setText(Integer.toString(dto.get(i).getRun_time()));

		String year = tfStartTime.getText().substring(0, 4);
		String month = tfStartTime.getText().substring(5, 7);
		String date = tfStartTime.getText().substring(8, 10);
		String hour = tfStartTime.getText().substring(11, 13);
		String minute = tfStartTime.getText().substring(14, 16);

		cbYear.setSelectedItem(year);
		cbMonth.setSelectedItem(month);
		cbDate.setSelectedItem(date);
		cbHour.setSelectedItem(hour);
		cbMinute.setSelectedItem(minute);

	}

	// 등록, 수정, 삭제 눌렀을 경우
	private void rbSelect() {
		if (rbInsert.isSelected() == true) {
			insertScreenInformation();
		}
		if (rbUpdate.isSelected() == true) {
			updateScreenInformation();
		}
		if (rbDelete.isSelected() == true) {
			deleteScreenInformation();
		}
		screenTableInit();
		screenSearchAction();
	}

	// DB의 screen Table에 등록(insert) (좌석예약코드)
	private void insertScreenInformation() {
//		System.out.println(cbMovieTitle.getSelectedItem()); // 영화 제목
		String scr_movie_title = cbMovieTitle.getSelectedItem().toString(); // 영화 제목
//		System.out.println(cbScroom.getSelectedItem()); // 상영관 이름
		String scr_scroom_name = cbScroom.getSelectedItem().toString(); // 상영관 이름
//		System.out.println(ShareVar.managerID); // 관리자 ID
		String admin_admin_id = ShareVar.managerID; // 관리자 ID
//		System.out.println(seatResvCodeSetting()); // 좌석예약코드
		String seat_resv_code = seatResvCodeSetting(); // 좌석예약코드
//		System.out.println(tfStartTime.getText()); // 상영시작시간
		String scr_start_time = tfStartTime.getText(); // 상영시작시간
//		System.out.println(tfRunTime.getText()); // 상영시간
		try {
			int run_time = Integer.parseInt(tfRunTime.getText()); // 상영시간
			
			DaoScreenControl daoScreenControl = new DaoScreenControl(scr_movie_title, scr_scroom_name, admin_admin_id,
					seat_resv_code, scr_start_time, run_time);
			
			daoScreenControl.screenInsert();
			
			JOptionPane.showMessageDialog(null, "등록 되었습니다.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "상영시간을 입력해 주세요.");
		}

	}

	// 수정
	private void updateScreenInformation() {

		int i = innerTable.getSelectedRow();

		DaoScreenControl dao = new DaoScreenControl();
		ArrayList<DtoWDH> dto = dao.innerTable();

		int scr_code = dto.get(i).getScr_code();
		String scr_movie_title = cbMovieTitle.getSelectedItem().toString(); // 영화 제목
		String scr_scroom_name = cbScroom.getSelectedItem().toString(); // 상영관 이름
		String admin_admin_id = ShareVar.managerID; // 관리자 ID
		String seat_resv_code = seatResvCodeSetting(); // 좌석예약코드
		String scr_start_time = tfStartTime.getText(); // 상영시작시간

		try {
			int run_time = Integer.parseInt(tfRunTime.getText()); // 상영시간

			DaoScreenControl daoScreenControl = new DaoScreenControl(scr_movie_title, scr_scroom_name, admin_admin_id,
					seat_resv_code, scr_start_time, run_time, scr_code);

			daoScreenControl.screenUpdate();

			JOptionPane.showMessageDialog(null, "수정 되었습니다.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "상영시간을 입력해 주세요.");
		}
	}

	// 삭제
	private void deleteScreenInformation() {
		int i = innerTable.getSelectedRow();

		DaoScreenControl dao = new DaoScreenControl();
		ArrayList<DtoWDH> dto = dao.innerTable();

		int scr_code = dto.get(i).getScr_code();

		DaoScreenControl daoScreenControl = new DaoScreenControl(scr_code);

		boolean result = daoScreenControl.screenDelete();
		if (result == true) {
			JOptionPane.showMessageDialog(null, "삭제 되었습니다.");
		}else{
			JOptionPane.showMessageDialog(null, "삭제 중 오류가 발생했습니다.");
		}

	}

	// innerTable위의 cbScreenSelect의 고른 상영관만 보여주기
	private void cbScroomSelectSetting() {

		String scroom_name = cbScroomSelect.getSelectedItem().toString();

		DaoScreenControl dao = new DaoScreenControl(scroom_name);

		ArrayList<DtoWDH> dtoList = dao.cbInnerTable();

		for (int i = 0; i < dtoList.size(); i++) {
			String[] qTxt = { dtoList.get(i).getScr_movie_title(), dtoList.get(i).getScr_scroom_name(),
					dtoList.get(i).getScr_start_time(), Integer.toString(dtoList.get(i).getRun_time()) + "분",
					dtoList.get(i).getRel_date(), dtoList.get(i).getOver_date(), dtoList.get(i).getRel_state() };
			outerTable.addRow(qTxt);
		}

	}

	// 상영시간을 고르는 ComboBox와 상영시간을 나타내는 TextField 초기화 하기
	private void cbRunTimeInit() {
		cbYear.setSelectedIndex(0);
		cbMonth.setSelectedIndex(0);
		cbDate.setSelectedIndex(0);
		cbHour.setSelectedIndex(0);
		cbMinute.setSelectedIndex(0);
		tfRunTime.setText("");
	}
		
	
	
} // End
