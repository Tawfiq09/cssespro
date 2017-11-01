package com.csse.interfaces.payment;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.csse.payment.Service;
import com.csse.payment.exam_payment.ExamPayment;
import com.csse.payment.exam_payment.ExamPaymentHandler;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField textFieldExamination;
	private JComboBox<String> comboBoxSpecialization;
	private JComboBox<String> comboBoxCurrentYear;

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
		setBounds(100, 100, 760, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Service.setconnection();
		ExamPaymentHandler.setconnection();

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
		lblExamination.setBounds(10, 360, 82, 14);
		contentPane.add(lblExamination);

		JLabel lblBank = new JLabel("Bank");
		lblBank.setBounds(394, 41, 82, 14);
		contentPane.add(lblBank);

		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(394, 81, 82, 14);
		contentPane.add(lblBranch);

		JLabel lblRegistrationDate = new JLabel("Registration Date");
		lblRegistrationDate.setBounds(10, 440, 108, 14);
		contentPane.add(lblRegistrationDate);

		JLabel lblDepositDate = new JLabel("Deposit Date");
		lblDepositDate.setBounds(394, 122, 82, 14);
		contentPane.add(lblDepositDate);

		JDateChooser dateChooserReDate = new JDateChooser();
		dateChooserReDate.setDateFormatString(" yyyy-MM-dd");
		dateChooserReDate.setBounds(142, 440, 180, 20);
		contentPane.add(dateChooserReDate);
		dateChooserReDate.setMinSelectableDate(new Date());

		textFieldStudentID = new JTextField();
		textFieldStudentID.setBounds(142, 37, 180, 20);
		contentPane.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);

		textFieldStudentName = new JTextField();
		textFieldStudentName.setBounds(142, 77, 180, 20);
		contentPane.add(textFieldStudentName);
		textFieldStudentName.setColumns(10);

		textFieldStudentEmail = new JTextField();
		textFieldStudentEmail.setBounds(142, 117, 180, 20);
		contentPane.add(textFieldStudentEmail);
		textFieldStudentEmail.setColumns(10);

		textFieldYear = new JTextField();
		textFieldYear.setBounds(142, 157, 180, 20);
		contentPane.add(textFieldYear);
		textFieldYear.setColumns(10);
		String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		textFieldYear.setText(year);

		JComboBox<String> comboBoxFaculty = new JComboBox<String>();
		comboBoxFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comboBoxFaculty.getSelectedItem().equals("select")
						&& !comboBoxCurrentYear.getSelectedItem().equals("select")) {
					String faculty = (String) comboBoxFaculty.getSelectedItem();
					int year = Integer.parseInt((String) comboBoxCurrentYear.getSelectedItem());
					comboBoxSpecialization.removeAllItems();
					fillSpecialicationComboBox(comboBoxSpecialization, Service.fillSpecialication(faculty, year));
				}
			}
		});
		comboBoxFaculty.setModel(new DefaultComboBoxModel<String>(new String[] { "select" }));
		comboBoxFaculty.setBounds(142, 197, 180, 20);
		contentPane.add(comboBoxFaculty);
		fillFacultyComboBox(comboBoxFaculty, Service.fillFaculty());

		comboBoxCurrentYear = new JComboBox<String>();
		comboBoxCurrentYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comboBoxFaculty.getSelectedItem().equals("select")
						&& !comboBoxCurrentYear.getSelectedItem().equals("select")) {
					String faculty = (String) comboBoxFaculty.getSelectedItem();
					int year = Integer.parseInt((String) comboBoxCurrentYear.getSelectedItem());
					comboBoxSpecialization.removeAllItems();
					fillSpecialicationComboBox(comboBoxSpecialization, Service.fillSpecialication(faculty, year));
				}
			}
		});
		comboBoxCurrentYear.setModel(new DefaultComboBoxModel<String>(new String[] { "select", "1", "2", "3", "4" }));
		comboBoxCurrentYear.setBounds(142, 237, 180, 20);
		contentPane.add(comboBoxCurrentYear);

		comboBoxSpecialization = new JComboBox<String>();
		comboBoxSpecialization.setModel(new DefaultComboBoxModel<String>(new String[] { "select" }));
		comboBoxSpecialization.setBounds(142, 277, 180, 20);
		contentPane.add(comboBoxSpecialization);

		JLabel lblExamFee = new JLabel("Exam Fee");
		lblExamFee.setBounds(10, 400, 82, 14);
		contentPane.add(lblExamFee);

		textFieldExamFee = new JTextField();
		textFieldExamFee.setBounds(142, 397, 180, 20);
		contentPane.add(textFieldExamFee);
		textFieldExamFee.setColumns(10);

		textFieldBranch = new JTextField();
		textFieldBranch.setBounds(500, 77, 135, 20);
		contentPane.add(textFieldBranch);
		textFieldBranch.setColumns(10);

		JComboBox<String> comboBoxBank = new JComboBox<String>();
		comboBoxBank.setModel(new DefaultComboBoxModel<String>(new String[] {"Sampath Bank", "BOC", "NTB"}));
		comboBoxBank.setBounds(500, 37, 135, 20);
		contentPane.add(comboBoxBank);

		JDateChooser dateChooserDepDate = new JDateChooser();
		dateChooserDepDate.setDateFormatString("yyyy-MM-dd");
		dateChooserDepDate.setBounds(500, 116, 135, 20);
		contentPane.add(dateChooserDepDate);
		dateChooserDepDate.setMaxSelectableDate(new Date());
		

		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(10, 320, 82, 14);
		contentPane.add(lblSemester);

		JComboBox<String> comboBoxsemeste = new JComboBox<String>();
		comboBoxsemeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!comboBoxsemeste.getSelectedItem().equals("select")
						&& !comboBoxFaculty.getSelectedItem().equals("select")
						&& !comboBoxCurrentYear.getSelectedItem().equals("select")
						&& !comboBoxSpecialization.getSelectedItem().equals("select")) {
					String faculty = (String) comboBoxFaculty.getSelectedItem();
					int year_of_university = Integer.parseInt((String) comboBoxCurrentYear.getSelectedItem());
					String specialization = (String) comboBoxSpecialization.getSelectedItem();
					int semester = Integer.parseInt((String) comboBoxsemeste.getSelectedItem());
					int year = Integer.parseInt(textFieldYear.getText());
					ResultSet resultSet = Service.getExaminationDetails(faculty, year_of_university, specialization,
							semester, year);
					try {
						while (resultSet.next()) {
							textFieldExamination.setText(resultSet.getString("exam_Name"));
							textFieldExamFee.setText(String.valueOf(resultSet.getDouble("exam_fee")));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		comboBoxsemeste.setModel(new DefaultComboBoxModel<String>(new String[] { "select", "1", "2" }));
		comboBoxsemeste.setBounds(142, 317, 180, 20);
		contentPane.add(comboBoxsemeste);

		textFieldExamination = new JTextField();
		textFieldExamination.setBounds(142, 357, 180, 20);
		contentPane.add(textFieldExamination);
		textFieldExamination.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExamPayment examPayment = new ExamPayment();
				examPayment.setStudent_id(textFieldStudentID.getText());
				examPayment.setStudent_name(textFieldStudentName.getText());
				examPayment.setStudent_email(textFieldStudentEmail.getText());
				examPayment.setYear(Integer.parseInt(textFieldYear.getText()));
				examPayment.setFaculty((String) comboBoxFaculty.getSelectedItem());
				examPayment.setCurrent_year(Integer.parseInt((String) comboBoxCurrentYear.getSelectedItem()));
				examPayment.setSpecialization((String) comboBoxSpecialization.getSelectedItem());
				examPayment.setSemester(Integer.parseInt((String) comboBoxsemeste.getSelectedItem()));
				examPayment.setExamination(textFieldExamination.getText());
				examPayment.setExam_fee(Double.parseDouble(textFieldExamFee.getText()));
				examPayment.setRegistered_date(dateChooserReDate.getDate());
				examPayment.setBank((String) comboBoxBank.getSelectedItem());
				examPayment.setBranch(textFieldBranch.getText());
				examPayment.setDeposit_date(dateChooserDepDate.getDate());
				examPayment.setStatus("pending");
				
				boolean result = ExamPaymentHandler.add(examPayment);
				if(result) {
					JOptionPane.showMessageDialog(null, "successfully Recorded");
				}
				else {
					JOptionPane.showMessageDialog(null, "Database error");
				}
			}
		});
		btnSubmit.setBounds(500, 276, 115, 46);
		contentPane.add(btnSubmit);
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
