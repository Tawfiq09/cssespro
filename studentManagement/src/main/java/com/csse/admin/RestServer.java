package com.csse.admin;

import java.util.Map;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class RestServer {
	 public static void start() throws Exception {
	    		    	
	        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
	        context.setContextPath("/");

	        //TODO make this configurable
	        int adminPort = 8081;
	      
	        Server jettyServer = new Server(adminPort);
	        jettyServer.setHandler(context);

	        ServletHolder jerseyServlet = context.addServlet(
	             org.glassfish.jersey.servlet.ServletContainer.class, "/*");
	        jerseyServlet.setInitOrder(0);

	  
	        jerseyServlet.setInitParameter(
	                "jersey.config.server.provider.packages",
	                StudentRest.class.getPackage().getName());
	        

	        try {
	            jettyServer.start();
	            jettyServer.join();
	        } finally {
	            jettyServer.destroy();
	        }
	    }
}