package com.csse.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class EditCourse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCourse frame = new EditCourse();
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
	public EditCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 772, 380);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Course code");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(39, 60, 85, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Course Name");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(39, 99, 85, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("No of credits");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(39, 136, 85, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Year");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(39, 174, 68, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Lecturer in charge");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(382, 57, 120, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Duration");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(382, 99, 68, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("From");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(408, 136, 68, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("To");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(408, 178, 42, 14);
		panel.add(label_7);
		
		JLabel lblUpdateCourseDetails = new JLabel("Update Course Details");
		lblUpdateCourseDetails.setForeground(Color.DARK_GRAY);
		lblUpdateCourseDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUpdateCourseDetails.setBounds(10, 11, 210, 34);
		panel.add(lblUpdateCourseDetails);
		
		JLabel label_9 = new JLabel("Subject Stream");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(39, 211, 103, 14);
		panel.add(label_9);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(161, 60, 108, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(161, 99, 108, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(161, 134, 108, 20);
		panel.add(textField_2);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(457, 136, 141, 20);
		panel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(457, 174, 141, 20);
		panel.add(dateChooser_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.DARK_GRAY);
		btnUpdate.setFont(new Font("Cambria", Font.BOLD, 14));
		btnUpdate.setBackground(new Color(60, 179, 113));
		btnUpdate.setBounds(465, 296, 89, 31);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.setFont(new Font("Cambria", Font.BOLD, 14));
		btnDelete.setBackground(new Color(192, 192, 192));
		btnDelete.setBounds(564, 296, 89, 31);
		panel.add(btnDelete);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(512, 58, 141, 20);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(161, 172, 108, 20);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(161, 209, 108, 20);
		panel.add(comboBox_2);
	}
}
