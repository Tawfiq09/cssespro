package com.csse.application.starter;

import java.io.IOException;
import java.util.Properties;

import com.csse.admin.RestServer;
import com.csse.common.utill.ApplicationConfig;
import com.csse.common.utill.Filehandler;

public class ApplictionHandler {

	public static volatile Properties CONFIGS;
	
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
	
}
