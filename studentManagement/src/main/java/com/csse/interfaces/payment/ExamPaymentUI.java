package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ExamPaymentUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentID;
	private JTextField textFieldStudentName;
	private JTextField textFieldStudentEmail;
	private JTextField textFieldYear;
	private JTextField textFieldExamFee;
	private JTextField textFieldBranch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamPaymentUI frame = new ExamPaymentUI();
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
	public ExamPaymentUI() {
		setTitle("Exam Payment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(10, 40, 82, 14);
		contentPane.add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(10, 80, 82, 14);
		contentPane.add(lblStudentName);
		
		JLabel lblStudentEmail = new JLabel("Student Email");
		lblStudentEmail.setBounds(10, 120, 82, 14);
		contentPane.add(lblStudentEmail);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(10, 160, 82, 14);
		contentPane.add(lblYear);
		
		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setBounds(10, 200, 82, 14);
		contentPane.add(lblFaculty);
		
		JLabel lblCurrentYear = new JLabel("Current Year");
		lblCurrentYear.setBounds(10, 240, 82, 14);
		contentPane.add(lblCurrentYear);
		
		JLabel lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setBounds(10, 280, 82, 14);
		contentPane.add(lblSpecialization);
		
		JLabel lblExamination = new JLabel("Examination");
		lblExamination.setBounds(10, 320, 82, 14);
		contentPane.add(lblExamination);
		
		JLabel lblBank = new JLabel("Bank");
		lblBank.setBounds(394, 41, 82, 14);
		contentPane.add(lblBank);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(394, 81, 82, 14);
		contentPane.add(lblBranch);
		
		JLabel lblRegistrationDate = new JLabel("Registration Date");
		lblRegistrationDate.setBounds(10, 360, 108, 14);
		contentPane.add(lblRegistrationDate);
		
		JLabel lblDepositDate = new JLabel("Deposit Date");
		lblDepositDate.setBounds(394, 122, 82, 14);
		contentPane.add(lblDepositDate);
		
		JDateChooser dateChooserReDate = new JDateChooser();
		dateChooserReDate.setBounds(142, 360, 135, 20);
		contentPane.add(dateChooserReDate);
		
		textFieldStudentID = new JTextField();
		textFieldStudentID.setBounds(142, 37, 135, 20);
		contentPane.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);
		
		textFieldStudentName = new JTextField();
		textFieldStudentName.setBounds(142, 77, 135, 20);
		contentPane.add(textFieldStudentName);
		textFieldStudentName.setColumns(10);
		
		textFieldStudentEmail = new JTextField();
		textFieldStudentEmail.setBounds(142, 117, 135, 20);
		contentPane.add(textFieldStudentEmail);
		textFieldStudentEmail.setColumns(10);
		
		textFieldYear = new JTextField();
		textFieldYear.setBounds(142, 157, 135, 20);
		contentPane.add(textFieldYear);
		textFieldYear.setColumns(10);
		
		JComboBox<String> comboBoxFaculty = new JComboBox<String>();
		comboBoxFaculty.setBounds(142, 197, 135, 20);
		contentPane.add(comboBoxFaculty);
		
		JComboBox<String> comboBoxCurrentYear = new JComboBox<String>();
		comboBoxCurrentYear.setBounds(142, 237, 135, 20);
		contentPane.add(comboBoxCurrentYear);
		
		JComboBox<String> comboBoxSpecialization = new JComboBox<String>();
		comboBoxSpecialization.setBounds(142, 277, 135, 20);
		contentPane.add(comboBoxSpecialization);
		
		JComboBox<String> comboBoxExam = new JComboBox<String>();
		comboBoxExam.setBounds(142, 317, 135, 20);
		contentPane.add(comboBoxExam);
		
		JLabel lblExamFee = new JLabel("Exam Fee");
		lblExamFee.setBounds(10, 400, 82, 14);
		contentPane.add(lblExamFee);
		
		textFieldExamFee = new JTextField();
		textFieldExamFee.setBounds(142, 397, 135, 20);
		contentPane.add(textFieldExamFee);
		textFieldExamFee.setColumns(10);
		
		textFieldBranch = new JTextField();
		textFieldBranch.setBounds(500, 77, 135, 20);
		contentPane.add(textFieldBranch);
		textFieldBranch.setColumns(10);
		
		JComboBox<String> comboBoxBank = new JComboBox<String>();
		comboBoxBank.setBounds(500, 37, 135, 20);
		contentPane.add(comboBoxBank);
		
		JDateChooser dateChooserDepDate = new JDateChooser();
		dateChooserDepDate.setBounds(500, 116, 135, 20);
		contentPane.add(dateChooserDepDate);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(500, 276, 115, 46);
		contentPane.add(btnSubmit);
	}
}
