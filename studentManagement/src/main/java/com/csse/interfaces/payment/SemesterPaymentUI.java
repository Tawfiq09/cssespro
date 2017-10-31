package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.csse.payment.Service;
import com.csse.payment.semester_payment.SemesterPayment;
import com.csse.payment.semester_payment.SemesterPaymentHandler;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SemesterPaymentUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentID;
	private JTextField textFieldStudentName;
	private JTextField textFieldStudentEmail;
	private JTextField textFieldYear;
	private JTextField textFieldCourseFee;
	private JTextField textFieldbranch;
	private JComboBox<String> comboBoxSpecialication;
	private JComboBox<String> comboBoxFaculty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterPaymentUI frame = new SemesterPaymentUI();
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
	public SemesterPaymentUI() {
		setTitle("Semester Registration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// set db connection to service class
		Service.setconnection();
		SemesterPaymentHandler.setconnection();
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(24, 60, 86, 14);
		contentPane.add(lblStudentId);

		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(24, 100, 86, 14);
		contentPane.add(lblStudentName);

		JLabel lblStudentEmail = new JLabel("Student Email");
		lblStudentEmail.setBounds(24, 140, 86, 14);
		contentPane.add(lblStudentEmail);

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(24, 220, 86, 14);
		contentPane.add(lblYear);

		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(24, 260, 86, 14);
		contentPane.add(lblSemester);

		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setBounds(372, 54, 86, 14);
		contentPane.add(lblFaculty);

		JLabel lblSpecialication = new JLabel("Specialication");
		lblSpecialication.setBounds(372, 94, 86, 14);
		contentPane.add(lblSpecialication);

		JLabel lblCourseFee = new JLabel("Course Fee");
		lblCourseFee.setBounds(372, 134, 86, 14);
		contentPane.add(lblCourseFee);

		JLabel lblRegisteredDate = new JLabel("Registration Date");
		lblRegisteredDate.setBounds(372, 174, 98, 14);
		contentPane.add(lblRegisteredDate);

		// student id
		textFieldStudentID = new JTextField();
		textFieldStudentID.setBounds(158, 58, 135, 20);
		contentPane.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);

		// student name
		textFieldStudentName = new JTextField();
		textFieldStudentName.setBounds(158, 98, 135, 20);
		contentPane.add(textFieldStudentName);
		textFieldStudentName.setColumns(10);

		// student email
		textFieldStudentEmail = new JTextField();
		textFieldStudentEmail.setBounds(158, 138, 135, 20);
		contentPane.add(textFieldStudentEmail);
		textFieldStudentEmail.setColumns(10);

		// registration date
		JDateChooser dateChooserRegisterdDate = new JDateChooser();
		dateChooserRegisterdDate.setDateFormatString("yyyy-MM-dd");
		dateChooserRegisterdDate.setBounds(509, 168, 135, 20);
		contentPane.add(dateChooserRegisterdDate);
		dateChooserRegisterdDate.setMinSelectableDate(new Date());

		// year
		textFieldYear = new JTextField();
		textFieldYear.setEditable(false);
		textFieldYear.setBounds(158, 218, 135, 20);
		contentPane.add(textFieldYear);
		textFieldYear.setColumns(10);
		String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		textFieldYear.setText(year);

		// current year
		JComboBox<String> comboBoxstudentCurrentYear = new JComboBox<String>();
		comboBoxstudentCurrentYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comboBoxFaculty.getSelectedItem().equals("select")
						&& !comboBoxSpecialication.getSelectedItem().equals("select")) {
					comboBoxSpecialication.removeAllItems();
					String faculty = (String) comboBoxFaculty.getSelectedItem();
					int year = Integer.parseInt((String) comboBoxstudentCurrentYear.getSelectedItem());
					fillSpecialicationComboBox(comboBoxSpecialication, Service.fillSpecialication(faculty, year));

				}
			}
		});
		comboBoxstudentCurrentYear
				.setModel(new DefaultComboBoxModel<String>(new String[] { "select", "1", "2", "3", "4" }));
		comboBoxstudentCurrentYear.setBounds(158, 178, 135, 20);
		contentPane.add(comboBoxstudentCurrentYear);

		// current semester
		JComboBox<String> comboBoxSemester = new JComboBox<String>();
		comboBoxSemester.setModel(new DefaultComboBoxModel<String>(new String[] { "select", "1", "2" }));
		comboBoxSemester.setBounds(158, 258, 135, 20);
		contentPane.add(comboBoxSemester);

		// faculty
		comboBoxFaculty = new JComboBox<String>();
		comboBoxFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!comboBoxFaculty.getSelectedItem().equals("select")
						&& !comboBoxstudentCurrentYear.getSelectedItem().equals("select")) {
					comboBoxSpecialication.removeAllItems();
					String faculty = (String) comboBoxFaculty.getSelectedItem();
					int year = Integer.parseInt((String) comboBoxstudentCurrentYear.getSelectedItem());
					fillSpecialicationComboBox(comboBoxSpecialication, Service.fillSpecialication(faculty, year));

				}
			}
		});
		comboBoxFaculty.setModel(new DefaultComboBoxModel<String>(new String[] { "select" }));
		comboBoxFaculty.setBounds(509, 51, 135, 20);
		contentPane.add(comboBoxFaculty);
		fillFacultyComboBox(comboBoxFaculty, Service.fillFaculty());

		// Specialization
		comboBoxSpecialication = new JComboBox<String>();
		comboBoxSpecialication.setModel(new DefaultComboBoxModel<String>(new String[] { "select" }));
		comboBoxSpecialication.setBounds(509, 91, 135, 20);
		contentPane.add(comboBoxSpecialication);

		// course fee
		textFieldCourseFee = new JTextField();
		textFieldCourseFee.setBounds(509, 131, 135, 20);
		contentPane.add(textFieldCourseFee);
		textFieldCourseFee.setColumns(10);

		JLabel lblBankDetails = new JLabel("Bank Details");
		lblBankDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBankDetails.setForeground(Color.BLACK);
		lblBankDetails.setBounds(24, 324, 105, 14);
		contentPane.add(lblBankDetails);

		JLabel lblBank = new JLabel("Bank");
		lblBank.setBounds(24, 380, 46, 14);
		contentPane.add(lblBank);

		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(24, 423, 46, 14);
		contentPane.add(lblBranch);

		// bank
		JComboBox<String> comboBoxbank = new JComboBox<String>();
		comboBoxbank.setModel(new DefaultComboBoxModel<String>(new String[] { "Sampath Bank", "BOC", "NTB" }));
		comboBoxbank.setBounds(95, 377, 124, 20);
		contentPane.add(comboBoxbank);

		// branch
		textFieldbranch = new JTextField();
		textFieldbranch.setBounds(95, 420, 124, 20);
		contentPane.add(textFieldbranch);
		textFieldbranch.setColumns(10);

		JLabel lblDeposit = new JLabel("Deposit Date");
		lblDeposit.setBounds(250, 380, 98, 14);
		contentPane.add(lblDeposit);

		// Deposit date
		JDateChooser dateChooserDeposit = new JDateChooser();
		dateChooserDeposit.setDateFormatString(" yyyy-MM-dd");
		dateChooserDeposit.setBounds(358, 377, 100, 20);
		contentPane.add(dateChooserDeposit);

		// submit button
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SemesterPayment semeterpayment = new SemesterPayment();
				semeterpayment.setStudentId(textFieldStudentID.getText());
				semeterpayment.setStudentName(textFieldStudentName.getText());
				semeterpayment.setStudentEmail(textFieldStudentEmail.getText());
				semeterpayment.setCurrentYear(Integer.parseInt((String) comboBoxstudentCurrentYear.getSelectedItem()));
				semeterpayment.setYear(Integer.parseInt(textFieldYear.getText()));
				semeterpayment.setSemester(Integer.parseInt((String) comboBoxSemester.getSelectedItem()));
				semeterpayment.setFaculty((String) comboBoxFaculty.getSelectedItem());
				semeterpayment.setSpecialication((String) comboBoxSpecialication.getSelectedItem());
				semeterpayment.setCourseFee(Double.parseDouble(textFieldCourseFee.getText()));
				semeterpayment.setRegisteredDate(dateChooserRegisterdDate.getDate());
				semeterpayment.setBankName((String) comboBoxbank.getSelectedItem());
				semeterpayment.setBranchName(textFieldbranch.getText());
				semeterpayment.setDate(dateChooserDeposit.getDate());
				semeterpayment.setStatus("pending");

				boolean result = SemesterPaymentHandler.add(semeterpayment);
				if(result) {
					JOptionPane.showMessageDialog(null, "successfully Recorded");
				}
				else {
					JOptionPane.showMessageDialog(null, "Database error");
				}

			}
		});
		btnSubmit.setBounds(578, 379, 98, 58);
		contentPane.add(btnSubmit);

		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentDetails.setBounds(24, 11, 128, 14);
		contentPane.add(lblStudentDetails);

		JLabel lblStudentCurrentYear = new JLabel("Student Current Year");
		lblStudentCurrentYear.setBounds(24, 180, 124, 14);
		contentPane.add(lblStudentCurrentYear);

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

	public void fillSpecialicationComboBox(JComboBox<String> jComboBox, ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				jComboBox.addItem(resultSet.getString("specialication"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
