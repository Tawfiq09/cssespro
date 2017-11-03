package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.csse.payment.exam_payment.ExamPaymentHandler;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class ExamPaymentViewingUI extends JFrame {

	/**
	 * This UI for student to view there exam payments
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentId;
	private JTextField textFieldNic;
	private JTable table;
	private ResultSet resultSet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamPaymentViewingUI frame = new ExamPaymentViewingUI();
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
	public ExamPaymentViewingUI() {
		setResizable(false);
		setTitle("view payment details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 758, 493);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			ExamPaymentHandler.setconnection();
		} catch (ClassNotFoundException e2) {
			JOptionPane.showMessageDialog(null, "Db connection error");
		}

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(30, 30, 82, 14);
		contentPane.add(lblStudentId);

		// student id
		textFieldStudentId = new JTextField();
		textFieldStudentId.setBounds(114, 27, 135, 20);
		contentPane.add(textFieldStudentId);
		textFieldStudentId.setColumns(10);

		JLabel lblNic = new JLabel("Nic");
		lblNic.setBounds(308, 30, 46, 14);
		contentPane.add(lblNic);

		// nic
		textFieldNic = new JTextField();
		textFieldNic.setBounds(364, 27, 135, 20);
		contentPane.add(textFieldNic);
		textFieldNic.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 722, 295);
		contentPane.add(scrollPane);

		//table
		table = new JTable();
		scrollPane.setViewportView(table);

		//search button
		JButton btnSearch = new JButton("Search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(Color.BLUE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldStudentId.getText().trim().isEmpty()) {
					try {
						resultSet = ExamPaymentHandler.studentSearch(textFieldStudentId.getText());
						table.setModel(DbUtils.resultSetToTableModel(resultSet));
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Db error");
					}
					
				}
			}
		});
		btnSearch.setBounds(575, 26, 101, 23);
		contentPane.add(btnSearch);
	}
}
