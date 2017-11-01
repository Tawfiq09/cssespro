package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.csse.payment.Service;
import com.csse.payment.exam_payment.ExamPayment;
import com.csse.payment.exam_payment.ExamPaymentHandler;
import com.toedter.calendar.JYearChooser;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminExamPaymentUI extends JFrame {

	/**
	 * This ui for administrator to view exam payment details
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentId;
	private JTable table;
	JComboBox<String> comboBoxfaculty;
	JComboBox<String> comboBoxExamination;
	private static ResultSet resultSet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminExamPaymentUI frame = new AdminExamPaymentUI();
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
	public AdminExamPaymentUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1044, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// set db connection for both Service and ExamPaymentHandler
		Service.setconnection();
		ExamPaymentHandler.setconnection();

		JPanel panel = new JPanel();
		panel.setBounds(10, 5, 305, 204);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblStudentId = new JLabel("Student Id");
		lblStudentId.setBounds(10, 54, 89, 14);
		panel.add(lblStudentId);

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(10, 95, 46, 14);
		panel.add(lblYear);

		// student id
		textFieldStudentId = new JTextField();
		textFieldStudentId.setBounds(90, 51, 120, 20);
		panel.add(textFieldStudentId);
		textFieldStudentId.setColumns(10);

		// panel1 year
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(90, 89, 47, 20);
		panel.add(yearChooser);

		JLabel lblStudentWiseSearch = new JLabel("Student Wise Search");
		lblStudentWiseSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentWiseSearch.setBounds(10, 11, 156, 14);
		panel.add(lblStudentWiseSearch);

		// panel 1 search button
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!textFieldStudentId.getText().trim().isEmpty()) {

					resultSet = ExamPaymentHandler.searchStudent(textFieldStudentId.getText(), yearChooser.getValue());
					table.setModel(DbUtils.resultSetToTableModel(resultSet));
				}
			}
		});
		btnSearch.setBounds(104, 164, 89, 23);
		panel.add(btnSearch);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(643, 5, 375, 204);
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblExamWiseSearch = new JLabel("Exam wise Search");
		lblExamWiseSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExamWiseSearch.setBounds(10, 11, 131, 14);
		panel_1.add(lblExamWiseSearch);

		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setBounds(10, 87, 70, 14);
		panel_1.add(lblFaculty);

		JLabel lblYear_1 = new JLabel("year");
		lblYear_1.setBounds(10, 48, 70, 14);
		panel_1.add(lblYear_1);

		JLabel lblExamination = new JLabel("Examination");
		lblExamination.setBounds(10, 136, 85, 14);
		panel_1.add(lblExamination);

		// panel 2
		JYearChooser yearChooser_1 = new JYearChooser();
		yearChooser_1.setBounds(102, 42, 47, 20);
		panel_1.add(yearChooser_1);

		// faculty
		comboBoxfaculty = new JComboBox<String>();
		comboBoxfaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!comboBoxfaculty.getSelectedItem().equals("select")) {
					fillExaminationComboBox(comboBoxExamination, Service.getExaminationDetails(yearChooser_1.getValue(),
							(String) comboBoxfaculty.getSelectedItem()));
				}
			}
		});
		comboBoxfaculty.setModel(new DefaultComboBoxModel<String>(new String[] { "select" }));
		comboBoxfaculty.setBounds(102, 84, 153, 20);
		panel_1.add(comboBoxfaculty);
		fillFacultyComboBox(comboBoxfaculty, Service.fillFaculty());

		// examination
		comboBoxExamination = new JComboBox<String>();
		comboBoxExamination.setModel(new DefaultComboBoxModel<String>(new String[] { "select" }));
		comboBoxExamination.setBounds(102, 133, 153, 20);
		panel_1.add(comboBoxExamination);

		// panel 2 search button
		JButton btnSearchExam = new JButton("Search");
		btnSearchExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!comboBoxfaculty.getSelectedItem().equals("select")
						&& !comboBoxExamination.getSelectedItem().equals("select")) {
					resultSet = ExamPaymentHandler.search((String) comboBoxExamination.getSelectedItem(),
							yearChooser_1.getValue());
					table.setModel(DbUtils.resultSetToTableModel(resultSet));
				}
			}
		});
		btnSearchExam.setBounds(276, 170, 89, 23);
		panel_1.add(btnSearchExam);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 232, 1008, 363);
		contentPane.add(scrollPane);

		// table
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				ExamPayment examPayment = new ExamPayment();
				examPayment.setStudent_id((String) model.getValueAt(i, 0));
				examPayment.setStudent_name((String) model.getValueAt(i, 1));
				examPayment.setStudent_email((String) model.getValueAt(i, 2));
				examPayment.setYear((int) model.getValueAt(i, 3));
				examPayment.setFaculty((String) model.getValueAt(i, 4));
				examPayment.setCurrent_year((int) model.getValueAt(i, 5));
				examPayment.setSpecialization((String) model.getValueAt(i, 6));
				examPayment.setSemester((int) model.getValueAt(i, 7));
				examPayment.setExamination((String) model.getValueAt(i, 8));
				examPayment.setRegistered_date((Date) model.getValueAt(i, 9));
				examPayment.setExam_fee((double) model.getValueAt(i, 10));
				examPayment.setBank((String) model.getValueAt(i, 11));
				examPayment.setBranch((String) model.getValueAt(i, 12));
				examPayment.setDeposit_date((Date) model.getValueAt(i, 13));
				examPayment.setStatus((String) model.getValueAt(i, 14));
				AdminExamPaymentManupulationUI frame = new AdminExamPaymentManupulationUI(examPayment);
				frame.setVisible(true);

			}
		});
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

	// method for fill examination comboBox
	public void fillExaminationComboBox(JComboBox<String> jComboBox, ResultSet resultSet) {
		try {
			while (resultSet.next()) {
				jComboBox.addItem(resultSet.getString("exam_Name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
