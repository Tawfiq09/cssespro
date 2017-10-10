package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSemesterRegistrationPayment = new JButton("Semester Registration Payment");
		btnSemesterRegistrationPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SemesterPaymentUI semesterPaymentUI = new SemesterPaymentUI();
				semesterPaymentUI.setVisible(true);
			}
		});
		btnSemesterRegistrationPayment.setBounds(118, 95, 197, 23);
		contentPane.add(btnSemesterRegistrationPayment);
		
		JButton btnExamRegistrationPayment = new JButton("Exam Registration Payment");
		btnExamRegistrationPayment.setBounds(118, 165, 197, 23);
		contentPane.add(btnExamRegistrationPayment);
	}

}
