package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.csse.payment.Service;
import com.csse.payment.semester_payment.SemesterPaymentHandler;
import com.toedter.calendar.JYearChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AdminSemesterPaymentUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSemesterPaymentUI frame = new AdminSemesterPaymentUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminSemesterPaymentUI() {
		setTitle("Admin Semester Payment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1395, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Service.setconnection();
		SemesterPaymentHandler.setconnection();
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 36, 345, 601, 345, 0 };
		gbl_contentPane.rowHeights = new int[] { 233, 293, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel1 = new GridBagConstraints();
		gbc_panel1.fill = GridBagConstraints.BOTH;
		gbc_panel1.insets = new Insets(0, 0, 5, 5);
		gbc_panel1.gridx = 1;
		gbc_panel1.gridy = 0;
		contentPane.add(panel1, gbc_panel1);
		panel1.setLayout(null);

		JLabel lblStudentWiseSearch = new JLabel("Student wise Search");
		lblStudentWiseSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentWiseSearch.setBounds(10, 11, 152, 14);
		panel1.add(lblStudentWiseSearch);

		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setBounds(10, 50, 74, 14);
		panel1.add(lblStudentId);

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(10, 87, 46, 14);
		panel1.add(lblYear);

		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(10, 130, 74, 14);
		panel1.add(lblSemester);

		textFieldStudentID = new JTextField();
		textFieldStudentID.setBounds(101, 47, 152, 20);
		panel1.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);

		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(101, 87, 47, 20);
		panel1.add(yearChooser);

		JComboBox<String> comboBoxSemester = new JComboBox<String>();
		comboBoxSemester.setModel(new DefaultComboBoxModel<String>(new String[] { "1", "2" }));
		comboBoxSemester.setBounds(101, 127, 152, 20);
		panel1.add(comboBoxSemester);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!textFieldStudentID.getText().trim().isEmpty()) {
					String sid = textFieldStudentID.getText();
					int year = yearChooser.getValue();
					int semester = Integer.parseInt((String) comboBoxSemester.getSelectedItem());
					table.setModel(DbUtils
							.resultSetToTableModel(SemesterPaymentHandler.adminSearchStudentWise(sid, year, semester)));
				}

			}
		});
		btnSearch.setBounds(54, 187, 89, 23);
		panel1.add(btnSearch);

		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(172, 187, 143, 23);
		panel1.add(btnGenerateReport);

		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.fill = GridBagConstraints.BOTH;
		gbc_panel2.insets = new Insets(0, 0, 5, 0);
		gbc_panel2.gridx = 3;
		gbc_panel2.gridy = 0;
		contentPane.add(panel2, gbc_panel2);
		panel2.setLayout(null);

		JLabel lblFacultyWiseSearch = new JLabel("Faculty wise Search");
		lblFacultyWiseSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFacultyWiseSearch.setBounds(10, 11, 145, 14);
		panel2.add(lblFacultyWiseSearch);

		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setBounds(10, 47, 81, 14);
		panel2.add(lblFaculty);

		JLabel lblYearF = new JLabel("Year");
		lblYearF.setBounds(10, 85, 46, 14);
		panel2.add(lblYearF);

		JLabel lblSemesterF = new JLabel("Semester");
		lblSemesterF.setBounds(10, 129, 81, 14);
		panel2.add(lblSemesterF);

		JComboBox<String> comboBoxFaculty = new JComboBox<String>();
		comboBoxFaculty.setBounds(101, 44, 152, 20);
		panel2.add(comboBoxFaculty);
		fillFacultyComboBox(comboBoxFaculty, Service.fillFaculty());

		JComboBox<String> comboBoxSemesterF = new JComboBox<String>();
		comboBoxSemesterF.setModel(new DefaultComboBoxModel<String>(new String[] { "1", "2" }));
		comboBoxSemesterF.setBounds(101, 126, 152, 20);
		panel2.add(comboBoxSemesterF);

		JYearChooser yearChooser_1 = new JYearChooser();
		yearChooser_1.setBounds(101, 85, 47, 20);
		panel2.add(yearChooser_1);

		JButton btnSearchF = new JButton("Search");
		btnSearchF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String faculty = (String) comboBoxFaculty.getSelectedItem();
				int year = yearChooser_1.getValue();
				int semester = Integer.parseInt((String) comboBoxSemesterF.getSelectedItem());
				table.setModel(DbUtils.resultSetToTableModel(
						SemesterPaymentHandler.adminSearchFacultytWise(faculty, year, semester)));
			}
		});
		btnSearchF.setBounds(62, 180, 89, 23);
		panel2.add(btnSearchF);

		JButton btnGenerateReportF = new JButton("Generate Report");
		btnGenerateReportF.setBounds(178, 180, 140, 23);
		panel2.add(btnGenerateReportF);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Student ID", "Student Name", "Student Email", "Current Year", "Year", "Semester",
						"Faculty", "Specialication", "Course Fee", "Registered Date", "Bank", "Branch", "Deposit Date",
						"Status" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(83);
		table.getColumnModel().getColumn(9).setPreferredWidth(94);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

	}

	// method for fill faculty comboBox
	public void fillFacultyComboBox(JComboBox<String> jComboBox, ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				jComboBox.addItem(resultSet.getString("faculty_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
