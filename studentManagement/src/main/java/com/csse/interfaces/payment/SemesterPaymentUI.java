package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

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
	private JTextField textFieldBank;
	private JTextField textFieldbranch;

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
		setBounds(100, 100, 723, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(24, 61, 86, 14);
		contentPane.add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(24, 101, 86, 14);
		contentPane.add(lblStudentName);
		
		JLabel lblStudentEmail = new JLabel("Student Email");
		lblStudentEmail.setBounds(24, 141, 86, 14);
		contentPane.add(lblStudentEmail);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(24, 181, 86, 14);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(24, 221, 86, 14);
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
		
		JLabel lblRegisteredDate = new JLabel("Registered Date");
		lblRegisteredDate.setBounds(372, 174, 98, 14);
		contentPane.add(lblRegisteredDate);
		
		textFieldStudentID = new JTextField();
		textFieldStudentID.setBounds(158, 58, 100, 20);
		contentPane.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);
		
		textFieldStudentName = new JTextField();
		textFieldStudentName.setBounds(158, 98, 100, 20);
		contentPane.add(textFieldStudentName);
		textFieldStudentName.setColumns(10);
		
		textFieldStudentEmail = new JTextField();
		textFieldStudentEmail.setBounds(158, 138, 100, 20);
		contentPane.add(textFieldStudentEmail);
		textFieldStudentEmail.setColumns(10);
		
		JDateChooser dateChooserRegisterdDate = new JDateChooser();
		dateChooserRegisterdDate.setBounds(509, 168, 100, 20);
		contentPane.add(dateChooserRegisterdDate);
		
		textFieldYear = new JTextField();
		textFieldYear.setBounds(158, 178, 100, 20);
		contentPane.add(textFieldYear);
		textFieldYear.setColumns(10);
		
		JComboBox comboBoxSemester = new JComboBox();
		comboBoxSemester.setBounds(158, 218, 100, 20);
		contentPane.add(comboBoxSemester);
		
		JComboBox comboBoxFaculty = new JComboBox();
		comboBoxFaculty.setBounds(509, 51, 100, 20);
		contentPane.add(comboBoxFaculty);
		
		JComboBox comboBoxSpecialication = new JComboBox();
		comboBoxSpecialication.setBounds(509, 91, 100, 20);
		contentPane.add(comboBoxSpecialication);
		
		textFieldCourseFee = new JTextField();
		textFieldCourseFee.setBounds(509, 131, 100, 20);
		contentPane.add(textFieldCourseFee);
		textFieldCourseFee.setColumns(10);
		
		JLabel lblBankDetails = new JLabel("Bank Details");
		lblBankDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBankDetails.setForeground(Color.BLACK);
		lblBankDetails.setBounds(24, 279, 105, 14);
		contentPane.add(lblBankDetails);
		
		JLabel lblBank = new JLabel("Bank");
		lblBank.setBounds(24, 335, 46, 14);
		contentPane.add(lblBank);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(24, 378, 46, 14);
		contentPane.add(lblBranch);
		
		textFieldBank = new JTextField();
		textFieldBank.setBounds(95, 332, 100, 20);
		contentPane.add(textFieldBank);
		textFieldBank.setColumns(10);
		
		textFieldbranch = new JTextField();
		textFieldbranch.setBounds(95, 375, 100, 20);
		contentPane.add(textFieldbranch);
		textFieldbranch.setColumns(10);
		
		JLabel lblDeposit = new JLabel("Deposit Date");
		lblDeposit.setBounds(236, 335, 98, 14);
		contentPane.add(lblDeposit);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(333, 329, 100, 20);
		contentPane.add(dateChooser);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(531, 334, 98, 58);
		contentPane.add(btnSubmit);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentDetails.setBounds(24, 11, 128, 14);
		contentPane.add(lblStudentDetails);
	}
}
