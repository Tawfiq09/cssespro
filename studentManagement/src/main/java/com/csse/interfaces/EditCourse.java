package com.csse.interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.csse.course.add_course.addCourse;
import com.csse.course.add_course.addCourseHandler;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class EditCourse extends JFrame {

	private JPanel contentPane;
	private JTextField course_code;
	private JTextField course_name;
	private JTextField no_of_credits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCourse addcourse = new addCourse();
					EditCourse frame = new EditCourse(addcourse);
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
	public EditCourse(addCourse addcourse) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 772, 405);
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
		label_3.setBounds(382, 58, 68, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Lecturer in charge");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(382, 136, 120, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Duration");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(382, 178, 68, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("From");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(408, 215, 68, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("To");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(408, 257, 42, 14);
		panel.add(label_7);
		
		JLabel lblUpdateCourseDetails = new JLabel("Update Course Details");
		lblUpdateCourseDetails.setForeground(Color.DARK_GRAY);
		lblUpdateCourseDetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUpdateCourseDetails.setBounds(10, 11, 210, 34);
		panel.add(lblUpdateCourseDetails);
		
		JLabel label_9 = new JLabel("Subject Stream");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(382, 95, 103, 14);
		panel.add(label_9);
		
		course_code = new JTextField();
		course_code.setColumns(10);
		course_code.setBounds(161, 60, 108, 20);
		panel.add(course_code);
		course_code.setText(addcourse.getCourse_code());
		
		course_name = new JTextField();
		course_name.setColumns(10);
		course_name.setBounds(161, 99, 108, 20);
		panel.add(course_name);
		course_name.setText(addcourse.getCourse_name());
		
		no_of_credits = new JTextField();
		no_of_credits.setColumns(10);
		no_of_credits.setBounds(161, 134, 108, 20);
		panel.add(no_of_credits);
		no_of_credits.setText(addcourse.getNo_of_credits());
		
		JDateChooser from_date = new JDateChooser();
		from_date.setBounds(457, 215, 141, 20);
		panel.add(from_date);
		from_date.setDate(addcourse.getFrom_date());
		
		JDateChooser to_date = new JDateChooser();
		to_date.setBounds(457, 253, 141, 20);
		panel.add(to_date);
		to_date.setDate(addcourse.getTo_date());
		
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog(null, "Do yo want to delete this record?", "Warning",
						JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					String course_code1 = course_code.getText();
					boolean result = addCourseHandler.delete(course_code1);
					
					if (result) {
						JOptionPane.showMessageDialog(null, "Successfully Delete");
					} else {
						JOptionPane.showMessageDialog(null, "Some thing wrong in database");
					}
				}
			}
		});
		btnDelete.setForeground(Color.DARK_GRAY);
		btnDelete.setFont(new Font("Cambria", Font.BOLD, 14));
		btnDelete.setBackground(new Color(192, 192, 192));
		btnDelete.setBounds(564, 340, 89, 31);
		panel.add(btnDelete);
		
		JComboBox lecture_in_charge = new JComboBox();
		lecture_in_charge.setBounds(512, 137, 141, 20);
		panel.add(lecture_in_charge);
		
		JComboBox year = new JComboBox();
		year.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		year.setBounds(504, 56, 108, 20);
		panel.add(year);
		
		JComboBox sub_stream = new JComboBox();
		sub_stream.setModel(new DefaultComboBoxModel(new String[] {"Physic", "Applied math", "Pure math", "SE", "IT", "Bussiness", "Art", "Bio"}));
		sub_stream.setBounds(504, 93, 108, 20);
		panel.add(sub_stream);
		
		JComboBox faculty = new JComboBox();
		faculty.setModel(new DefaultComboBoxModel(new String[] {"engineering", "bussiness", "IT", "science"}));
		faculty.setBounds(161, 178, 108, 20);
		panel.add(faculty);
		
		JComboBox graduate = new JComboBox();
		graduate.setModel(new DefaultComboBoxModel(new String[] {"undergraduate", "post graduate"}));
		graduate.setBounds(161, 215, 108, 20);
		panel.add(graduate);
		
		JLabel label_8 = new JLabel("Faculty");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(39, 180, 68, 14);
		panel.add(label_8);
		
		JLabel label_10 = new JLabel("Gaduate status");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(39, 217, 103, 14);
		panel.add(label_10);
		
		JButton buttonupdate = new JButton("Update");
		buttonupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
addCourse addcourse = new addCourse();
				
				addcourse.setCourse_code(course_code.getText());
				addcourse.setCourse_name(course_name.getText());
				addcourse.setNo_of_credits(no_of_credits.getText());
				addcourse.setFaculty((String)faculty.getSelectedItem());
				addcourse.setGraduate((String)graduate.getSelectedItem());
				addcourse.setYear((String)year.getSelectedItem());
				addcourse.setSub_stream((String)sub_stream.getSelectedItem());
				addcourse.setLecture_in_charge((String)lecture_in_charge.getSelectedItem());
				
				java.util.Date utilfromDate = from_date.getDate();
				java.sql.Date sqlfromDate = new java.sql.Date(utilfromDate.getTime());
				addcourse.setFrom_date( sqlfromDate);
				
				java.util.Date utiltoDate = from_date.getDate();
				java.sql.Date sqltoDate = new java.sql.Date(utiltoDate.getTime());
				addcourse.setTo_date(sqltoDate);
				
				boolean result = addCourseHandler.update(addcourse);
				
				if (result) {
					JOptionPane.showMessageDialog(null, "Successfully Updated");
				} else {
					JOptionPane.showMessageDialog(null, "Some thing wrong in database");
				}
				
			}
		});
		buttonupdate.setForeground(Color.DARK_GRAY);
		buttonupdate.setFont(new Font("Cambria", Font.BOLD, 14));
		buttonupdate.setBackground(Color.LIGHT_GRAY);
		buttonupdate.setBounds(457, 340, 89, 31);
		panel.add(buttonupdate);
		
		/*JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addCourse addcourse = new addCourse();
				
				addcourse.setCourse_code(course_code.getText());
				addcourse.setCourse_name(course_name.getText());
				addcourse.setNo_of_credits(no_of_credits.getText());
				addcourse.setFaculty((String)faculty.getSelectedItem());
				addcourse.setGraduate((String)graduate.getSelectedItem());
				addcourse.setYear((String)year.getSelectedItem());
				addcourse.setSub_stream((String)sub_stream.getSelectedItem());
				addcourse.setLecture_in_charge((String)lecture_in_charge.getSelectedItem());
				
				java.util.Date utilfromDate = from_date.getDate();
				java.sql.Date sqlfromDate = new java.sql.Date(utilfromDate.getTime());
				addcourse.setFrom_date( sqlfromDate);
				
				java.util.Date utiltoDate = from_date.getDate();
				java.sql.Date sqltoDate = new java.sql.Date(utiltoDate.getTime());
				addcourse.setTo_date(sqltoDate);
				
				boolean result = addCourseHandler.update(addcourse);
				
				if (result) {
					JOptionPane.showMessageDialog(null, "Successfully Updated");
				} else {
					JOptionPane.showMessageDialog(null, "Some thing wrong in database");
				}
				
				
			}
		});*/
		
	}
}
