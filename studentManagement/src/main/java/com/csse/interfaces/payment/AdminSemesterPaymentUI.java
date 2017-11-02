package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.csse.payment.Service;
import com.csse.payment.semester_payment.SemesterPayment;
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
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminSemesterPaymentUI extends JFrame {

	/**
	 * UI for administrator to view payment details
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
		contentPane.setLayout(null);
		
		//set db connection for both Service and SemesterPaymentHandler classes
		Service.setconnection();
		SemesterPaymentHandler.setconnection();

		JPanel panel1 = new JPanel();
		panel1.setBounds(36, 11, 345, 233);
		panel1.setBackground(Color.WHITE);
		contentPane.add(panel1);
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

		//student id
		textFieldStudentID = new JTextField();
		textFieldStudentID.setBounds(101, 47, 152, 20);
		panel1.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);

		//year panel 1
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(101, 87, 47, 20);
		panel1.add(yearChooser);

		//semester
		JComboBox<String> comboBoxSemester = new JComboBox<String>();
		comboBoxSemester.setModel(new DefaultComboBoxModel<String>(new String[] { "1", "2" }));
		comboBoxSemester.setBounds(101, 127, 152, 20);
		panel1.add(comboBoxSemester);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 266, 1291, 293);
		contentPane.add(scrollPane);

		//table
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();

				SemesterPayment semesterPayment = new SemesterPayment();
				semesterPayment.setStudentId((String) model.getValueAt(i, 0));
				semesterPayment.setStudentName((String) model.getValueAt(i, 1));
				semesterPayment.setStudentEmail((String) model.getValueAt(i, 2));
				semesterPayment.setCurrentYear((Integer) model.getValueAt(i, 3));
				semesterPayment.setYear((Integer) model.getValueAt(i, 4));
				semesterPayment.setSemester((Integer) model.getValueAt(i, 5));
				semesterPayment.setFaculty((String) model.getValueAt(i, 6));
				semesterPayment.setSpecialication((String) model.getValueAt(i, 7));
				semesterPayment.setCourseFee((double) model.getValueAt(i, 8));
				semesterPayment.setRegisteredDate((Date) model.getValueAt(i, 9));
				semesterPayment.setBankName((String) model.getValueAt(i, 10));
				semesterPayment.setBranchName((String) model.getValueAt(i, 11));
				semesterPayment.setDate((Date) model.getValueAt(i, 12));
				semesterPayment.setStatus((String) model.getValueAt(i, 13));
				
				
				AdminSemesterPaymentManupulationUI frame = new AdminSemesterPaymentManupulationUI(semesterPayment);
				frame.setVisible(true);
				
			}
		});
		scrollPane.setViewportView(table);

		//panel 1 search button
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
				else {
					JOptionPane.showMessageDialog(null, "Please enter Student Id");
				}

			}
		});
		btnSearch.setBounds(54, 187, 89, 23);
		panel1.add(btnSearch);

		//panel 1 generate report button
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(172, 187, 143, 23);
		panel1.add(btnGenerateReport);

		JPanel panel2 = new JPanel();
		panel2.setBounds(991, 11, 336, 233);
		panel2.setBackground(Color.WHITE);
		contentPane.add(panel2);
		panel2.setLayout(null);

		JLabel lblFacultyWiseSearch = new JLabel("Faculty wise Search");
		lblFacultyWiseSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFacultyWiseSearch.setBounds(10, 11, 145, 14);
		panel2.add(lblFacultyWiseSearch);

		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setBounds(10, 47, 82, 14);
		panel2.add(lblFaculty);

		JLabel lblYearF = new JLabel("Year");
		lblYearF.setBounds(10, 85, 82, 14);
		panel2.add(lblYearF);

		JLabel lblSemesterF = new JLabel("Semester");
		lblSemesterF.setBounds(10, 162, 82, 14);
		panel2.add(lblSemesterF);

		//faculty
		JComboBox<String> comboBoxFaculty = new JComboBox<String>();
		comboBoxFaculty.setBounds(123, 44, 152, 20);
		panel2.add(comboBoxFaculty);
		fillFacultyComboBox(comboBoxFaculty, Service.fillFaculty());

		//semester panel 2
		JComboBox<String> comboBoxSemesterF = new JComboBox<String>();
		comboBoxSemesterF.setModel(new DefaultComboBoxModel<String>(new String[] { "1", "2" }));
		comboBoxSemesterF.setBounds(123, 159, 152, 20);
		panel2.add(comboBoxSemesterF);

		//year panel 2
		JYearChooser yearChooser_1 = new JYearChooser();
		yearChooser_1.setBounds(123, 79, 47, 20);
		panel2.add(yearChooser_1);
		
		//year of university or current year of university
		JComboBox<String> comboBoxUnYear = new JComboBox<String>();
		comboBoxUnYear.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4"}));
		comboBoxUnYear.setBounds(123, 119, 152, 20);
		panel2.add(comboBoxUnYear);
		
		//panel 2 search button
		JButton btnSearchF = new JButton("Search");
		btnSearchF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String faculty = (String) comboBoxFaculty.getSelectedItem();
				int year = yearChooser_1.getValue();
				int semester = Integer.parseInt((String) comboBoxSemesterF.getSelectedItem());
				int current_year = Integer.parseInt((String) comboBoxUnYear.getSelectedItem());
				table.setModel(DbUtils.resultSetToTableModel(SemesterPaymentHandler.adminSearchFacultytWise(faculty, year, semester,current_year)));
			}
		});
		btnSearchF.setBounds(32, 199, 89, 23);
		panel2.add(btnSearchF);

		//panel 2 generate report button
		JButton btnGenerateReportF = new JButton("Generate Report");
		btnGenerateReportF.setBounds(152, 199, 140, 23);
		panel2.add(btnGenerateReportF);
		
		JLabel lblUniversityYear = new JLabel("Year of University");
		lblUniversityYear.setBounds(10, 122, 103, 14);
		panel2.add(lblUniversityYear);
		
		
		
		

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
