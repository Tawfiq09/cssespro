package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.csse.payment.semester_payment.SemesterPayment;
import com.csse.payment.semester_payment.SemesterPaymentHandler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminSemesterPaymentManupulationUI extends JFrame {

	/**
	 * This is for update and delete semester payment details
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentID;
	private JLabel lblStudentName;
	private JLabel lblStudentEmail;
	private JLabel lblCurrentYear;
	private JLabel lblYear;
	private JLabel lblSemester;
	private JLabel lblFaculty;
	private JLabel lblSpecialication;
	private JLabel lblCourseFee;
	private JLabel lblRegisteredDate;
	private JLabel lblBankDetails;
	private JLabel lblNewLabel;
	private JLabel lblBranch;
	private JLabel lblDepositDate;
	private JTextField textFieldStudentName;
	private JLabel lblStatus;
	private JTextField textFieldStudentEmail;
	private JTextField textFieldCurrentYear;
	private JTextField textFieldYear;
	private JTextField textFieldSemester;
	private JTextField textFieldFaculty;
	private JTextField textFieldSpecialication;
	private JTextField textFieldCourseFee;
	private JTextField textFieldRegDate;
	private JTextField textFieldBank;
	private JTextField textFieldBranch;
	private JTextField textFieldDepDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterPayment semesterPayment = new SemesterPayment();
					AdminSemesterPaymentManupulationUI frame = new AdminSemesterPaymentManupulationUI(semesterPayment);
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
	public AdminSemesterPaymentManupulationUI(SemesterPayment semesterPayment) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(10, 34, 82, 14);
		contentPane.add(lblStudentId);

		lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(10, 82, 82, 14);
		contentPane.add(lblStudentName);

		lblStudentEmail = new JLabel("Student Email");
		lblStudentEmail.setBounds(10, 129, 82, 14);
		contentPane.add(lblStudentEmail);

		lblCurrentYear = new JLabel("Current Year");
		lblCurrentYear.setBounds(10, 178, 82, 14);
		contentPane.add(lblCurrentYear);

		lblYear = new JLabel("Year");
		lblYear.setBounds(10, 229, 82, 14);
		contentPane.add(lblYear);

		lblSemester = new JLabel("Semester");
		lblSemester.setBounds(10, 276, 82, 14);
		contentPane.add(lblSemester);

		lblFaculty = new JLabel("Faculty");
		lblFaculty.setBounds(394, 34, 82, 14);
		contentPane.add(lblFaculty);

		lblSpecialication = new JLabel("Specialization");
		lblSpecialication.setBounds(394, 82, 82, 14);
		contentPane.add(lblSpecialication);

		lblCourseFee = new JLabel("Course Fee");
		lblCourseFee.setBounds(394, 129, 82, 14);
		contentPane.add(lblCourseFee);

		lblRegisteredDate = new JLabel("Registered Date");
		lblRegisteredDate.setBounds(394, 178, 96, 14);
		contentPane.add(lblRegisteredDate);

		lblBankDetails = new JLabel("Bank details");
		lblBankDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBankDetails.setBounds(10, 343, 141, 14);
		contentPane.add(lblBankDetails);

		lblNewLabel = new JLabel("Bank");
		lblNewLabel.setBounds(10, 391, 82, 14);
		contentPane.add(lblNewLabel);

		lblBranch = new JLabel("Branch");
		lblBranch.setBounds(10, 435, 82, 14);
		contentPane.add(lblBranch);

		lblDepositDate = new JLabel("Deposit Date");
		lblDepositDate.setBounds(10, 479, 82, 14);
		contentPane.add(lblDepositDate);

		// student id
		textFieldStudentID = new JTextField();
		textFieldStudentID.setEditable(false);
		textFieldStudentID.setBounds(114, 31, 135, 20);
		contentPane.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);
		textFieldStudentID.setText(semesterPayment.getStudentId());

		// student name
		textFieldStudentName = new JTextField();
		textFieldStudentName.setEditable(false);
		textFieldStudentName.setBounds(114, 79, 135, 20);
		contentPane.add(textFieldStudentName);
		textFieldStudentName.setColumns(10);
		textFieldStudentName.setText(semesterPayment.getStudentName());

		lblStatus = new JLabel("Status");
		lblStatus.setBounds(394, 229, 82, 14);
		contentPane.add(lblStatus);

		// student email
		textFieldStudentEmail = new JTextField();
		textFieldStudentEmail.setEditable(false);
		textFieldStudentEmail.setBounds(114, 126, 135, 20);
		contentPane.add(textFieldStudentEmail);
		textFieldStudentEmail.setColumns(10);
		textFieldStudentEmail.setText(semesterPayment.getStudentEmail());

		// student current year
		textFieldCurrentYear = new JTextField();
		textFieldCurrentYear.setEditable(false);
		textFieldCurrentYear.setBounds(114, 175, 135, 20);
		contentPane.add(textFieldCurrentYear);
		textFieldCurrentYear.setColumns(10);
		textFieldCurrentYear.setText(semesterPayment.getCurrentYear().toString());

		// year
		textFieldYear = new JTextField();
		textFieldYear.setEditable(false);
		textFieldYear.setBounds(114, 226, 135, 20);
		contentPane.add(textFieldYear);
		textFieldYear.setColumns(10);
		textFieldYear.setText(semesterPayment.getYear().toString());

		// semester
		textFieldSemester = new JTextField();
		textFieldSemester.setEditable(false);
		textFieldSemester.setBounds(114, 273, 135, 20);
		contentPane.add(textFieldSemester);
		textFieldSemester.setColumns(10);
		textFieldSemester.setText(semesterPayment.getSemester().toString());

		// faculty
		textFieldFaculty = new JTextField();
		textFieldFaculty.setEditable(false);
		textFieldFaculty.setBounds(500, 31, 135, 20);
		contentPane.add(textFieldFaculty);
		textFieldFaculty.setColumns(10);
		textFieldFaculty.setText(semesterPayment.getFaculty());

		// specialization
		textFieldSpecialication = new JTextField();
		textFieldSpecialication.setEditable(false);
		textFieldSpecialication.setBounds(500, 79, 135, 20);
		contentPane.add(textFieldSpecialication);
		textFieldSpecialication.setColumns(10);
		textFieldSpecialication.setText(semesterPayment.getSpecialication());

		// course Fee
		textFieldCourseFee = new JTextField();
		textFieldCourseFee.setEditable(false);
		textFieldCourseFee.setBounds(500, 126, 135, 20);
		contentPane.add(textFieldCourseFee);
		textFieldCourseFee.setColumns(10);
		textFieldCourseFee.setText(String.valueOf(semesterPayment.getCourseFee()));

		// registered date
		textFieldRegDate = new JTextField();
		textFieldRegDate.setEditable(false);
		textFieldRegDate.setBounds(500, 175, 135, 20);
		contentPane.add(textFieldRegDate);
		textFieldRegDate.setColumns(10);
		textFieldRegDate.setText(semesterPayment.getRegisteredDate().toString());

		// status
		JComboBox<String> comboBoxStatus = new JComboBox<String>();
		comboBoxStatus.setModel(new DefaultComboBoxModel<String>(new String[] { "verified", "pending" }));
		comboBoxStatus.setBounds(500, 226, 135, 20);
		contentPane.add(comboBoxStatus);
		comboBoxStatus.setSelectedItem(semesterPayment.getStatus());

		// bank
		textFieldBank = new JTextField();
		textFieldBank.setEditable(false);
		textFieldBank.setBounds(114, 388, 135, 20);
		contentPane.add(textFieldBank);
		textFieldBank.setColumns(10);
		textFieldBank.setText(semesterPayment.getBankName());

		// Branch
		textFieldBranch = new JTextField();
		textFieldBranch.setEditable(false);
		textFieldBranch.setBounds(114, 432, 135, 20);
		contentPane.add(textFieldBranch);
		textFieldBranch.setColumns(10);
		textFieldBranch.setText(semesterPayment.getBranchName());

		// deposit Date
		textFieldDepDate = new JTextField();
		textFieldDepDate.setEditable(false);
		textFieldDepDate.setBounds(114, 476, 135, 20);
		contentPane.add(textFieldDepDate);
		textFieldDepDate.setColumns(10);
		textFieldDepDate.setText(semesterPayment.getDate().toString());

		// update button
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(Color.BLUE);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sid = textFieldStudentID.getText();
				int year = Integer.parseInt(textFieldYear.getText());
				int semester = Integer.parseInt(textFieldSemester.getText());
				String status = (String) comboBoxStatus.getSelectedItem();

				// call SemesterPaymentHandler update method
				boolean result = SemesterPaymentHandler.update(sid, year, semester, status);
				if (result) {
					JOptionPane.showMessageDialog(null, "Successfully Updated");
				} else {
					JOptionPane.showMessageDialog(null, "Some thing wrong in database");
				}
			}
		});
		btnUpdate.setBounds(419, 420, 116, 44);
		contentPane.add(btnUpdate);

		// delete button
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Do yo want to delete this record?", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					String sid = textFieldStudentID.getText();
					int year = Integer.parseInt(textFieldYear.getText());
					int semester = Integer.parseInt(textFieldSemester.getText());

					// call SemesterPaymentHandler delete method
					boolean result = SemesterPaymentHandler.delete(sid, year, semester);
					if (result) {
						JOptionPane.showMessageDialog(null, "Successfully Delete");
					} else {
						JOptionPane.showMessageDialog(null, "Some thing wrong in database");
					}
				}
			}
		});
		btnDelete.setBounds(569, 420, 116, 44);
		contentPane.add(btnDelete);
	}
}
