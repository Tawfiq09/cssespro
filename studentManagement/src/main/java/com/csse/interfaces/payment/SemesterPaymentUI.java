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
		setResizable(false);
		setTitle("Semester Registration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// set db connection to service class
		Service.setconnection();
		SemesterPaymentHandler.setconnection();
		contentPane.setLayout(null);
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
		textFieldStudentID.setBounds(158, 58, 134, 20);
		contentPane.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);

		// student name
		textFieldStudentName = new JTextField();
		textFieldStudentName.setBounds(158, 98, 134, 20);
		contentPane.add(textFieldStudentName);
		textFieldStudentName.setColumns(10);

		// student email
		textFieldStudentEmail = new JTextField();
		textFieldStudentEmail.setBounds(158, 138, 134, 20);
		contentPane.add(textFieldStudentEmail);
		textFieldStudentEmail.setColumns(10);

		// registration date
		JDateChooser dateChooserRegisterdDate = new JDateChooser();
		dateChooserRegisterdDate.setBounds(509, 168, 134, 20);
		dateChooserRegisterdDate.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dateChooserRegisterdDate);
		dateChooserRegisterdDate.setMinSelectableDate(new Date());

		// year
		textFieldYear = new JTextField();
		textFieldYear.setBounds(158, 218, 134, 20);
		textFieldYear.setEditable(false);
		contentPane.add(textFieldYear);
		textFieldYear.setColumns(10);
		String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		textFieldYear.setText(year);

		// current year
		JComboBox<String> comboBoxstudentCurrentYear = new JComboBox<String>();
		comboBoxstudentCurrentYear.setBounds(158, 178, 134, 20);
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
		contentPane.add(comboBoxstudentCurrentYear);

		// current semester
		JComboBox<String> comboBoxSemester = new JComboBox<String>();
		comboBoxSemester.setBounds(158, 258, 134, 20);
		comboBoxSemester.setModel(new DefaultComboBoxModel<String>(new String[] { "select", "1", "2" }));
		contentPane.add(comboBoxSemester);

		// faculty
		comboBoxFaculty = new JComboBox<String>();
		comboBoxFaculty.setBounds(509, 51, 134, 20);
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
		contentPane.add(comboBoxFaculty);
		fillFacultyComboBox(comboBoxFaculty, Service.fillFaculty());

		// Specialization
		comboBoxSpecialication = new JComboBox<String>();
		comboBoxSpecialication.setBounds(509, 91, 134, 20);
		comboBoxSpecialication.setModel(new DefaultComboBoxModel<String>(new String[] { "select" }));
		contentPane.add(comboBoxSpecialication);

		// course fee
		textFieldCourseFee = new JTextField();
		textFieldCourseFee.setBounds(509, 131, 134, 20);
		contentPane.add(textFieldCourseFee);
		textFieldCourseFee.setColumns(10);

		JLabel lblBankDetails = new JLabel("Bank Details");
		lblBankDetails.setBounds(24, 324, 105, 14);
		lblBankDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBankDetails.setForeground(Color.BLACK);
		contentPane.add(lblBankDetails);

		JLabel lblBank = new JLabel("Bank");
		lblBank.setBounds(24, 380, 46, 14);
		contentPane.add(lblBank);

		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(24, 423, 46, 14);
		contentPane.add(lblBranch);

		// bank
		JComboBox<String> comboBoxbank = new JComboBox<String>();
		comboBoxbank.setBounds(95, 377, 100, 20);
		comboBoxbank.setModel(new DefaultComboBoxModel<String>(new String[] { "Sampath Bank", "BOC", "NTB" }));
		contentPane.add(comboBoxbank);

		// branch
		textFieldbranch = new JTextField();
		textFieldbranch.setBounds(95, 420, 100, 20);
		contentPane.add(textFieldbranch);
		textFieldbranch.setColumns(10);

		JLabel lblDeposit = new JLabel("Deposit Date");
		lblDeposit.setBounds(236, 380, 98, 14);
		contentPane.add(lblDeposit);

		// Deposit date
		JDateChooser dateChooserDeposit = new JDateChooser();
		dateChooserDeposit.setBounds(333, 374, 125, 20);
		dateChooserDeposit.setDateFormatString(" yyyy-MM-dd");
		contentPane.add(dateChooserDeposit);
		dateChooserDeposit.setMaxSelectableDate(new Date());

		// submit button
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(578, 379, 98, 58);
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

				boolean result = SemesterPaymentHandler.addSemesterPayment(semeterpayment);
				if(result) {
					JOptionPane.showMessageDialog(null, "successfully Recorded");
				}
				else {
					JOptionPane.showMessageDialog(null, "Database error");
				}

			}
		});
		contentPane.add(btnSubmit);

		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setBounds(24, 11, 128, 14);
		lblStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblStudentDetails);

		JLabel lblStudentCurrentYear = new JLabel("Student Current Year");
		lblStudentCurrentYear.setBounds(24, 180, 116, 14);
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
