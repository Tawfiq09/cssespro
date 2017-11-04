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

import com.csse.course.DBConnection;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class course_1 extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private JTable table_1;
	
	private static Connection connection = null;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private JTextField descript;
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
		scrollPane.setBounds(141, 162, 477, 119);
		panel_1.add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"From", "To", "Description"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table1.getColumnModel().getColumn(2).setPreferredWidth(150);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFrom.setBounds(22, 97, 46, 20);
		panel_1.add(lblFrom);
		
		JLabel lblNewLabel = new JLabel("To");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(206, 97, 37, 20);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Description");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(372, 97, 79, 20);
		panel_1.add(lblNewLabel_1);
		
		JDateChooser from_date = new JDateChooser();
		from_date.setBounds(65, 97, 110, 20);
		panel_1.add(from_date);
		
		JDateChooser to_date = new JDateChooser();
		to_date.setBounds(242, 97, 110, 20);
		panel_1.add(to_date);
		
		JLabel lblAddSchedule = new JLabel("Add Schedule");
		lblAddSchedule.setForeground(Color.DARK_GRAY);
		lblAddSchedule.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddSchedule.setBounds(10, 22, 141, 34);
		panel_1.add(lblAddSchedule);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				String data1 = df.format(from_date.getDate());
			    String data2 = df.format(to_date.getDate());
			    String data3 = descript.getText();
			 
			    Object[] row = { data1, data2, data3 };

			    DefaultTableModel model = (DefaultTableModel) table1.getModel();

			    model.addRow(row);
			}
		});
		btnAdd.setForeground(Color.DARK_GRAY);
		btnAdd.setFont(new Font("Cambria", Font.BOLD, 14));
		btnAdd.setBackground(new Color(60, 179, 113));
		btnAdd.setBounds(629, 92, 89, 31);
		panel_1.add(btnAdd);
		
		JLabel lblIt = new JLabel("it150");
		lblIt.setForeground(Color.DARK_GRAY);
		lblIt.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIt.setBounds(199, 22, 141, 34);
		panel_1.add(lblIt);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					connection = DBConnection.getconnection();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				int row = table1.getRowCount();
				Date from_date1 = null;
				Date to_date1 = null;
				
				for(int i = 0 ; i<row ;i++) {
					String course_code = lblIt.getText();
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					
					
					
					try {
						 from_date1 =  df.parse((String) table1.getValueAt(i, 0));
						 to_date1 = df.parse((String) table1.getValueAt(i, 1));
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					String descript1 = (String) table1.getValueAt(i, 2);
					
					java.sql.Date sqlfromdate = new java.sql.Date(from_date1.getTime());
					java.sql.Date sqltodate = new java.sql.Date(to_date1.getTime());
					System.out.println(course_code+sqlfromdate+sqltodate+descript);
					
					//String query = "Insert into course_schedule values ('" + course_code + "','" + sqlfromdate + "','" + sqltodate + "','" + descript1 + "')";
					
					try {
					//	preparedStatement = connection.prepareStatement(query);
						preparedStatement.executeUpdate();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
			}
			
		});
		btnSave.setForeground(Color.DARK_GRAY);
		btnSave.setFont(new Font("Cambria", Font.BOLD, 14));
		btnSave.setBackground(new Color(60, 179, 113));
		btnSave.setBounds(629, 318, 89, 31);
		panel_1.add(btnSave);
		
		descript = new JTextField();
		descript.setFont(new Font("Tahoma", Font.PLAIN, 12));
		descript.setBounds(448, 98, 170, 45);
		panel_1.add(descript);
		descript.setColumns(10);
		
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
