package com.csse.interfaces.payment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentAdminUI extends JFrame {

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
					PaymentAdminUI frame = new PaymentAdminUI();
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
	public PaymentAdminUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnViewSemesterPayment = new JButton("View Semester Payment");
		btnViewSemesterPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSemesterPaymentUI adminSemesterPaymentUI = new AdminSemesterPaymentUI();
				adminSemesterPaymentUI.setVisible(true);
			}
		});
		btnViewSemesterPayment.setBounds(22, 116, 207, 23);
		contentPane.add(btnViewSemesterPayment);
	}

}
