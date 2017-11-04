package com.csse.interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.eclipse.jetty.util.StringUtil;

import com.csse.admin.HttpMessaheHandler;
import com.csse.application.starter.ApplictionHandler;
import com.csse.common.utill.ApplicationConfig;
import com.csse.common.utill.Filehandler;
import com.csse.db.utill.DAOManager;
import com.csse.db.utill.StudentDAO;
import com.csse.student.registration.DAOType;
import com.csse.student.registration.FacultyType;
import com.csse.student.registration.PostGraduateStudent;
import com.csse.student.registration.Student;
import com.csse.student.registration.StudentType;
import com.csse.student.registration.StudentValidation;
import com.csse.student.registration.UnderGraduateStudent;

import net.proteanit.sql.DbUtils;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class StudentRegistrationUI extends JFrame {

	JFrame frame;
	private JTextField fullNameTxt;
	private JTextField nameWithInitTxt;
	private JTextField mobileNoTxt;
	private JTextField persnContTxt;
	private JTextField relationTxt;
	private JTextField persnContNumTxt;
	private JTextField ageTxt;
	private JTextField nicTxt;
	private JComboBox stuCategCmbx;
	private JComboBox facCategCmbx;
	private JComboBox DegreProCmbx;
	private String stuCategry="UnderGraduate";
	private String faclCategry;
	private JTable table;
	private JLabel MsgLbl;
	private JLabel nicMsgLbl;
	private JLabel mobileLbl;
	private JLabel gurMbileLbl;
	private JLabel ageMsgeLbl;
	private JTextField addrTxt;
	private JLabel starLbl;
	private JTextField idSechTxt;
	private JTextField serchByName;
	private JLabel stuidLbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegistrationUI window = new StudentRegistrationUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentRegistrationUI() {
		initialize();
		clearLabels();
		addingItemsToStudntCategry();
		addingItemsToFacultyCategry();
		loadTable();
	}
	
	private void addingItemsToStudntCategry() {
		
		ArrayList<String> list=new ArrayList<String>();
		list.add(StudentType.UNDERGRADUATE.type());
		list.add(StudentType.POSTGRADUATE.type()); 
		
		Iterator stuCatery=list.iterator();  
		
		  while(stuCatery.hasNext()){  
			  stuCategCmbx.addItem(stuCatery.next());  
		  }  
	}
	
	private void addingItemsToFacultyCategry() {
		
		ArrayList<String> list=new ArrayList<String>();
		list.add(FacultyType.IT.fType());
		list.add(FacultyType.BUSSINESS.fType());
		list.add(FacultyType.ENGINEERING.fType());
		
		Iterator facltyCatery=list.iterator();  
		
		  while(facltyCatery.hasNext()){  
			  facCategCmbx.addItem(facltyCatery.next());  
		  }  
	}
	
	private void addingItmesToDegreeCategry() {
		if(stuCategry.equalsIgnoreCase(StudentType.UNDERGRADUATE.type())) {
			DegreProCmbx.removeAllItems();
			UnderGraduateStudent ustu = new UnderGraduateStudent();
			java.util.List<String> courses = ustu.performAllocateCourse();
			
			Iterator degrCatery=courses.iterator();  
				
				  while(degrCatery.hasNext()){  
					  DegreProCmbx.addItem(degrCatery.next());  
				  } 
				 
		}else if(stuCategry.equalsIgnoreCase(StudentType.POSTGRADUATE.type())) {
			DegreProCmbx.removeAllItems();
			PostGraduateStudent pstu = new PostGraduateStudent();
			java.util.List<String> courses = pstu.performAllocateCourse();
			
			Iterator degrCatery=courses.iterator();  
			
			  while(degrCatery.hasNext()){  
				  DegreProCmbx.addItem(degrCatery.next());  
			  } 
		}
	}
	
	private void loadTable() {
		DAOManager dmger =new DAOManager();
		Connection con;
		try {
			con = dmger.getConnection();
			StudentDAO sdao = (StudentDAO) dmger.getDAO(DAOType.STUDENTDAO.dao());
			ResultSet rset = sdao.getStudentList(con);
			table.setModel(DbUtils.resultSetToTableModel(rset));
			con.close();
			/*table.getColumnModel().getColumn(0).setPreferredWidth(82);
			table.getColumnModel().getColumn(1).setPreferredWidth(87);*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void clearLabels() {
		MsgLbl.setText("");
		nicMsgLbl.setText("");
		mobileLbl.setText("");
		gurMbileLbl.setText("");
		ageMsgeLbl.setText("");
		starLbl.setText("");
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 870, 679);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearLabels();
				ObjectMapper mapper = new ObjectMapper();
				DAOManager dmger =new DAOManager();
				
				if(StringUtil.isBlank(fullNameTxt.getText()) || StringUtil.isBlank(nameWithInitTxt.getText()) || StringUtil.isBlank(nicTxt.getText())
						|| StringUtil.isBlank(stuCategCmbx.getSelectedItem().toString()) || StringUtil.isBlank(facCategCmbx.getSelectedItem().toString()) || StringUtil.isBlank(DegreProCmbx.getSelectedItem().toString())
						|| StringUtil.isBlank(mobileNoTxt.getText()) || StringUtil.isBlank(ageTxt.getText()) || StringUtil.isBlank(addrTxt.getText())
						|| StringUtil.isBlank(persnContTxt.getText()) || StringUtil.isBlank(relationTxt.getText()) || StringUtil.isBlank(persnContNumTxt.getText()) ) {
					
					starLbl.setText("*");
					MsgLbl.setText("Mandatory Fields!");
				}
				else {
					if(StudentValidation.validateNicNo(nicTxt.getText())) {
						nicMsgLbl.setText("Invalid Value!");
					}else if(StudentValidation.validateMobileNo(Long.parseLong(mobileNoTxt.getText()))) {
						mobileLbl.setText("Invalid Value!");
					}else if(StudentValidation.validateMobileNo(Long.parseLong(persnContNumTxt.getText()))){
						gurMbileLbl.setText("Invalid Value!");
					}else if(StudentValidation.validateAge(Long.parseLong(ageTxt.getText()))) {
						ageMsgeLbl.setText("Invalid Value!");
					}else{
				try {
				StudentDAO sdao = (StudentDAO) dmger.getDAO(DAOType.STUDENTDAO.dao());
				
				String stuCat = stuCategCmbx.getSelectedItem().toString();
				String facCat = facCategCmbx.getSelectedItem().toString();
				String nic = nicTxt.getText();
				
				String stuID = sdao.generateStudentId(stuCat,facCat,nic);
				stuidLbl.setText(stuID);
				
				Student stuSaveObject = null;
				if(stuCat.equalsIgnoreCase(StudentType.UNDERGRADUATE.type())) {
				    stuSaveObject = new UnderGraduateStudent(stuID,fullNameTxt.getText(),nameWithInitTxt.getText(),nicTxt.getText(),
						stuCategCmbx.getSelectedItem().toString(),facCategCmbx.getSelectedItem().toString(),DegreProCmbx.getSelectedItem().toString(),
						  Long.parseLong(mobileNoTxt.getText()),Long.parseLong(ageTxt.getText()),addrTxt.getText(),
						    persnContTxt.getText(), relationTxt.getText(),Long.parseLong(persnContNumTxt.getText()));
				}else if(stuCat.equalsIgnoreCase(StudentType.POSTGRADUATE.type())) {
					stuSaveObject = new PostGraduateStudent(stuID,fullNameTxt.getText(),nameWithInitTxt.getText(),nicTxt.getText(),
							stuCategCmbx.getSelectedItem().toString(),facCategCmbx.getSelectedItem().toString(),DegreProCmbx.getSelectedItem().toString(),
							  Long.parseLong(mobileNoTxt.getText()),Long.parseLong(ageTxt.getText()),addrTxt.getText(),
							    persnContTxt.getText(), relationTxt.getText(),Long.parseLong(persnContNumTxt.getText()));
				}
					String jsonInString = mapper.writeValueAsString(stuSaveObject);
					System.out.println(jsonInString);
					HttpMessaheHandler.httpService("POST",jsonInString,
							Filehandler.loadPropertiesFromFile(ApplictionHandler.CONFIGS.getProperty(ApplicationConfig.STUDENT_PROPERTY_FILE))
							.getProperty(ApplicationConfig.SAVE_ENDPOINT));
					clearLabels();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				loadTable();
			  }
			}
		}
	});
		btnRegister.setFont(new Font("Traditional Arabic", Font.PLAIN, 17));
		btnRegister.setBounds(267, 596, 106, 23);
		frame.getContentPane().add(btnRegister);
		
		fullNameTxt = new JTextField();
		fullNameTxt.setBounds(157, 21, 188, 30);
		frame.getContentPane().add(fullNameTxt);
		fullNameTxt.setColumns(10);
		
		nameWithInitTxt = new JTextField();
		nameWithInitTxt.setColumns(10);
		nameWithInitTxt.setBounds(157, 74, 188, 30);
		frame.getContentPane().add(nameWithInitTxt);
		
		mobileNoTxt = new JTextField();
		mobileNoTxt.setColumns(10);
		mobileNoTxt.setBounds(157, 365, 188, 30);
		frame.getContentPane().add(mobileNoTxt);
		
		persnContTxt = new JTextField();
		persnContTxt.setColumns(10);
		persnContTxt.setBounds(580, 21, 188, 30);
		frame.getContentPane().add(persnContTxt);
		
		relationTxt = new JTextField();
		relationTxt.setColumns(10);
		relationTxt.setBounds(580, 74, 188, 30);
		frame.getContentPane().add(relationTxt);
		
		persnContNumTxt = new JTextField();
		persnContNumTxt.setColumns(10);
		persnContNumTxt.setBounds(580, 130, 188, 30);
		frame.getContentPane().add(persnContNumTxt);
		
		stuCategCmbx = new JComboBox();
		stuCategCmbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(stuCategCmbx.getSelectedItem().equals(StudentType.POSTGRADUATE.type())) {
					stuCategry = stuCategCmbx.getSelectedItem().toString();
					addingItmesToDegreeCategry();
				}else if(stuCategCmbx.getSelectedItem().equals(StudentType.UNDERGRADUATE.type())){
					stuCategry = stuCategCmbx.getSelectedItem().toString();
					addingItmesToDegreeCategry();
				}
			}
		});
		stuCategCmbx.setBounds(157, 211, 188, 30);
		frame.getContentPane().add(stuCategCmbx);
			
		facCategCmbx = new JComboBox();
		facCategCmbx.setBounds(157, 260, 188, 30);
		frame.getContentPane().add(facCategCmbx);
		DegreProCmbx = new JComboBox();
		DegreProCmbx.setBounds(157, 301, 188, 30);
		
		frame.getContentPane().add(DegreProCmbx);
		
		ageTxt = new JTextField();
		ageTxt.setColumns(10);
		ageTxt.setBounds(157, 431, 188, 30);
		frame.getContentPane().add(ageTxt);
		
		JLabel fullNameLbl = new JLabel("Full Name");
		fullNameLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		fullNameLbl.setBounds(13, 23, 134, 23);
		frame.getContentPane().add(fullNameLbl);
		
		JLabel nameWithInitLbl = new JLabel("Name with Initials");
		nameWithInitLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameWithInitLbl.setBounds(13, 74, 134, 23);
		frame.getContentPane().add(nameWithInitLbl);
		
		JLabel nicLbl = new JLabel("NIC No");
		nicLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nicLbl.setBounds(13, 132, 134, 23);
		frame.getContentPane().add(nicLbl);
		
		JLabel stuCategLbl = new JLabel("Student Category");
		stuCategLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stuCategLbl.setBounds(13, 213, 134, 23);
		frame.getContentPane().add(stuCategLbl);
		
		JLabel lblDegreeProgram = new JLabel("Degree Program");
		lblDegreeProgram.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDegreeProgram.setBounds(13, 308, 134, 23);
		frame.getContentPane().add(lblDegreeProgram);
		
		JLabel mobileNoLbl = new JLabel("Mobile No");
		mobileNoLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mobileNoLbl.setBounds(13, 367, 134, 23);
		frame.getContentPane().add(mobileNoLbl);
		
		JLabel ageLbl = new JLabel("Age");
		ageLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ageLbl.setBounds(13, 433, 134, 23);
		frame.getContentPane().add(ageLbl);
		
		JLabel addrLbl = new JLabel("Address");
		addrLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addrLbl.setBounds(405, 205, 134, 23);
		frame.getContentPane().add(addrLbl);
		
		JLabel persnContLbl = new JLabel("PersonToContact \r\nEOM");
		persnContLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		persnContLbl.setBounds(405, 23, 154, 23);
		frame.getContentPane().add(persnContLbl);
		
		JLabel relationLbl = new JLabel("Relationship");
		relationLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		relationLbl.setBounds(405, 76, 134, 23);
		frame.getContentPane().add(relationLbl);
		
		JLabel persnContNumLbl = new JLabel("Gurdian's Mobile No");
		persnContNumLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		persnContNumLbl.setBounds(405, 132, 134, 23);
		frame.getContentPane().add(persnContNumLbl);
		
		nicTxt = new JTextField();
		nicTxt.setColumns(10);
		nicTxt.setBounds(157, 130, 188, 30);
		frame.getContentPane().add(nicTxt);
		
		JLabel FacultyLbl = new JLabel("Faculty");
		FacultyLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FacultyLbl.setBounds(13, 262, 134, 23);
		frame.getContentPane().add(FacultyLbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(424, 349, 389, 270);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRowIndx = table.getSelectedRow();
				
				stuidLbl.setText(model.getValueAt(selectedRowIndx, 0).toString());
				fullNameTxt.setText(model.getValueAt(selectedRowIndx, 1).toString());
				nameWithInitTxt.setText(model.getValueAt(selectedRowIndx, 2).toString());
				nicTxt.setText(model.getValueAt(selectedRowIndx,3).toString());
				stuCategCmbx.setSelectedItem(model.getValueAt(selectedRowIndx,4).toString());
				facCategCmbx.setSelectedItem(model.getValueAt(selectedRowIndx,5).toString());
				DegreProCmbx.setSelectedItem(model.getValueAt(selectedRowIndx,6).toString());
				mobileNoTxt.setText(model.getValueAt(selectedRowIndx,7).toString());
				ageTxt.setText(model.getValueAt(selectedRowIndx,8).toString());
				addrTxt.setText(model.getValueAt(selectedRowIndx,9).toString());
				persnContTxt.setText(model.getValueAt(selectedRowIndx,10).toString());
				relationTxt.setText(model.getValueAt(selectedRowIndx,11).toString());
				persnContNumTxt.setText(model.getValueAt(selectedRowIndx,12).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearLabels();
				ObjectMapper mapper = new ObjectMapper();
				int action = JOptionPane.showConfirmDialog(null,"Do you want to update this record?","Update",JOptionPane.YES_NO_OPTION);

					if (StringUtil.isBlank(fullNameTxt.getText()) || StringUtil.isBlank(nameWithInitTxt.getText()) || StringUtil.isBlank(nicTxt.getText())
							|| StringUtil.isBlank(stuCategCmbx.getSelectedItem().toString()) || StringUtil.isBlank(facCategCmbx.getSelectedItem().toString()) || StringUtil.isBlank(DegreProCmbx.getSelectedItem().toString())
							|| StringUtil.isBlank(mobileNoTxt.getText()) || StringUtil.isBlank(ageTxt.getText()) || StringUtil.isBlank(addrTxt.getText())
							|| StringUtil.isBlank(persnContTxt.getText()) || StringUtil.isBlank(relationTxt.getText()) || StringUtil.isBlank(persnContNumTxt.getText())) {
						starLbl.setText("*");
						MsgLbl.setText("Mandatory Fields!");
					} else {
						if (StudentValidation.validateNicNo(nicTxt.getText())) {
							nicMsgLbl.setText("Invalid Value!");
						} else if (StudentValidation.validateMobileNo(Long.parseLong(mobileNoTxt.getText()))) {
							mobileLbl.setText("Invalid Value!");
						} else if (StudentValidation.validateMobileNo(Long.parseLong(persnContNumTxt.getText()))) {
							gurMbileLbl.setText("Invalid Value!");
						} else if (StudentValidation.validateAge(Long.parseLong(ageTxt.getText()))) {
							ageMsgeLbl.setText("Invalid Value!");
						} else {
							if (action == 0) {
								Student stuUpdateObject = null;
								
							if(stuCategCmbx.getSelectedItem().toString().equalsIgnoreCase(StudentType.UNDERGRADUATE.type())) {
								
								stuUpdateObject = new UnderGraduateStudent(fullNameTxt.getText(), nameWithInitTxt.getText(),
										nicTxt.getText(), stuCategCmbx.getSelectedItem().toString(),
										facCategCmbx.getSelectedItem().toString(),
										DegreProCmbx.getSelectedItem().toString(), Long.parseLong(mobileNoTxt.getText()),
										Long.parseLong(ageTxt.getText()), persnContTxt.getText(), persnContTxt.getText(),
										relationTxt.getText(), Long.parseLong(persnContNumTxt.getText()));
								
							}else if(stuCategCmbx.getSelectedItem().toString().equalsIgnoreCase(StudentType.POSTGRADUATE.type())){
								
							    stuUpdateObject = new PostGraduateStudent(fullNameTxt.getText(), nameWithInitTxt.getText(),
									nicTxt.getText(), stuCategCmbx.getSelectedItem().toString(),
									facCategCmbx.getSelectedItem().toString(),
									DegreProCmbx.getSelectedItem().toString(), Long.parseLong(mobileNoTxt.getText()),
									Long.parseLong(ageTxt.getText()), persnContTxt.getText(), persnContTxt.getText(),
									relationTxt.getText(), Long.parseLong(persnContNumTxt.getText()));
							    
							}
							
							try {
								String jsonInString = mapper.writeValueAsString(stuUpdateObject);
								System.out.println(jsonInString);
								HttpMessaheHandler.httpService("POST", jsonInString,
										Filehandler.loadPropertiesFromFile(ApplictionHandler.CONFIGS.getProperty(ApplicationConfig.STUDENT_PROPERTY_FILE))
										.getProperty(ApplicationConfig.UPDATE_ENDPOINT));
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
							loadTable();
					} 
				}
	}
});
		updateBtn.setFont(new Font("Traditional Arabic", Font.PLAIN, 17));
		updateBtn.setBounds(13, 596, 89, 23);
		frame.getContentPane().add(updateBtn);
		
		JButton deleteBtn = new JButton("Delete");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sid = stuidLbl.getText();
				int action = JOptionPane.showConfirmDialog(null,"Do you want to delete this record?","Delete",JOptionPane.YES_NO_OPTION);
				if(action == 0) {
				try {
					DAOManager dmger =new DAOManager();
					StudentDAO sdao = sdao = (StudentDAO) dmger.getDAO(DAOType.STUDENTDAO.dao());;
					Connection con = dmger.getConnection();
					sdao.deleteStudent(con,sid);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				loadTable();
			  }
			}
		});
		deleteBtn.setFont(new Font("Traditional Arabic", Font.PLAIN, 17));
		deleteBtn.setBounds(149, 596, 89, 23);
		frame.getContentPane().add(deleteBtn);
		
		MsgLbl = new JLabel("msg");
		MsgLbl.setForeground(Color.RED);
		MsgLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MsgLbl.setBounds(66, 508, 160, 23);
		frame.getContentPane().add(MsgLbl);
		
		starLbl = new JLabel("*");
		starLbl.setForeground(Color.RED);
		starLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		starLbl.setBounds(13, 508, 33, 23);
		frame.getContentPane().add(starLbl);
		
		nicMsgLbl = new JLabel("nicmsg");
		nicMsgLbl.setForeground(Color.RED);
		nicMsgLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nicMsgLbl.setBounds(13, 171, 181, 23);
		frame.getContentPane().add(nicMsgLbl);
		
		mobileLbl = new JLabel("mbmsg");
		mobileLbl.setForeground(Color.RED);
		mobileLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mobileLbl.setBounds(13, 403, 181, 23);
		frame.getContentPane().add(mobileLbl);
		
		gurMbileLbl = new JLabel("mbmsg");
		gurMbileLbl.setForeground(Color.RED);
		gurMbileLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gurMbileLbl.setBounds(405, 171, 181, 23);
		frame.getContentPane().add(gurMbileLbl);
		
		ageMsgeLbl = new JLabel("agemsg");
		ageMsgeLbl.setForeground(Color.RED);
		ageMsgeLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ageMsgeLbl.setBounds(10, 472, 160, 23);
		frame.getContentPane().add(ageMsgeLbl);
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(355, 28, 33, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(355, 82, 33, 23);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(355, 138, 33, 23);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(355, 219, 33, 23);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(355, 268, 33, 23);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_5.setBounds(355, 309, 33, 23);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_6.setBounds(355, 373, 33, 23);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_7.setBounds(355, 439, 33, 23);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_8.setBounds(778, 29, 33, 23);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("*");
		label_9.setForeground(Color.RED);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_9.setBounds(778, 82, 33, 23);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("*");
		label_10.setForeground(Color.RED);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_10.setBounds(778, 138, 33, 23);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("*");
		label_11.setForeground(Color.RED);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_11.setBounds(778, 211, 33, 23);
		frame.getContentPane().add(label_11);
		
		addrTxt = new JTextField();
		addrTxt.setColumns(10);
		addrTxt.setBounds(580, 198, 188, 30);
		frame.getContentPane().add(addrTxt);
		
		idSechTxt = new JTextField();
		idSechTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DAOManager dmger =new DAOManager();
				StudentDAO sdao;
				try {
					sdao = (StudentDAO) dmger.getDAO(DAOType.STUDENTDAO.dao());
					Connection con = dmger.getConnection();
					ResultSet rst = sdao.searchById(con,idSechTxt.getText());
					table.setModel(DbUtils.resultSetToTableModel(rst));
					con.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		idSechTxt.setColumns(10);
		idSechTxt.setBounds(409, 267, 188, 30);
		frame.getContentPane().add(idSechTxt);
		
		JLabel lblSearchbyid = new JLabel("SearchByID");
		lblSearchbyid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchbyid.setBounds(445, 303, 94, 23);
		frame.getContentPane().add(lblSearchbyid);
		
		serchByName = new JTextField();
		serchByName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				DAOManager dmger =new DAOManager();
				try {
					StudentDAO sdao = sdao = (StudentDAO) dmger.getDAO(DAOType.STUDENTDAO.dao());;
					Connection con = dmger.getConnection();
					ResultSet rst = sdao.searchByName(con,serchByName.getText());
					table.setModel(DbUtils.resultSetToTableModel(rst));
					con.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		serchByName.setColumns(10);
		serchByName.setBounds(633, 267, 188, 30);
		frame.getContentPane().add(serchByName);
		
		JLabel lblSearchbyname = new JLabel("SearchByName");
		lblSearchbyname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSearchbyname.setBounds(674, 303, 106, 23);
		frame.getContentPane().add(lblSearchbyname);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStudentId.setBounds(13, 542, 106, 23);
		frame.getContentPane().add(lblStudentId);
		
		stuidLbl = new JLabel("Student ID");
		stuidLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stuidLbl.setBounds(149, 542, 142, 23);
		frame.getContentPane().add(stuidLbl);
		
	}
}
