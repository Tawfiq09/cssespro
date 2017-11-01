package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.csse.payment.Service;
import com.csse.payment.exam_payment.ExamPayment;
import com.csse.payment.exam_payment.ExamPaymentHandler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class AdminExamPaymentManupulationUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentID;
	private JTextField textFieldStudentName;
	private JTextField textFieldStudentEmail;
	private JTextField textFieldYear;
	private JTextField textFieldFaculty;
	private JTextField textFieldcurrentYear;
	private JTextField textFieldSpecialization;
	private JTextField textFieldExamination;
	private JTextField textFieldRegDate;
	private JTextField textFieldExamFee;
	private JTextField textFieldBank;
	private JTextField textFieldbranch;
	private JTextField textFieldDepDate;
	private JTextField textFieldsemester;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamPayment examPayment = new ExamPayment();
					AdminExamPaymentManupulationUI frame = new AdminExamPaymentManupulationUI(examPayment);
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
	public AdminExamPaymentManupulationUI(ExamPayment examPayment) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 773, 517);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Service.setconnection();

		JLabel label = new JLabel("Student ID");
		label.setBounds(43, 30, 82, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Student Name");
		label_1.setBounds(43, 70, 82, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Student Email");
		label_2.setBounds(43, 110, 82, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Year");
		label_3.setBounds(43, 150, 82, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Faculty");
		label_4.setBounds(43, 190, 82, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Current Year");
		label_5.setBounds(43, 230, 82, 14);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("Specialization");
		label_6.setBounds(43, 270, 82, 14);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("Examination");
		label_7.setBounds(43, 350, 82, 14);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("Registration Date");
		label_8.setBounds(43, 390, 108, 14);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("Exam Fee");
		label_9.setBounds(43, 430, 82, 14);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("Bank");
		label_10.setBounds(427, 31, 82, 14);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("Branch");
		label_11.setBounds(427, 71, 82, 14);
		contentPane.add(label_11);

		JLabel label_12 = new JLabel("Deposit Date");
		label_12.setBounds(427, 112, 82, 14);
		contentPane.add(label_12);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(427, 150, 46, 14);
		contentPane.add(lblStatus);

		textFieldStudentID = new JTextField();
		textFieldStudentID.setEditable(false);
		textFieldStudentID.setBounds(161, 30, 180, 20);
		contentPane.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);
		textFieldStudentID.setText(examPayment.getStudent_id());

		textFieldStudentName = new JTextField();
		textFieldStudentName.setEditable(false);
		textFieldStudentName.setBounds(161, 70, 180, 20);
		contentPane.add(textFieldStudentName);
		textFieldStudentName.setColumns(10);
		textFieldStudentName.setText(examPayment.getStudent_name());

		textFieldStudentEmail = new JTextField();
		textFieldStudentEmail.setEditable(false);
		textFieldStudentEmail.setText("");
		textFieldStudentEmail.setBounds(161, 110, 180, 20);
		contentPane.add(textFieldStudentEmail);
		textFieldStudentEmail.setColumns(10);
		textFieldStudentEmail.setText(examPayment.getStudent_email());

		textFieldYear = new JTextField();
		textFieldYear.setEditable(false);
		textFieldYear.setBounds(161, 150, 180, 20);
		contentPane.add(textFieldYear);
		textFieldYear.setColumns(10);
		textFieldYear.setText(String.valueOf(examPayment.getYear()));

		textFieldFaculty = new JTextField();
		textFieldFaculty.setEditable(false);
		textFieldFaculty.setBounds(161, 190, 180, 20);
		contentPane.add(textFieldFaculty);
		textFieldFaculty.setColumns(10);
		textFieldFaculty.setText(examPayment.getFaculty());

		textFieldcurrentYear = new JTextField();
		textFieldcurrentYear.setEditable(false);
		textFieldcurrentYear.setBounds(161, 230, 180, 20);
		contentPane.add(textFieldcurrentYear);
		textFieldcurrentYear.setColumns(10);
		textFieldcurrentYear.setText(String.valueOf(examPayment.getCurrent_year()));

		textFieldSpecialization = new JTextField();
		textFieldSpecialization.setEditable(false);
		textFieldSpecialization.setBounds(161, 270, 180, 20);
		contentPane.add(textFieldSpecialization);
		textFieldSpecialization.setColumns(10);
		textFieldSpecialization.setText(examPayment.getSpecialization());

		textFieldExamination = new JTextField();
		textFieldExamination.setEditable(false);
		textFieldExamination.setBounds(161, 347, 180, 20);
		contentPane.add(textFieldExamination);
		textFieldExamination.setColumns(10);
		textFieldExamination.setText(examPayment.getExamination());

		textFieldRegDate = new JTextField();
		textFieldRegDate.setEditable(false);
		textFieldRegDate.setBounds(161, 387, 180, 20);
		contentPane.add(textFieldRegDate);
		textFieldRegDate.setColumns(10);
		textFieldRegDate.setText(examPayment.getRegistered_date().toString());

		textFieldExamFee = new JTextField();
		textFieldExamFee.setEditable(false);
		textFieldExamFee.setBounds(161, 427, 180, 20);
		contentPane.add(textFieldExamFee);
		textFieldExamFee.setColumns(10);
		textFieldExamFee.setText(String.valueOf(examPayment.getExam_fee()));

		textFieldBank = new JTextField();
		textFieldBank.setEditable(false);
		textFieldBank.setBounds(508, 27, 180, 20);
		contentPane.add(textFieldBank);
		textFieldBank.setColumns(10);
		textFieldBank.setText(examPayment.getBank());

		textFieldbranch = new JTextField();
		textFieldbranch.setEditable(false);
		textFieldbranch.setBounds(508, 67, 180, 20);
		contentPane.add(textFieldbranch);
		textFieldbranch.setColumns(10);
		textFieldbranch.setText(examPayment.getBranch());

		textFieldDepDate = new JTextField();
		textFieldDepDate.setEditable(false);
		textFieldDepDate.setBounds(508, 107, 180, 20);
		contentPane.add(textFieldDepDate);
		textFieldDepDate.setColumns(10);
		textFieldDepDate.setText(examPayment.getDeposit_date().toString());

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "pending", "verified" }));
		comboBox.setBounds(508, 150, 180, 20);
		contentPane.add(comboBox);
		comboBox.setSelectedItem(examPayment.getStatus());

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					Date regdate = df.parse(textFieldRegDate.getText());
					java.sql.Date sqlregisteredDate = new java.sql.Date(regdate.getTime());
					boolean result = ExamPaymentHandler.upadte(textFieldStudentID.getText(), sqlregisteredDate,
							textFieldExamination.getText(), (String) comboBox.getSelectedItem());
					if (result) {
						JOptionPane.showMessageDialog(null, "Successfully Updated");
					} else {
						JOptionPane.showMessageDialog(null, "Some thing wrong in database");
					}
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnUpdate.setBounds(427, 283, 89, 23);
		contentPane.add(btnUpdate);

		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(43, 313, 82, 14);
		contentPane.add(lblSemester);

		textFieldsemester = new JTextField();
		textFieldsemester.setEditable(false);
		textFieldsemester.setBounds(159, 310, 182, 20);
		contentPane.add(textFieldsemester);
		textFieldsemester.setColumns(10);
		textFieldsemester.setText(String.valueOf(examPayment.getSemester()));
	}
}
