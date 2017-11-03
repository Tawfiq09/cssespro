package com.csse.application.starter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import com.csse.admin.RestServer;
import com.csse.common.utill.ApplicationConfig;
import com.csse.common.utill.Filehandler;
import com.csse.db.utill.ConnectionPool;
import com.csse.db.utill.DAOManager;

public class ApplictionHandler {

	public static volatile Properties CONFIGS;
	
	public static void start() throws ClassNotFoundException, SQLException {
		ApplictionHandler.initProperties();
		ApplictionHandler.initPoolConnection();
		ApplictionHandler.startRestService();
		
	}
	
	public static void startRestService(){
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					RestServer.start();
				} catch (Throwable ex) {
					System.out.println(ex.getMessage());
				}
			}
		}).start();
	}
	
	
	public static void initProperties(){
		try {
			CONFIGS = Filehandler.loadPropertiesFromFile(ApplicationConfig.FILE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initPoolConnection() throws ClassNotFoundException, SQLException {
		DAOManager dmger =new DAOManager();
		dmger.startConnectionPool();
	}
}
