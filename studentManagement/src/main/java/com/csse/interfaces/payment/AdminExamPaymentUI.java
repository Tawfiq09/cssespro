package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JYearChooser;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminExamPaymentUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentId;
	private JTable table;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		textFieldStudentId = new JTextField();
		textFieldStudentId.setBounds(90, 51, 120, 20);
		panel.add(textFieldStudentId);
		textFieldStudentId.setColumns(10);
		
		JLabel lblStudentWiseSearch = new JLabel("Student Wise Search");
		lblStudentWiseSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentWiseSearch.setBounds(10, 11, 156, 14);
		panel.add(lblStudentWiseSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(104, 164, 89, 23);
		panel.add(btnSearch);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(90, 89, 47, 20);
		panel.add(yearChooser);
		
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
		
		JButton btnSearchExam = new JButton("Search");
		btnSearchExam.setBounds(262, 170, 89, 23);
		panel_1.add(btnSearchExam);
		
		JYearChooser yearChooser_1 = new JYearChooser();
		yearChooser_1.setBounds(102, 42, 47, 20);
		panel_1.add(yearChooser_1);
		
		JComboBox<String> comboBoxfaculty = new JComboBox<String>();
		comboBoxfaculty.setModel(new DefaultComboBoxModel<String>(new String[] {"select"}));
		comboBoxfaculty.setBounds(102, 84, 134, 20);
		panel_1.add(comboBoxfaculty);
		
		JComboBox<String> comboBoxExamination = new JComboBox<String>();
		comboBoxExamination.setModel(new DefaultComboBoxModel<String>(new String[] {"select"}));
		comboBoxExamination.setBounds(102, 133, 131, 20);
		panel_1.add(comboBoxExamination);
		
		table = new JTable();
		table.setBounds(10, 232, 1008, 363);
		contentPane.add(table);
	}
}
