package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class SemesterPaymentViewingUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentID;
	private JTextField textFieldNIC;
	private JTable table;

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
		setTitle("View Payment Deatils");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 722, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(47, 45, 80, 14);
		contentPane.add(lblStudentId);
		
		textFieldStudentID = new JTextField();
		textFieldStudentID.setBounds(137, 42, 86, 20);
		contentPane.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);
		
		JLabel lblNic = new JLabel("NIC");
		lblNic.setBounds(288, 45, 46, 14);
		contentPane.add(lblNic);
		
		textFieldNIC = new JTextField();
		textFieldNIC.setBounds(344, 42, 86, 20);
		contentPane.add(textFieldNIC);
		textFieldNIC.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(482, 41, 89, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 121, 622, 291);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
