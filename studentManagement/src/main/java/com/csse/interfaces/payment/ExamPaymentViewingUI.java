package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class ExamPaymentViewingUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentId;
	private JTextField textFieldNic;
	private JTable table;

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
		setTitle("view payment details");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 758, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(30, 30, 82, 14);
		contentPane.add(lblStudentId);
		
		textFieldStudentId = new JTextField();
		textFieldStudentId.setBounds(114, 27, 135, 20);
		contentPane.add(textFieldStudentId);
		textFieldStudentId.setColumns(10);
		
		JLabel lblNic = new JLabel("Nic");
		lblNic.setBounds(308, 30, 46, 14);
		contentPane.add(lblNic);
		
		textFieldNic = new JTextField();
		textFieldNic.setBounds(364, 27, 135, 20);
		contentPane.add(textFieldNic);
		textFieldNic.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 98, 702, 295);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(575, 26, 101, 23);
		contentPane.add(btnSearch);
	}
}
