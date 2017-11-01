package com.csse.interfaces.payment;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import java.awt.Font;
import java.awt.Color;

public class ExamPaymentUI extends JFrame {

	/**
	 * This ui for record payment details of exam
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
	private JDateChooser dateChooserReDate;
	private JComboBox<String> comboBoxFaculty;
	private JComboBox<String> comboBoxBank;
	private JDateChooser dateChooserDepDate;
	private JComboBox<String> comboBoxsemeste;

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

		// set db connection for both Service and ExamPaymentHandler
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

		// reg gate
		dateChooserReDate = new JDateChooser();
		dateChooserReDate.setDateFormatString(" yyyy-MM-dd");
		dateChooserReDate.setBounds(142, 440, 180, 20);
		contentPane.add(dateChooserReDate);
		dateChooserReDate.setMinSelectableDate(new Date());

		// student id
		textFieldStudentID = new JTextField();
		textFieldStudentID.setBounds(142, 37, 180, 20);
		contentPane.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);

		// student name
		textFieldStudentName = new JTextField();
		textFieldStudentName.setBounds(142, 77, 180, 20);
		contentPane.add(textFieldStudentName);
		textFieldStudentName.setColumns(10);

		// student email
		textFieldStudentEmail = new JTextField();
		textFieldStudentEmail.setBounds(142, 117, 180, 20);
		contentPane.add(textFieldStudentEmail);
		textFieldStudentEmail.setColumns(10);

		// year
		textFieldYear = new JTextField();
		textFieldYear.setEditable(false);
		textFieldYear.setBounds(142, 157, 180, 20);
		contentPane.add(textFieldYear);
		textFieldYear.setColumns(10);
		String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		textFieldYear.setText(year);

		// faculty
		comboBoxFaculty = new JComboBox<String>();
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

		// current year of university
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

		// Specialization
		comboBoxSpecialization = new JComboBox<String>();
		comboBoxSpecialization.setModel(new DefaultComboBoxModel<String>(new String[] { "select" }));
		comboBoxSpecialization.setBounds(142, 277, 180, 20);
		contentPane.add(comboBoxSpecialization);

		JLabel lblExamFee = new JLabel("Exam Fee");
		lblExamFee.setBounds(10, 400, 82, 14);
		contentPane.add(lblExamFee);

		// exam fee
		textFieldExamFee = new JTextField();
		textFieldExamFee.setEditable(false);
		textFieldExamFee.setBounds(142, 397, 180, 20);
		contentPane.add(textFieldExamFee);
		textFieldExamFee.setColumns(10);

		// branch
		textFieldBranch = new JTextField();
		textFieldBranch.setBounds(500, 77, 135, 20);
		contentPane.add(textFieldBranch);
		textFieldBranch.setColumns(10);

		// bank
		comboBoxBank = new JComboBox<String>();
		comboBoxBank.setModel(new DefaultComboBoxModel<String>(new String[] { "Sampath Bank", "BOC", "NTB" }));
		comboBoxBank.setBounds(500, 37, 135, 20);
		contentPane.add(comboBoxBank);

		// dep date
		dateChooserDepDate = new JDateChooser();
		dateChooserDepDate.setDateFormatString("yyyy-MM-dd");
		dateChooserDepDate.setBounds(500, 116, 135, 20);
		contentPane.add(dateChooserDepDate);
		dateChooserDepDate.setMaxSelectableDate(new Date());

		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(10, 320, 82, 14);
		contentPane.add(lblSemester);

		// semester
		comboBoxsemeste = new JComboBox<String>();
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

		// examination
		textFieldExamination = new JTextField();
		textFieldExamination.setEditable(false);
		textFieldExamination.setBounds(142, 357, 180, 20);
		contentPane.add(textFieldExamination);
		textFieldExamination.setColumns(10);

		// submit button
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isempty()) {
					if (validateEmail(textFieldStudentEmail)) {
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
						if (!ExamPaymentHandler.checkRecordAlreadyExist(examPayment)) {
							boolean result = ExamPaymentHandler.add(examPayment);
							if (result) {
								JOptionPane.showMessageDialog(null, "successfully Recorded");
							} else {
								JOptionPane.showMessageDialog(null, "Database error");
							}
						} else {
							JOptionPane.showMessageDialog(null, "You cannot add same record two times");
						}
					} else {
						JOptionPane.showMessageDialog(null, "please enter valid email ");
					}
				} else {
					JOptionPane.showMessageDialog(null, "All mandatory feilds must be filled");
				}
			}
		});
		btnSubmit.setBounds(500, 276, 115, 46);
		contentPane.add(btnSubmit);

		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(70, 40, 17, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_1.setBounds(90, 80, 17, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(90, 120, 17, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(53, 200, 17, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(85, 240, 17, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(90, 280, 17, 14);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(70, 320, 17, 14);
		contentPane.add(label_6);

		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(80, 360, 17, 14);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setBounds(65, 400, 17, 14);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("*");
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(110, 440, 17, 14);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("*");
		label_10.setForeground(Color.RED);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(425, 40, 17, 14);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("*");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(435, 80, 17, 14);
		contentPane.add(label_11);

		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_12.setBounds(468, 120, 17, 14);
		contentPane.add(label_12);
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

	// method to fill specialization comboBox
	public void fillSpecialicationComboBox(JComboBox<String> jComboBox, ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				jComboBox.addItem(resultSet.getString("specialization"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// check all components
	public boolean isempty() {
		boolean textBoxes = checkTextBoxes();
		boolean comboBoxes = checkComboBoxes();
		boolean dateChoosers = checkDateChoosers();
		if (textBoxes && comboBoxes && dateChoosers) {
			return false;
		}

		return true;
	}

	// check textFields
	public boolean checkTextBoxes() {

		if (!textFieldStudentID.getText().trim().isEmpty() && !textFieldStudentName.getText().trim().isEmpty()
				&& !textFieldStudentEmail.getText().trim().isEmpty() && !textFieldBranch.getText().trim().isEmpty()) {
			return true;
		}

		return false;
	}

	// check comboBoxes
	public boolean checkComboBoxes() {
		if (!comboBoxCurrentYear.getSelectedItem().equals("select")
				&& !comboBoxsemeste.getSelectedItem().equals("select")
				&& !comboBoxFaculty.getSelectedItem().equals("select")
				&& !comboBoxSpecialization.getSelectedItem().equals("select")) {
			return true;
		}

		return false;
	}

	// check dateChoosers
	public boolean checkDateChoosers() {

		Date RegisterdDate = dateChooserReDate.getDate();

		Date DepositDate = dateChooserDepDate.getDate();
		if (RegisterdDate != null && DepositDate != null) {
			return true;
		}
		return false;
	}

	// check email
	public boolean validateEmail(JTextField textField) {
		Pattern email = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = email.matcher(textField.getText());
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

}
