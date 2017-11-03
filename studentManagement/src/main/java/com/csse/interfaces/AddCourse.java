package com.csse.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.csse.course.add_course.addCourse;
import com.csse.course.add_course.addCourseHandler;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import net.proteanit.sql.DbUtils;

public class AddCourse extends JFrame {

	private JPanel contentPane;
	private JTextField course_code;
	private JTextField course_name;
	private JTextField no_of_credits;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField searchtxt;
	private JComboBox combofaculty;
	private JComboBox lecture_in_charge;
	JComboBox year;
	JComboBox sub_stream;
	JDateChooser from_date;
	JDateChooser to_date;
	private static ResultSet resultSet;
	private static JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse frame = new AddCourse();
					frame.setVisible(true);
					
					resultSet = addCourseHandler.courseload();
					table_1.setModel(DbUtils.resultSetToTableModel(resultSet));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCourse() {
		addCourseHandler.setconnection();
		
		//resultSet = addCourseHandler.courseload();
		//table_1.setModel(DbUtils.resultSetToTableModel(resultSet));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 777, 436);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		tabbedPane.setBounds(0, 0, 777, 436);
		panel_1.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add courses", null, panel, null);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course code");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(39, 60, 85, 14);
		panel.add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCourseName.setBounds(39, 99, 85, 14);
		panel.add(lblCourseName);
		
		JLabel lblNoOfCredits = new JLabel("No of credits");
		lblNoOfCredits.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoOfCredits.setBounds(39, 136, 85, 14);
		panel.add(lblNoOfCredits);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYear.setBounds(382, 58, 68, 14);
		panel.add(lblYear);
		
		JLabel lblLecturerInCharge = new JLabel("Lecturer in charge");
		lblLecturerInCharge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLecturerInCharge.setBounds(382, 136, 120, 14);
		panel.add(lblLecturerInCharge);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDuration.setBounds(382, 178, 68, 14);
		panel.add(lblDuration);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFrom.setBounds(408, 215, 68, 14);
		panel.add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTo.setBounds(408, 257, 42, 14);
		panel.add(lblTo);
		
		JLabel lblCourses = new JLabel("Add Courses");
		lblCourses.setForeground(Color.DARK_GRAY);
		lblCourses.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCourses.setBounds(10, 11, 141, 34);
		panel.add(lblCourses);
		
		JLabel lblSubjectStream = new JLabel("Subject Stream");
		lblSubjectStream.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubjectStream.setBounds(382, 95, 103, 14);
		panel.add(lblSubjectStream);
		
		combofaculty = new JComboBox();
		combofaculty.setModel(new DefaultComboBoxModel(new String[] {"engineering", "bussiness", "IT", "science"}));
		combofaculty.setBounds(161, 178, 108, 20);
		panel.add(combofaculty);
		
		JComboBox combograduate = new JComboBox();
		combograduate.setModel(new DefaultComboBoxModel(new String[] {"undergraduate", "post graduate"}));
		combograduate.setBounds(161, 215, 108, 20);
		panel.add(combograduate);
		
		course_code = new JTextField();
		course_code.setBounds(161, 60, 108, 20);
		panel.add(course_code);
		course_code.setColumns(10);
		
		course_name = new JTextField();
		course_name.setColumns(10);
		course_name.setBounds(161, 97, 108, 20);
		panel.add(course_name);
		
		no_of_credits = new JTextField();
		no_of_credits.setColumns(10);
		no_of_credits.setBounds(161, 134, 108, 20);
		panel.add(no_of_credits);
		
		from_date = new JDateChooser();
		from_date.setBounds(457, 215, 141, 20);
		panel.add(from_date);
		
		to_date = new JDateChooser();
		to_date.setBounds(457, 253, 141, 20);
		panel.add(to_date);
		
		JButton clear = new JButton("Clear");
		clear.setBackground(new Color(192, 192, 192));
		clear.setFont(new Font("Cambria", Font.BOLD, 14));
		clear.setForeground(Color.DARK_GRAY);
		clear.setBounds(564, 327, 89, 31);
		panel.add(clear);
		
		lecture_in_charge = new JComboBox();
		lecture_in_charge.setModel(new DefaultComboBoxModel(new String[] {"xyz", "asd"}));
		lecture_in_charge.setBounds(512, 137, 141, 20);
		panel.add(lecture_in_charge);
		
		year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		year.setBounds(504, 56, 149, 20);
		panel.add(year);
		
		sub_stream = new JComboBox();
		sub_stream.setModel(new DefaultComboBoxModel(new String[] {"Physic", "Applied math", "Pure math", "SE", "IT", "Bussiness", "Art", "Bio"}));
		sub_stream.setBounds(504, 93, 149, 20);
		panel.add(sub_stream);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if ( !isempty()) {
				
			
					
						addCourse addcourse = new addCourse();
						
						addcourse.setCourse_code(course_code.getText());
						addcourse.setCourse_name(course_name.getText());
						addcourse.setNo_of_credits(no_of_credits.getText());
						addcourse.setFaculty((String)combofaculty.getSelectedItem());
						addcourse.setGraduate((String)combograduate.getSelectedItem());
						addcourse.setYear((String)year.getSelectedItem());
						addcourse.setSub_stream((String)sub_stream.getSelectedItem());
						addcourse.setLecture_in_charge((String)lecture_in_charge.getSelectedItem());
						
						java.util.Date utilfromDate = from_date.getDate();
						java.sql.Date sqlfromDate = new java.sql.Date(utilfromDate.getTime());
						addcourse.setFrom_date( sqlfromDate);
						
						java.util.Date utiltoDate = from_date.getDate();
						java.sql.Date sqltoDate = new java.sql.Date(utiltoDate.getTime());
						addcourse.setTo_date(sqltoDate);
					
						if (!addCourseHandler.checkRecordAlreadyExist(addcourse)) {
							boolean result = addCourseHandler.add(addcourse);
							if (result) {
								JOptionPane.showMessageDialog(null, "successfully Recorded");
							} else {
								JOptionPane.showMessageDialog(null, "Database error");
							}
						} else {
							JOptionPane.showMessageDialog(null, "You cannot add same record two times");
						}
				
				} else {
					JOptionPane.showMessageDialog(null, "All mandatory feilds must be filled");
			}
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Cambria", Font.BOLD, 14));
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(465, 327, 89, 31);
		panel.add(button);
		
		JLabel lblGaduateStatus = new JLabel("Gaduate status");
		lblGaduateStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGaduateStatus.setBounds(39, 217, 103, 14);
		panel.add(lblGaduateStatus);
		
		JLabel lblFaculty = new JLabel("Faculty");
		lblFaculty.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFaculty.setBounds(39, 180, 68, 14);
		panel.add(lblFaculty);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("View courses", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_8 = new JLabel("Courses");
		label_8.setForeground(Color.DARK_GRAY);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_8.setBounds(20, 11, 103, 22);
		panel_2.add(label_8);
		
		JLabel lblNewLabel_1 = new JLabel("Search");
		lblNewLabel_1.setBounds(29, 47, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		searchtxt = new JTextField();
		searchtxt.setBounds(73, 44, 149, 20);
		panel_2.add(searchtxt);
		searchtxt.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!searchtxt.getText().trim().isEmpty()) {

					resultSet = addCourseHandler.courseSearch(searchtxt.getText());
					table_1.setModel(DbUtils.resultSetToTableModel(resultSet));
					//table2.setModel(DbUtils.resultSetToTableModel(resultSet));
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(232, 43, 89, 23);
		panel_2.add(btnSearch);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 96, 742, 219);
		panel_2.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}
	
	
	public boolean isempty() {
		boolean textBoxes = checkTextBoxes();
		boolean comboBoxes = checkComboBoxes();
		boolean dateChoosers = checkDateChoosers();
		if (textBoxes && comboBoxes && dateChoosers) {
			return false;
		}

		return true;
	}

	// check textFields
	public boolean checkTextBoxes() {

		if (!course_code.getText().trim().isEmpty() && !course_name.getText().trim().isEmpty()
				&& !no_of_credits.getText().trim().isEmpty()) {
			return true;
		}

		return false;
	}

	// check comboBoxes
	public boolean checkComboBoxes() {
		if (!combofaculty.getSelectedItem().equals("select")
				&& !lecture_in_charge.getSelectedItem().equals("select")
				&& !year.getSelectedItem().equals("select")
				&& !sub_stream.getSelectedItem().equals("select")) {
			return true;
		}

		return false;
	}

	// check dateChoosers
	public boolean checkDateChoosers() {

		
		if ( from_date.getDate() != null &&  to_date.getDate() != null) {
			return true;
		}
		return false;
	}
	
	
}
