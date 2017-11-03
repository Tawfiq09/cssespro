package com.csse.db.utill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mysql.jdbc.PreparedStatement;

public class StudentDAO extends GenericDAO{

	public StudentDAO() {}

	public void saveStudent(String stuObject) throws Exception {
		DAOManager dmger =new DAOManager();
		Connection con = dmger.getConnection();
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(stuObject);
		String fname = (String) json.get("fullName");
		String address = (String) json.get("address");
		System.out.println("fname:"+fname);
		String query = "insert into registration values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
		pst.setString(1,(String) json.get("sid"));
		pst.setString(2,(String) json.get("fullName"));
		pst.setString(3,(String) json.get("nameWithInit"));
		pst.setString(4,(String) json.get("nic"));
		pst.setString(5,(String) json.get("stuCategry"));
		pst.setString(6,(String) json.get("faculty"));
		pst.setString(7,(String) json.get("degreeProg"));
		pst.setLong(8,(long) json.get("mobileNo"));
		pst.setLong(9,(long) json.get("age"));
		pst.setString(10,(String) json.get("address"));
		pst.setString(11,(String) json.get("personToCntact"));
		pst.setString(12,(String) json.get("relationship"));
		pst.setLong(13,(long) json.get("gurdianMobile"));
		pst.execute();
		pst.close();
	}
	
	public ResultSet getStudentList(Connection conn) throws SQLException {
		Statement ste = conn.createStatement();
		ResultSet rs = ste.executeQuery("select * from registration");
		return rs;
	}
	
	public void updateStudent(String stuObject) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(stuObject);
		DAOManager dmger =new DAOManager();
		Connection con = dmger.getConnection();
		String query = "update registration set fullName='"+(String) json.get("fullName")+"',nameWithInit='"+(String) json.get("nameWithInit")+"',"
				+ "nic='"+(String) json.get("nic")+"',stuCategory='"+(String) json.get("stuCategry")+"',faclCategory='"+(String) json.get("faculty")+"',"
						+ "degreeCategory='"+(String) json.get("degreeProg")+"',mobile='"+(long) json.get("mobileNo")+"',age='"+(long) json.get("age")+"',"
								+ "address='"+(String) json.get("address")+"',persnToCntact='"+(String) json.get("personToCntact")+"',"
										+ "relationship='"+(String) json.get("relationship")+"',gurdianMobile='"+(long) json.get("gurdianMobile")+"' "
												+ "where nic='"+(String) json.get("nic")+"'";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
		pst.execute();
		pst.close();
	}

	public void deleteStudent(Connection con,String nic) throws Exception {
		/*DAOManager dmger =new DAOManager();
		Connection con = dmger.getConnection();*/
		String query = "delete from registration where nic='"+nic+"'";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
		pst.execute();
		pst.close();
	}

	public String generateStudentId(String stuCat, String facCat,String nic) {
		return stuCat.substring(0,2)+facCat.substring(0,2)+nic.substring(0,9);
	}
	
	public ResultSet searchById(Connection con,String id) throws Exception {
		/*DAOManager dmger =new DAOManager();
		Connection con = dmger.getConnection();*/
		String query = "select * from registration where id = ?";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
		pst.setString(1,id);
		ResultSet rs = pst.executeQuery();
		return rs;
	}
	
	public ResultSet searchByName(Connection con,String name) throws Exception {
		/*DAOManager dmger =new DAOManager();
		Connection con = dmger.getConnection();*/
		String query = "select * from registration where fullname = ?";
		PreparedStatement pst = (PreparedStatement) con.prepareStatement(query);
		pst.setString(1,name);
		ResultSet rs = pst.executeQuery();
		return rs;
	}
	
}
