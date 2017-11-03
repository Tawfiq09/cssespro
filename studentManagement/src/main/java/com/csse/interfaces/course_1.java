package com.csse.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;

public class course_1 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					course_1 frame = new course_1();
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
	public course_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 747, 437);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 747, 437);
		panel.add(tabbedPane);
		
		JPanel content = new JPanel();
		tabbedPane.addTab("Content", null, content, null);
		content.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 742, 409);
		content.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 167, 477, 179);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"From", "To", "Description"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFrom.setBounds(24, 71, 46, 20);
		panel_1.add(lblFrom);
		
		JLabel lblNewLabel = new JLabel("To");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(207, 71, 37, 20);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(372, 71, 79, 20);
		panel_1.add(lblNewLabel_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(65, 71, 110, 20);
		panel_1.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(242, 71, 110, 20);
		panel_1.add(dateChooser_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(461, 71, 133, 46);
		panel_1.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblAddSchedule = new JLabel("Add Schedule");
		lblAddSchedule.setForeground(Color.DARK_GRAY);
		lblAddSchedule.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddSchedule.setBounds(10, 11, 141, 34);
		panel_1.add(lblAddSchedule);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(Color.DARK_GRAY);
		btnAdd.setFont(new Font("Cambria", Font.BOLD, 14));
		btnAdd.setBackground(new Color(60, 179, 113));
		btnAdd.setBounds(632, 71, 89, 31);
		panel_1.add(btnAdd);
		
		JPanel students = new JPanel();
		tabbedPane.addTab("Students", null, students, null);
		students.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 0, 740, 407);
		students.add(panel_7);
		panel_7.setBackground(Color.WHITE);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(98, 64, 493, 303);
		panel_7.add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"Student ID", "Student Name"
			}
		));
		scrollPane_2.setViewportView(table_1);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("notice", null, panel_4, null);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 0, 742, 409);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(35, 36, 363, 45);
		panel_5.add(scrollPane_3);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_3.setViewportView(textArea_1);
		
		JButton button = new JButton("Add");
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Cambria", Font.BOLD, 14));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(432, 40, 89, 30);
		panel_5.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("Hello!this is a notice");
		lblNewLabel_2.setForeground(new Color(220, 20, 60));
		lblNewLabel_2.setFont(new Font("Consolas", Font.BOLD, 18));
		lblNewLabel_2.setBounds(35, 130, 548, 30);
		panel_5.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("delete");
		lblNewLabel_3.setFont(new Font("Consolas", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(0, 0, 205));
		lblNewLabel_3.setBounds(610, 130, 61, 30);
		panel_5.add(lblNewLabel_3);
		
		JPanel assignments = new JPanel();
		tabbedPane.addTab("Assignments", null, assignments, null);
		assignments.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(0, 0, 742, 409);
		assignments.add(panel_8);
		panel_8.setLayout(null);
	}
}
