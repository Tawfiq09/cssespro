package com.csse.payment;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Properties;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ReportGenerator {

	private static Connection connection = null;
	private static String report_one = null;
	private static String report_two = null;

	// to get sql connection
	public static void setconnection() {

		if (connection == null) {
			try {
				connection = DBConnection.getconnection();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// load file locations using property file
	public static void loadPropertyFile(Properties properties) {
		report_one = properties.getProperty("report_one");
		report_two = properties.getProperty("report_two");
	}

	// method for generate faculty wise semester payment report
	public static void generateFacSemPayReport(HashMap<String, Object> parameters) throws JRException {

		if (report_one != null) {
			String report = report_one;
			
				JasperReport jasperReport = JasperCompileManager.compileReport(report);
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
				JasperViewer.viewReport(jasperPrint,false);
			
		}

	}

	// method for generate student wise semester payment report
	public static void generateStdSemPayReport(HashMap<String, Object> parameters) throws JRException {

		if (report_two != null) {
			String report = report_two;

			
				JasperReport jasperReport = JasperCompileManager.compileReport(report);
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
				JasperViewer.viewReport(jasperPrint,false);
			
		}

	}
}
