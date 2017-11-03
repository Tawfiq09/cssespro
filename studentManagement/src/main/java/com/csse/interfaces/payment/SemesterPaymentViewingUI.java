package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.csse.payment.Service;
import com.csse.payment.semester_payment.SemesterPaymentHandler;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class SemesterPaymentViewingUI extends JFrame {

	/**
	 * UI for search payment details for student
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentID;
	private JTextField textFieldNIC;
	private JTable table;
	private ResultSet resultSet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SemesterPaymentViewingUI frame = new SemesterPaymentViewingUI();
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
	public SemesterPaymentViewingUI() {
		setResizable(false);
		setTitle("View Payment Deatils");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 879, 505);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// set db connection to both Service and SemesterPaymentHandler classes
		try {
			Service.setconnection();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Db connection error");
		}
		try {
			SemesterPaymentHandler.setconnection();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Db connection error");
		}

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(47, 45, 80, 14);
		contentPane.add(lblStudentId);

		// student id
		textFieldStudentID = new JTextField();
		textFieldStudentID.setBounds(137, 42, 86, 20);
		contentPane.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);

		JLabel lblNic = new JLabel("NIC");
		lblNic.setBounds(288, 45, 46, 14);
		contentPane.add(lblNic);

		// student nic
		textFieldNIC = new JTextField();
		textFieldNIC.setBounds(344, 42, 86, 20);
		contentPane.add(textFieldNIC);
		textFieldNIC.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 121, 759, 291);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		// search button
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setBackground(Color.BLUE);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					resultSet = SemesterPaymentHandler.studentSearch(textFieldStudentID.getText());
					table.setModel(DbUtils.resultSetToTableModel(resultSet));
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Db error");
				}

			}
		});
		btnSearch.setBounds(482, 41, 89, 23);
		contentPane.add(btnSearch);

	}
}
