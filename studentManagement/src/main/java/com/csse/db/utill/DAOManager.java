package com.csse.db.utill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.sql.PooledConnection;

import com.csse.application.starter.ApplictionHandler;
import com.csse.common.utill.ApplicationConfig;

public class DAOManager {
	
	 private Connection conn;
	 private ConnectionPool connectionPool;
	 
	 public DAOManager() {
		 
	 }
	 
	 public void startConnectionPool() {
		 try {
			connectionPool = new ConnectionPool(8, 6,ApplictionHandler.CONFIGS.getProperty(ApplicationConfig.DB_CONNECTION),
					ApplictionHandler.CONFIGS.getProperty(ApplicationConfig.DB_USERNAME), ApplictionHandler.CONFIGS.getProperty(ApplicationConfig.DB_PASSWORD),
					ApplictionHandler.CONFIGS.getProperty(ApplicationConfig.DB_DRIVER));
		 } catch (Exception e) {
			System.out.println("msg:"+e.getMessage());
		}
	 }
	
	 public Connection getConnection() throws Exception {
		 if(connectionPool == null) {
				//connectionPool = new ConnectionPool(8, 6, "jdbc:mysql://localhost:3306/studentmanagement", "root", "dogsun123", "com.mysql.jdbc.Driver");
			 connectionPool = new ConnectionPool(8, 6,ApplictionHandler.CONFIGS.getProperty(ApplicationConfig.DB_CONNECTION),
						ApplictionHandler.CONFIGS.getProperty(ApplicationConfig.DB_USERNAME), ApplictionHandler.CONFIGS.getProperty(ApplicationConfig.DB_PASSWORD),
						ApplictionHandler.CONFIGS.getProperty(ApplicationConfig.DB_DRIVER));
		 }
		 return connectionPool.getConnectionFromPool();
	 }
	 
	    
	 public GenericDAO getDAO(String DAOType ) throws SQLException {
	     switch(DAOType)
	     {
	        case "StudentDAO":
	            return new StudentDAO();
	        default:
	            throw new SQLException("Trying to link to an unexistant table.");
	     }

	  }

	   
}
