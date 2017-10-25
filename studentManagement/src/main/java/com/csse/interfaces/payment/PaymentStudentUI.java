package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class PaymentStudentUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentStudentUI frame = new PaymentStudentUI();
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
	public PaymentStudentUI() {
		setResizable(false);
		setTitle("Student Payment Panel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 627, 380);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSemesterRegistrationPayment = new JButton("Semester Registration Payment");
		btnSemesterRegistrationPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSemesterRegistrationPayment.setForeground(Color.WHITE);
		btnSemesterRegistrationPayment.setBackground(SystemColor.textHighlight);
		btnSemesterRegistrationPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SemesterPaymentUI semesterPaymentUI = new SemesterPaymentUI();
				semesterPaymentUI.setVisible(true);
			}
		});
		btnSemesterRegistrationPayment.setBounds(39, 36, 237, 70);
		contentPane.add(btnSemesterRegistrationPayment);

		JButton btnExamRegistrationPayment = new JButton("Exam Registration Payment");
		btnExamRegistrationPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExamRegistrationPayment.setForeground(Color.WHITE);
		btnExamRegistrationPayment.setBackground(SystemColor.textHighlight);
		btnExamRegistrationPayment.setBounds(338, 36, 237, 70);
		contentPane.add(btnExamRegistrationPayment);

		JButton btnViewSemesterPayment = new JButton("View Semester Payment Details");
		btnViewSemesterPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewSemesterPayment.setForeground(Color.WHITE);
		btnViewSemesterPayment.setBackground(SystemColor.textHighlight);
		btnViewSemesterPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SemesterPaymentViewingUI semesterPaymentViewingUI = new SemesterPaymentViewingUI();
				semesterPaymentViewingUI.setVisible(true);
			}
		});
		btnViewSemesterPayment.setBounds(39, 166, 237, 70);
		contentPane.add(btnViewSemesterPayment);

		JButton btnViewExamPayment = new JButton("View Exam payment Deatils");
		btnViewExamPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewExamPayment.setForeground(Color.WHITE);
		btnViewExamPayment.setBackground(SystemColor.textHighlight);
		btnViewExamPayment.setBounds(338, 166, 237, 70);
		contentPane.add(btnViewExamPayment);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentAdminUI paymentAdminUI = new PaymentAdminUI();
				paymentAdminUI.setVisible(true);
			}
		});
		btnAdmin.setBounds(241, 293, 89, 23);
		contentPane.add(btnAdmin);
	}

}
